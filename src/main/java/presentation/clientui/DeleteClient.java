package presentation.clientui;

import businesslogic.clientbl.ClientBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteClient {
    public void deleteClient_init() {
        JFrame dframe = new JFrame("删除客户");
        JPanel dpanel = new JPanel();
        dframe.add(dpanel);
        dpanel.setBackground(Color.orange);
        dpanel.setLayout(null);
        JTextField textField = new JTextField("请您输入客户编号");

        textField.setBounds(200,100,200,30);
        textField.setColumns(20);
        textField.setEditable(true);
        JButton find = new JButton("删除");
        find.setBounds(420,100,70,30);
        dpanel.add(textField);
        dpanel.add(find);

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dframe.setVisible(false);
                String text = textField.getText();
                ClientBL clientBL = new ClientBL();
                clientBL.deleteClient(text);
            }
        });
        dframe.setVisible(true);
        dframe.setBounds(550, 250, 800, 600);

    }

    public static void main(String[] args) {
        new DeleteClient().deleteClient_init();
    }
}
