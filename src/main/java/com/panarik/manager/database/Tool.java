package com.panarik.manager.database;

import java.util.List;

/**
 * Specific tool with check list from database.
 */
public class Tool {

    public final String name; // Tool name.
    public final List<String> checkers; // List with check names.

    public Tool(String name, List<String> checkers) {
        this.name = name;
        this.checkers = checkers;
    }

}
