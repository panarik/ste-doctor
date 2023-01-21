package com.panarik.command;

import com.panarik.command.model.CommandController;
import com.panarik.command.model.Response;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class CommandManager {

    CommandController controller = CommandController.getInstance();

    // Debug commands.
    public static void main(String[] args) {
        try {
            new CommandManager().controller.runCommand(new File("/usr/local/test"), "ls");
            new CommandManager().controller.runCommand(new File("/usr/local/test"), "ls -a");
            new CommandManager().controller.runCommand(new File("/usr/local/test"), "pwd");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Runs terminal commands for specific tool check.
     *
     * @param toolName Tool name.
     * @return Response with answers from terminal.
     */
    public Response check(String toolName) {
        Response response = new Response();
        try {
            if (toolName.equals("shell")) // ToDo: database needed.
                response = controller.runCommand(new File("/usr/local/test"), "echo $SHELL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}