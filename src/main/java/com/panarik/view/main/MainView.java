package com.panarik.view.main;

import com.panarik.manager.database.Tool;
import com.panarik.view.RootView;
import com.panarik.view.main.model.TableField;
import com.panarik.view.main.model.TitleButtonField;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainView extends RootView {

    private List<Tool> tools;

    public MainView(List<Tool> tools) {
        this.tools = tools;
        configWindow();
        addFields();
    }

    private void configWindow() {
        int width = screenTools.getScreenCenter().width +200;
        int height = screenTools.getScreenCenter().height;
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(screenTools.getWindowCenter(width, height));
        setTitle("ste-doctor");
    }

    private void addFields() {
        add(new TitleButtonField("Check all"), BorderLayout.NORTH); // 'Check all' button on top of window.
        add(new TableField(tools)); // Table with tools checkers.
        this.revalidate();
    }


}
