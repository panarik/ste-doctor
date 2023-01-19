package com.panarik.view.main.model;

import javax.swing.*;
import java.util.List;

public class TableField extends JPanel {

    List<ToolPanel> tools;

    public TableField(List<ToolPanel> tools) {
        this.tools = tools;
        init();
    }

    private void init() {
        for (ToolPanel tool : tools) add(tool);
        this.setLayout(new BoxLayout(this, 1));
    }

}
