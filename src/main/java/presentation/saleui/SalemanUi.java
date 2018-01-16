package presentation.saleui;

import presentation.clientui.Client;
import presentation.importui.Export;
import presentation.importui.Import;

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
        JButton exportCommody = new JButton("制定进货退货单");
        JButton sale = new JButton("制定销售单");
        JButton sale_refund = new JButton("制定销售退货单");

        client.setBounds(100, 200, 90, 30);
        importCommody.setBounds(210, 200, 100, 30);
        exportCommody.setBounds(330, 200, 130, 30);
        sale.setBounds(480, 200, 100, 30);
        sale_refund.setBounds(600, 200, 130, 30);

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

        exportCommody.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Export().init();
            }
        });

        sale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaleForm().init();
            }
        });

        sale_refund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaleRefund().init();
            }
        });
        p.add(client);
        p.add(importCommody);
        p.add(sale);
        p.add(sale_refund);
        p.add(exportCommody);

        f.setBounds(550, 250, 800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

    public static void main(String[] args) {
        new SalemanUi().init();
    }
}
