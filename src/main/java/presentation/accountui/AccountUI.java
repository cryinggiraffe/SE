package presentation.accountui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class AccountUI extends JPanel {
    private static JButton bt_add;
    private static JButton bt_delete;
    private static JButton bt_search;
    private static JButton bt_update;

    private static JTextField jt_search;

    private static JTable jta_accountlist;
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
        String[] columnTitle = {"选择","账户名称","余额"};
        //此处写一个获取所有账户名称和余额的方法
        int length = 4;//后面把length赋值为获取到的账户的数量
        ButtonGroup listRadioButtonGroup = new ButtonGroup();
        Object[][] datas = new Object[length][3];
        for (int i=0;i<length;i++){
            Object[] objs = new Object[3];
            JPanel panel = new JPanel();
            JRadioButton rbt_select = new JRadioButton();
            panel.add(rbt_select);
            listRadioButtonGroup.add(rbt_select);
            objs[0] = panel;
            objs[1] = "账户"+i;
            objs[2] = 0;
            datas[i]=objs;
        }



        DefaultTableModel model = new DefaultTableModel(datas, columnTitle);
        jta_accountlist = new JTable();
        jta_accountlist.setModel(model);
        jta_accountlist.setRowHeight(30);
        jta_accountlist.getColumnModel().getColumn(0).setCellRenderer(new MyButtonRender());

        jta_accountlist.setBounds(40,140,810,30 * length);
        jta_accountlist.getColumnModel().getColumn(0).setPreferredWidth(50);
        jta_accountlist.getColumnModel().getColumn(1).setPreferredWidth(330);
        jta_accountlist.getColumnModel().getColumn(2).setPreferredWidth(330);

        JScrollPane sp = new JScrollPane(jta_accountlist);
        sp.setBounds(40,140,810,500);
        sp.setBackground(background_table);
        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_add);
        this.add(jt_search);
        this.add(bt_search);
        this.add(bt_update);
        this.add(bt_delete);
        this.add(sp);



        this.setVisible(true);

    }
}
