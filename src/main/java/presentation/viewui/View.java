package presentation.viewui;

import PO.InventoryPO;
import businesslogic.goodbl.GoodBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class View {
    public void init() {
        JFrame vframe = new JFrame("查看库存");
        JTextField vtf = new JTextField("请输入查询时间段,格式为2010/01/01-2011/01/01");
        vtf.setBounds(100, 100, 280, 20);
        vtf.setColumns(20);
        JButton find = new JButton("查询");
        find.setBounds(400, 100, 70, 20);
        JButton check = new JButton("今日库存盘点");
        check.setBounds(100, 200, 120, 30);
        JPanel vpanel = new JPanel();
        vframe.add(vpanel);
        vpanel.setLayout(null);
        vpanel.setBackground(Color.pink);

        vpanel.add(vtf);
        vpanel.add(find);
        vpanel.add(check);

        vtf.setEditable(true);
//        vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vframe.setSize(600, 400);
        vframe.setVisible(true);

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String period = find.getText();
                Date begin = null;
                Date end = null;
                List<InventoryPO> inventoryList = new GoodBL().viewPeriod(begin, end);

//                public List<InventoryPO> viewPeriod(Date begin,Date end){


            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cframe = new JFrame("库存盘点");
                cframe.setVisible(true);
                cframe.setSize(600,400);
                JPanel cpanel = new JPanel();
                cpanel.setLayout(new FlowLayout());
                cpanel.setBackground(Color.orange);
                cframe.add(cpanel);
                JTable ctable = new JTable();
                new ViewTable().init_table(ctable);

                JScrollPane scroll = new JScrollPane(ctable);
                scroll.setSize(300, 200);
                scroll.setLocation(650, 300);
                cpanel.add(scroll);


//                public List<InventoryPO> dayCheck(){
                List<InventoryPO> inventoryDList = new GoodBL().dayCheck();
                int id;  //行号
                String goodid;
                String goodname;
                String type;
                int price;
                String batch; //批次
                String batch_num;  //批号
                Date date;  //出厂日期
                InventoryPO temp;
                for (int i = 0; i < inventoryDList.size(); i++) {
                    temp = inventoryDList.get(i);
                    id = temp.getId();
                    goodid = temp.getGoodid();
                    goodname = temp.getGoodname();
                    type = temp.getType();
                    price = temp.getPrice();
                    batch = temp.getBatch();
                    batch_num = temp.getBatch_num();
                    date = temp.getDate();

                }
            }
        });
    }

    public static void main(String[] args) {
        new View().init();
    }
}
