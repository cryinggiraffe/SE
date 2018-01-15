package presentation.accountui;

import businesslogic.accountbl.AccountBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddAccountUI extends JFrame{
    private static JLabel jl_account;
    private static JLabel jl_balance;

    private static JTextField jt_account;
    private static JTextField jt_balance;

    private static JButton bt_submit;

    private static JFrame jf_1;
    private static int Width = 900;
    private static int Height = 400;
    private static Color background = new Color(135, 206, 250);

    public AddAccountUI () {
        Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体
        jl_account = new JLabel("账户名称：");
        jl_account.setBounds(150,75,120,50);
        jl_account.setFont(font);
        jt_account = new JTextField();
        jt_account.setBounds(280,75,550,50);
        jt_account.setFont(font);

        jl_balance = new JLabel("余额：");
        jl_balance.setBounds(150,175,120,50);
        jl_balance.setFont(font);
        jt_balance = new JTextField();
        jt_balance.setBounds(280,175,550,50);
        jt_balance.setFont(font);

        bt_submit = new JButton("提交");
        bt_submit.setBounds(700,250,120,50);
        bt_submit.setFont(font);

        //向frame添加组件
        jf_1 = new JFrame("添加账户");
        jf_1.setSize(Width,Height);
        jf_1.setLocation(200,10);
        jf_1.setLayout(null);
        jf_1.getContentPane().setBackground(background);

        jf_1.add(jl_account);
        jf_1.add(jt_account);
        jf_1.add(jl_balance);
        jf_1.add(jt_balance);
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
                    String account = jt_account.getText();
                    String balance = jt_balance.getText();
                    if (account.equals("") || balance.equals("")) {
                        System.out.println("error");
                        JOptionPane.showMessageDialog(jf_1, "账户和余额不能为空", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else {
                        AccountBL accountBL = new AccountBL();
                        accountBL.newAccount(account,Double.parseDouble(balance));
                        System.out.println("add account");
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
