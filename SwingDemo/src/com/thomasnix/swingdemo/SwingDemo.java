package com.thomasnix.swingdemo;

import javax.swing.*;

public class SwingDemo {

    // Constructor
    SwingDemo(){

        // Create new JFrame
        JFrame jFrame = new JFrame("Frame Title");

        // Give the frame dimensions
        jFrame.setSize(270,100);

        // Terminate program on user close
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Show the frame
        jFrame.setVisible(true);

        // Create a jLabel
        JLabel jLabel = new JLabel("This is a label!");


        // Add components to frame
        jFrame.add(jLabel);

    }

    public static void main(String args[]){
        //Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
