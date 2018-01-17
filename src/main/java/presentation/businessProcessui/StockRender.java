package presentation.businessProcessui;

import PO.StockPO;

import javax.swing.*;
import java.awt.*;

public class StockRender extends JPanel implements ListCellRenderer<StockPO>{
    private JLabel lbName = new JLabel();
    private JLabel lbId = new JLabel();
    private JLabel lbNum = new JLabel();
    private JLabel lbDate = new JLabel();
    JPanel panelText = new JPanel(new GridLayout(0, 4));
    public StockRender() {
        setLayout(new BorderLayout(5, 5));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbName.setFont(font1);
        lbId.setFont(font1);
        lbNum.setFont(font1);
        lbDate.setFont(font1);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends StockPO> list,
                                                  StockPO stock, int index, boolean isSelected, boolean cellHasFocus) {

        lbName.setText("商品名：" + stock.getGoodname());
        lbId.setText("商品ID：" + stock.getGoodid());
        lbNum.setText("数量：" + stock.getNum());
        lbDate.setText("日期：" + stock.getDate());

        lbName.setOpaque(true);
        lbId.setOpaque(true);
        lbNum.setOpaque(true);
        lbDate.setOpaque(true);
        panelText.setLayout(new GridLayout(0, 4));

        panelText.add(lbId);
        panelText.add(lbName);
        panelText.add(lbNum);
        panelText.add(lbDate);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbId.setBackground(list.getSelectionBackground());
            lbNum.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbId.setBackground(list.getBackground());
            lbNum.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
