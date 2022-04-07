package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    //create all buttons (Load, Exit, etc.)
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        this.add(saveBtn);
        this.add(loadBtn);
        this.add(resetBtn);
        this.add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }


    private void save(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose the name and location for saving the game");
        int returnVal = fileChooser.showOpenDialog(saveBtn);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                ImageIO.write(frame.canvas.image, "PNG", file);
            } catch (IOException ex) {
                System.err.println(ex.toString());
            }
        }
    }


    private void load(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(loadBtn);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                reset(null);
                frame.canvas.image= ImageIO.read(file);
            } catch (IOException ex) {
                System.err.println(ex.toString());
            }
        }
    }

    private void reset(ActionEvent e) {
        frame.remove(frame.canvas);
        frame.canvas = new DrawingPanel(frame);
        frame.add(frame.canvas);
        frame.pack();
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }

}
