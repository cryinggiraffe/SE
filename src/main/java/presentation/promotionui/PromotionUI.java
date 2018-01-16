package presentation.promotionui;

import PO.PromotionPO;
import businesslogic.promotionbl.PromotionBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromotionUI extends JPanel {
    private static JButton bt_refresh;
    private static JButton bt_add;
    private static JLabel jl_type;
    private static JComboBox jc_type;
    private static JList jl_promotionlist;
    private static JScrollPane jsp_promotionlist;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);

    public PromotionUI () {
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        bt_refresh = new JButton("刷新");
        bt_refresh.setBounds(445,90,80,30);
        bt_refresh.setFont(font);

        jl_type = new JLabel("策略类型：" );
        jl_type.setBounds(545,90,80,30);
        jl_type.setFont(font);
        jc_type = new JComboBox();
        jc_type.setBounds(630,90,120,30);
        jc_type.setFont(font);
        jc_type.addItem("用户级别");
        jc_type.addItem("特价包");
        jc_type.addItem("总价优惠");


        bt_add = new JButton("制定");
        bt_add.setBounds(770,90,80,30);
        bt_add.setFont(font);

        //显示所有促销策略列表
        DefaultListModel<PromotionPO> model = new DefaultListModel<>();
        PromotionBL promotionBL = new PromotionBL();
        java.util.List<PromotionPO> promotionPOList = promotionBL.findAll();
        System.out.println(promotionPOList.size());
        for(int i = 0; i < promotionPOList.size(); i++)
        {
            PromotionPO promotionPO = promotionPOList.get(i);
            model.addElement(promotionPO);

        }
        jl_promotionlist = new JList(model);
        jl_promotionlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_promotionlist.setCellRenderer(new MyPromotionRender());
        jl_promotionlist.setFont(font);

        jsp_promotionlist = new JScrollPane(jl_promotionlist);
        jsp_promotionlist.setBounds(50,140,800,500);
        jsp_promotionlist.setBackground(background_table);

        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_add);
        this.add(bt_refresh);
        this.add(jsp_promotionlist);
        this.add(jl_type);
        this.add(jc_type);
        this.setVisible(true);

        //刷新按钮事件
        ActionListener btRefresh_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("refresh promotion");
                refresh();
            }
        };
        bt_refresh.addActionListener(btRefresh_ls);

        //添加策略事件
        ActionListener btAdd_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("add promotion");
                String type = jc_type.getSelectedItem().toString();
                AddPromotionUI addPromotionUI = new AddPromotionUI(type);
            }
        };
        bt_add.addActionListener(btAdd_ls);

    }

    public void refresh() {
        DefaultListModel<PromotionPO> model = new DefaultListModel<>();
        PromotionBL promotionBL = new PromotionBL();
        java.util.List<PromotionPO> promotionPOList = promotionBL.findAll();
        for(int i = 0; i < promotionPOList.size(); i++)
        {
            PromotionPO promotionPO = promotionPOList.get(i);
            model.addElement(promotionPO);

        }
        jl_promotionlist = new JList(model);
    }

}
