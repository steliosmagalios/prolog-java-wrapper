package me.steliosmagalios.prologwrapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.parctechnologies.eclipse.*;
import me.steliosmagalios.prologwrapper.models.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {

    // Static GSON to work with
    private static final Gson GSON = new Gson();

    // ECLiPSe engine options
    private static final EclipseEngineOptions ECLIPSE_ENGINE_OPTIONS = new EclipseEngineOptions();

    static {
        // Set the options
        ECLIPSE_ENGINE_OPTIONS.setUseQueues(true); // close the stdout from prolog
    }

    // args[1] = program location (compiles it)
    // args[2] = data (json)
    public static void main(String[] args) throws EclipseException, IOException {
        // Ensure argument length is 2 and extract the arguments
        if (args.length != 2) {
            System.err.println("Syntax: java -Declipse.directory=<path_to_eclipse> -jar wrapper.jar <prolog_location> <json_data> ");
            System.exit(1);
        }
        String programPath = args[0];
        String unparsedData = args[1];

        // Check if the program file exists
        File programFile = new File(programPath);
        if (!programFile.exists()) {
            errorOutFromProgram("Program file does not exist!");
        }

        // Start the ECLiPSe engine
        EclipseEngine engine = new OutOfProcessEclipse(ECLIPSE_ENGINE_OPTIONS); // this may throw error
        engine.compile(new File(programPath));

        // Parse the JSON to java objects
        DataModel jsonData = null;
        try {
            jsonData = GSON.fromJson(unparsedData, DataModel.class);
        } catch (JsonSyntaxException ex) {
            errorOutFromProgram("There was an error parsing the data");
        }
        // After that there should be data here
        assert jsonData != null;

        // Parse the objects to prolog CompoundTerms
        Collection<CompoundTerm> lectures = Arrays.stream(jsonData.getLectures()).map(Lecture::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> professors = Arrays.stream(jsonData.getProfessors()).map(Professor::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> groups = Arrays.stream(jsonData.getGroups()).map(Group::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> rooms = Arrays.stream(jsonData.getRooms()).map(Room::toProlog).collect(Collectors.toList());

        try {
            // Start the scheduling process
            CompoundTerm result;
            result = engine.rpc("schedule", null, lectures, professors, groups, rooms);
            Collection<Task> parsedTasks = ((Collection<CompoundTerm>) result.arg(1)).stream().map(Task::fromProlog).collect(Collectors.toList());

            // Return the data to the user
            returnDataToUser(parsedTasks, true);
        } catch (EclipseException ex) {
            // Solution could not be found
            returnDataToUser(new ArrayList<>(), false);
        }
    }

    private static void errorOutFromProgram(String error) {
        // Prepare the return
        ErrorReturnModel errorReturnModel = new ErrorReturnModel();
        errorReturnModel.setError(error);

        // Send the error to the user
        System.err.println(GSON.toJson(errorReturnModel));
        System.exit(1);
    }

    private static void returnDataToUser(Collection<Task> data, boolean solutionFound) {
        // Prepare for return
        ReturnDataModel returnModel = new ReturnDataModel();
        returnModel.setTasks(data);
        returnModel.setSolutionFound(solutionFound);

        // Send the result to the user (through stdout, in JSON)
        System.out.println(GSON.toJson(returnModel, ReturnDataModel.class));

    }
}