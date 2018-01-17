package presentation.clientui;

import PO.ClientPO;
import businesslogic.clientbl.ClientBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindClient {
    public void findClient_init() {
        JFrame fframe = new JFrame("查找客户");
        JPanel fpanel = new JPanel();
        fframe.add(fpanel);
        fpanel.setBackground(Color.pink);
        fpanel.setLayout(null);
        JTextField textField = new JTextField("请您输入客户编号");
        textField.setBounds(200, 200, 200, 30);
        textField.setEditable(true);
        JTextField textField2 = new JTextField("请您输入客户姓名");
        textField2.setBounds(200, 250, 200, 30);
        textField2.setEditable(true);
        JButton search = new JButton("查找");
        search.setBounds(450, 200, 100, 30);
        JButton search2 = new JButton("查找");
        search2.setBounds(450, 250, 100, 30);
        fpanel.add(textField);
        fpanel.add(search);
        fpanel.add(textField2);
        fpanel.add(search2);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fframe.setVisible(false);
                String text = textField.getText();
                ClientBL clientBL = new ClientBL();
                ClientPO client = clientBL.findClient(text);
                if (client == null)
                    JOptionPane.showMessageDialog(null, "没有找到！", "错误消息", JOptionPane.WARNING_MESSAGE);
                else {
                    JFrame info_f = new JFrame("客户信息");
                    JPanel info_p = new JPanel();
                    info_f.add(info_p);
                    info_f.setBounds(600, 250, 400, 400);
                    info_f.setVisible(true);
                    info_p.setBackground(Color.orange);
                    info_p.setLayout(new FlowLayout());

                    JLabel l0 = new JLabel("客户编号:");
                    JTextField t0 = new JTextField(client.getId());
                    JLabel l1 = new JLabel("客户分类:");
                    JTextField t1 = new JTextField(client.getType());
                    JLabel l2 = new JLabel("级别：");
                    JTextField t2 = new JTextField(String.valueOf(client.getRank()));
                    JLabel l3 = new JLabel("姓名");
                    JTextField t3 = new JTextField(client.getName());
                    JLabel l4 = new JLabel("电话");
                    JTextField t4 = new JTextField(client.getPhone());
                    JLabel l5 = new JLabel("地址");
                    JTextField t5 = new JTextField(client.getAddress());
                    JLabel l6 = new JLabel("邮编");
                    JTextField t6 = new JTextField(client.getPostnum());
                    JLabel l7 = new JLabel("电子邮箱");
                    JTextField t7 = new JTextField(client.getEmail());
                    JLabel l8 = new JLabel("应收额度");
                    JTextField t8 = new JTextField(String.valueOf(client.getReceive_limit()));
                    JLabel l9 = new JLabel("应收");
                    JTextField t9 = new JTextField(String.valueOf(client.getReceive()));
                    JLabel l10 = new JLabel("应付");
                    JTextField t10 = new JTextField(String.valueOf(client.getSend()));
                    JLabel l11 = new JLabel("默认业务员");
                    JTextField t11 = new JTextField(client.getDefaultsalesman());

                    t0.setColumns(10);
                    t1.setColumns(10);
                    t2.setColumns(10);
                    t3.setColumns(10);
                    t4.setColumns(10);
                    t5.setColumns(10);
                    t6.setColumns(10);
                    t7.setColumns(10);
                    t8.setColumns(10);
                    t9.setColumns(10);
                    t10.setColumns(10);
                    t11.setColumns(10);

                    t0.setEditable(false);
                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);
                    t7.setEditable(false);
                    t8.setEditable(false);
                    t9.setEditable(false);
                    t10.setEditable(false);
                    t11.setEditable(false);

                    info_p.add(l0);
                    info_p.add(t0);
                    info_p.add(l1);
                    info_p.add(t1);
                    info_p.add(l2);
                    info_p.add(t2);
                    info_p.add(l3);
                    info_p.add(t3);
                    info_p.add(l4);
                    info_p.add(t4);
                    info_p.add(l5);
                    info_p.add(t6);
                    info_p.add(l6);
                    info_p.add(t6);
                    info_p.add(l7);
                    info_p.add(t7);
                    info_p.add(l8);
                    info_p.add(t8);
                    info_p.add(l9);
                    info_p.add(t9);
                    info_p.add(l10);
                    info_p.add(t10);
                    info_p.add(l11);
                    info_p.add(t11);


                }
            }
        });

        search2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fframe.setVisible(false);
                String text = textField2.getText();
                ClientBL clientBL = new ClientBL();
                ClientPO client = clientBL.findClient(text);
                if (client == null)
                    JOptionPane.showMessageDialog(null, "没有找到！", "错误消息", JOptionPane.WARNING_MESSAGE);
                else {
                    JFrame info_f = new JFrame("客户信息");
                    JPanel info_p = new JPanel();
                    info_f.add(info_p);
                    info_f.setBounds(600, 250, 400, 400);
                    info_f.setVisible(true);
                    info_p.setBackground(Color.orange);
                    info_p.setLayout(new FlowLayout());

                    JLabel l0 = new JLabel("客户编号:");
                    JTextField t0 = new JTextField(client.getId());
                    JLabel l1 = new JLabel("客户分类:");
                    JTextField t1 = new JTextField(client.getType());
                    JLabel l2 = new JLabel("级别：");
                    JTextField t2 = new JTextField(String.valueOf(client.getRank()));
                    JLabel l3 = new JLabel("姓名");
                    JTextField t3 = new JTextField(client.getName());
                    JLabel l4 = new JLabel("电话");
                    JTextField t4 = new JTextField(client.getPhone());
                    JLabel l5 = new JLabel("地址");
                    JTextField t5 = new JTextField(client.getAddress());
                    JLabel l6 = new JLabel("邮编");
                    JTextField t6 = new JTextField(client.getPostnum());
                    JLabel l7 = new JLabel("电子邮箱");
                    JTextField t7 = new JTextField(client.getEmail());
                    JLabel l8 = new JLabel("应收额度");
                    JTextField t8 = new JTextField(String.valueOf(client.getReceive_limit()));
                    JLabel l9 = new JLabel("应收");
                    JTextField t9 = new JTextField(String.valueOf(client.getReceive()));
                    JLabel l10 = new JLabel("应付");
                    JTextField t10 = new JTextField(String.valueOf(client.getSend()));
                    JLabel l11 = new JLabel("默认业务员");
                    JTextField t11 = new JTextField(client.getDefaultsalesman());

                    t0.setColumns(10);
                    t1.setColumns(10);
                    t2.setColumns(10);
                    t3.setColumns(10);
                    t4.setColumns(10);
                    t5.setColumns(10);
                    t6.setColumns(10);
                    t7.setColumns(10);
                    t8.setColumns(10);
                    t9.setColumns(10);
                    t10.setColumns(10);
                    t11.setColumns(10);

                    t0.setEditable(false);
                    t1.setEditable(false);
                    t2.setEditable(false);
                    t3.setEditable(false);
                    t4.setEditable(false);
                    t5.setEditable(false);
                    t6.setEditable(false);
                    t7.setEditable(false);
                    t8.setEditable(false);
                    t9.setEditable(false);
                    t10.setEditable(false);
                    t11.setEditable(false);

                    info_p.add(l0);
                    info_p.add(t0);
                    info_p.add(l1);
                    info_p.add(t1);
                    info_p.add(l2);
                    info_p.add(t2);
                    info_p.add(l3);
                    info_p.add(t3);
                    info_p.add(l4);
                    info_p.add(t4);
                    info_p.add(l5);
                    info_p.add(t6);
                    info_p.add(l6);
                    info_p.add(t6);
                    info_p.add(l7);
                    info_p.add(t7);
                    info_p.add(l8);
                    info_p.add(t8);
                    info_p.add(l9);
                    info_p.add(t9);
                    info_p.add(l10);
                    info_p.add(t10);
                    info_p.add(l11);
                    info_p.add(t11);


                }
            }
        });
        fframe.setVisible(true);
        fframe.setBounds(550, 250, 800, 600);

    }

    public static void main(String[] args) {
        new FindClient().findClient_init();
    }
}
