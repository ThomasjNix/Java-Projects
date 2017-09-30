package com.thomasnix.flashcards;

import sun.plugin.javascript.JSContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FlashCardPlayer {

    // Create structures and variables
    private JTextArea display;
    private JTextArea answer;
    private JButton jButtonShowAnswer;
    private ArrayList<FlashCard> cardList;
    private Iterator cardIterator;
    private FlashCard currentCard;
    private int currentCardIndex;
    private JFrame jFrame;
    private boolean isShowAnswer;


    // Build UI
    public FlashCardPlayer(){

        // Define Frame
        jFrame = new JFrame("Flash Card Player");
        JPanel mainPanel = new JPanel();
        Font appFont = new Font("Helvetica Nue", Font.BOLD, 22);

        // Define frame settings
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display = new JTextArea(10,20);
        display.setFont(appFont);

        // Structure jScrollPane for question
        JScrollPane jScrollPaneQuestion = new JScrollPane(display);
        jScrollPaneQuestion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneQuestion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Create next button
        jButtonShowAnswer = new JButton("Show Answer");
        jButtonShowAnswer.addActionListener(new ShowAnswerListener());

        // Create scrollbar
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenuItem jMenuItemLoad = new JMenuItem("Load Card Set");

        // Add load functionality
        jMenuItemLoad.addActionListener(new OpenMenuListener());

        // Create menu bar
        jMenu.add(jMenuItemLoad);
        jMenuBar.add(jMenu);
        jFrame.setJMenuBar(jMenuBar);

        // Define frame structure
        jFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        jFrame.setSize(600,500);
        jFrame.setVisible(true);

        // Apply frame to panel
        mainPanel.add(jScrollPaneQuestion);
        mainPanel.add(jButtonShowAnswer);

    }

    // Invoke program run
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardPlayer();
            }
        });
    }

    /*
        Class to define behavior on next button click based
        on state of the show answer boolean property
     */
    class ShowAnswerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isShowAnswer){
                display.setText(currentCard.getAnswer());
                jButtonShowAnswer.setText("Next Card");
                isShowAnswer = false;
            }else{
                if (cardIterator.hasNext()){
                    showNextCard();
                }else{
                    display.setText("End of cards");
                    jButtonShowAnswer.setEnabled(false);
                }

            }
        }
    }

    /*
        Class to define functionality of opening a file and calling the loadFile function
     */
    class OpenMenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(jFrame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    /*
        Loads in a file, grabs lines, and calls makeCard to parse / insert questions and
        answers into the cardList ArrayList
     */
    public void loadFile(File inFile){
        cardList = new ArrayList<FlashCard>();

        try{
            BufferedReader fileBR = new BufferedReader(new FileReader(inFile));
            String tempLineString;

            while ((tempLineString = fileBR.readLine()) != null){
                makeCard(tempLineString);
            }
        }catch (Exception e){
            System.out.println("Exception encountered:\n\t" + e.getMessage());
        }

        cardIterator = cardList.iterator();
        showNextCard();
    }

    /*
        Loads next card information from the ArrayList
     */
    private void showNextCard() {
        currentCard = (FlashCard) cardIterator.next();
        display.setText(currentCard.getQuestion());
        jButtonShowAnswer.setText("Show Answer");
        isShowAnswer = true;

    }

    /*
        Parses the line from the file and inserts it into the ArrayList
     */
    private void makeCard(String lineToParse) {
        String question = lineToParse.substring(0, lineToParse.lastIndexOf('/'));
        String answer = lineToParse.substring(lineToParse.lastIndexOf('/')+1, lineToParse.length());
        FlashCard interpretedCard = new FlashCard(question,answer);
        cardList.add(interpretedCard);
        System.out.println(interpretedCard.getQuestion());
        System.out.println(interpretedCard.getAnswer());

    }
}
