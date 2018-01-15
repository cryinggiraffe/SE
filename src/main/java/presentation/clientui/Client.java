package presentation.clientui;

import PO.ClientPO;
import businesslogic.clientbl.ClientBL;
import presentation.saleui.Sale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client {
    public void init() {
        JFrame frame = new JFrame("客户管理");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.orange);
        frame.add(panel);
        JButton addClient = new JButton("添加客户");
        JButton deleteClient = new JButton("删除客户");
        JButton editClient = new JButton("修改信息");
        JButton findClient = new JButton("查找客户");


        addClient.setBounds(120, 200, 100, 30);
        deleteClient.setBounds(280, 200, 100, 30);
        editClient.setBounds(420, 200, 100, 30);
        findClient.setBounds(580, 200, 100, 30);

        panel.add(addClient);
        panel.add(deleteClient);
        panel.add(editClient);
        panel.add(findClient);

        addClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddClient().addClient_init();
            }
        });

        deleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new DeleteClient().deleteClient_init();
            }
        });

        editClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditClient().editClient_init();
            }
        });

        findClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindClient().findClient_init();
            }
        });

        frame.setVisible(true);
        frame.setBounds(550, 250, 800, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Client().init();
    }
}
