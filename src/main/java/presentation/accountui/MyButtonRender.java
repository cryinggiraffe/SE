package presentation.accountui;

import PO.AccountPO;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonRender extends JPanel implements ListCellRenderer<AccountPO> {

    private JLabel lbName = new JLabel();
    private JLabel lbBalance = new JLabel();

    public MyButtonRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 2));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbBalance.setFont(font1);
        lbName.setFont(font1);
        panelText.add(lbName);
        panelText.add(lbBalance);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends AccountPO> list,
                                                  AccountPO account, int index, boolean isSelected, boolean cellHasFocus) {

        lbName.setText("账户名称：" + account.getName());
        lbBalance.setText("余额：" + String.valueOf(account.getBalance()) + "元");
        lbBalance.setForeground(Color.blue);

        lbName.setOpaque(true);
        lbBalance.setOpaque(true);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbBalance.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbBalance.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}

