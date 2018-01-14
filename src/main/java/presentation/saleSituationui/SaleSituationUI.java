package presentation.saleSituationui;

import PO.SaleSituationPo;
import businesslogic.goodbl.GoodBL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SaleSituationUI extends JPanel {
    private static JTextField jt_begintime;
    private static JTextField jt_endtime;
    private static JComboBox jc_name;
    private static JComboBox jc_client;
    private static JComboBox jc_salesman;
    private static JComboBox jc_houseware;

    private static JButton bt_search;
    private static JLabel jl_1;
    private static JLabel jl_name;
    private static JLabel jl_client;
    private static JLabel jl_salesman;
    private static JLabel jl_houseware;


    private static JList jl_accountlist;
    private static JScrollPane jsp_accountlist;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);

    public SaleSituationUI () {
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        bt_search = new JButton("查询");
        bt_search.setBounds(730,170,120,30);
        bt_search.setFont(font);

        jl_1 = new JLabel("筛选条件: 时间区间：");
        jl_1.setBounds(50,90,180,30);
        jl_1.setFont(font);

        jt_begintime = new JTextField();
        jt_begintime.setBounds(180,90,180,30);
        jt_begintime.setFont(font);

        jt_endtime = new JTextField();
        jt_endtime.setBounds(365,90,180,30);
        jt_endtime.setFont(font);

        jl_name = new JLabel("商品名：");
        jl_name.setBounds(580,90,60,30);
        jl_name.setFont(font);

        jc_name = new JComboBox();
        jc_name.setBounds(640,90,210,30);
        jc_name.setFont(font);

        jl_client = new JLabel("客户ID：");
        jl_client.setBounds(50,130,60,30);
        jl_client.setFont(font);

        jc_client = new JComboBox();
        jc_client.setBounds(110,130,210,30);
        jc_client.setFont(font);

        jl_salesman= new JLabel("业务员ID：");
        jl_salesman.setBounds(560,130,80,30);
        jl_salesman.setFont(font);

        jc_salesman = new JComboBox();
        jc_salesman.setBounds(640,130,210,30);
        jc_salesman.setFont(font);
        jc_salesman.addItem("1");
        jc_salesman.addItem("2");
        jc_salesman.addItem("3");

        jl_houseware = new JLabel("仓库ID：");
        jl_houseware.setBounds(50,170,60,30);
        jl_houseware.setFont(font);

        jc_houseware = new JComboBox();
        jc_houseware.setBounds(110,170,210,30);
        jc_houseware.setFont(font);
        jc_houseware.addItem("1");
        jc_houseware.addItem("2");
        jc_houseware.addItem("3");

        //向下拉框添加数据
        GoodBL goodBL = new GoodBL();
        List<String> nameList = goodBL.listNames();
        for (int i=0;i<nameList.size();i++){
            jc_name.addItem(nameList.get(i));
        }



        DefaultListModel<SaleSituationPo> model = new DefaultListModel<>();
        jl_accountlist = new JList(model);
        jl_accountlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_accountlist.setCellRenderer(new MySaleRender());
        jl_accountlist.setFont(font);

        jsp_accountlist = new JScrollPane(jl_accountlist);
        jsp_accountlist.setBounds(50,210,800,430);
        jsp_accountlist.setBackground(background_table);
        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);
        this.setVisible(true);

        this.add(jt_begintime);
        this.add(jt_endtime);
        this.add(jc_name);
        this.add(jc_client);
        this.add(jc_salesman);
        this.add(jc_houseware);
        this.add(jl_1);
        this.add(jl_name);
        this.add(jl_client);
        this.add(jl_salesman);
        this.add(jl_houseware);
        this.add(bt_search);
        this.add(jsp_accountlist);

        //搜索账户按钮事件
        ActionListener btSearch_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("search sale");
//                String searchName = jt_search.getText();
//                AccountBL accountBL = new AccountBL();
//                AccountPO accountPO = accountBL.findAccount(searchName);
//                if (accountPO != null) {
//                    DefaultListModel<AccountPO> model = new DefaultListModel<>();
//                    model.addElement(accountPO);
//                    jl_accountlist.setModel(model);
//                    jt_search.setText("");
//                }else {
//                    JOptionPane.showMessageDialog(null, "查无此账户", "错误信息",JOptionPane.ERROR_MESSAGE);
//                }

            }
        };
        bt_search.addActionListener(btSearch_ls);

    }



}
