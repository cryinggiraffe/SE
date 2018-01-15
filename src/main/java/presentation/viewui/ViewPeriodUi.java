package presentation.viewui;

import PO.InventoryPO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ViewPeriodUi {
    public void init(List<InventoryPO> inventoryList){
        JFrame cframe = new JFrame("根据时间段查看库存");
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
        for (int i = 0; i < inventoryList.size(); i++) {
            temp = inventoryList.get(i);
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

    }
}
