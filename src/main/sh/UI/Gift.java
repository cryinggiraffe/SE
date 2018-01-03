package UI;

import javax.swing.*;
import java.awt.*;

public class Gift {
    private JFrame gframe;
    private JPanel gpanel;
    private JButton gbutton;

    public  void createAndShowGiftGUI(){
        gframe = new JFrame("赠送库存");
        Container container = gframe.getContentPane();
        gbutton = new JButton("赠品推荐");
        gpanel = new JPanel();

        container.setLayout(new FlowLayout());

        gpanel.add(gbutton);
        container.add(gpanel);

        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gframe.setSize(400,600);
        gframe.setVisible(true);


    }
}
