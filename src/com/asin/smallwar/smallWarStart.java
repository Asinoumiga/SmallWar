package com.asin.smallwar;

import javax.swing.*;

public class smallWarStart {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(10, 10, 800, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(SmallWarGamePanel.getInstance());
        frame.setVisible(true);
    }
}
