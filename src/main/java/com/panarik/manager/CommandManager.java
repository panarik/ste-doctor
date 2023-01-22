package com.panarik.manager;

import com.panarik.manager.command.CommandController;
import com.panarik.manager.command.Response;
import com.panarik.manager.database.DatabaseController;
import com.panarik.manager.database.Tool;
import com.panarik.view.main.MainView;

import java.io.*;
import java.util.List;

public class CommandManager {

    // Controllers.
    CommandController command = CommandController.getInstance();
    DatabaseController dataBase = DatabaseController.getInstance();

    // Windows.
    MainView mainView;

    // Debug commands.
    public static void main(String[] args) {
        try {
            new CommandManager().command.runCommand(new File("/usr/local/test"), "ls");
            new CommandManager().command.runCommand(new File("/usr/local/test"), "ls -a");
            new CommandManager().command.runCommand(new File("/usr/local/test"), "pwd");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startMain() {

        // Request tasks (ToolName and VerifyName) from DB.
        List<Tool> tools = dataBase.getTools(); // list with all tools and all checkers.

        // Create main window object with requested tools.
        mainView = new MainView(tools);

        // Receive controllers





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
                response = command.runCommand(new File("/usr/local/test"), "echo $SHELL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}