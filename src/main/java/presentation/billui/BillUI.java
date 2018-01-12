package presentation.billui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillUI extends JPanel {
    private static JButton bt_receipt; //创建收款单按钮
    private static JButton bt_payment; //创建收款单按钮
    private static JButton bt_cash; //创建收款单按钮

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public BillUI (String name) {

        //设置界面的按钮
        Font font1 =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体1
        bt_receipt = new JButton("创建收款单");
        bt_receipt.setBounds(170,325,150,50);
        bt_receipt.setFont(font1);

        bt_payment = new JButton("创建付款单");
        bt_payment.setBounds(350,325,150,50);
        bt_payment.setFont(font1);

        bt_cash = new JButton("创建现金费用单");
        bt_cash.setBounds(530,325,200,50);
        bt_cash.setFont(font1);

        //向panel添加按钮
        this.setBounds(0,0,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_receipt);
        this.add(bt_payment);
        this.add(bt_cash);

        this.setVisible(true);

        //创建收款单按钮事件
        ActionListener btReceipt_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into receipt");
                ReceiptUI receiptUI = new ReceiptUI(name);

            }
        };
        bt_receipt.addActionListener(btReceipt_ls);

        //创建付款单按钮事件
        ActionListener btPayment_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into user manage");
                //mainLayout ml=new mainLayout();//为跳转的界面

            }
        };
        bt_payment.addActionListener(btPayment_ls);

        //创建现金费用单按钮事件
        ActionListener btCash_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into user manage");
                //mainLayout ml=new mainLayout();//为跳转的界面

            }
        };
        bt_cash.addActionListener(btCash_ls);

    }

}
