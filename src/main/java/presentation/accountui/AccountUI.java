package presentation.accountui;

import PO.AccountPO;
import businesslogic.accountbl.AccountBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountUI extends JPanel {
    private static JButton bt_add;
    private static JButton bt_delete;
    private static JButton bt_search;
    private static JButton bt_update;
    private static JButton bt_refresh;

    private static JTextField jt_search;

    private static JList jl_accountlist;
    private static JScrollPane jsp_accountlist;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);

    public AccountUI () {
        //设置界面的按钮
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        bt_add = new JButton("添加账户");
        bt_add.setBounds(50,90,120,30);
        bt_add.setFont(font1);

        jt_search = new JTextField();
        jt_search.setBounds(180,90,240,30);
        jt_search.setFont(font1);

        bt_search = new JButton("查询");
        bt_search.setBounds(420,90,80,30);
        bt_search.setFont(font1);

        bt_refresh = new JButton("刷新");
        bt_refresh.setBounds(510,90,80,30);
        bt_refresh.setFont(font1);

        bt_update = new JButton("编辑账户");
        bt_update.setBounds(600,90,120,30);
        bt_update.setFont(font1);

        bt_delete = new JButton("删除账户");
        bt_delete.setBounds(730,90,120,30);
        bt_delete.setFont(font1);


        //显示所有账户列表
        DefaultListModel<AccountPO> model = new DefaultListModel<>();
        AccountBL accountBL = new AccountBL();
        List<AccountPO> accountPOList = accountBL.findAllAccount();
        for(int i = 0; i < accountPOList.size(); i++)
        {
            AccountPO account = accountPOList.get(i);
            model.addElement(account);

        }

        jl_accountlist = new JList(model);
        jl_accountlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_accountlist.setCellRenderer(new MyButtonRender());
        jl_accountlist.setFont(font1);

        jsp_accountlist = new JScrollPane(jl_accountlist);
        jsp_accountlist.setBounds(50,140,800,500);
        jsp_accountlist.setBackground(background_table);
        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_add);
        this.add(jt_search);
        this.add(bt_search);
        this.add(bt_refresh);
        this.add(bt_update);
        this.add(bt_delete);
        this.add(jsp_accountlist);



        this.setVisible(true);

        //编辑账户按钮事件
        ActionListener btUpdate_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("update account");
                Object value = jl_accountlist.getSelectedValue();
                String str = value.toString();
                String[] tmp = str.split(",");
                String account = tmp[0];
                String balance = tmp[1];
                System.out.println(str);

                UpdateAccountUI updateAccountUI = new UpdateAccountUI(account,Double.parseDouble(balance));
            }
        };
        bt_update.addActionListener(btUpdate_ls);

        //添加账户按钮事件
        ActionListener btAdd_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("add account");
                AddAccountUI addAccountUI = new AddAccountUI();
            }
        };
        bt_add.addActionListener(btAdd_ls);

        //搜索账户按钮事件
        ActionListener btSearch_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("search account");
                String searchName = jt_search.getText();
                AccountBL accountBL = new AccountBL();
                AccountPO accountPO = accountBL.findAccount(searchName);
                if (accountPO != null) {
                    DefaultListModel<AccountPO> model = new DefaultListModel<>();
                    model.addElement(accountPO);
                    jl_accountlist.setModel(model);
                    jt_search.setText("");
                }else {
                    JOptionPane.showMessageDialog(null, "查无此账户", "错误信息",JOptionPane.ERROR_MESSAGE);
                }

            }
        };
        bt_search.addActionListener(btSearch_ls);

        //刷新按钮事件
        ActionListener btRefresh_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("refresh account");
                refresh();
            }
        };
        bt_refresh.addActionListener(btRefresh_ls);

        //删除账户按钮事件
        ActionListener btDelete_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("delete account");
                Object[] options = {" 确定 "," 取消 "};
                int response=JOptionPane.showOptionDialog(null, "确认删除此账户？", "提示信息",JOptionPane.YES_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(response==0) {
                    System.out.println(" 您按下了确定按钮  ");
                    AccountBL accountBL = new AccountBL();
                    Object value = jl_accountlist.getSelectedValue();
                    String str = value.toString();
                    String[] tmp = str.split(",");
                    String account = tmp[0];
                    accountBL.delete(account);
                    refresh();
                } else if(response==1) {
                    System.out.println(" 您按下了取消按钮  ");
                }
            }
        };
        bt_delete.addActionListener(btDelete_ls);



    }

    public void refresh() {
        AccountBL accountBL = new AccountBL();
        DefaultListModel<AccountPO> model = new DefaultListModel<>();
        List<AccountPO> accountPOList = accountBL.findAllAccount();
        for(int i = 0; i < accountPOList.size(); i++) {
            AccountPO account = accountPOList.get(i);
            model.addElement(account);
        }
        jt_search.setText("");
        jl_accountlist.setModel(model);
    }
}
