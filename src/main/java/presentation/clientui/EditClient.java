package presentation.clientui;

import PO.ClientPO;
import businesslogic.clientbl.ClientBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditClient {
    public void editClient_init() {
        JFrame fframe = new JFrame("修改客户信息");
        JPanel fpanel = new JPanel();
        fframe.add(fpanel);
        fpanel.setBackground(Color.pink);
        fpanel.setLayout(new FlowLayout());
        JTextField textField = new JTextField("请您输入客户编号");
        textField.setColumns(20);
        textField.setEditable(true);
        JButton search = new JButton("查找");
        fpanel.add(textField);
        fpanel.add(search);

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fframe.setVisible(false);
                String text = textField.getText();
                ClientBL clientBL = new ClientBL();
                ClientPO client = clientBL.findClient(text);
                if (client == null)
                    JOptionPane.showMessageDialog(null, "没有找到！请您添加新客户。", "错误消息", JOptionPane.WARNING_MESSAGE);
                else {
                    JFrame info_f = new JFrame("客户信息");
                    JPanel info_p = new JPanel();
                    info_f.add(info_p);
                    info_f.setBounds(100, 100, 400, 600);
                    info_f.setVisible(true);
                    info_p.setBackground(Color.pink);
                    info_p.setLayout(new FlowLayout());

                    JLabel l0 = new JLabel("客户编号:");
                    JTextField t0 = new JTextField(client.getId());
                    JLabel l1 = new JLabel("客户分类:");
                    JTextField t1 = new JTextField(client.getType());
                    JLabel l2 = new JLabel("级别：");
                    JTextField t2 = new JTextField(client.getRank());
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
                    t0.setEditable(false);
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

                    JButton submit = new JButton("提交");
                    info_p.add(submit);
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int yes_or_no = JOptionPane.showConfirmDialog(null, "确定修改吗？", "确认窗口", JOptionPane.OK_CANCEL_OPTION);
                            if (yes_or_no == 2)
                                return;
                            else {
                                String clientId = t0.getText();
                                String type = t1.getText();
                                String rank = t2.getText();
                                int rank2;
                                try {
                                    rank2 = Integer.valueOf(rank);
                                } catch (Exception exception) {
                                    JOptionPane.showMessageDialog(null, "级别格式错误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                String sname = t3.getText();
                                String stel = t4.getText();
                                String saddress = t5.getText();
                                String spostcode = t6.getText();
                                String semail = t7.getText();
                                String sreceive = t8.getText();
                                Double receive_limit;
                                try {
                                    receive_limit = Double.valueOf(sreceive);
                                } catch (Exception e1) {
                                    JOptionPane.showMessageDialog(null, "应收额度格式错误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                String sreceive2 = t9.getText();
                                Double receive_0;
                                try {
                                    receive_0 = Double.valueOf(sreceive2);
                                } catch (Exception e2) {
                                    JOptionPane.showMessageDialog(null, "应收格式错误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                String spay = t10.getText();
                                Double send;
                                try {
                                    send = Double.valueOf(spay);
                                } catch (Exception e3) {
                                    JOptionPane.showMessageDialog(null, "应付格式错误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                                String defaultsalesman = t11.getText();

                                ClientPO client = new ClientPO(clientId, type, rank2, sname, stel, saddress, spostcode, semail, receive_limit, receive_0, send, defaultsalesman);
                                new ClientBL().updateClient(client);
                                info_f.setVisible(false);

                            }
                        }
                    });


                }
            }
        });
        fframe.setVisible(true);
        fframe.setBounds(100, 100, 400, 600);

    }

    public static void main(String[] args) {
        new EditClient().editClient_init();
    }
}
