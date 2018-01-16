package presentation.promotionui;

import PO.PromotionPO;

import javax.swing.*;
import java.awt.*;

public class MyPromotionRender  extends JPanel implements ListCellRenderer<PromotionPO>{
    private JLabel lbId = new JLabel();
    private JLabel lbUserClass = new JLabel();
    private JLabel lbGiftName = new JLabel();
    private JLabel lbNum = new JLabel();
    private JLabel lbDiscount = new JLabel();
    private JLabel lbCash = new JLabel();
    private JLabel lbSGood1 = new JLabel();
    private JLabel lbSGood2 = new JLabel();
    private JLabel lbDisprice = new JLabel();
    JPanel panelText = new JPanel();

    public MyPromotionRender() {
        setLayout(new BorderLayout(5, 5));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 10);//设置按钮字体1
        lbId.setFont(font1);
        lbUserClass.setFont(font1);
        lbGiftName.setFont(font1);
        lbNum.setFont(font1);
        lbDiscount.setFont(font1);
        lbCash.setFont(font1);
        lbSGood1.setFont(font1);
        lbSGood2.setFont(font1);
        lbDisprice.setFont(font1);

        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends PromotionPO> list,
                                                  PromotionPO po, int index, boolean isSelected, boolean cellHasFocus) {
        int userClass = po.getUserclass();
        String specialgoodname1 = po.getSpecialgoodname1();
        double cash_coupon = po.getCash_coupon();
        if (userClass != 0){
            panelText.removeAll();
            lbId.setText("ID：" + po.getId());
            lbUserClass.setText("用户级别：" + po.getClass());
            lbGiftName.setText("赠品名：" + po.getGiftname());
            lbDiscount.setText("折扣价：" + po.getDiscount());
            lbNum.setText("数量：" + po.getNum());
            lbCash.setText("现金抵用：" + po.getCash_coupon());
            panelText.add(lbId);
            panelText.add(lbUserClass);
            panelText.add(lbGiftName);
            panelText.add(lbNum);
            panelText.add(lbDiscount);
            panelText.add(lbCash);
        }else if (specialgoodname1 != null) {
            panelText.removeAll();
            lbId.setText("ID：" + po.getId());
            lbSGood1.setText("特价商品1：" + po.getSpecialgoodname1());
            lbSGood2.setText("特价商品2：" + po.getSpecialgoodname2());
            lbDisprice.setText("折扣价：" + po.getDiscountprice());
            panelText.add(lbId);
            panelText.add(lbSGood1);
            panelText.add(lbSGood2);
            panelText.add(lbDisprice);

        }else if (cash_coupon != 0.0) {
            panelText.removeAll();
            lbId.setText("ID：" + po.getId());
            lbGiftName.setText("赠品名：" + po.getGiftname());
            lbNum.setText("数量：" + po.getNum());
            lbCash.setText("现金抵用：" + po.getCash_coupon());
            panelText.add(lbId);
            panelText.add(lbGiftName);
            panelText.add(lbNum);
            panelText.add(lbCash);
        }

        lbId.setOpaque(true);
        lbUserClass.setOpaque(true);
        lbGiftName.setOpaque(true);
        lbNum.setOpaque(true);
        lbDiscount.setOpaque(true);
        lbCash.setOpaque(true);
        lbSGood1.setOpaque(true);
        lbSGood2.setOpaque(true);
        lbDisprice.setOpaque(true);

        // when select item
        if (isSelected) {
            lbId.setBackground(list.getSelectionBackground());
            lbUserClass.setBackground(list.getSelectionBackground());
            lbGiftName.setBackground(list.getSelectionBackground());
            lbNum.setBackground(list.getSelectionBackground());
            lbDiscount.setBackground(list.getSelectionBackground());
            lbCash.setBackground(list.getSelectionBackground());
            lbSGood1.setBackground(list.getSelectionBackground());
            lbSGood2.setBackground(list.getSelectionBackground());
            lbDisprice.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbId.setBackground(list.getBackground());
            lbUserClass.setBackground(list.getBackground());
            lbGiftName.setBackground(list.getBackground());
            lbNum.setBackground(list.getBackground());
            lbDiscount.setBackground(list.getBackground());
            lbCash.setBackground(list.getBackground());
            lbSGood1.setBackground(list.getBackground());
            lbSGood2.setBackground(list.getBackground());
            lbDisprice.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
