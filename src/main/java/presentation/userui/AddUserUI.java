package presentation.userui;

import businesslogic.userbl.UserBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddUserUI extends JFrame {
    private static JLabel jl_user;
    private static JLabel jl_password;
    private static JLabel jl_class;
    private static JLabel jl_type;

    private static JTextField jt_user;
    private static JTextField jt_password;

    private static JComboBox jc_class;
    private static JComboBox jc_type;

    private static JButton bt_submit;

    private static JFrame jf_1;
    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public AddUserUI () {
        Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体
        jl_user = new JLabel("用户名：");
        jl_user.setBounds(150,75,120,50);
        jl_user.setFont(font);
        jt_user = new JTextField();
        jt_user.setBounds(280,75,470,50);
        jt_user.setFont(font);


        jl_password = new JLabel("密码：" );
        jl_password.setBounds(150,150,120,50);
        jl_password.setFont(font);
        jt_password = new JTextField();
        jt_password.setBounds(280,150,470,50);
        jt_password.setFont(font);

        jl_class = new JLabel("用户等级：" );
        jl_class.setBounds(150,225,120,50);
        jl_class.setFont(font);
        jc_class = new JComboBox();
        jc_class.setBounds(280,225,470,50);
        jc_class.setFont(font);
        jc_class.addItem("1");
        jc_class.addItem("2");
        jc_class.addItem("3");
        jc_class.addItem("4");
        jc_class.addItem("5");

        jl_type = new JLabel("用户类型：" );
        jl_type.setBounds(150,300,120,50);
        jl_type.setFont(font);
        jc_type = new JComboBox();
        jc_type.setBounds(280,300,470,50);
        jc_type.setFont(font);
        jc_type.addItem("admin");
        jc_type.addItem("manager");
        jc_type.addItem("finance");
        jc_type.addItem("sale");
        jc_type.addItem("stock");


        bt_submit = new JButton("提交");
        bt_submit.setBounds(630,375,120,50);
        bt_submit.setFont(font);

        //向frame添加组件
        jf_1 = new JFrame("添加用户");
        jf_1.setSize(Width,Height);
        jf_1.setLocation(200,10);
        jf_1.setLayout(null);
        jf_1.getContentPane().setBackground(background);

        jf_1.add(jl_user);
        jf_1.add(jl_password);
        jf_1.add(jl_class);
        jf_1.add(jl_type);

        jf_1.add(jt_user);
        jf_1.add(jt_password);
        jf_1.add(jc_class);
        jf_1.add(jc_type);

        jf_1.add(bt_submit);

        jf_1.setVisible(true);
        //提交按钮事件
        ActionListener btSubmit_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Object[] options = {" 确定 "," 取消 "};
                int response=JOptionPane.showOptionDialog(null, "确认提交？", "提示信息",JOptionPane.YES_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(response==0) {
                    System.out.println(" 您按下了确定按钮  ");

                    String userName = jt_user.getText();
                    String userPassword = jt_password.getText();
                    int userClass = Integer.parseInt(jc_class.getSelectedItem().toString());
                    String userType = jc_type.getSelectedItem().toString();

                    if (userName.equals("")||userPassword.equals("") || userType.equals("")) {
                        System.out.println("error password");
                        JOptionPane.showMessageDialog(jf_1, "用户名、密码、用户类型不能为空", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else if (userClass < 1 || userClass > 5){
                        System.out.println("error userclass");
                        JOptionPane.showMessageDialog(jf_1, "用户级别在1-5之间", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else {
                        System.out.println("add user");
                        UserBL userBL = new UserBL();
                        userBL.newUser(userName,userPassword,userClass,userType);
                        jf_1.dispose();
                    }

                } else if(response==1) {
                    System.out.println(" 您按下了取消按钮  ");
                }
            }
        };
        bt_submit.addActionListener(btSubmit_ls);

        jf_1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jf_1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(jf_1, "您的信息尚未保存，是否仍要关闭？","提示信息", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if(JOptionPane.YES_OPTION == flag){
                    jf_1.dispose();
                }else{
                    return;
                }
            }
        });


    }
}
