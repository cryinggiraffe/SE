package presentation.promotionui;

import PO.PromotionPO;
import businesslogic.goodbl.GoodBL;
import businesslogic.promotionbl.PromotionBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AddPromotionUI extends JFrame {
    private JLabel lbId = new JLabel();
    private JLabel lbUserClass = new JLabel("用户级别：");
    private JLabel lbGiftName = new JLabel("赠品名称：");
    private JLabel lbNum = new JLabel("赠品数量：");
    private JLabel lbDiscount = new JLabel("折让：");
    private JLabel lbCash = new JLabel("现金抵用：");
    private JLabel lbSGood1 = new JLabel("特价商品1：");
    private JLabel lbSGood2 = new JLabel("特价商品2：");
    private JLabel lbDisprice = new JLabel("降价：");

    private JComboBox jcUserClass = new JComboBox();
    private JComboBox jcGiftName = new JComboBox();
    private JTextField jtNum = new JTextField("");
    private JTextField jtDiscount = new JTextField("");
    private JComboBox jcSGood1 = new JComboBox();
    private JTextField jtCash = new JTextField("");
    private JComboBox jcSGood2 = new JComboBox();
    private JTextField jtDisprice = new JTextField("");
    private JPanel panel = new JPanel();

    private static JButton bt_submit;

    private static JFrame jf_1;
    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);

    public AddPromotionUI (String type) {
        Font font =new Font("微软雅黑", Font.PLAIN, 20);//设置按钮字体
        PromotionBL promotionBL = new PromotionBL();
        String id = promotionBL.getId();
        lbId.setText("策略ID：" + id);
        lbId.setBounds(150,50,500,50);
        lbId.setFont(font);

        bt_submit = new JButton("提交");
        bt_submit.setBounds(630,500,120,50);
        bt_submit.setFont(font);

        panel.setBounds(0,0,Width,Height);
        panel.setLayout(null);
        panel.setBackground(background);
        panel.setVisible(true);

        if (type.equals("用户级别")){
            lbUserClass.setBounds(150,120,120,50);
            lbUserClass.setFont(font);
            jcUserClass.setBounds(280,120,120,50);
            jcUserClass.setFont(font);
            jcUserClass.addItem("1");
            jcUserClass.addItem("2");
            jcUserClass.addItem("3");
            jcUserClass.addItem("4");
            jcUserClass.addItem("5");


            lbGiftName.setBounds(150,190,120,50);
            lbGiftName.setFont(font);
            jcGiftName.setBounds(280,190,120,50);
            jcGiftName.setFont(font);

            lbNum.setBounds(150,260,120,50);
            lbNum.setFont(font);
            jtNum.setBounds(280,260,470,50);
            jtNum.setFont(font);

            lbDiscount.setBounds(150,330,120,50);
            lbDiscount.setFont(font);
            jtDiscount.setBounds(280,330,470,50);
            jtDiscount.setFont(font);

            lbCash.setBounds(150,400,120,50);
            lbCash.setFont(font);
            jtCash.setBounds(280,400,470,50);
            jtCash.setFont(font);

            GoodBL goodBL = new GoodBL();
            List<String> nameList = goodBL.listNames();
            for (int i=0;i<nameList.size();i++){
                jcGiftName.addItem(nameList.get(i));
            }

            panel.add(lbUserClass);
            panel.add(jcUserClass);
            panel.add(lbGiftName);
            panel.add(jcGiftName);
            panel.add(lbNum);
            panel.add(jtNum);
            panel.add(lbDiscount);
            panel.add(jtDiscount);
            panel.add(lbCash);
            panel.add(jtCash);
        }else if (type.equals("特价包")){
            lbSGood1.setBounds(150,120,120,50);
            lbSGood1.setFont(font);
            jcSGood1.setBounds(280,120,120,50);
            jcSGood1.setFont(font);

            lbSGood2.setBounds(150,190,120,50);
            lbSGood2.setFont(font);
            jcSGood2.setBounds(280,190,120,50);
            jcSGood2.setFont(font);

            lbDisprice.setBounds(150,260,120,50);
            lbDisprice.setFont(font);
            jtDisprice.setBounds(280,260,470,50);
            jtDisprice.setFont(font);

            GoodBL goodBL = new GoodBL();
            List<String> nameList = goodBL.listNames();
            for (int i=0;i<nameList.size();i++){
                jcSGood1.addItem(nameList.get(i));
                jcSGood2.addItem(nameList.get(i));
            }

            panel.add(lbSGood1);
            panel.add(jcSGood1);
            panel.add(lbSGood2);
            panel.add(jcSGood2);
            panel.add(lbDisprice);
            panel.add(jtDisprice);
        }else if (type.equals("总价优惠")){
            lbGiftName.setBounds(150,120,120,50);
            lbGiftName.setFont(font);
            jcGiftName.setBounds(280,120,120,50);
            jcGiftName.setFont(font);

            lbNum.setBounds(150,190,120,50);
            lbNum.setFont(font);
            jtNum.setBounds(280,190,470,50);
            jtNum.setFont(font);

            lbCash.setBounds(150,260,120,50);
            lbCash.setFont(font);
            jtCash.setBounds(280,260,470,50);
            jtCash.setFont(font);

            GoodBL goodBL = new GoodBL();
            List<String> nameList = goodBL.listNames();
            for (int i=0;i<nameList.size();i++){
                jcGiftName.addItem(nameList.get(i));
            }

            panel.add(lbGiftName);
            panel.add(jcGiftName);
            panel.add(lbNum);
            panel.add(jtNum);
            panel.add(lbCash);
            panel.add(jtCash);

        }

        panel.add(lbId);
        panel.add(bt_submit);

        jf_1 = new JFrame("添加用户");
        jf_1.setSize(Width,Height);
        jf_1.setLocation(200,10);
        jf_1.setLayout(null);
        jf_1.getContentPane().setBackground(background);
        jf_1.setContentPane(panel);
        jf_1.setVisible(true);

        //提交按钮事件
        ActionListener btSubmit_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Object[] options = {" 确定 "," 取消 "};
                int response=JOptionPane.showOptionDialog(panel, "确认提交？", "提示信息",JOptionPane.YES_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if(response==0) {
                    System.out.println(" 您按下了确定按钮  ");
                    int id = 1;
                    int userclass = Integer.parseInt(jcUserClass.getSelectedItem().toString());
                    String giftname = jcGiftName.getSelectedItem().toString();
                    int num = Integer.parseInt(jtNum.getText());
                    double discount = Double.parseDouble(jtDiscount.getText());
                    double cash_coupon = Double.parseDouble(jtCash.getText());
                    String specialgoodname1 = jcSGood1.getSelectedItem().toString();
                    String specialgoodname2 = jcSGood2.getSelectedItem().toString();
                    double discountprice = Double.parseDouble(jtDisprice.getText());
                    if (type.equals("用户级别")){
                        System.out.println("make userclass promotion");
                        //PromotionPO promotionPO = new PromotionPO(id,userclass,giftname,num,discount,cash_coupon);
                        //promotionBL.makePromotion(promotionPO);
                    }else if (type.equals("特价包")){
                        System.out.println("make special price promotion");
                        //PromotionPO promotionPO = new PromotionPO(id,specialgoodname1,specialgoodname2,discountprice);
                        //promotionBL.makePromotion(promotionPO);
                    }else if (type.equals("总价优惠")){
                        System.out.println("make total price promotion");
                        //PromotionPO promotionPO = new PromotionPO(id,giftname,num,cash_coupon);
                        //promotionBL.makePromotion(promotionPO);
                    }

                } else if(response==1) {
                    System.out.println(" 您按下了取消按钮  ");
                }
            }
        };
        bt_submit.addActionListener(btSubmit_ls);

        jf_1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        jf_1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(jf_1, "您的信息尚未保存，是否仍要关闭？","提示信息", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if(JOptionPane.YES_OPTION == flag){
                    jf_1.dispose();
                }else{
                    return;
                }
            }
        });


    }
}
