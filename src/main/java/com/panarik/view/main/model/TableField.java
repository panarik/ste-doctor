package com.panarik.view.main.model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableField extends JPanel {

    private final List<ToolPanel> tools = new ArrayList<>();

    public TableField() {
        tools.add(new ToolPanel("line1", new JButton("button 1"), new JTextArea("tool1 name")));
        tools.add(new ToolPanel("line2", new JButton("button 2"), new JTextArea("tool2 name")));
        for (ToolPanel tool : tools) add(tool);
        this.setLayout(new BoxLayout(this, 1));
    }

}
