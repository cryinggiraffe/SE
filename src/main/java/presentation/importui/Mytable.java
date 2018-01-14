package presentation.importui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Mytable {
    public TableModel init_table(JTable jTable1) {

        Vector vData = new Vector();
        Vector vName = new Vector();
        vName.add("商品编号");
        vName.add("名称");
        vName.add("型号");
        vName.add("数量");
        vName.add("单价");
        vName.add("金额");
        vName.add("备注");

        DefaultTableModel model = new DefaultTableModel(vData, vName);
        jTable1.setModel(model);
        return model;
    }

    public static void main(String[] args) {

        JTable jTable1 = new JTable();
        DefaultTableModel model = (DefaultTableModel) new Mytable().init_table(jTable1);
    /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/
        JScrollPane scroll = new JScrollPane(jTable1);
        scroll.setSize(300, 200);
        scroll.setLocation(650, 300);
        JFrame jFrame = new JFrame("试一试");
        jFrame.setVisible(true);
        jFrame.setSize(600, 400);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(scroll);
        jFrame.add(p);

        //        添加：（原理：重新set一下model即可，改的是new() model时候的数据而已，即vData）
        Vector vRow = new Vector();
        for (int i = 0; i < 7; i++)
            vRow.add(i);
        JButton addRow = new JButton("添加入库商品");
        p.add(addRow);
        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(vRow);
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}




