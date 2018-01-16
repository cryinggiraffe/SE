package presentation.goodui;

import PO.GoodPO;
import businesslogic.goodbl.GoodBL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AddGoodUi {
    public void addGoodUi_init(int parentId) {
        JFrame f = new JFrame("商品信息");
        f.setVisible(true);
        f.setBounds(555, 350, 800, 170);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBackground(Color.pink);
        f.add(p);

        Vector vData = new Vector();
        Vector vName = new Vector();
        Vector vRow = new Vector();
        vName.add("名称");
        vName.add("型号");
        vName.add("库存数量");
        vName.add("进价");
        vName.add("零售价");
        vName.add("最近进价");
        vName.add("最近零售价");
        for (int i = 0; i < 7; i++)
            vRow.add("");

        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(vData, vName);
        table.setModel(model);
        model.addRow(vRow);

        f.setVisible(true);
        table.setPreferredScrollableViewportSize(new Dimension(570, 30));


        JScrollPane scrollPane = new JScrollPane(table);
        p.add(scrollPane);
        f.setTitle("商品信息");
        f.show();

        JButton button = new JButton("添加");
        p.add(button);
        button.setBounds(330, 80, 100, 30);

//        GoodPO addNew = new GoodPO();


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addName = table.getValueAt(0, 0).toString();
                if (addName.equals("")) {
                    JOptionPane.showMessageDialog(null, "名称不能为空！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String type = table.getValueAt(0, 1).toString();
                int num = 0;
                try {
                    num = Integer.valueOf(table.getValueAt(0, 2).toString());
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(null, "库存数量格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int pur_price = 0;
                try {
                    pur_price = Integer.valueOf(table.getValueAt(0, 3).toString());
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(null, "进价格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int ret_price = 0;
                try {
                    ret_price = Integer.valueOf(table.getValueAt(0, 4).toString());
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(null, "零售价格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int rece_price = 0;
                try {
                    rece_price = Integer.valueOf(table.getValueAt(0, 5).toString());
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(null, "最近进价格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int rece_ret_price = 0;
                try {
                    rece_ret_price = Integer.valueOf(table.getValueAt(0, 6).toString());
                } catch (NumberFormatException ex1) {
                    JOptionPane.showMessageDialog(null, "最近零售价格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                System.out.println(addName + " ");
                //另外还要设置Pid
                GoodPO addNew = new GoodPO(new GoodBL().generateId(), parentId, addName, type, num, pur_price, ret_price, rece_price, rece_ret_price);
                System.out.println(addNew.getGoodid());
                new GoodBL().newGood(addNew);

//                addNew.setName(addName);
//                addNew.setNum(num);
//                addNew.setType(type);
//                addNew.setRece_price(rece_price);
//                addNew.setPur_price(pur_price);
//                addNew.setRece_ret_price(rece_ret_price);
//                addNew.setRet_price(ret_price);
                f.setVisible(false);
//                System.out.println("test" + addNew.getGoodid() + " " + addNew.getName());
            }

        });
//        	public GoodPO(String goodid, int pid, String name, String type, int num, int pur_price, int ret_price,
//        int rece_price, int rece_ret_price) {

//        System.out.println("123123123fr4r" + addNew.getGoodid() + " " + addNew.getName());

    }

}
