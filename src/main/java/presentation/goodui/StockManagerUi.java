package presentation.goodui;

import presentation.giftui.Gift;
import presentation.superviseui.Supervise;
import presentation.viewui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockManagerUi {
    public void init(){
        JFrame f = new JFrame("库存管理");
        JPanel p = new JPanel();
        Container container = f.getContentPane();
        container.setLayout(new FlowLayout());
        f.add(p);
        JButton commidy = new JButton("商品管理");
        JButton view = new JButton("查看库存");
        JButton gift = new JButton("赠品推荐");
        JButton supervise = new JButton("库存监管");

        commidy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Good gf = new Good();
                gf.init();

            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View vf= new View();
                vf.init();
            }
        });

        gift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gift gf = new Gift();
                gf.init();
            }
        });

        supervise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Supervise sf = new Supervise();
                sf.init();

            }
        });

        p.add(commidy);
        p.add(view);
        p.add(gift);
        p.add(supervise);

        f.setSize(400,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }
    public static void main(String [] args){
        new StockManagerUi().init();
    }
}
