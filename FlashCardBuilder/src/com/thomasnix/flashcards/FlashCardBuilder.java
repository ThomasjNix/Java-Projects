package com.thomasnix.flashcards;

import sun.reflect.generics.scope.Scope;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlashCardBuilder {

    private JTextArea jTextQuestion;
    private JTextArea jTextAnswer;
    private ArrayList<FlashCard> cardList;
    private JFrame jFrame;


    FlashCardBuilder(){

        // Set up frame
        jFrame = new JFrame("Flash Card");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //// Create JPanel
        JPanel mainPanel = new JPanel();

        //// Set font
        Font appFont = new Font("Helvetica New", Font.BOLD, 22);

        // Components

        //// jTextQuestion, 6 rows by 20 columns with line wrap
        jTextQuestion = new JTextArea(6,20);
        jTextQuestion.setLineWrap(true);
        jTextQuestion.setWrapStyleWord(true);
        jTextQuestion.setFont(appFont);

        //// jTextQuestion, 6 rows by 20 columns with line wrap
        jTextAnswer = new JTextArea(6,20);
        jTextAnswer.setLineWrap(true);
        jTextAnswer.setWrapStyleWord(true);
        jTextAnswer.setFont(appFont);

        ////JScrollPane for jTextQuestion
        JScrollPane jScrollPanelQuestion = new JScrollPane(jTextQuestion);
        jScrollPanelQuestion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPanelQuestion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //// JScrollPane for jTextAnswer, set vertical scroll (no horizontal)
        JScrollPane jScrollPanelAnswer = new JScrollPane(jTextAnswer);
        jScrollPanelAnswer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPanelAnswer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //// JButton for next card
        JButton jButtonNext = new JButton("Next Card");

        //// JLabels
        JLabel jLabelQuestion = new JLabel("Question");
        JLabel jLabelAnswer = new JLabel("Answer");

        //Adding components
        mainPanel.add(jLabelQuestion);
        mainPanel.add(jScrollPanelQuestion);
        mainPanel.add(jLabelAnswer);
        mainPanel.add(jScrollPanelAnswer);
        mainPanel.add(jButtonNext);


        // Add constraints to the pane
        jFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        jFrame.setSize(500,600);
        jFrame.setVisible(true);
    }

    public static void main(String[] args){

        // Run FlashCardBuilder constructor - Set up application and frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardBuilder();
            }
        });
    }
}
