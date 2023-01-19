package com.panarik.view.main.model;

import javax.swing.*;

public class ToolPanel extends JPanel {

    public String panelName;
    public ToolField toolField;


    public ToolPanel(String panelName, ToolField toolField) {
        this.panelName = panelName;
        this.toolField = toolField;
        this.add(toolField.button);
        this.add(toolField.textField);
        this.setLayout(new BoxLayout(this, 0));
    }

}
