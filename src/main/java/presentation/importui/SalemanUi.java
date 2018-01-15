package presentation.importui;

import presentation.clientui.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalemanUi {
    public void init() {
        JFrame f = new JFrame("销售人员界面");
        JPanel p = new JPanel();
        p.setBackground(Color.pink);
        f.add(p);
        p.setLayout(null);
        JButton client = new JButton("客户管理");
        JButton importCommody = new JButton("制定进货单");
        JButton sale = new JButton("制定销售单");

        client.setBounds(120, 200, 100, 30);
        importCommody.setBounds(340, 200, 100, 30);
        sale.setBounds(580, 200, 100, 30);

        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Client().init();
            }
        });

        importCommody.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Import().init();
            }
        });

        sale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaleForm().init();
            }
        });

        p.add(client);
        p.add(importCommody);
        p.add(sale);

        f.setBounds(550,250,800,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

    public static void main(String[] args) {
        new SalemanUi().init();
    }
}
