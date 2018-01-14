package presentation.saleSituationui;

import PO.SaleSituationPo;

import javax.swing.*;
import java.awt.*;

public class MySaleRender extends JPanel implements ListCellRenderer<SaleSituationPo>{
    private JLabel lbDate = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbVersion = new JLabel();
    private JLabel lbQuantity = new JLabel();
    private JLabel lbPrice = new JLabel();
    private JLabel lbSubtotalprice = new JLabel();

    public MySaleRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 6));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbName.setFont(font1);
        lbDate.setFont(font1);
        lbVersion.setFont(font1);
        lbQuantity.setFont(font1);
        lbPrice.setFont(font1);
        lbSubtotalprice.setFont(font1);
        panelText.add(lbDate);
        panelText.add(lbName);
        panelText.add(lbVersion);
        panelText.add(lbQuantity);
        panelText.add(lbPrice);
        panelText.add(lbSubtotalprice);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SaleSituationPo> list,
                                                  SaleSituationPo saleSituation, int index, boolean isSelected, boolean cellHasFocus) {

        lbName.setText("商品名：" + saleSituation.getName());
        lbDate.setText("时间：" + saleSituation.getDate());
        lbVersion.setText("型号：" + saleSituation.getVersion());
        lbQuantity.setText("数量：" + saleSituation.getQuantity());
        lbPrice.setText("单价：" + saleSituation.getPirce());
        lbSubtotalprice.setText("总额：" + saleSituation.getSubtotalprice());

        lbName.setOpaque(true);
        lbDate.setOpaque(true);
        lbVersion.setOpaque(true);
        lbQuantity.setOpaque(true);
        lbPrice.setOpaque(true);
        lbSubtotalprice.setOpaque(true);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            lbVersion.setBackground(list.getSelectionBackground());
            lbQuantity.setBackground(list.getSelectionBackground());
            lbPrice.setBackground(list.getSelectionBackground());
            lbSubtotalprice.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            lbVersion.setBackground(list.getBackground());
            lbQuantity.setBackground(list.getBackground());
            lbPrice.setBackground(list.getBackground());
            lbSubtotalprice.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
