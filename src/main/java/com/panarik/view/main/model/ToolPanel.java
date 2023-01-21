package com.panarik.view.main.model;

import com.panarik.command.CommandManager;
import com.panarik.command.model.Response;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ToolPanel extends JPanel {

    private String panelName;
    private JButton button;
    private JLabel icon;
    private JTextArea textField;

    public ToolPanel(String panelName, JButton button, JTextArea textField) {
        this.panelName = panelName;
        this.button = button;
        this.icon = new JLabel();
        this.textField = textField;
        addFields();
        configFields();
        this.setLayout(new BoxLayout(this, 0));
        this.icon.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/clear-30.png"))));
    }

    private void addFields() {
        this.add(button);
        this.add(icon);
        this.add(textField);
    }

    private void configFields() {
        textField.setMaximumSize(new Dimension(200, 50));
        button.addActionListener(e -> {
            Response response = new CommandManager().check("shell");
            icon.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/done-30.png"))));
            textField.setText(response.getResponse());
        });
    }

}
