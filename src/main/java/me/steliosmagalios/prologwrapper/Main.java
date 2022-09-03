package me.steliosmagalios.prologwrapper;

import com.google.gson.Gson;
import com.parctechnologies.eclipse.*;

import java.io.File;
import java.io.IOException;

public class Main {

    // Static GSON to work with
    private static final Gson GSON = new Gson();

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

        // Start the ECLiPSe engine
        EclipseEngine engine = new OutOfProcessEclipse(new EclipseEngineOptions()); // this may throw error
        engine.compile(new File(programPath));

        // Parse the JSON to prolog facts

        // Start the scheduling process

        // Send the result to the user (through stdout)
        System.out.println("Hello world!");
    }
}