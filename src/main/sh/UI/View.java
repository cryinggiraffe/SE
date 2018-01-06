package UI;

import javax.swing.*;
import java.awt.*;

public class View {

    JFrame vframe;
    JTextField vtf;
    JButton vbutton;
    JPanel vpanel;

    public void createAndShowViewGUI() {
        vframe = new JFrame("查看库存");
        vtf = new JTextField("请输入查询时间段,格式为2010/01/01-2011/01/01");
        vbutton = new JButton("今日库存盘点");
        vpanel = new JPanel();

        Container container = vframe.getContentPane();
        container.setLayout(new FlowLayout());
        container.add(vpanel);
        vpanel.add(vtf);
        vpanel.add(vbutton);

        vtf.setEditable(true);
        vframe.setSize(400, 400);
        vframe.setVisible(true);
    }
}
