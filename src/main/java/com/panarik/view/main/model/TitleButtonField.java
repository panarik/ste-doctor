package com.panarik.view.main.model;

import javax.swing.*;
import java.awt.*;

public class TitleButtonField extends JButton {

    public TitleButtonField(String name) {
        super(name);
        this.setFont(new Font("Serif", Font.BOLD, 18));
        this.setPreferredSize(new Dimension(100, 50));
        this.revalidate();
    }

}
