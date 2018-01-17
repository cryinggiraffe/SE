package presentation.businessProcessui;

import PO.Commodity;
import PO.ImportFormPO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ImportRender extends JPanel implements ListCellRenderer<ImportFormPO> {
    private JLabel lbHoseware = new JLabel();
    private JLabel lbsum = new JLabel();
    private JLabel lbRemark = new JLabel();
    private JLabel lbDate = new JLabel();
    private JLabel lbId = new JLabel();
    private JLabel lbOperater = new JLabel();
    private JLabel lbClient = new JLabel();
    private JLabel lbState = new JLabel();
    private JList lsCommodity = new JList();

    public ImportRender() {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 4));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbHoseware.setFont(font1);
        lbsum.setFont(font1);
        lbRemark.setFont(font1);
        lbDate.setFont(font1);
        lbId.setFont(font1);
        lbOperater.setFont(font1);
        lbClient.setFont(font1);
        lbState.setFont(font1);
        lsCommodity.setFont(font1);

        panelText.add(lbId);
        panelText.add(lbOperater);
        panelText.add(lbClient);
        panelText.add(lbsum);

        panelText.add(lbHoseware);
        panelText.add(lbDate);
        panelText.add(lbState);
        panelText.add(lbRemark);

        panelText.add(lsCommodity);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends ImportFormPO> list,
                                                  ImportFormPO importpo, int index, boolean isSelected, boolean cellHasFocus) {

        lbHoseware.setText("仓库：" + importpo.getHouseware());
        lbsum.setText("总额：" + importpo.getSum());
        lbRemark.setText("备注：" + importpo.getRemark());
        lbDate.setText("日期："+ importpo.getDate());
        lbId.setText("ID：" + importpo.getId());
        lbOperater.setText("操作员：" + importpo.getOperator());
        lbClient.setText("客户ID：" + importpo.getClient());
        lbState.setText("审批状态：" + importpo.getState());

        DefaultListModel<Commodity> model = new DefaultListModel<>();
        List<Commodity> commodities = importpo.getImportcommoditylist();
        for (int i=0;i<commodities.size();i++){
            model.addElement(commodities.get(i));
        }
        lsCommodity.setModel(model);
        lsCommodity.setCellRenderer(new CommodityRender());

        lbHoseware.setOpaque(true);
        lbsum.setOpaque(true);
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
            lbsum.setBackground(list.getSelectionBackground());
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
            lbsum.setBackground(list.getBackground());
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
