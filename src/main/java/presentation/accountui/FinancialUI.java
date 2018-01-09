package presentation.accountui;

import presentation.userui.AdministratorUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialUI extends JFrame{
    private static JButton bt_exit; //登出按钮
    private static JLabel jl_user; //当前用户
    private static JLabel jl_username; //当前用户姓名
    private static JLabel jl_1;//财务员的版面
    private static JFrame jf_1;//财务员界面的框架

    private static JButton bt_account;//账户管理按钮
    private static JButton bt_bill;//财务管理按钮
    private static JButton bt_initialAccount;//期初建账按钮
    private static JButton bt_busiProcess;//经营历程按钮
    private static JButton bt_transSituation;//经营情况按钮
    private static JButton bt_saleSituation;//销售情况按钮


    private static int Width = 900;
    private static int Height = 700;

    public FinancialUI () {//初始化
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置字体1
        jf_1=new JFrame("财务人员界面");
        jf_1.setSize(Width, Height);

        //标题栏
        jl_user = new JLabel("当前用户：财务员 ");
        jl_user.setBounds(450,30,140,30);
        jl_user.setFont(font);

        jl_username = new JLabel("01001");//此处字符串后期变为获取到的用户名
        jl_username.setBounds(580,30,120,30);
        jl_username.setFont(font);

        bt_exit = new JButton("退出");
        bt_exit.setBounds(750,30,100,30);
        bt_exit.setFont(font);

        //设置界面的按钮
        Font font1 =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体1
        bt_account = new JButton("账户管理");
        bt_account.setBounds(270,250,120,50);
        bt_account.setFont(font1);

        bt_bill = new JButton("财务管理");
        bt_bill.setBounds(270,320,120,50);
        bt_bill.setFont(font1);

        bt_initialAccount = new JButton("期初建账");
        bt_initialAccount.setBounds(270,390,120,50);
        bt_initialAccount.setFont(font1);

        bt_busiProcess = new JButton("经营历程");
        bt_busiProcess.setBounds(510,250,120,50);
        bt_busiProcess.setFont(font1);

        bt_transSituation = new JButton("经营情况");
        bt_transSituation.setBounds(510,320,120,50);
        bt_transSituation.setFont(font1);

        bt_saleSituation = new JButton("销售情况");
        bt_saleSituation.setBounds(510,390,120,50);
        bt_saleSituation.setFont(font1);

        //向panel添加按钮
        JPanel contentPane = new JPanel();
        contentPane.setBounds(0,0,Width,Height);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);
        contentPane.add(jl_user);
        contentPane.add(jl_username);
        contentPane.add(bt_exit);

        contentPane.add(bt_account);
        contentPane.add(bt_bill);
        contentPane.add(bt_initialAccount);
        contentPane.add(bt_busiProcess);
        contentPane.add(bt_transSituation);
        contentPane.add(bt_saleSituation);


        //向frame添加panel
        jf_1.setContentPane(contentPane);
        jf_1.setVisible(true);
        //jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_1.setLocation(500,200);


        //退出事件的处理
        ActionListener btExit_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };
        bt_exit.addActionListener(btExit_ls);

        //账户管理事件处理
        ActionListener btAccount_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into account manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_account.addActionListener(btAccount_ls);

        //财务管理事件处理
        ActionListener btBill_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into bill manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_bill.addActionListener(btBill_ls);

        //期初建账事件处理
        ActionListener btInitialAccount_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into initial account manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_initialAccount.addActionListener(btInitialAccount_ls);

        //经营历程事件处理
        ActionListener btBusiProcess_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into business process manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_busiProcess.addActionListener(btBusiProcess_ls);

        //经营情况事件处理
        ActionListener btTransSituation_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into translation situation manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_transSituation.addActionListener(btTransSituation_ls);

        //销售情况事件处理
        ActionListener btSaleSituation_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into sale situation manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_saleSituation.addActionListener(btSaleSituation_ls);
    }

    public static void main (String[] args) {
        //初始化
        FinancialUI financialUI = new FinancialUI();
    }

}
