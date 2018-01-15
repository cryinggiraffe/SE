package presentation.saleui;

import presentation.clientui.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalerUi {
    public void init() {
        JFrame frame = new JFrame("销售");
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton client = new JButton("客户管理");
        JButton cargo = new JButton("进退货管理");
        JButton sale = new JButton("销售管理");

        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Client().init();
            }
        });

        sale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sale().init();
            }
        });


        client.setBounds(100,100,10,10);
        cargo.setBounds(100,200,10,10);
        sale.setBounds(100,300,10,10);

        panel.add(client);
        panel.add(cargo);
        panel.add(sale);

        frame.setVisible(true);
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SalerUi().init();
    }
}
