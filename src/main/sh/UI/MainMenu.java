package UI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainMenu extends JFrame{
	
	private JPanel panel;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;
	private JMenu begin,category,help;
	private JMenuItem login,exit;
	
	
	public void init(){
		panel = new JPanel();
		scrollPane = new JScrollPane();
		
		createMenu();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(600, 700);
		this.setTitle("经销存");
		this.setVisible(true);
		this.getContentPane().add(scrollPane);
		
		addEvent();
	}
	
	
	public void createMenu(){
		menuBar = new JMenuBar();
		
		begin = new JMenu("开始");
		category = new JMenu("库存管理");
		help = new JMenu("帮助");
		
		login = new JMenuItem("登陆");
		exit = new JMenuItem("退出");
		
		begin.add(login);
		begin.addSeparator();
		begin.add(exit);
		
		menuBar.add(begin);
		menuBar.add(category);
		menuBar.add(help);
		this.setJMenuBar(menuBar);
		
	}
	
	
	public void addEvent(){
		login.addActionListener(new Event_Login());
		exit.addActionListener(new Event_Exit());
	}
	
	

}
