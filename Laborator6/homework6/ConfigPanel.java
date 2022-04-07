package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1;
    JSpinner spinner2;
    JButton createBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner

        label = new JLabel("Grid size:");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createBtn = new JButton("Create");
        //create spinners for rows and cols, and the button

        add(label); //JPanel uses FlowLayout by default
        add(spinner1);
        add(spinner2);
        add(createBtn);

        createBtn.addActionListener(this::create);
    }

    public int getRows() {
        return (int) spinner1.getValue();
    }

    public int getCols() {
        return (int) spinner2.getValue();
    }

    private void create(ActionEvent e){
        frame.remove(frame.canvas);
        frame.canvas = new DrawingPanel(frame);
        frame.add(frame.canvas);
        frame.pack();
    }
}
