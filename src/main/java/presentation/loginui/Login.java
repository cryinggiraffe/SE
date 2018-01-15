package presentation.loginui;

import businesslogic.loginbl.LoginBL;
import presentation.accountui.FinancialUI;
import presentation.goodui.StockManagerUi;
import presentation.promotionui.ManagerUI;
import presentation.saleui.SalerUi;
import presentation.userui.AdministratorUI;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame{
    private static int count=0;
    private static JButton bt1;//登陆按钮
    private static JButton bt2;//忘记密码按钮
    private static JLabel jl_1;//登录的版面
    private static JFrame jf_1;//登陆的框架
    private static JTextField jtext1;//用户名
    private static JPasswordField jtext2;//密码
    private static JLabel jl_admin;
    private static JLabel jl_password;

    private static int Width = 900;
    private static int Height = 700;


    public Login (){//初始化登陆界面
        Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置字体
        jf_1=new JFrame("登录");
        jf_1.setSize(Width, Height);
        //给登陆界面添加背景图片
        ImageIcon bgim = new ImageIcon("src/main/resource/IMG/welcome.png") ;//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(Width, Height, Image.SCALE_DEFAULT));
        jl_1=new JLabel();
        jl_1.setIcon(bgim);

        jl_admin=new JLabel("用户名");
        jl_admin.setBounds(500, 250, 60, 50);
        jl_admin.setFont(font);

        jl_password=new JLabel("密码");
        jl_password.setBounds(500, 320, 60, 50);
        jl_password.setFont(font);

        bt1=new JButton("登录");
        bt1.setBounds(500, 380, 100, 50);
        bt1.setFont(font);

        bt2=new JButton("退出");
        bt2.setBounds(730, 380, 100, 50);
        bt2.setFont(font);

        //加入文本框
        jtext1=new JTextField("01001");
        jtext1.setBounds(580, 250, 250, 50);
        jtext1.setFont(font);


        jtext2=new JPasswordField("123456");//密码输入框
        jtext2.setEchoChar('*');
        jtext2.setBounds(580, 320, 250, 50);
        jtext2.setFont(font);

        jl_1.add(jtext1);
        jl_1.add(jtext2);

        jl_1.add(jl_admin);
        jl_1.add(jl_password);
        jl_1.add(bt1);
        jl_1.add(bt2);

        jf_1.add(jl_1);
        jf_1.setVisible(true);
        jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_1.setLocation(500,200);


        //登陆点击事件
        ActionListener bt1_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String user = jtext1.getText();
                char[] password = jtext2.getPassword();
                String str = String.valueOf(password); //将char数组转化为string类型
                LoginBL lg = new LoginBL();

               if (lg.validatePassword(user, str)) {
                    System.out.println(user);
                    System.out.println(str);
                    String type = lg.usertype(user);

                    if (type.equals("manager")) {
                        ManagerUI managerUI = new ManagerUI(user);
                        jf_1.dispose();//销毁当前界面
                    } else if (type.equals("finance")) {
                        FinancialUI financialUI = new FinancialUI(user);
                        jf_1.dispose();//销毁当前界面
                    } else if (type.equals("sale")) {
                        SalerUi salerUi = new SalerUi();
                        salerUi.init();
                        jf_1.dispose();//销毁当前界面
                    } else if (type.equals("stock")) {
                        StockManagerUi stockManagerUi = new StockManagerUi();
                        stockManagerUi.init();
                        jf_1.dispose();//销毁当前界面
                    } else if (type.equals("admin")){
                        AdministratorUI administratorUI = new AdministratorUI(user);
                        jf_1.dispose();//销毁当前界面
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "密码有误，请重新输入", "错误信息",JOptionPane.ERROR_MESSAGE);
                    count++;
                    System.out.println("error");
                    if (count == 3) {
                        JOptionPane.showMessageDialog(null, "密码输入错误3次，程序即将关闭", "错误信息",JOptionPane.ERROR_MESSAGE);
                        jf_1.dispose();
                    }
                }
            }
        };
        bt1.addActionListener(bt1_ls);

        //退出事件的处理
        ActionListener bt2_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };
        bt2.addActionListener(bt2_ls);
    }
    public static void main(String[] args) {
        //初始化登陆界面

        Login login =new Login();

    }
}