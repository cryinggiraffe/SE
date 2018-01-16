package presentation.businessProcessui;

import PO.Commodity;

import javax.swing.*;
import java.awt.*;

public class CommodityRender extends JPanel implements ListCellRenderer<Commodity>  {
    private JLabel lbId = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbVersion = new JLabel();
    private JLabel lbQuantity = new JLabel();
    private JLabel lbPrice = new JLabel();
    private JLabel lbSubtotalprice = new JLabel();
    private JLabel lbRemark = new JLabel();

    public CommodityRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 7));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbName.setFont(font1);
        lbId.setFont(font1);
        lbVersion.setFont(font1);
        lbQuantity.setFont(font1);
        lbPrice.setFont(font1);
        lbRemark.setFont(font1);
        lbSubtotalprice.setFont(font1);

        panelText.add(lbId);
        panelText.add(lbName);
        panelText.add(lbVersion);
        panelText.add(lbQuantity);
        panelText.add(lbPrice);
        panelText.add(lbSubtotalprice);
        panelText.add(lbRemark);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Commodity> list,
                                                  Commodity commodity, int index, boolean isSelected, boolean cellHasFocus) {

        lbName.setText("商品名：" + commodity.getName());
        lbId.setText("编号：" + commodity.getGoodid());
        lbVersion.setText("型号：" + commodity.getVersion());
        lbQuantity.setText("数量：" + commodity.getQuantity());
        lbPrice.setText("单价：" + commodity.getPirce());
        lbSubtotalprice.setText("总额：" + commodity.getSubtotalprice());
        lbRemark.setText("备注：" + commodity.getRemark());

        lbName.setOpaque(true);
        lbId.setOpaque(true);
        lbVersion.setOpaque(true);
        lbQuantity.setOpaque(true);
        lbPrice.setOpaque(true);
        lbSubtotalprice.setOpaque(true);
        lbRemark.setOpaque(true);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbId.setBackground(list.getSelectionBackground());
            lbVersion.setBackground(list.getSelectionBackground());
            lbQuantity.setBackground(list.getSelectionBackground());
            lbPrice.setBackground(list.getSelectionBackground());
            lbSubtotalprice.setBackground(list.getSelectionBackground());
            lbRemark.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbId.setBackground(list.getBackground());
            lbVersion.setBackground(list.getBackground());
            lbQuantity.setBackground(list.getBackground());
            lbPrice.setBackground(list.getBackground());
            lbSubtotalprice.setBackground(list.getBackground());
            lbRemark.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
