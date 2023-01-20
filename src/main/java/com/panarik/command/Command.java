package com.panarik.command;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Command {

    private final LinkedList<String> terminalOutput = new LinkedList<>();

    public static void main(String[] args) {

        try {
            new Command().runCommand(new File("/usr/local/test"), "ls");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<String> getTerminalOutput() {
        return terminalOutput;
    }

    /**
     * Runs commands in specific directory.
     *
     * @param whereToRun Directory for command.
     * @param command    command text.
     * @throws IOException
     */
    public void runCommand(File whereToRun, String command) throws IOException {
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
            isFinished = process.waitFor(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputStream.flush();
        outputStream.close();

        if (!isFinished) {
            process.destroyForcibly();
        }
    }

    /**
     * Print terminal answers.
     *
     * @param input
     * @throws IOException
     */
    private void print(InputStream input) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String singleLine;
            while ((singleLine = reader.readLine()) != null) {
                terminalOutput.add(singleLine);
                System.out.println(singleLine);
            }
        }
    }

}