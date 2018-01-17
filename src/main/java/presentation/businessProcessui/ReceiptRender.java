package presentation.businessProcessui;

import PO.ReceiptPO;

import javax.swing.*;
import java.awt.*;

public class ReceiptRender  extends JPanel implements ListCellRenderer<ReceiptPO> {
    private JLabel lbAcount = new JLabel();
    private JLabel lbsum = new JLabel();
    private JLabel lbRemark = new JLabel();
    private JLabel lbDate = new JLabel();
    private JLabel lbId = new JLabel();
    private JLabel lbOperater = new JLabel();
    private JLabel lbClient = new JLabel();
    private JLabel lbAmount = new JLabel();

    public ReceiptRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 4));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbAcount.setFont(font1);
        lbsum.setFont(font1);
        lbRemark.setFont(font1);
        lbDate.setFont(font1);
        lbId.setFont(font1);
        lbOperater.setFont(font1);
        lbClient.setFont(font1);
        lbAmount.setFont(font1);

        panelText.add(lbId);
        panelText.add(lbOperater);
        panelText.add(lbClient);
        panelText.add(lbsum);

        panelText.add(lbAcount);
        panelText.add(lbDate);
        panelText.add(lbRemark);
        panelText.add(lbAmount);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ReceiptPO> list,
                                                  ReceiptPO receiptPO, int index, boolean isSelected, boolean cellHasFocus) {

        lbAcount.setText("银行账户：" + receiptPO.getAccount());
        lbsum.setText("总额：" + receiptPO.getSum());
        lbRemark.setText("备注：" + receiptPO.getRemark());
        lbDate.setText("日期："+ receiptPO.getDate());
        lbId.setText("ID：" + receiptPO.getId());
        lbOperater.setText("操作员：" + receiptPO.getOperator());
        lbClient.setText("客户ID：" + receiptPO.getClient());
        lbAmount.setText("转账金额：" + receiptPO.getAmount());


        lbAcount.setOpaque(true);
        lbsum.setOpaque(true);
        lbRemark.setOpaque(true);
        lbDate.setOpaque(true);
        lbId.setOpaque(true);
        lbOperater.setOpaque(true);
        lbClient.setOpaque(true);
        lbAmount.setOpaque(true);

        // when select item
        if (isSelected) {
            lbAcount.setBackground(list.getSelectionBackground());
            lbsum.setBackground(list.getSelectionBackground());
            lbRemark.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            lbId.setBackground(list.getSelectionBackground());
            lbOperater.setBackground(list.getSelectionBackground());
            lbClient.setBackground(list.getSelectionBackground());
            lbAmount.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbAcount.setBackground(list.getBackground());
            lbsum.setBackground(list.getBackground());
            lbRemark.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            lbId.setBackground(list.getBackground());
            lbOperater.setBackground(list.getBackground());
            lbClient.setBackground(list.getBackground());
            lbAmount.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
