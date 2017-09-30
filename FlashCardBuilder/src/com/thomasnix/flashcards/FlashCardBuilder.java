package com.thomasnix.flashcards;

import sun.reflect.generics.scope.Scope;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //// JMenuBar and JMenu / JMenuItem for File
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuFile = new JMenu("File");
        JMenuItem jMenuItemNew = new JMenuItem("New");
        JMenuItem jMenuItemSave = new JMenuItem("Save");

        //// Menu Items
        jMenuItemNew.addActionListener(new NewMenuItemListener());
        jMenuItemSave.addActionListener(new SaveMenuItemListener());

        // Add items to menu
        jMenuFile.add(jMenuItemNew);
        jMenuFile.add(jMenuItemSave);

        // Add menu bar to JMenu
        jMenuBar.add(jMenuFile);

        // Adding components
        mainPanel.add(jLabelQuestion);
        mainPanel.add(jScrollPanelQuestion);
        mainPanel.add(jLabelAnswer);
        mainPanel.add(jScrollPanelAnswer);
        mainPanel.add(jButtonNext);

        // Action listeners

        //// Button
        jButtonNext.addActionListener(new NextCardListener());

        // Add menu to the frame
        jFrame.setJMenuBar(jMenuBar);

        // Add constraints to the frame
        jFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        jFrame.setSize(500,600);
        jFrame.setVisible(true);
    }

    /*
        Main - Run program and Swing utility (Flash card builder)
     */
    public static void main(String[] args){

        // Run FlashCardBuilder constructor - Set up application and frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardBuilder();
            }
        });
    }

    /*
        Listener for the Next button
     */
    class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Button clicked!");
        }
    }

    /*
        Listener for the New menu item
     */
    class NewMenuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("New menu item clicked!");
        }
    }

    /*
        Listener for the Save menu item
     */
    class SaveMenuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Save menu item clicked!");
        }
    }
}
