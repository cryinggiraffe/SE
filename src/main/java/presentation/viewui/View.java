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

                JButton makeExcelButton = new JButton("导出Excel");
                cpanel.add(makeExcelButton);
                makeExcelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
