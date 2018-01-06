package UI;

import javax.swing.*;
import java.awt.*;

public class Supervise {
    public static void createAndShowSuperviseGUI() {

        JFrame frame = new JFrame("库存监管");


        JPanel panel = new JPanel();
        Container container = frame.getContentPane();


        JButton button1 = new JButton("库存报溢");
        JButton button2 = new JButton("库存报损");
        JButton button3 = new JButton("库存报警");

        container.setLayout(new FlowLayout());
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        container.add(panel);

        frame.setBounds(100, 100, 800, 800);
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}