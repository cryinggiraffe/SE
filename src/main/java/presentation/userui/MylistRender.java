package presentation.userui;

import PO.UserPO;

import javax.swing.*;
import java.awt.*;

public class MylistRender extends JPanel implements ListCellRenderer<UserPO>  {
    private JLabel lbName = new JLabel();
    private JLabel lbPassword = new JLabel();
    private JLabel lbClass = new JLabel();
    private JLabel lbType = new JLabel();
    JPanel panelText = new JPanel(new GridLayout(0, 4));
    public MylistRender() {
        setLayout(new BorderLayout(5, 5));
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        lbName.setFont(font1);
        lbPassword.setFont(font1);
        lbClass.setFont(font1);
        lbType.setFont(font1);
        add(panelText, BorderLayout.CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends UserPO> list,
                                                  UserPO user, int index, boolean isSelected, boolean cellHasFocus) {

        lbName.setText("用户名：" + user.getUsername());
        lbPassword.setText("密码：" + user.getPassword());
        lbClass.setText("用户级别：" + user.getUserclass());
        lbType.setText("用户类型：" + user.getType());

        lbName.setOpaque(true);
        lbPassword.setOpaque(true);
        lbClass.setOpaque(true);
        lbType.setOpaque(true);
        panelText.setLayout(new GridLayout(0, 4));
        panelText.add(lbName);
        panelText.add(lbPassword);
        panelText.add(lbClass);
        panelText.add(lbType);

        // when select item
        if (isSelected) {
            lbName.setBackground(list.getSelectionBackground());
            lbPassword.setBackground(list.getSelectionBackground());
            lbClass.setBackground(list.getSelectionBackground());
            lbType.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else { // when don't select
            lbName.setBackground(list.getBackground());
            lbPassword.setBackground(list.getBackground());
            lbClass.setBackground(list.getBackground());
            lbType.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
