package edu.guilford;

import java.awt.font;
import java.awt.Dimension;




import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizPanel extends JPanel {

    private JLabel quizTitle;



    public QuizPanel(){
        super();
        initPanel();
    }

    public void initPanel() {
        setPreferredSize(new Dimension(600,600));

        quizTitle = new JLabel("Chemistry Quiz");
        quizTitle.setFont(new Font("Arial", font.BOLD, 20));
        add(quizTitle);


    }
}
