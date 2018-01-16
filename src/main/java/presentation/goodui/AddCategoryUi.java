package presentation.goodui;

import PO.CategoryPO;
import businesslogic.categorybl.CategoryBL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddCategoryUi {
    public void init(int parentId) {
        JFrame f = new JFrame("商品分类信息");
        f.setVisible(true);
        f.setBounds(555, 350, 800, 170);
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.setBackground(Color.pink);
        f.add(p);

        JLabel lname = new JLabel("请输入商品分类名称");
        JTextField tname = new JTextField();
        tname.setColumns(10);
        p.add(lname);
        p.add(tname);


        f.setVisible(true);


        JButton button = new JButton("添加");
        p.add(button);
        button.setBounds(330, 80, 100, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoryBL categoryBL = new CategoryBL();
                String addName = tname.getText().toString();
                String id = categoryBL.generateId();
                CategoryPO cpo = new CategoryPO(addName, parentId, id);
                categoryBL.addCategory(cpo);

                f.setVisible(false);

            }

        });
    }
}
