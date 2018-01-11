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
        panel.setBackground(Color.orange);
        frame.add(panel);
        JButton addClient = new JButton("添加客户");
        JButton deleteClient = new JButton("删除客户");
        JButton editClient = new JButton("修改信息");
        JButton findClient = new JButton("查找客户");


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
        frame.setSize(400, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Client().init();
    }
}
