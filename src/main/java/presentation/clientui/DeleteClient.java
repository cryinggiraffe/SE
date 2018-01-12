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
        dpanel.setLayout(new FlowLayout());
        JTextField textField = new JTextField("请您输入客户编号");
        textField.setColumns(20);
        textField.setEditable(true);
        JButton find = new JButton("查找");
        dpanel.add(textField);
        dpanel.add(find);

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dframe.setVisible(false);
                String text = textField.getText();
                ClientBL clientBL = new ClientBL();
                boolean find_or_not = clientBL.deleteClient(text);
                if (find_or_not == false)
                    JOptionPane.showMessageDialog(null, "没有匹配的客户！", "错误消息", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "删除成功！", "删除结果", JOptionPane.WARNING_MESSAGE);
            }
        });
        dframe.setVisible(true);
        dframe.setBounds(100, 100, 400, 600);

    }
}
