package presentation.translationSituationui;

import PO.ExpenditurePO;

import javax.swing.*;
import java.awt.*;

public class ExpenditureRender extends JPanel implements ListCellRenderer<ExpenditurePO> {
    private JLabel lbSale = new JLabel();
    private JLabel lbCommodity = new JLabel();
    private JLabel lbGift = new JLabel();
    private JLabel lbSum = new JLabel();
    private JLabel lbDate = new JLabel();

    public ExpenditureRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 3));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbSale.setFont(font1);
        lbCommodity.setFont(font1);
        lbGift.setFont(font1);
        lbSum.setFont(font1);
        lbDate.setFont(font1);

        panelText.add(lbDate);
        panelText.add(lbSale);
        panelText.add(lbCommodity);

        panelText.add(lbGift);
        panelText.add(lbSum);





        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ExpenditurePO> list,
                                                  ExpenditurePO expenditurePO, int index, boolean isSelected, boolean cellHasFocus) {

        lbSale.setText("销售成本：" + expenditurePO.getSalecost());
        lbCommodity.setText("商品报损：" + expenditurePO.getCommoditylostexpenditure());
        lbGift.setText("商品增出：" + expenditurePO.getGiftexpenditure());
        lbSum.setText("总支出：" + expenditurePO.getSumexpenditure());
        lbDate.setText("日期：" + expenditurePO.getDate());


        lbSale.setOpaque(true);
        lbCommodity.setOpaque(true);
        lbGift.setOpaque(true);
        lbSum.setOpaque(true);
        lbDate.setOpaque(true);

        // when select item
        if (isSelected) {
            lbSale.setBackground(list.getSelectionBackground());
            lbCommodity.setBackground(list.getSelectionBackground());
            lbGift.setBackground(list.getSelectionBackground());
            lbSum.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbSale.setBackground(list.getBackground());
            lbCommodity.setBackground(list.getBackground());
            lbGift.setBackground(list.getBackground());
            lbSum.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
