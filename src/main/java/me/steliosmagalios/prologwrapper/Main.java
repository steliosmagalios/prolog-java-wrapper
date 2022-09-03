package me.steliosmagalios.prologwrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parctechnologies.eclipse.*;
import me.steliosmagalios.prologwrapper.models.*;

import java.io.File;
import java.io.IOException;
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

    // Arg[1] = program location (compiles it)
    // Arg[2] = data (json)
    public static void main(String[] args) throws EclipseException, IOException {
        // Ensure argument length is 2
        if (args.length != 2) {
            System.err.println("Syntax: java -Declipse.directory=\"path/to/eclise\" -jar wrapper.jar <prolog_location> <json_data> ");
            System.exit(1);
        }
        String programPath = args[0];
        String unparsedData = args[1];
//        String unparsedData = "{\"professors\":[{\"id\": 1, \"availability\":[1, 2, 3, 4, 5, 6]}],\"groups\":[{\"id\": 1,\"memberCount\": 100, \"overlapping\": []}],\"rooms\":[],\"lectures\":[]}";

        // Start the ECLiPSe engine
        EclipseEngine engine = new OutOfProcessEclipse(ECLIPSE_ENGINE_OPTIONS); // this may throw error
        engine.compile(new File(programPath));

        // Parse the JSON to java objects
        DataModel jsonData = GSON.fromJson(unparsedData, DataModel.class);

        // Parse the objects to prolog CompoundTerms
        Collection<CompoundTerm> lectures = Arrays.stream(jsonData.getLectures()).map(Lecture::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> professors = Arrays.stream(jsonData.getProfessors()).map(Professor::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> groups = Arrays.stream(jsonData.getGroups()).map(Group::toProlog).collect(Collectors.toList());
        Collection<CompoundTerm> rooms = Arrays.stream(jsonData.getRooms()).map(Room::toProlog).collect(Collectors.toList());

        // Start the scheduling process
        CompoundTerm result = engine.rpc("schedule", null, lectures, professors, groups, rooms);
        Collection<Task> parsedTasks =((Collection<CompoundTerm>) result.arg(1)).stream().map(Task::fromProlog).collect(Collectors.toList());

        // Prepare for return
        ReturnDataModel returnModel = new ReturnDataModel();
        returnModel.setTasks(parsedTasks);

        // Send the result to the user (through stdout, in JSON)
        System.out.println(GSON.toJson(returnModel, ReturnDataModel.class));
    }
}