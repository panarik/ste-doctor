package com.panarik.manager.command;

import java.util.LinkedList;

/**
 * Terminal command response.
 */
public class Response {

    private final LinkedList<String> responseOutput = new LinkedList<>();
    private final LinkedList<String> errorOutput = new LinkedList<>();

    public String getResponse() {
        StringBuilder builder = new StringBuilder();
        for (String line : responseOutput) builder.append(line).append('\n');
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    /**
     * Add line to response list.
     *
     * @param line terminal output line.
     */
    public void addResponseLine(String line) {
        responseOutput.add(line);
    }

    public void addErrorLine(String line) {
        errorOutput.add(line);
    }

}
