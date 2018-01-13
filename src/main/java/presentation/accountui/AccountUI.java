package presentation.accountui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountUI extends JPanel {
    private static JButton bt_add;
    private static JButton bt_delete;
    private static JButton bt_search;
    private static JButton bt_update;

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
        bt_add.setBounds(40,90,120,30);
        bt_add.setFont(font1);

        jt_search = new JTextField();
        jt_search.setBounds(180,90,240,30);
        jt_search.setFont(font1);

        bt_search = new JButton("查询");
        bt_search.setBounds(420,90,80,30);
        bt_search.setFont(font1);

        bt_update = new JButton("编辑账户");
        bt_update.setBounds(590,90,120,30);
        bt_update.setFont(font1);

        bt_delete = new JButton("删除账户");
        bt_delete.setBounds(730,90,120,30);
        bt_delete.setFont(font1);


        //显示所有账户列表
        //此处写一个获取所有账户名称和余额的方法
        int length = 4;//后面把length赋值为获取到的账户的数量

        DefaultListModel model = new DefaultListModel();
        Object[] data = new Object[length + 1];
        data[0] = String.format("   %s                                                 %s","账户名称","余额");
        model.addElement(data[0]);
        for (int i=1;i<=length;i++){
            data[i] = String.format("账户%d                                                   %f元",i,45.5);
            model.addElement(data[i]);
        }

        jl_accountlist = new JList(model);
        jl_accountlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_accountlist.setFont(font1);

        jsp_accountlist = new JScrollPane(jl_accountlist);
        jsp_accountlist.setBounds(40,140,810,500);
        jsp_accountlist.setBackground(background_table);
        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_add);
        this.add(jt_search);
        this.add(bt_search);
        this.add(bt_update);
        this.add(bt_delete);
        this.add(jsp_accountlist);



        this.setVisible(true);

        //创建收款单按钮事件
        ActionListener btUpdate_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("update account");
                Object value = jl_accountlist.getSelectedValue();
                System.out.println(value.toString());

            }
        };
        bt_update.addActionListener(btUpdate_ls);

    }
}
