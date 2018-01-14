package presentation.importui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Ssale {
    public void init() {
        JFrame iframe = new JFrame("制定进货单");
        JPanel ipanel = new JPanel();
        iframe.add(ipanel);
        ipanel.setLayout(new FlowLayout());
        ipanel.setBackground(Color.pink);


        String id = "1"; //这里要改一下？？？？
        JLabel lid = new JLabel("单据编号");
        JTextField tid = new JTextField(id);
        tid.setEditable(false);
        JLabel lprovider = new JLabel("供应商");
        JTextField tprovider = new JTextField();
        JLabel lhouseware = new JLabel("仓库");
        JTextField thouseware = new JTextField();
        JLabel loperator = new JLabel("操作员");
        JTextField toperator = new JTextField();


        tid.setColumns(10);
        tprovider.setColumns(10);
        toperator.setColumns(10);
        thouseware.setColumns(10);

        ipanel.add(lid);
        ipanel.add(tid);
        ipanel.add(lprovider);
        ipanel.add(tprovider);
        ipanel.add(lhouseware);
        ipanel.add(thouseware);
        ipanel.add(loperator);
        ipanel.add(toperator);


        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) new Mytable().init_table(table);

        Vector vRow = new Vector();
        for (int i = 0; i < 7; i++)
            vRow.add(i);
        JButton addRow = new JButton("添加入库商品");
        ipanel.add(addRow);
        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(vRow);
            }
        });

        table.setPreferredScrollableViewportSize(new Dimension(670, 200));
        JScrollPane scrollPane = new JScrollPane(table);
        ipanel.add(scrollPane);


        JLabel lremark = new JLabel("备注");
        JTextArea tremark = new JTextArea();
        tremark.setColumns(20);
        tremark.setRows(5);
        JLabel lsum = new JLabel("总额合计");
        JTextField tsum = new JTextField();
        tsum.setColumns(5);

        ipanel.add(lremark);
        ipanel.add(tremark);
        ipanel.add(lsum);
        ipanel.add(tsum);

        JButton submit = new JButton("提交");
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ipanel.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String provider = tprovider.getText();
                String houseware = thouseware.getText();
                String operator = toperator.getText();
                List importCommoditylist = null;
                String remark = tremark.getText();
                double sum = Integer.valueOf(tsum.getText());




            }
        });

        iframe.setSize(690, 600);
        iframe.setVisible(true);
        iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Import().init();
    }
}
