package presentation.translationSituationui;

import PO.ExpenditurePO;
import PO.IncomePO;
import businesslogic.translationSituationbl.TranslationSituationBL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TransSituationUI extends JPanel {
    private static JList jl_list;
    private static JList jl_list1;
    private static JScrollPane jsp_list;
    private static JScrollPane jsp_list1;
    private static JLabel jl_sum;
    private static JLabel jl_income;
    private static JLabel jl_expenditure;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);

    public TransSituationUI () {
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体
        Font font1 =new Font("微软雅黑", Font.PLAIN, 25);//设置按钮字体

        jl_list = new JList();
        jl_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list.setFont(font);

        jl_list1 = new JList();
        jl_list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list1.setFont(font);

        jl_income = new JLabel("收入：");
        jl_income.setBounds(50,30,600,50);
        jl_income.setFont(font1);

        jl_expenditure = new JLabel("支出：");
        jl_expenditure.setBounds(50,320,600,50);
        jl_expenditure.setFont(font1);

        jl_sum = new JLabel();
        jl_sum.setBounds(50,610,600,50);
        jl_sum.setFont(font1);

        //显示所有收入列表
        DefaultListModel<IncomePO> model = new DefaultListModel<>();
        TranslationSituationBL transSituationBL = new TranslationSituationBL();
        //transSituationBL.newIncome();
        java.util.List<IncomePO> incomePOList = transSituationBL.findAllIncome();
        System.out.println(incomePOList.size());
        for(int i = 0; i < incomePOList.size(); i++)
        {
            IncomePO incomePO = incomePOList.get(i);
            System.out.println(incomePO.toString());
            model.addElement(incomePO);

        }
        jl_list = new JList(model);
        jl_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list.setCellRenderer(new IncomRender());
        jl_list.setFont(font);
        jsp_list = new JScrollPane(jl_list);
        jsp_list.setBounds(50,85,800,230);
        jsp_list.setBackground(background_table);

        //显示所有支出列表
        DefaultListModel<ExpenditurePO> model1 = new DefaultListModel<>();
        //transSituationBL.newExpenditure();
        java.util.List<ExpenditurePO> expenditurePOList = transSituationBL.findAllExpenditure();
        System.out.println(expenditurePOList.size());
        for(int i = 0; i < expenditurePOList.size(); i++)
        {
            ExpenditurePO expenditurePO = expenditurePOList.get(i);
            System.out.println(expenditurePO.toString());
            model1.addElement(expenditurePO);

        }
        jl_list1 = new JList(model1);
        jl_list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list1.setCellRenderer(new ExpenditureRender());
        jl_list1.setFont(font);
        jsp_list1 = new JScrollPane(jl_list1);
        jsp_list1.setBounds(50,375,800,230);
        jsp_list1.setBackground(background_table);
        double profit = incomePOList.get(0).getSumincome() - expenditurePOList.get(0).getSumexpenditure();
        jl_sum.setText("利润：" + profit + "元");

        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(jsp_list);
        this.add(jsp_list1);
        this.add(jl_sum);
        this.add(jl_income);
        this.add(jl_expenditure);
        this.setVisible(true);

        //双击取消选中状态
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jl_list.clearSelection();
                }
            }
        };
        jl_list.addMouseListener(mouseListener);

        //双击取消选中状态
        MouseListener mouseListener1 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jl_list1.clearSelection();
                }
            }
        };
        jl_list1.addMouseListener(mouseListener1);
    }

}
