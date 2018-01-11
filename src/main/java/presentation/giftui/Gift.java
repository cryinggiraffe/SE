package presentation.giftui;

import javax.swing.*;
import java.awt.*;

public class Gift {
    public void init(){
        JFrame gframe = new JFrame("赠送库存");
        Container container = gframe.getContentPane();
        JButton button = new JButton("赠品推荐");
        JPanel panel = new JPanel();

        container.setLayout(new FlowLayout());

        panel.add(button);
        container.add(panel);

//        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gframe.setSize(400,600);
        gframe.setVisible(true);


    }
    public static void main(String []args){
        new Gift().init();
    }
}
