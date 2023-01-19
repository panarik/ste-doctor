package com.panarik.view.main.model;

import javax.swing.*;
import java.awt.*;

public class ToolField {

    JButton button;
    JTextField textField;

    public ToolField(JButton button, JTextField textField) {
        this.button = button;
        this.textField = textField;
        textField.setMaximumSize(new Dimension(200, 50));
    }

}
