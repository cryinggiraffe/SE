package presentation.businessProcessui;

import PO.*;
import businesslogic.ReceiptBL.ReceiptBL;
import businesslogic.businessProcessbl.BusinessProcessbl;
import businesslogic.cashbl.CashBL;
import businesslogic.clientbl.ClientBL;
import businesslogic.goodbl.GoodBL;
import businesslogic.importbl.ImportBL;
import businesslogic.paymentbl.PaymentBL;
import businesslogic.salebl.SaleBL;
import presentation.importui.Import;
import presentation.saleSituationui.MySaleRender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class BusiProcessUI extends JPanel {
    private static JTextField jt_begintime;
    private static JTextField jt_endtime;
    private static JComboBox jc_type;
    private static JComboBox jc_client;
    private static JComboBox jc_salesman;
    private static JComboBox jc_houseware;

    private static JButton bt_search;
    private static JButton bt_red;
    private static JButton bt_redCopy;
    private static JLabel jl_1;
    private static JLabel jl_type;
    private static JLabel jl_client;
    private static JLabel jl_salesman;
    private static JLabel jl_houseware;


    private static JList jl_accountlist;
    private static JScrollPane jsp_list;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);

    public BusiProcessUI (String user) {
        Font font =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        bt_search = new JButton("查询");
        bt_search.setBounds(730,170,120,30);
        bt_search.setFont(font);

        bt_red = new JButton("红冲");
        bt_red.setBounds(470,170,120,30);
        bt_red.setFont(font);

        bt_redCopy = new JButton("红冲复制");
        bt_redCopy.setBounds(600,170,120,30);
        bt_redCopy.setFont(font);

        jl_1 = new JLabel("筛选条件: 单据类型：");
        jl_1.setBounds(50,90,180,30);
        jl_1.setFont(font);

        jt_begintime = new JTextField("");
        jt_begintime.setBounds(480,90,180,30);
        jt_begintime.setFont(font);

        jt_endtime = new JTextField("");
        jt_endtime.setBounds(670,90,180,30);
        jt_endtime.setFont(font);

        jl_type = new JLabel("时间区间：");
        jl_type.setBounds(400,90,80,30);
        jl_type.setFont(font);

        jc_type = new JComboBox();
        jc_type.setBounds(180,90,210,30);
        jc_type.setFont(font);
        jc_type.addItem("销售类");
        jc_type.addItem("进货类");
        jc_type.addItem("财务类");
        jc_type.addItem("库存类");

        jl_client = new JLabel("客户ID：");
        jl_client.setBounds(50,130,60,30);
        jl_client.setFont(font);

        jc_client = new JComboBox();
        jc_client.setBounds(110,130,210,30);
        jc_client.setFont(font);
        jc_client.addItem("");

        jl_salesman= new JLabel("业务员ID：");
        jl_salesman.setBounds(560,130,80,30);
        jl_salesman.setFont(font);

        jc_salesman = new JComboBox();
        jc_salesman.setBounds(640,130,210,30);
        jc_salesman.setFont(font);
        jc_salesman.addItem("");
        jc_salesman.addItem("02002");
        jc_salesman.addItem("02003");
        jc_salesman.addItem("02004");

        jl_houseware = new JLabel("仓库ID：");
        jl_houseware.setBounds(50,170,60,30);
        jl_houseware.setFont(font);

        jc_houseware = new JComboBox();
        jc_houseware.setBounds(110,170,210,30);
        jc_houseware.setFont(font);
        jc_houseware.addItem("");
        jc_houseware.addItem("1");
        jc_houseware.addItem("2");
        jc_houseware.addItem("3");

        //向下拉框添加数据
        ClientBL clientBL = new ClientBL();
        List<String> idList = clientBL.listIds();
        for (int i=0;i<idList.size();i++){
            jc_client.addItem(idList.get(i));
        }


        DefaultListModel<RecordPO> model1 = new DefaultListModel<>();
        DefaultListModel<RecordPO> model2 = new DefaultListModel<>();
        DefaultListModel<RecordPO> model3 = new DefaultListModel<>();
        DefaultListModel<CashPO> model4 = new DefaultListModel<>();
        //DefaultListModel<RecordPO> model2 = new DefaultListModel<>();  //此处为库存类单据

        jl_accountlist = new JList();
        jl_accountlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_accountlist.setCellRenderer(new MySaleRender());
        jl_accountlist.setFont(font);

        jsp_list = new JScrollPane(jl_accountlist);
        jsp_list.setBounds(50,210,800,430);
        jsp_list.setBackground(background_table);

        //根据用户判断是否显示红冲按钮
        if(user.equals("manager")){

            bt_red.setVisible(false);
            bt_redCopy.setVisible(false);
        }else if (user.equals("finance")){
            bt_red.setVisible(true);
            bt_redCopy.setVisible(true);
        }
        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);
        this.setVisible(true);

        this.add(jt_begintime);
        this.add(jt_endtime);
        this.add(jc_type);
        this.add(jc_client);
        this.add(jc_salesman);
        this.add(jc_houseware);
        this.add(jl_1);
        this.add(jl_type);
        this.add(jl_client);
        this.add(jl_salesman);
        this.add(jl_houseware);
        this.add(bt_search);
        this.add(bt_red);
        this.add(bt_redCopy);
        this.add(jsp_list);



        //根据类型显示相应的搜索条件
        jc_type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    //这里写你的任务 ，比如取到现在的值
                    String type = jc_type.getSelectedItem().toString();
                    System.out.println(type);
                    if (type.equals("销售类")) {
                        jl_client.setVisible(true);
                        jc_client.setVisible(true);
                        jl_salesman.setVisible(true);
                        jc_salesman.setVisible(true);
                        jl_houseware.setVisible(true);
                        jc_houseware.setVisible(true);
                    }else if (type.equals("进货类")) {
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                    }else if (type.equals("财务类")) {
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                        jl_houseware.setVisible(false);
                        jc_houseware.setVisible(false);
                    }else if (type.equals("库存类")) {
                        jl_client.setVisible(false);
                        jc_client.setVisible(false);
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                        jl_houseware.setVisible(false);
                        jc_houseware.setVisible(false);
                    }
                }
            }
        });

        //搜索按钮事件
        ActionListener btSearch_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("search sale");
                String begin = jt_begintime.getText().toString();
                String end = jt_endtime.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                java.util.Date beginTime = null;
                java.util.Date endTime = null;
                String type = jc_type.getSelectedItem().toString();
                String client = jc_client.getSelectedItem().toString();
                String salesman = jc_salesman.getSelectedItem().toString();
                String houseware = jc_houseware.getSelectedItem().toString();
                System.out.println(type);
                BusinessProcessbl businessProcessbl = new BusinessProcessbl();
                if (type.equals("销售类")) {
                    if (!begin.equals("") && !end.equals("")){
                        try{
                            beginTime = format.parse(begin);
                            endTime = format.parse(end);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        java.sql.Date beginDate = new java.sql.Date(beginTime.getTime());
                        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
                        List<SaleFormPO> SaleFormPOList = businessProcessbl.findSaleFormForTime(beginDate,endDate);
                        SaleFormPOList.addAll(businessProcessbl.findSaleReturnFormForTime(beginDate,endDate));
                        refreshSale(SaleFormPOList);
                    }else if (!client.equals("")){
                        List<SaleFormPO> SaleFormPOList = businessProcessbl.findSaleFormForClient(client);
                        SaleFormPOList.addAll(businessProcessbl.findSaleReturnFormForClient(client));
                        refreshSale(SaleFormPOList);
                    }else if (!salesman.equals("")){
                        List<SaleFormPO> SaleFormPOList = businessProcessbl.findSaleFormForSalesman(salesman);
                        SaleFormPOList.addAll(businessProcessbl.findSaleReturnFormForSalesman(salesman));
                        refreshSale(SaleFormPOList);
                    }else if (!houseware.equals("")){
                        List<SaleFormPO> SaleFormPOList = businessProcessbl.findSaleFormForHouseWare(houseware);
                        SaleFormPOList.addAll(businessProcessbl.findSaleReturnFormForHouseWare(houseware));
                        refreshSale(SaleFormPOList);
                    }else {
                        JOptionPane.showMessageDialog(null, "未输入查询条件", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }
                }else if (type.equals("进货类")) {
                    if (!begin.equals("") && !end.equals("")){
                        try{
                            beginTime = format.parse(begin);
                            endTime = format.parse(end);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        java.sql.Date beginDate = new java.sql.Date(beginTime.getTime());
                        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
                        List<ImportFormPO> ImportFormPOList = businessProcessbl.findImportFormForTime(beginDate,endDate);
                        ImportFormPOList.addAll(businessProcessbl.findImportReturnFormForTime(beginDate,endDate));
                        refreshImport(ImportFormPOList);
                    }else if (!client.equals("")){
                        List<ImportFormPO> ImportFormPOList = businessProcessbl.findImportFormForClient(client);
                        ImportFormPOList.addAll(businessProcessbl.findImportReturnFormForClient(client));
                        refreshImport(ImportFormPOList);
                    }else if (!houseware.equals("")){
                        List<ImportFormPO> ImportFormPOList = businessProcessbl.findImportFormForHouseWare(houseware);
                        ImportFormPOList.addAll(businessProcessbl.findImportReturnFormForHouseWare(houseware));
                        refreshImport(ImportFormPOList);
                    }else {
                        JOptionPane.showMessageDialog(null, "未输入查询条件", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }

                }else if (type.equals("财务类")) {
                    if (!begin.equals("") && !end.equals("")){
                        try{
                            beginTime = format.parse(begin);
                            endTime = format.parse(end);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        java.sql.Date beginDate = new java.sql.Date(beginTime.getTime());
                        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
                        List<PaymentPO> paymentPOList = businessProcessbl.findPaymentForTime(beginDate,endDate);
                        List<ReceiptPO> receiptPOList = businessProcessbl.findReceiptForTime(beginDate,endDate);
                        List<CashPO> cashPOList = businessProcessbl.findCashForTime(beginDate,endDate);
                        refreshFinance1(paymentPOList,receiptPOList,cashPOList);
                    }else if (!client.equals("")){
                        List<PaymentPO> paymentPOList = businessProcessbl.findPaymentForClient(client);
                        List<ReceiptPO> receiptPOList = businessProcessbl.findReceiptForClient(client);
                        refreshFinance2(paymentPOList,receiptPOList);
                    }else {
                        JOptionPane.showMessageDialog(null, "未输入查询条件", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }

                }else if (type.equals("库存类")) {
                    if (!begin.equals("") && !end.equals("")){
                        try{
                            beginTime = format.parse(begin);
                            endTime = format.parse(end);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        java.sql.Date beginDate = new java.sql.Date(beginTime.getTime());
                        java.sql.Date endDate = new java.sql.Date(endTime.getTime());
                        List<PaymentPO> paymentPOList = businessProcessbl.findPaymentForTime(beginDate,endDate);
                        List<ReceiptPO> receiptPOList = businessProcessbl.findReceiptForTime(beginDate,endDate);
                        List<CashPO> cashPOList = businessProcessbl.findCashForTime(beginDate,endDate);
                        //refreshStock(paymentPOList,receiptPOList,cashPOList);
                    } {
                        JOptionPane.showMessageDialog(null, "未输入查询条件", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }
                }
                

            }
        };
        bt_search.addActionListener(btSearch_ls);

    }

    public void refreshSale(List<SaleFormPO> SaleFormPOList) {
        DefaultListModel<SaleFormPO> model = new DefaultListModel<>();
//        if (SaleFormPOList.size() == 0){
//            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
//        }
//        for(int i = 0; i < SaleFormPOList.size(); i++)
//        {
//            SaleFormPO user = SaleFormPOList.get(i);
//            model.addElement(user);
//
//        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_accountlist.setModel(model);
    }
    public void refreshImport(List<ImportFormPO> ImportFormPOList) {
        DefaultListModel<SaleFormPO> model = new DefaultListModel<>();
//        if (ImportFormPOList.size() == 0){
//            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
//        }
//        for(int i = 0; i < ImportFormPOList.size(); i++)
//        {
//            SaleFormPO user = ImportFormPOList.get(i);
//            model.addElement(user);
//
//        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_accountlist.setModel(model);
    }

    public void refreshFinance1(List<PaymentPO> paymentPOList, List<ReceiptPO> receiptPOList, List<CashPO> cashPOList) {
        DefaultListModel<SaleFormPO> model = new DefaultListModel<>();
//        if (ImportFormPOList.size() == 0){
//            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
//        }
//        for(int i = 0; i < ImportFormPOList.size(); i++)
//        {
//            SaleFormPO user = ImportFormPOList.get(i);
//            model.addElement(user);
//
//        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_accountlist.setModel(model);
    }

    public void refreshFinance2(List<PaymentPO> paymentPOList, List<ReceiptPO> receiptPOList) {
        DefaultListModel<SaleFormPO> model = new DefaultListModel<>();
//        if (ImportFormPOList.size() == 0){
//            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
//        }
//        for(int i = 0; i < ImportFormPOList.size(); i++)
//        {
//            SaleFormPO user = ImportFormPOList.get(i);
//            model.addElement(user);
//
//        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_accountlist.setModel(model);
    }
}
