package presentation.businessProcessui;

import PO.Commodity;
import PO.SaleFormPO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SaleRender extends JPanel implements ListCellRenderer<SaleFormPO> {
    private JLabel lbSalesman = new JLabel();
    private JLabel lbHoseware = new JLabel();
    private JLabel lbtpbfDiscount = new JLabel();
    private JLabel lbtpafDiscount = new JLabel();
    private JLabel lbDiscount = new JLabel();
    private JLabel lbvoucher = new JLabel();
    private JLabel lbRemark = new JLabel();
    private JLabel lbDate = new JLabel();
    private JLabel lbId = new JLabel();
    private JLabel lbOperater = new JLabel();
    private JLabel lbClient = new JLabel();
    private JLabel lbState = new JLabel();
    private JList lsCommodity = new JList();

    public SaleRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 4));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbHoseware.setFont(font1);
        lbSalesman.setFont(font1);
        lbtpbfDiscount.setFont(font1);
        lbtpafDiscount.setFont(font1);
        lbDiscount.setFont(font1);
        lbvoucher.setFont(font1);
        lbRemark.setFont(font1);
        lbDate.setFont(font1);
        lbId.setFont(font1);
        lbOperater.setFont(font1);
        lbClient.setFont(font1);
        lbState.setFont(font1);
        lsCommodity.setFont(font1);

        panelText.add(lbId);
        panelText.add(lbOperater);
        panelText.add(lbSalesman);
        panelText.add(lbClient);

        panelText.add(lbtpbfDiscount);
        panelText.add(lbDiscount);
        panelText.add(lbvoucher);
        panelText.add(lbtpafDiscount);

        panelText.add(lbHoseware);
        panelText.add(lbDate);
        panelText.add(lbState);
        panelText.add(lbRemark);

        panelText.add(lsCommodity);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SaleFormPO> list,
                                                  SaleFormPO sale, int index, boolean isSelected, boolean cellHasFocus) {

        lbHoseware.setText("仓库：" + sale.getHouseware());
        lbSalesman.setText("业务员：" + sale.getSalesman());
        lbtpbfDiscount.setText("折让前总额：" + sale.getTpbfDiscounting());
        lbtpafDiscount.setText("折让后总额：" + sale.getTpafDiscounting());
        lbDiscount.setText("折让：" + sale.getDiscount());
        lbvoucher.setText("代金券金额：" + sale.getVoucher());
        lbRemark.setText("备注：" + sale.getRemark());
        lbDate.setText("日期："+ sale.getDate());
        lbId.setText("ID：" + sale.getId());
        lbOperater.setText("操作员：" + sale.getOperator());
        lbClient.setText("客户ID：" + sale.getClient());
        lbState.setText("审批状态：" + sale.getState());

        DefaultListModel<Commodity> model = new DefaultListModel<>();
        List<Commodity> commodities = sale.getCommodityList();
        for (int i=0;i<commodities.size();i++){
            model.addElement(commodities.get(i));
        }
        lsCommodity.setModel(model);
        lsCommodity.setCellRenderer(new CommodityRender());

        lbHoseware.setOpaque(true);
        lbSalesman.setOpaque(true);
        lbtpbfDiscount.setOpaque(true);
        lbtpafDiscount.setOpaque(true);
        lbDiscount.setOpaque(true);
        lbvoucher.setOpaque(true);
        lbRemark.setOpaque(true);
        lbDate.setOpaque(true);
        lbId.setOpaque(true);
        lbOperater.setOpaque(true);
        lbClient.setOpaque(true);
        lbState.setOpaque(true);
        lsCommodity.setOpaque(true);

        // when select item
        if (isSelected) {
            lbHoseware.setBackground(list.getSelectionBackground());
            lbSalesman.setBackground(list.getSelectionBackground());
            lbtpbfDiscount.setBackground(list.getSelectionBackground());
            lbtpafDiscount.setBackground(list.getSelectionBackground());
            lbDiscount.setBackground(list.getSelectionBackground());
            lbvoucher.setBackground(list.getSelectionBackground());
            lbRemark.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            lbId.setBackground(list.getSelectionBackground());
            lbOperater.setBackground(list.getSelectionBackground());
            lbClient.setBackground(list.getSelectionBackground());
            lbState.setBackground(list.getSelectionBackground());
            lsCommodity.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbHoseware.setBackground(list.getBackground());
            lbSalesman.setBackground(list.getBackground());
            lbtpbfDiscount.setBackground(list.getBackground());
            lbtpafDiscount.setBackground(list.getBackground());
            lbDiscount.setBackground(list.getBackground());
            lbvoucher.setBackground(list.getBackground());
            lbRemark.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            lbId.setBackground(list.getBackground());
            lbOperater.setBackground(list.getBackground());
            lbClient.setBackground(list.getBackground());
            lbState.setBackground(list.getBackground());
            lsCommodity.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
