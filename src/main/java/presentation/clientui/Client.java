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
                addClient_init();
            }
        });

        deleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient_init();
            }
        });

        editClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        findClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setVisible(true);
        frame.setSize(400, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addClient_init() {
        JFrame aframe = new JFrame("添加客户信息");
        aframe.setBounds(100, 100, 620, 200);
        JPanel apanel = new JPanel();
        apanel.setBackground(Color.pink);
        aframe.setContentPane(apanel);
        apanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//        JLabel id = new JLabel("客户编号");
//        //这里调用bl层提供的方法自动生成一个客户编号
        JLabel client_class = new JLabel("客户分类:");
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem("进货商");
        comboBox1.addItem("销售商");
        JLabel status = new JLabel("级别：");
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem("1");
        comboBox2.addItem("2");
        comboBox2.addItem("3");
        comboBox2.addItem("4");
        comboBox2.addItem("5");
        JLabel name = new JLabel("姓名");
        JTextField textField1 = new JTextField();
        JLabel tel = new JLabel("电话");
        JTextField textField2 = new JTextField();
        JLabel address = new JLabel("地址");
        JTextField textField3 = new JTextField();
        JLabel postcode = new JLabel("邮编");
        JTextField textField4 = new JTextField();
        JLabel email = new JLabel("电子邮箱");
        JTextField textField5 = new JTextField();
        JLabel receive = new JLabel("应收额度");
        JTextField textField6 = new JTextField();
        JLabel receive2 = new JLabel("应收");
        JTextField textField7 = new JTextField();
        JLabel pay = new JLabel("应付");
        JTextField textField8 = new JTextField();

        //这里最好是下拉菜单似的。。。。
        JLabel person = new JLabel("默认业务员");
        JTextField textField9 = new JTextField();

        textField1.setColumns(10);
        textField2.setColumns(10);
        textField3.setColumns(30);
        textField4.setColumns(10);
        textField5.setColumns(10);
        textField6.setColumns(10);
        textField7.setColumns(10);
        textField8.setColumns(10);
        textField9.setColumns(10);

        apanel.add(client_class);
        apanel.add(comboBox1);
        apanel.add(status);
        apanel.add(comboBox2);
        apanel.add(name);
        apanel.add(textField1);
        apanel.add(tel);
        apanel.add(textField2);
        apanel.add(address);
        apanel.add(textField3);
        apanel.add(postcode);
        apanel.add(textField4);
        apanel.add(email);
        apanel.add(textField5);
        apanel.add(receive);
        apanel.add(textField6);
        apanel.add(receive2);
        apanel.add(textField7);
        apanel.add(pay);
        apanel.add(textField8);
        apanel.add(person);
        apanel.add(textField9);


        JButton submit = new JButton("提交");
        submit.setBounds(450, 190, 10, 10);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /*这儿有问题*/
                String id = "1";
                int yes_or_no = JOptionPane.showConfirmDialog(null, "确定提交？", "确定提交信息", JOptionPane.OK_CANCEL_OPTION);
                if (yes_or_no == 2) {
                    return;
                } else {
                    String type = comboBox1.getSelectedItem().toString();
                    String rank = comboBox2.getSelectedItem().toString();
                    int rank2 = Integer.valueOf(rank);
                    String sname = textField1.getText();
                    String stel = textField2.getText();
                    String saddress = textField3.getText();
                    String spostcode = textField4.getText();
                    String semail = textField5.getText();
                    String sreceive = textField6.getText();
                    Double receive_limit = Double.valueOf(sreceive);
                    String sreceive2 = textField7.getText();
                    Double receive_0 = Double.valueOf(sreceive2);
                    String spay = textField8.getText();
                    Double send = Double.valueOf(spay);
                    String defaultsalesman = textField9.getText();

                    ClientPO client = new ClientPO(id, type, rank2, sname, stel, saddress, spostcode, semail, receive_limit, receive_0, send, defaultsalesman);
                    new ClientBL().newClient(client);

                }
            }
        });
        apanel.add(submit);

        aframe.setVisible(true);

    }

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

            }
        });
        dframe.setVisible(true);
        dframe.setBounds(100, 100, 400, 600);

    }

    public void editClient_init() {

    }

    public void findClient_init() {

    }

    public static void main(String[] args) {
        new Client().init();
    }
}
