package com.panarik.view.main;

import com.panarik.view.RootView;
import com.panarik.view.main.model.TableField;
import com.panarik.view.main.model.TitleButtonField;

import javax.swing.*;
import java.awt.*;

public class MainView extends RootView {

    public MainView() {
        configWindow();
        addFields();
    }

    private void configWindow() {
        int width = tools.getScreenCenter().width;
        int height = tools.getScreenCenter().height;
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(tools.getWindowCenter(width, height));
        setTitle("ste-doctor");
    }

    private void addFields() {
        add(new TitleButtonField("Check"), BorderLayout.NORTH);
        add(new TableField());
        this.revalidate();
    }



}
