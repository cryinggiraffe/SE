package presentation.viewui;

import PO.InventoryPO;
import businesslogic.goodbl.GoodBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class View {
    public void init() {
        JFrame vframe = new JFrame("查看库存");
        vframe.setBounds(550, 250, 800, 600);
        JLabel label1 = new JLabel("按时间段查询");
        label1.setBounds(100, 100, 100, 30);
        JLabel label2 = new JLabel("库存盘点");
        label2.setBounds(100, 200, 100, 30);
        JTextField vtf = new JTextField("格式为2010-01-01|2011-01-01");
        vtf.setBounds(220, 100, 200, 30);
        vtf.setColumns(20);
        JButton find = new JButton("查询");
        find.setBounds(400, 100, 70, 30);
        JButton check = new JButton("今日库存盘点");
        check.setBounds(220, 200, 120, 30);
        JPanel vpanel = new JPanel();
        vframe.add(vpanel);
        vpanel.setLayout(null);
        vpanel.setBackground(Color.pink);

        vpanel.add(vtf);
        vpanel.add(find);
        vpanel.add(check);
        vpanel.add(label1);
        vpanel.add(label2);

        vtf.setEditable(true);
//        vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vframe.setSize(600, 400);
        vframe.setVisible(true);

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String period = vtf.getText();
                String[] dates = period.split("\\|");
//                for (String str : dates)
//                    System.out.println(str);
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date begin = df.parse(dates[0]);
                    Date end = df.parse(dates[1]);
                    //                public List<InventoryPO> viewPeriod(Date begin,Date end){
                    List<InventoryPO> inventoryList = new GoodBL().viewPeriod(begin, end);
                    if (inventoryList.size() == 0) {
                        JOptionPane.showMessageDialog(null, "没有找到！", "错误消息", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    //找到了以后
                    new ViewPeriodUi().init(inventoryList);

                } catch (ParseException e1) {
                    JOptionPane.showMessageDialog(null, "请按指定格式输入！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<InventoryPO> inventoryDList = new GoodBL().dayCheck();
                if (inventoryDList.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有找到！", "错误信息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JFrame cframe = new JFrame("库存盘点");
                cframe.setVisible(true);
                cframe.setBounds(550, 250, 550, 600);
                JPanel cpanel = new JPanel();
                cpanel.setLayout(new FlowLayout());
                cpanel.setBackground(Color.orange);
                cframe.add(cpanel);
                JTable ctable = new JTable();
                DefaultTableModel model = (DefaultTableModel) new ViewTable().init_table(ctable);

                JScrollPane scroll = new JScrollPane(ctable);
                scroll.setSize(300, 200);
                scroll.setLocation(650, 300);
                cpanel.add(scroll);

                InventoryPO temp;
                for (int i = 0; i < inventoryDList.size(); i++) {
                    temp = inventoryDList.get(i);
                    Vector vRow = new Vector();
                    vRow.add(temp.getId());
                    vRow.add(temp.getGoodid());
                    vRow.add(temp.getGoodname());
                    vRow.add(temp.getType());
                    vRow.add(temp.getPrice());
                    vRow.add(temp.getBatch());
                    vRow.add(temp.getBatch_num());
                    vRow.add(temp.getDate());
                    model.addRow(vRow);

                }

                JTextField tmakeExcel = new JTextField("请输入文件路径");
                tmakeExcel.setColumns(20);
                cpanel.add(tmakeExcel);

                JButton makeExcelButton = new JButton("导出Excel");
                cpanel.add(makeExcelButton);
                makeExcelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String path = tmakeExcel.getText();
                        new GoodBL().makeExcel(null);
//                        JOptionPane.showMessageDialog(null,"导出成功！","导出信息",JOptionPane.WARNING_MESSAGE);
                    }
                });
            }
        });


    }

    public static void main(String[] args) {
        new View().init();
    }
}
