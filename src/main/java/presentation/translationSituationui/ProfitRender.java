package presentation.translationSituationui;

import PO.ProfitPO;

import javax.swing.*;
import java.awt.*;

public class ProfitRender extends JPanel implements ListCellRenderer<ProfitPO> {
    private JLabel lbDate = new JLabel();
    private JLabel lbProfit = new JLabel();

    public ProfitRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 2));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbProfit.setFont(font1);
        lbDate.setFont(font1);
        panelText.add(lbDate);
        panelText.add(lbProfit);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ProfitPO> list,
                                                  ProfitPO profit, int index, boolean isSelected, boolean cellHasFocus) {

        lbDate.setText("日期：" + profit.getDate());
        lbProfit.setText("利润：" + String.valueOf(profit.getProfit()) + "元");
        lbProfit.setForeground(Color.blue);

        lbDate.setOpaque(true);
        lbProfit.setOpaque(true);

        // when select item
        if (isSelected) {
            lbDate.setBackground(list.getSelectionBackground());
            lbProfit.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbDate.setBackground(list.getBackground());
            lbProfit.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
