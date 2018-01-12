package presentation.userui;

import presentation.accountui.FinancialUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdministratorUI extends JFrame {
    private static JButton bt_1; //用户管理按钮
    private static JButton bt_exit; //登出按钮
    private static JLabel jl_user; //当前用户
    private static JLabel jl_username; //当前用户姓名
    private static JLabel jl_1;//管理员的版面
    private static JFrame jf_1;//管理员界面的框架

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public AdministratorUI () { //初始化
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置字体
        jf_1=new JFrame("管理员界面");
        jf_1.setSize(Width, Height);

        jl_user = new JLabel("当前用户：管理员 ");
        jl_user.setBounds(450,30,140,30);
        jl_user.setFont(font);

        jl_username = new JLabel("Adnimistrator");
        jl_username.setBounds(580,30,120,30);
        jl_username.setFont(font);

        bt_exit = new JButton("退出");
        bt_exit.setBounds(750,30,100,30);
        bt_exit.setFont(font);

        Font font1 =new Font("微软雅黑", Font.PLAIN, 20);//设置字体1
        bt_1 = new JButton("用户管理");
        bt_1.setBounds(290,315,320,50);
        bt_1.setFont(font1);

        JPanel contentPane = new JPanel();
        contentPane.setBounds(0,0,Width,Height);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.CYAN);
        contentPane.add(jl_user);
        contentPane.add(jl_username);
        contentPane.add(bt_1);
        contentPane.add(bt_exit);

        jf_1.setContentPane(contentPane);
        jf_1.setVisible(true);
        //jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_1.setLocation(500,200);
        jf_1.getContentPane().setBackground(background);

        //用户管理点击事件
        ActionListener bt1_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("into user manage");
                //mainLayout ml=new mainLayout();//为跳转的界面
                jf_1.dispose();//销毁当前界面
            }
        };
        bt_1.addActionListener(bt1_ls);

        //退出事件的处理
        ActionListener btExit_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };
        bt_exit.addActionListener(btExit_ls);

    }

    public JFrame getJFrame (){
        return jf_1;
    }

    public static void main(String[] args) {
        //初始化
        AdministratorUI administratorUI = new AdministratorUI();
    }
}

