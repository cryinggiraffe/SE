package presentation.giftui;

import javax.swing.*;
import java.awt.*;

public class Gift {
    public void init(){
        JFrame gframe = new JFrame("赠送库存");
        JButton button = new JButton("赠品推荐");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.pink);

        gframe.add(panel);
        panel.add(button);
        button.setBounds(340,200,100,50);

//        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gframe.setBounds(550,250,800,600);
        gframe.setVisible(true);


    }
    public static void main(String []args){
        new Gift().init();
    }
}
