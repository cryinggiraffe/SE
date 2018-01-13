package presentation.promotionui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerUI extends JFrame {
    private static JButton bt_exit; //登出按钮
    private static JLabel jl_user; //当前用户
    private static JLabel jl_username; //当前用户姓名
    private static JPanel contentPane;//总经理的版面
    private static JFrame jf_1;//总经理界面的框架

    private static JButton bt_promotion;//制定促销策略按钮
    private static JButton bt_approve;//审批按钮
    private static JButton bt_busiProcess;//经营历程按钮
    private static JButton bt_transSituation;//经营情况按钮
    private static JButton bt_saleSituation;//销售情况按钮

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public ManagerUI (String name) {//初始化
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置字体1
        jf_1=new JFrame("总经理界面");
        jf_1.setSize(Width, Height);

        //标题栏
        jl_user = new JLabel("当前用户：总经理 ");
        jl_user.setBounds(450,30,140,30);
        jl_user.setFont(font);

        jl_username = new JLabel(name);//此处字符串后期变为获取到的用户名
        jl_username.setBounds(580,30,120,30);
        jl_username.setFont(font);

        bt_exit = new JButton("退出");
        bt_exit.setBounds(750,30,100,30);
        bt_exit.setFont(font);

        //设置界面的按钮
        Font font1 =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体1
        bt_promotion = new JButton("制定促销");
        bt_promotion.setBounds(270,250,120,50);
        bt_promotion.setFont(font1);

        bt_approve = new JButton("审批单据");
        bt_approve.setBounds(270,320,120,50);
        bt_approve.setFont(font1);

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
        contentPane = new JPanel();
        contentPane.setBounds(0,0,Width,Height);
        contentPane.setLayout(null);
        contentPane.setBackground(background);
        contentPane.add(jl_user);
        contentPane.add(jl_username);
        contentPane.add(bt_exit);

        contentPane.add(bt_promotion);
        contentPane.add(bt_approve);
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

        //制定促销事件处理
        ActionListener btPromotion_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into promotion manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_promotion.addActionListener(btPromotion_ls);

        //审批单据事件处理
        ActionListener btApprove_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into approve manage");
                //mainLayout ml=new mainLayout(jf_1);//为跳转的界面
                jf_1.setVisible(false);//隐藏当前界面
            }
        };
        bt_approve.addActionListener(btApprove_ls);

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

    public JFrame getJFrame (){
        return jf_1;
    }

    public static void main (String[] args) {
        //初始化
        ManagerUI managerUI = new ManagerUI("00001");
    }

}
