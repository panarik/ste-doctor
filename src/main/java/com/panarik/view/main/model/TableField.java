package com.panarik.view.main.model;

import com.panarik.manager.database.Tool;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Vertical table with {@link ToolPanel} - tool panels.
 */
public class TableField extends JPanel {

    private final List<ToolPanel> toolPanels = new ArrayList<>(); // List of panel components.
    private final List<Tool> tools; // List of checkable tools.

    public TableField(List<Tool> tools) {
        this.tools = tools;
        for (Tool tool : tools) {
            for (String checker : tool.checkers) {
                toolPanels.add(new ToolPanel(tool.name, checker));
            }
        }
        for (ToolPanel tool : toolPanels) add(tool);
        this.setLayout(new BoxLayout(this, 1));
    }

}
