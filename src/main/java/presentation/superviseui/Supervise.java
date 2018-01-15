package presentation.superviseui;


import javax.swing.*;
import java.awt.*;


public class Supervise {
    public void init() {

        JFrame frame = new JFrame("库存监管");


        JPanel panel = new JPanel();
        frame.add(panel);

        JButton button1 = new JButton("库存报溢");
        JButton button2 = new JButton("库存报损");
        JButton button3 = new JButton("库存报警");

        button1.setBounds(120, 200, 100, 30);
        button2.setBounds(340, 200, 100, 30);
        button3.setBounds(580, 200, 100, 30);

        panel.setLayout(null);
        panel.setBackground(Color.pink);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        frame.setBounds(550,250,800,600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
