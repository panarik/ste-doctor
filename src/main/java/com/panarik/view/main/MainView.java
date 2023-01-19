package com.panarik.view.main;

import com.panarik.view.RootView;
import com.panarik.view.main.model.TableField;
import com.panarik.view.main.model.ToolField;
import com.panarik.view.main.model.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class MainView extends RootView {

    // Window configs.
    int width = tools.getScreenCenter().width;
    int height = tools.getScreenCenter().height;

    // View components.
    JButton checkButton = new JButton("Check");


    public MainView() {
        start();
        addCheckButton(checkButton);
        addList();
    }
    private void start() {
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(tools.getWindowCenter(width, height));
    }

    private void addCheckButton(JButton checkButton) {
        checkButton.setFont(new Font("Serif", Font.BOLD, 18));
        checkButton.setPreferredSize(new Dimension(100, 50));
        add(checkButton, BorderLayout.NORTH);
        checkButton.revalidate();
    }

    private void addList() {
        ToolPanel line1 = new ToolPanel("line1", new ToolField(new JButton("button 1"), new JTextField("tool1 name")));
        ToolPanel line2 = new ToolPanel("line2", new ToolField(new JButton("button 2"), new JTextField("tool2 name")));
        TableField table = new TableField(Arrays.asList(line1, line2));
        add(table);
        table.revalidate();
    }

}
