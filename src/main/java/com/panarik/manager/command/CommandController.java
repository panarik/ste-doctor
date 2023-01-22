package com.panarik.manager.command;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class CommandController {

    private static CommandController instance;

    private CommandController() {
    }

    /**
     * Create instance of shell terminal controller.
     */
    public static synchronized CommandController getInstance() {
        if (instance == null) instance = new CommandController();
        return instance;
    }

    /**
     * Runs specific terminal shell commands in specific directory.
     *
     * @param whereToRun Directory for command.
     * @param command    Command text.
     * @return Terminal answer.
     */
    public Response runCommand(File whereToRun, String command) throws IOException {
        System.out.println("Directory:" + whereToRun);
        System.out.println("Command: " + command);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);
        builder.command("sh", "-c", command);

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        boolean isFinished;
        try {
            isFinished = process.waitFor(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputStream.flush();
        outputStream.close();

        if (!isFinished) {
            process.destroyForcibly();
        }

        return saveResponse(inputStream, errorStream);
    }

    /**
     * Save terminal answers.
     *
     * @param inputStream Terminal answers stream.
     * @param errorStream Terminal errors stream.
     * @return Terminal response.
     */
    private Response saveResponse(InputStream inputStream, InputStream errorStream) {
        Response response = new Response();
        String line;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = reader.readLine()) != null) {
                response.addResponseLine(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream))) {
            while ((line = reader.readLine()) != null) {
                response.addErrorLine(line);
                System.err.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}
