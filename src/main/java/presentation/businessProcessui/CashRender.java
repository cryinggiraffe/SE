package presentation.businessProcessui;

import PO.CashPO;

import javax.swing.*;
import java.awt.*;

public class CashRender extends JPanel implements ListCellRenderer<CashPO>  {
    private JLabel lbAcount = new JLabel();
    private JLabel lbsum = new JLabel();
    private JLabel lbRemark = new JLabel();
    private JLabel lbDate = new JLabel();
    private JLabel lbId = new JLabel();
    private JLabel lbOperater = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbAmount = new JLabel();

    public CashRender () {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 3));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbAcount.setFont(font1);
        lbsum.setFont(font1);
        lbRemark.setFont(font1);
        lbDate.setFont(font1);
        lbId.setFont(font1);
        lbOperater.setFont(font1);
        lbName.setFont(font1);
        lbAmount.setFont(font1);

        panelText.add(lbId);
        panelText.add(lbOperater);
        panelText.add(lbAcount);


        panelText.add(lbName);
        panelText.add(lbAmount);
        panelText.add(lbsum);

        panelText.add(lbDate);
        panelText.add(lbRemark);

        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends CashPO> list,
                                                  CashPO CashPO, int index, boolean isSelected, boolean cellHasFocus) {

        lbAcount.setText("银行账户：" + CashPO.getAccount());
        lbsum.setText("总额：" + CashPO.getSum());
        lbRemark.setText("备注：" + CashPO.getRemark());
        lbDate.setText("日期：" + CashPO.getDate());
        lbId.setText("ID：" + CashPO.getListid());
        lbOperater.setText("操作员：" + CashPO.getOperator());
        lbName.setText("条目名：" + CashPO.getName());
        lbAmount.setText("转账金额：" + CashPO.getAmount());


        lbAcount.setOpaque(true);
        lbsum.setOpaque(true);
        lbRemark.setOpaque(true);
        lbDate.setOpaque(true);
        lbId.setOpaque(true);
        lbOperater.setOpaque(true);
        lbName.setOpaque(true);

        lbAmount.setOpaque(true);

        // when select item
        if (isSelected) {
            lbAcount.setBackground(list.getSelectionBackground());
            lbsum.setBackground(list.getSelectionBackground());
            lbRemark.setBackground(list.getSelectionBackground());
            lbDate.setBackground(list.getSelectionBackground());
            lbId.setBackground(list.getSelectionBackground());
            lbOperater.setBackground(list.getSelectionBackground());
            lbName.setBackground(list.getSelectionBackground());
            lbAmount.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbAcount.setBackground(list.getBackground());
            lbsum.setBackground(list.getBackground());
            lbRemark.setBackground(list.getBackground());
            lbDate.setBackground(list.getBackground());
            lbId.setBackground(list.getBackground());
            lbOperater.setBackground(list.getBackground());
            lbName.setBackground(list.getBackground());
            lbAmount.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
