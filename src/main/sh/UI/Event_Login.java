package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Event_Login implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		JDialog infoDialog = new JDialog();
		infoDialog.setSize(100, 200);
		infoDialog.setLocation(600, 300);
		infoDialog.setVisible(true);
		
		JLabel infoLabel = new JLabel("登陆成功");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setVisible(true);
		infoDialog.add(infoLabel);
	}

}
