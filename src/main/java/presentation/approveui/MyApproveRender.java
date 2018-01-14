package presentation.approveui;

import PO.RecordPO;

import javax.swing.*;
import java.awt.*;

public class MyApproveRender extends JPanel implements ListCellRenderer<RecordPO>   {
    private JLabel lbId = new JLabel();
    private JLabel lbClient = new JLabel();
    private JLabel lbOperator = new JLabel();
    

    public MyApproveRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 3));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbId.setFont(font1);
        lbClient.setFont(font1);
        lbOperator.setFont(font1);
       
        panelText.add(lbId);
        panelText.add(lbClient);
        panelText.add(lbOperator);
      
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends RecordPO> list,
                                                  RecordPO record, int index, boolean isSelected, boolean cellHasFocus) {

        lbId.setText("单据编号：" + record.getId());
        lbClient.setText("客户ID：" + record.getClient());
        lbOperator.setText("操作员：" + record.getOperator());


        lbId.setOpaque(true);
        lbClient.setOpaque(true);
        lbOperator.setOpaque(true);


        // when select item
        if (isSelected) {
            lbId.setBackground(list.getSelectionBackground());
            lbClient.setBackground(list.getSelectionBackground());
            lbOperator.setBackground(list.getSelectionBackground());

            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbId.setBackground(list.getBackground());
            lbClient.setBackground(list.getBackground());
            lbOperator.setBackground(list.getBackground());

            setBackground(list.getBackground());
        }

        return this;
    }
}
