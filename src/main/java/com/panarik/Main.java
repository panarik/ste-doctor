package com.panarik;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        File location = new File("<put here full user path>");

        try {
            runCommand(location, "<put here command>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Runs commands in specific directory.
     *
     * @param whereToRun Directory for command.
     * @param command    command text.
     * @throws IOException
     */
    private static void runCommand(File whereToRun, String command) throws IOException {
        System.out.println("Directory:" + whereToRun);
        System.out.println("Command: " + command);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);
        builder.command("sh", "-c", command);

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        print(inputStream);
        print(errorStream);

        boolean isFinished;
        try {
            isFinished = process.waitFor(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputStream.flush();
        outputStream.close();

        if (!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void print(InputStream input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}