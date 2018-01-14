package presentation.viewui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    public void init() {
        JFrame vframe = new JFrame("查看库存");
        JTextField vtf = new JTextField("请输入查询时间段,格式为2010/01/01-2011/01/01");
        vtf.setBounds(100, 100, 280, 20);
        vtf.setColumns(20);
        JButton find = new JButton("查询");
        find.setBounds(400, 100, 70, 20);
        JButton check = new JButton("今日库存盘点");
        check.setBounds(100, 200, 120, 30);
        JPanel vpanel = new JPanel();
        vframe.add(vpanel);
        vpanel.setLayout(null);
        vpanel.setBackground(Color.pink);

        vpanel.add(vtf);
        vpanel.add(find);
        vpanel.add(check);

        vtf.setEditable(true);
//        vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vframe.setSize(600, 400);
        vframe.setVisible(true);

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new View().init();
    }
}
