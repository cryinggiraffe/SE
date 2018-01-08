package presentation.viewui;

import javax.swing.*;
import java.awt.*;

public class View {
    public  void init(){
        JFrame vframe = new JFrame("查看库存");
        JTextField vtf = new JTextField("请输入查询时间段,格式为2010/01/01-2011/01/01");
        JButton vbutton = new JButton("今日库存盘点");
        JPanel vpanel = new JPanel();

        Container container = vframe.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(vpanel);
        vpanel.add(vtf);
        vpanel.add(vbutton);

        vtf.setEditable(true);
//        vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vframe.setSize(400,400);
        vframe.setVisible(true);
    }
}
