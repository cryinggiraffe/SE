package presentation.translationSituationui;

import PO.IncomePO;

import javax.swing.*;
import java.awt.*;

public class IncomRender extends JPanel implements ListCellRenderer<IncomePO> {
    private JLabel lbSale = new JLabel();
    private JLabel lbOver = new JLabel();
    private JLabel lbCost = new JLabel();
    private JLabel lbImport = new JLabel();
    private JLabel lbVouchers = new JLabel();
    private JLabel lbSum = new JLabel();
    private JLabel lbDiscount = new JLabel();
    private JLabel lbDate = new JLabel();

    public IncomRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 4));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbSale.setFont(font1);
        lbOver.setFont(font1);
        lbCost.setFont(font1);
        lbImport.setFont(font1);
        lbVouchers.setFont(font1);
        lbSum.setFont(font1);
        lbDiscount.setFont(font1);
        lbDate.setFont(font1);
        panelText.add(lbDate);
        panelText.add(lbImport);
        panelText.add(lbSale);
        panelText.add(lbOver);

        panelText.add(lbCost);
        panelText.add(lbVouchers);
        panelText.add(lbDiscount);
        panelText.add(lbSum);





        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends IncomePO> list,
                                                  IncomePO importPO, int index, boolean isSelected, boolean cellHasFocus) {

        lbSale.setText("销售收入：" + importPO.getSaleincome() + "元");
        lbOver.setText("报溢收入：" + importPO.getOverflowincome() + "元");
        lbCost.setText("成本调价收入：" + importPO.getImportreturnincome() + "元");
        lbImport.setText("进货退货差价："+ importPO.getDate());
        lbVouchers.setText("代金券与实际收款差额收入：" + importPO.getVouchersincome() + "元");
        lbSum.setText("折后总收入：" + importPO.getSumincome() + "元");
        lbDiscount.setText("折让：" + importPO.getDiscount() + "元");
        lbDate.setText("日期：" + importPO.getDate());


        lbSale.setOpaque(true);
        lbOver.setOpaque(true);
        lbCost.setOpaque(true);
        lbImport.setOpaque(true);
        lbVouchers.setOpaque(true);
        lbSum.setOpaque(true);
        lbDiscount.setOpaque(true);
        lbDate.setOpaque(true);

        // when select item
        if (isSelected) {
            lbSale.setBackground(list.getSelectionBackground());
            lbOver.setBackground(list.getSelectionBackground());
            lbCost.setBackground(list.getSelectionBackground());
            lbImport.setBackground(list.getSelectionBackground());
            lbVouchers.setBackground(list.getSelectionBackground());
            lbSum.setBackground(list.getSelectionBackground());
            lbDiscount.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbSale.setBackground(list.getBackground());
            lbOver.setBackground(list.getBackground());
            lbCost.setBackground(list.getBackground());
            lbImport.setBackground(list.getBackground());
            lbVouchers.setBackground(list.getBackground());
            lbSum.setBackground(list.getBackground());
            lbDiscount.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }




}
