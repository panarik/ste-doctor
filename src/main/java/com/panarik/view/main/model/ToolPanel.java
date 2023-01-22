package com.panarik.view.main.model;

import com.panarik.manager.CommandManager;
import com.panarik.manager.command.Response;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Horizontal panel with checkable tools fields.
 */
public class ToolPanel extends JPanel {

    private JButton button;
    private JLabel icon;
    private JTextArea textField;
    private String toolName;
    private String checkerName;

    public ToolPanel(String toolName, String checkerName) {
        this.toolName = toolName;
        this.checkerName = checkerName;
        this.button = new JButton(toolName + " - " + checkerName);
        this.icon = new JLabel();
        this.textField = new JTextArea();
        addFields();
        configFields();
        this.setLayout(new BoxLayout(this, 0));
        this.icon.setIcon(new ImageIcon("resources/icons/clear-30.png"));
    }

    private void addFields() {
        this.add(button);
        this.add(icon);
        this.add(textField);
    }

    private void configFields() {
        textField.setMaximumSize(new Dimension(400, 50));
        button.addActionListener(e -> {
            Response response = new CommandManager().check(toolName, checkerName);
            icon.setIcon(new ImageIcon("resources/icons/ok-30.png"));
            textField.setText(response.getResponse());
        });
    }

}
