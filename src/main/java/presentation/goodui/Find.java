package presentation.goodui;

import PO.GoodPO;
import businesslogic.goodbl.GoodBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class Find {
    public void init() {
        JFrame frame = new JFrame("查找商品");
        frame.setBounds(550, 250, 800, 600);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);

        String s = "您可以通过以下两种方式进行查找";
        String s1 = "通过商品编号查找：";
        String s2 = "通过商品名称查找：";

        JLabel label = new JLabel(s);
        JLabel label1 = new JLabel(s1);
        JLabel label2 = new JLabel(s2);

        JTextField byName = new JTextField();
        JTextField byId = new JTextField();
        JButton findButton1 = new JButton("查询");
        JButton findButton2 = new JButton("查询");

        panel.add(label);
        panel.add(label1);
        panel.add(byId);
        panel.add(label2);
        panel.add(byName);
        panel.add(findButton1);
        panel.add(findButton2);

        label.setBounds(100, 100, 200, 30);
        label1.setBounds(100, 150, 140, 30);
        label2.setBounds(100, 200, 140, 30);
        byName.setBounds(280, 150, 200, 30);
        byId.setBounds(280, 200, 200, 30);
        findButton1.setBounds(490, 150, 70, 30);
        findButton2.setBounds(490, 200, 70, 30);

        findButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GoodPO good = new GoodBL().findGoodById(byId.getText());
                if (good == null) {
                    JOptionPane.showMessageDialog(null, "没有找到！", "错误信息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String[] names = {"编号", "名称", "型号", "库存数量", "进价", "零售价", "最近进价", "最近零售价"};
                String goodid = good.getGoodid();
                String name = good.getName();
                String type = good.getType();
                int num = good.getNum();
                int pur_price = good.getPur_price();
                int ret_price = good.getRet_price();
                int rece_price = good.getRece_price();
                int rece_ret_price = good.getRece_ret_price();

                Object[][] goodInfo = {{goodid, name, type, num, pur_price, ret_price, rece_price, rece_ret_price},};

                JFrame f = new JFrame();
                f.setBounds(550, 350, 800, 100);
                JTable table = new JTable(goodInfo, names);
                table.setPreferredScrollableViewportSize(new Dimension(550, 30));
                JScrollPane scrollPane = new JScrollPane(table);
                f.getContentPane().add(scrollPane, BorderLayout.CENTER);
                f.setTitle("商品信息");
                f.pack();
                f.show();

            }
        });

        findButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<GoodPO> goodList = new GoodBL().findGoodByName(byName.getText());
                if (goodList.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有找到！", "错误信息", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Vector vData = new Vector();
                Vector vName = new Vector();
                vName.add("编号");
                vName.add("名称");
                vName.add("型号");
                vName.add("库存数量");
                vName.add("进价");
                vName.add("零售价");
                vName.add("最近售价");
                vName.add("最近零售价");
                JFrame frame1 = new JFrame("商品信息");
                frame1.setBounds(550, 250, 800, 600);
                frame1.setVisible(true);
                JPanel panel1 = new JPanel();
                panel1.setBackground(Color.BLUE);
                frame1.add(panel1);
                DefaultTableModel model = new DefaultTableModel(vData, vName);
                JTable jtable = new JTable();
                jtable.setModel(model);
                JScrollPane scroll = new JScrollPane(jtable);
                scroll.setSize(300, 200);
                scroll.setLocation(650, 300);
                panel1.add(scroll);

                for (int i = 0; i < goodList.size(); i++) {
                    GoodPO good = goodList.get(i);
                    Vector vRow = new Vector();
                    vRow.add(good.getGoodid());
                    vRow.add(good.getName());
                    vRow.add(good.getType());
                    vRow.add(good.getNum());
                    vRow.add(good.getPur_price());
                    vRow.add(good.getRet_price());
                    vRow.add(good.getRece_price());
                    vRow.add(good.getRece_ret_price());
                    model.addRow(vRow);


                }

            }
        });

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Find().init();
    }
}
