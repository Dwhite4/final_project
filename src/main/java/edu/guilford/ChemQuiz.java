package edu.guilford;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//author david white

public class ChemQuiz{

    private JButton aButton = new JButton();
    private JButton bButton = new JButton();
    private JButton cButton = new JButton();
    private JButton dButton = new JButton();
    private JTextArea holdQuestion = new JTextArea();
    private JLabel answerA = new JLabel();
    private JLabel answerB = new JLabel();
    private JLabel answerC = new JLabel();
    private JLabel answerD = new JLabel();
    private JTextField correctAnswers = new JTextField("");
    
    //array holding chemestry questions
    String[] chemQuestions = {
        "What Element is Ar?",
        "Which one of these is a balanced Chemical Equasion?",
        "What is the equasion for finding the density of a solution?",
        "how many grams are in a nanogram?",
        "What is the mass in grams of 1 mole of As?",
        "What is the molecular formula for Methane?",
        "Who invented the Lewis Structure?"
    };
    //need 2 brackets because 2d array (array of arrays)
    String[][] chemOptions = {
        {"argon", "argan", "arsenic", "argonium"}, //a
        {"Ca(OH)2 + H3PO4 ---> Ca3(PO4)2 + H2O", "Zn + 2HCl ---> ZnCl2 + 2H2", "C5H12 + 8O2 ---> 5CO2 + 6H2O", "FeCl3 + NH4OH ---> Fe(OH)3 + NH4Cl"}, //c
        {"mass X volume", "volume/mass", "mass/volume", "mass + volume"}, //c
        {"10^11", "10^5", "10^15", "10^9"}, //d
        {"76.21g", "74.92g", "79.44g","70.00g"}, //b
        {"CH4", "CO4", "CO2", "CH2"}, //a
        {"John Lewie Newton", "Gilbert Lewis Newton", "Gilbert Isic Newton", "John Lewis Newton"}, //b
    };

    private int index;
    private int correctResponse;
    private int totalQuestions = 7;
    private char actualAnswer;
        //sets what the correct answers are 
    char[] chemAnswers = {
        'A',
        'C',
        'C',
        'D',
        'B',
        'A',
        'B',
    };
    
    public ChemQuiz(){
        JFrame quizFrame = new JFrame("Quiz Game");
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizFrame.pack();
        quizFrame.setVisible(true);
        

        quizFrame.setSize(new Dimension(500,500));
        quizFrame.setLayout(null);//if set to null, allows you to set absolute position insted of a generalized one like setLayo
        quizFrame.getContentPane().setBackground(Color.GRAY);

        holdQuestion.setBounds(0,0,500,50);
        holdQuestion.setLineWrap(true); //if text runs off screen it makes it go to next line 
        holdQuestion.setWrapStyleWord(true); // makes it so it wraps the whole word and makes it so it doesnt cut off a letter
        holdQuestion.setForeground(Color.BLACK); 
        holdQuestion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        holdQuestion.setBackground(Color.GRAY);
        holdQuestion.setEnabled(false);
        quizFrame.add(holdQuestion);

        aButton.setBounds(0,100,70,70);
        aButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        aButton.setText("A");
        aButton.addActionListener(new aButtonListener());
        quizFrame.add(aButton);
        
        bButton.setBounds(0,200,70,70);
        bButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        bButton.setText("B");
        bButton.addActionListener(new bButtonListener());
        quizFrame.add(bButton);

        cButton.setBounds(0,300,70,70);
        cButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        cButton.setText("C");
        cButton.addActionListener(new cButtonListener());
        quizFrame.add(cButton);
       
        dButton.setBounds(0,400,70,70);
        dButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        dButton.setText("D");
        dButton.addActionListener(new dButtonListener());
        quizFrame.add(dButton);
        
        answerA.setBounds(125,85,500,100);
        answerA.setForeground(Color.BLACK);
        answerA.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        quizFrame.add(answerA);

        answerB.setBounds(125,180,500,100);
        answerB.setForeground(Color.BLACK);
        answerB.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        quizFrame.add(answerB);

        answerC.setBounds(125,280,500,100);

        answerC.setForeground(Color.BLACK);
        answerC.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        quizFrame.add(answerC);

        answerD.setBounds(125,380,500,100);
        answerD.setForeground(Color.BLACK);
        answerD.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        quizFrame.add(answerD);

        correctAnswers.setBounds(285,362,200,100);
        correctAnswers.setBackground(Color.GRAY);
        correctAnswers.setForeground(Color.BLACK);
        correctAnswers.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        correctAnswers.setHorizontalAlignment(JTextField.CENTER);
        correctAnswers.setEditable(false);
        quizFrame.add(correctAnswers);
       
        changeQuestion();
    }

    public void changeQuestion(){      
        if (index>=totalQuestions){
        resultOfQuiz();
    }
    else { 
        holdQuestion.setText(chemQuestions[index]); //when question number increases, it gets the question the index is accosiated with 
        answerA.setText(chemOptions[index][0]); // looks at chemOptions and assigns correct index to button based on what the 
        answerB.setText(chemOptions[index][1]);
        answerC.setText(chemOptions[index][2]);
        answerD.setText(chemOptions[index][3]);
    }
    }


    private class aButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            

            if(e.getSource()==aButton){ // idea from lab 14 (checks to see if button is pressed)
                actualAnswer= 'A';
                if(actualAnswer == chemAnswers[index]) { //if the actual answer is the same as chemAnswers as the given index, increase correctResponse Index
                    correctResponse++;
                }
            }
            displayAnswer();
        }
       
    }
    
    private class bButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
           
            if (e.getSource()==bButton){
                actualAnswer= 'B';
                if(actualAnswer == chemAnswers[index]) {
                    correctResponse++;
                }
            }
            displayAnswer();  
        }
        
    }
    
    private class cButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
           
            if (e.getSource()==cButton){
                actualAnswer= 'C'; //sets actual answer
                if(actualAnswer == chemAnswers[index]) { //if the actual answer is c in the chem answers at that index,
                    correctResponse++;
                }
                displayAnswer();
            }
        }
        
    }
   
    private class dButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
           
            if (e.getSource()==dButton){
                actualAnswer = 'D';  
                if(actualAnswer == chemAnswers[index]) { //if match, increase final score
                    correctResponse++;
                }
                displayAnswer();
            }
        }  
    }
    public void displayAnswer() {
        index++;
        changeQuestion();
    }

    private void resultOfQuiz() {
        
        correctAnswers.setText(correctResponse+ " out of " + totalQuestions);
        
    }


}
