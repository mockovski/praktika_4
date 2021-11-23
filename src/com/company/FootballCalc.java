package com.company;
//библиотеки
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FootballCalc extends JFrame {
    private int RM = 0;//изначально 0 очков у реал мадрида
    private int ACM = 0;//изначально 0 очков у милана
    private String Last_Scorer = "N/A";//изначально не определена команда забившая последний гол
    private String win = "DRAW";//изначально написать DRAW
    private JButton addPointRM;//кнопка добавляет 1 очко реал мадриду
    private JButton addPointACM;//кнопка добавляет очко милану
    private JLabel result;// переменная результат (0 X 0 - изначально)
    private JLabel last_score;//показывает команду, последнюю забившую гол
    private Label winner;//переменна, показывающая победителя

    public FootballCalc() {
        super("Football RM VS Milan");//название для окна
        this.result = new JLabel("Result : " + this.RM + " X " + this.ACM);//отображает текущую ситуацию по очкам
        this.last_score = new JLabel("Last Scorer : " + this.Last_Scorer);//вывод команды, которая последняя забила гол
        this.winner = new Label("Winner: " + this.win);//победитель
        this.addPointRM = new JButton("Real Madrid");//кнопка real madrid
        this.addPointACM = new JButton("AC Milan");//кнопка milan
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout((LayoutManager)null);
        buttonsPanel.add(this.addPointRM);
        this.addPointRM.setBounds(10, 5, 120, 30);//координаты
        buttonsPanel.add(this.addPointACM);
        this.addPointACM.setBounds(10, 45, 120, 30);
        buttonsPanel.add(this.result);
        this.result.setBounds(140, 1, 85, 30);
        buttonsPanel.add(this.last_score);
        this.last_score.setBounds(140, 20, 300, 30);
        buttonsPanel.add(this.winner);
        this.winner.setBounds(140, 50, 300, 30);
        this.add(buttonsPanel);
        this.setBounds(100, 100, 350, 120);
        this.setDefaultCloseOperation(3);
        this.initListeners();
    }

    private void updateScoreCounter() {
        this.result.setText("Result : " + this.RM + " X " + this.ACM);//отображает результат
        this.last_score.setText("Last Scorer : " + this.Last_Scorer);//отображает команду последнюю забившую гол
        if (this.RM == 5 || this.ACM == 5) {//если счет одной команды равен 5, то та команда победила
            this.winner.setText("Winner: " + this.win);//отображает победителя
            this.addPointRM.setEnabled(false);//выключить кнопку при завершении
            this.addPointACM.setEnabled(false);//выключить кнопку при завершении
        }

    }

    private void initListeners() {
        this.addPointRM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++FootballCalc.this.RM;//добавляет 1 очко real madrid
                FootballCalc.this.Last_Scorer = "Real Madrid";//после гола написать реал мадрид как последнюю забившую гол
                FootballCalc.this.win = "Real Madrid";
                FootballCalc.this.updateScoreCounter();//обновить счет
            }
        });
        this.addPointACM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ++FootballCalc.this.ACM;//добавляет 1 очко milan
                FootballCalc.this.Last_Scorer = "AC Milan";//после гола написать милан как последнюю забившую гол
                FootballCalc.this.win = "AC Milan";
                FootballCalc.this.updateScoreCounter();//обновить счет
            }
        });
    }
}
