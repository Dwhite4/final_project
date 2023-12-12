package edu.guilford;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        
       JFrame quizFrame = new JFrame("Quiz Game");
       quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel xPanel = new JPanel();

       QuizPanel quizPanel = new QuizPanel();

       xPanel.add(quizPanel);
       quizFrame.add(xPanel);
       quizFrame.pack();
       quizFrame.setVisible(true);


       
    }


}

   

