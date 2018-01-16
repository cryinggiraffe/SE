package presentation.businessProcessui;

import PO.AccountPO;
import businesslogic.accountbl.AccountBL;
import businesslogic.cashbl.CashBL;
import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

public class RedCashUI extends JFrame {
    private static JLabel jl_id;
    private static JLabel jl_username;
    private static JLabel jl_account;
    private static JLabel jl_list;
    private static JLabel jl_amount;
    private static JLabel jl_remark;
    private static JLabel jl_sum;

    private static JTextField jt_account;
    private static JTextField jt_list;
    private static JTextField jt_amount;
    private static JTextField jt_remark;

    private static JButton bt_submit;
    private static JFrame jf_1;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public RedCashUI (String name, String account,String list, String amount) {
        //设置界面
        Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体
        CashBL cashBL = new CashBL();
        String cashId = cashBL.newId();
        jl_id = new JLabel("单据编号：" + cashId);
        jl_id.setBounds(150,100,500,50);
        jl_id.setFont(font);

        jl_username = new JLabel("操作员：" + name);
        jl_username.setBounds(650,100,300,50);
        jl_username.setFont(font);

        jl_account = new JLabel("银行账户：");
        jl_account.setBounds(150,190,120,50);
        jl_account.setFont(font);
        jt_account = new JTextField(account);
        jt_account.setBounds(280,190,550,50);
        jt_account.setFont(font);

        jl_list = new JLabel("条目名：");
        jl_list.setBounds(150,280,120,50);
        jl_list.setFont(font);
        jt_list = new JTextField(list);
        jt_list.setBounds(280,280,550,50);
        jt_list.setFont(font);

        jl_amount = new JLabel("金额：");
        jl_amount.setBounds(150,370,120,50);
        jl_amount.setFont(font);
        jt_amount = new JTextField(amount);
        jt_amount.setBounds(280,370,550,50);
        jt_amount.setFont(font);

        jl_remark = new JLabel("备注：");
        jl_remark.setBounds(150,460,120,50);
        jl_remark.setFont(font);
        jt_remark = new JTextField("红冲复制单据");
        jt_remark.setBounds(280,460,550,50);
        jt_remark.setFont(font);


        jl_sum = new JLabel("总额：");
        jl_sum.setBounds(150,550,610,50);
        jl_sum.setFont(font);

        bt_submit = new JButton("提交");
        bt_submit.setBounds(700,550,120,50);
        bt_submit.setFont(font);

        //向frame添加组件
        jf_1 = new JFrame("红冲复制现金费用单");
        jf_1.setSize(Width,Height);
        jf_1.setLocation(200,10);
        jf_1.setLayout(null);
        jf_1.getContentPane().setBackground(background);

        jf_1.add(jl_id);
        jf_1.add(jl_username);
        jf_1.add(jl_account);
        jf_1.add(jl_list);
        jf_1.add(jl_amount);
        jf_1.add(jl_remark);
        jf_1.add(jl_sum);
        jf_1.add(jt_account);
        jf_1.add(jt_list);
        jf_1.add(jt_amount);
        jf_1.add(jt_remark);
        jf_1.add(bt_submit);

        jf_1.setVisible(true);
        //在转账金额中输入自动在总额中显示
        Document dt = jt_amount.getDocument();
        dt.addDocumentListener(new javax.swing.event.DocumentListener(){
            public void insertUpdate(DocumentEvent e) {
                String sum = jt_amount.getText();
                jl_sum.setText("总额：" + sum + "元");
            }

            public void removeUpdate(DocumentEvent e) {
                String sum = jt_amount.getText();
                jl_sum.setText("总额：" + sum + "元");
            }

            public void changedUpdate(DocumentEvent e) {
                String sum = jt_amount.getText();
                jl_sum.setText("总额：" + sum + "元");
            }


        });

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
                    String list = jt_list.getText();
                    String amount=jt_amount.getText();
                    String remark = jt_remark.getText();

                    AccountBL accountBL = new AccountBL();
                    double amountNum = 0;
                    if (list.equals("")) {
                        System.out.println("error no client");
                        JOptionPane.showMessageDialog(jf_1, "必须填写条目名", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else if (account.equals("")) {
                        System.out.println("error no account");
                        JOptionPane.showMessageDialog(jf_1, "必须填写银行账户", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else if (amount.equals("")) {
                        System.out.println("error no amount");
                        JOptionPane.showMessageDialog(jf_1, "必须填写转账金额", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else {
                        amountNum = Double.parseDouble(amount);
                    }

                    if (amountNum < 0) {  //未来还要加银行账户的判断
                        JOptionPane.showMessageDialog(jf_1, "金额不得小于0", "错误信息",JOptionPane.ERROR_MESSAGE);
                        jt_amount.setText("");
                    }else if(accountBL.findAccount(account) == null){
                        JOptionPane.showMessageDialog(jf_1, "无此银行账户信息，请重新输入", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }else {
                        CashBL cashBL = new CashBL();
                        Date date = new Date(System.currentTimeMillis());
                        AccountPO accountpo = accountBL.findAccount(account);
                        double balance = accountpo.getBalance();
                        balance = balance - amountNum;
                        if (balance > 0) {
                            System.out.println("new payment");
                            cashBL.newCash(cashId,name,account,list,amountNum,remark,amountNum,date);
                            jf_1.dispose();
                        }else {
                            JOptionPane.showMessageDialog(jf_1, "消费金额超出账户余额，请确认后重新输入", "错误信息",JOptionPane.ERROR_MESSAGE);
                            jt_amount.setText("");
                        }
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
