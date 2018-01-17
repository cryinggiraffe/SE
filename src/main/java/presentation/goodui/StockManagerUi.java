package presentation.goodui;

import presentation.giftui.Gift;
import presentation.loginui.Login;
import presentation.superviseui.Supervise;
import presentation.viewui.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StockManagerUi {
    public void init(){
        JFrame f = new JFrame("库存管理");
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.orange);
        f.add(p);
        JButton commidy = new JButton("商品管理");
        JButton view = new JButton("查看库存");
        JButton gift = new JButton("赠品推荐");
        JButton supervise = new JButton("库存监管");

        commidy.setBounds(120, 200, 100, 30);
        view.setBounds(280, 200, 100, 30);
        gift.setBounds(420, 200, 100, 30);
        supervise.setBounds(580, 200, 100, 30);

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

        f.setBounds(550,250,800,600);

        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
                Login login = new Login();
            }
        });

    }
    public static void main(String [] args){
        new StockManagerUi().init();
    }
}
