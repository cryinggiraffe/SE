package presentation.viewui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ViewTable {
    public TableModel init_table(JTable jTable1) {
//        int id;  //行号
//        String goodid;
//        String goodname;
//        String type;
//        int price;
//        String batch; //批次
//        String batch_num;  //批号
//        Date date;  //出厂日期

        Vector vData = new Vector();
        Vector vName = new Vector();
        vName.add("行号");
        vName.add("商品编号");
        vName.add("商品名称");
        vName.add("类型");
        vName.add("价格");
        vName.add("批次");
        vName.add("批号");
        vName.add("出厂日期");

        DefaultTableModel model = new DefaultTableModel(vData, vName);
        jTable1.setModel(model);
        return model;
    }

}




