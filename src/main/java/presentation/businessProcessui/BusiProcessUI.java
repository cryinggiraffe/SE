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
import java.awt.event.*;
import java.sql.Date;
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


    private static JList jl_list;
    private static JList jl_list1;
    private static JList jl_list2;
    private static JList jl_list3;
    private static JScrollPane jsp_list;
    private static JScrollPane jsp_list1;
    private static JScrollPane jsp_list2;
    private static JScrollPane jsp_list3;


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

        bt_red.setVisible(false);
        bt_redCopy.setVisible(false);

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

        jl_list = new JList();
        jl_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list.setFont(font);
        jl_list1 = new JList();
        jl_list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list1.setFont(font);
        jl_list2 = new JList();
        jl_list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list2.setFont(font);
        jl_list3 = new JList();
        jl_list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jl_list3.setFont(font);

        jsp_list = new JScrollPane(jl_list);
        jsp_list.setBounds(50,210,800,430);
        jsp_list.setBackground(background_table);

        jsp_list1 = new JScrollPane(jl_list1);
        jsp_list1.setBounds(50,210,800,140);
        jsp_list1.setBackground(background_table);
        jsp_list1.setVisible(false);

        jsp_list2 = new JScrollPane(jl_list2);
        jsp_list2.setBounds(50,355,800,140);
        jsp_list2.setBackground(background_table);
        jsp_list2.setVisible(false);

        jsp_list3 = new JScrollPane(jl_list3);
        jsp_list3.setBounds(50,500,800,140);
        jsp_list3.setBackground(background_table);
        jsp_list3.setVisible(false);


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
        this.add(jsp_list);
        this.add(jsp_list1);
        this.add(jsp_list2);
        this.add(jsp_list3);

        //根据用户判断是否显示红冲按钮
        if (user.equals("finance")){
            this.add(bt_red);
            this.add(bt_redCopy);
        }
        //双击取消选中状态
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jl_list.locationToIndex(e.getPoint());
                    //System.out.println("Double clicked on Item " + index);
                    jl_list.clearSelection();
                }
            }
        };
        jl_list.addMouseListener(mouseListener);
        MouseListener mouseListener1 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jl_list1.locationToIndex(e.getPoint());
                    //System.out.println("Double clicked on Item " + index);
                    jl_list1.clearSelection();
                }
            }
        };
        jl_list1.addMouseListener(mouseListener1);
        MouseListener mouseListener2 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jl_list2.locationToIndex(e.getPoint());
                    //System.out.println("Double clicked on Item " + index);
                    jl_list2.clearSelection();
                }
            }
        };
        jl_list2.addMouseListener(mouseListener2);
        MouseListener mouseListener3 = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jl_list3.locationToIndex(e.getPoint());
                    //System.out.println("Double clicked on Item " + index);
                    jl_list3.clearSelection();
                }
            }
        };
        jl_list3.addMouseListener(mouseListener3);
        //根据类型显示相应的搜索条件
        jc_type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String type = jc_type.getSelectedItem().toString();
                    System.out.println(type);
                    if (type.equals("销售类")) {
                        jl_client.setVisible(true);
                        jc_client.setVisible(true);
                        jl_salesman.setVisible(true);
                        jc_salesman.setVisible(true);
                        jl_houseware.setVisible(true);
                        jc_houseware.setVisible(true);
                        bt_red.setVisible(false);
                        bt_redCopy.setVisible(false);
                    }else if (type.equals("进货类")) {
                        jl_houseware.setVisible(true);
                        jc_houseware.setVisible(true);
                        jl_client.setVisible(true);
                        jc_client.setVisible(true);
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                        bt_red.setVisible(false);
                        bt_redCopy.setVisible(false);
                    }else if (type.equals("财务类")) {
                        jl_client.setVisible(true);
                        jc_client.setVisible(true);
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                        jl_houseware.setVisible(false);
                        jc_houseware.setVisible(false);
                        bt_red.setVisible(true);
                        bt_redCopy.setVisible(true);
                    }else if (type.equals("库存类")) {
                        jl_client.setVisible(false);
                        jc_client.setVisible(false);
                        jl_salesman.setVisible(false);
                        jc_salesman.setVisible(false);
                        jl_houseware.setVisible(false);
                        jc_houseware.setVisible(false);
                        bt_red.setVisible(false);
                        bt_redCopy.setVisible(false);
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
                        List<? extends StockPO> stockPOList1 = businessProcessbl.findGiftForTime(beginDate,endDate);
                        List<? extends StockPO> stockPOList2 = businessProcessbl.findLossForTime(beginDate,endDate);
                        List<? extends StockPO> stockPOList3 = businessProcessbl.findOverflowForTime(beginDate,endDate);
                        refreshStock(stockPOList1,stockPOList2,stockPOList3);
                    } else {
                        JOptionPane.showMessageDialog(null, "未输入查询条件", "错误信息",JOptionPane.ERROR_MESSAGE);
                    }
                }
                

            }
        };
        bt_search.addActionListener(btSearch_ls);

        //红冲按钮事件
        ActionListener btRed_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Object value1 = jl_list1.getSelectedValue();
                Object value2 = jl_list2.getSelectedValue();
                Object value3 = jl_list3.getSelectedValue();
                String str = "";
                String type = "";
                boolean hasSelected = false;
                if (value1 != null) {
                    str = value1.toString();
                    type = "payment";
                    hasSelected = true;
                }else if (value2 != null) {
                    str = value2.toString();
                    type = "receipt";
                    hasSelected = true;
                }else if (value3 != null) {
                    str = value3.toString();
                    type = "cash";
                    hasSelected = true;
                }
                String[] tmp = str.split(",");
                if (hasSelected){
                    Object[] options = {" 确定 "," 取消 "};
                    int response=JOptionPane.showOptionDialog(null, "确认对此单据进行红冲操作？", "提示信息",JOptionPane.YES_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if(response==0) {
                        if (type.equals("payment")){
                            PaymentBL paymentBL = new PaymentBL();
                            String id = paymentBL.newId();
                            String client = tmp[1];
                            String operator = tmp[2];
                            String account = tmp[3];
                            String amount = tmp[4];
                            String remark = "红冲单据";
                            Date date = new Date(System.currentTimeMillis());
                            double amountNum = -Double.parseDouble(amount);
                            paymentBL.newPayment(id,client,operator,account,amountNum,remark,amountNum,date);
                        }else if (type.equals("receipt")){
                            ReceiptBL receiptBL = new ReceiptBL();
                            String id = receiptBL.newId();
                            String client = tmp[1];
                            String operator = tmp[2];
                            String account = tmp[3];
                            String amount = tmp[4];
                            String remark = "红冲单据";
                            Date date = new Date(System.currentTimeMillis());
                            double amountNum = -Double.parseDouble(amount);
                            receiptBL.newReceipt(id,client,operator,account,amountNum,remark,amountNum,date);
                        }else if (type.equals("cash")){
                            CashBL cashBL = new CashBL();
                            String id = cashBL.newId();
                            String operator = tmp[1];
                            String account = tmp[2];
                            String name = tmp[3];
                            String amount = tmp[4];
                            String remark = "红冲单据";
                            Date date = new Date(System.currentTimeMillis());
                            double amountNum = -Double.parseDouble(amount);
                            cashBL.newCash(id,operator,account,name,amountNum,remark,amountNum,date);
                        }

                    } else if(response==1) {
                        System.out.println(" 您按下了取消按钮  ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请选择一张单据再进行操作！", "错误信息",JOptionPane.ERROR_MESSAGE);
                }

            }
        };
        bt_red.addActionListener(btRed_ls);

        //红冲按钮事件
        ActionListener btRedCopy_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Object value1 = jl_list1.getSelectedValue();
                Object value2 = jl_list2.getSelectedValue();
                Object value3 = jl_list3.getSelectedValue();
                String str = "";
                String type = "";
                boolean hasSelected = false;
                if (value1 != null) {
                    str = value1.toString();
                    type = "payment";
                    hasSelected = true;
                }else if (value2 != null) {
                    str = value2.toString();
                    type = "receipt";
                    hasSelected = true;
                }else if (value3 != null) {
                    str = value3.toString();
                    type = "cash";
                    hasSelected = true;
                }
                String[] tmp = str.split(",");
                if (hasSelected){
                    Object[] options = {" 确定 "," 取消 "};
                    int response=JOptionPane.showOptionDialog(null, "确认对此单据进行红冲复制操作？", "提示信息",JOptionPane.YES_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    if(response==0) {
                        if (type.equals("payment")){
                            String client = tmp[1];
                            String operator = tmp[2];
                            String account = tmp[3];
                            String amount = tmp[4];
                            RedPaymentUI redPaymentUI = new RedPaymentUI(operator,client,account,amount);
                        }else if (type.equals("receipt")){
                            String client = tmp[1];
                            String operator = tmp[2];
                            String account = tmp[3];
                            String amount = tmp[4];
                            RedReceiptUI redReceiptUI = new RedReceiptUI(operator,client,account,amount);
                        }else if (type.equals("cash")){
                            String operator = tmp[1];
                            String account = tmp[2];
                            String name = tmp[3];
                            String amount = tmp[4];
                            RedCashUI redCashUI = new RedCashUI(operator,account,name,amount);
                        }

                    } else if(response==1) {
                        System.out.println(" 您按下了取消按钮  ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "请选择一张单据再进行操作！", "错误信息",JOptionPane.ERROR_MESSAGE);
                }

            }
        };
        bt_redCopy.addActionListener(btRedCopy_ls);

    }

    public void refreshSale(List<SaleFormPO> SaleFormPOList) {
        DefaultListModel<SaleFormPO> model = new DefaultListModel<>();
        if (SaleFormPOList.size() == 0){
            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
        }
        for(int i = 0; i < SaleFormPOList.size(); i++) {
            SaleFormPO sale = SaleFormPOList.get(i);
            model.addElement(sale);

        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_list.setModel(model);
        jl_list.setCellRenderer(new SaleRender());
        jsp_list.setVisible(true);
        jsp_list1.setVisible(false);
        jsp_list2.setVisible(false);
        jsp_list3.setVisible(false);
    }
    public void refreshImport(List<ImportFormPO> ImportFormPOList) {
        DefaultListModel<ImportFormPO> model = new DefaultListModel<>();
        if (ImportFormPOList.size() == 0){
            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
        }
        for(int i = 0; i < ImportFormPOList.size(); i++) {
            ImportFormPO importForm = ImportFormPOList.get(i);
            model.addElement(importForm);

        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_list.setModel(model);
        jl_list.setCellRenderer(new ImportRender());
        jsp_list.setVisible(true);
        jsp_list1.setVisible(false);
        jsp_list2.setVisible(false);
        jsp_list3.setVisible(false);
    }

    public void refreshFinance1(List<PaymentPO> paymentPOList, List<ReceiptPO> receiptPOList, List<CashPO> cashPOList) {
        DefaultListModel<PaymentPO> model1 = new DefaultListModel<>();
        DefaultListModel<ReceiptPO> model2 = new DefaultListModel<>();
        DefaultListModel<CashPO> model3 = new DefaultListModel<>();
        if (paymentPOList.size() == 0 && receiptPOList.size() == 0 && cashPOList.size() == 0){
            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
        }
        for(int i = 0; i < paymentPOList.size(); i++) {
            PaymentPO paymentPO = paymentPOList.get(i);
            if (paymentPO.getState().equals("yes")){
                model1.addElement(paymentPO);
            }

        }
        for(int i = 0; i < receiptPOList.size(); i++) {
            ReceiptPO receiptPO = receiptPOList.get(i);
            if (receiptPO.getState().equals("yes")) {
                model2.addElement(receiptPO);
            }
        }
        for(int i = 0; i < cashPOList.size(); i++) {
            CashPO cashPO = cashPOList.get(i);
            model3.addElement(cashPO);

        }
        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_list1.setModel(model1);
        jl_list1.setCellRenderer(new PaymentRender());
        jl_list2.setModel(model2);
        jl_list2.setCellRenderer(new ReceiptRender());
        jl_list3.setModel(model3);
        jl_list3.setCellRenderer(new CashRender());
        jsp_list.setVisible(false);
        jsp_list1.setVisible(true);
        jsp_list2.setVisible(true);
        jsp_list3.setVisible(true);
    }

    public void refreshFinance2(List<PaymentPO> paymentPOList, List<ReceiptPO> receiptPOList) {
        DefaultListModel<PaymentPO> model1 = new DefaultListModel<>();
        DefaultListModel<ReceiptPO> model2 = new DefaultListModel<>();
        DefaultListModel<CashPO> model3 = new DefaultListModel<>();
        if (paymentPOList.size() == 0 && receiptPOList.size() == 0){
            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
        }
        for(int i = 0; i < paymentPOList.size(); i++) {
            PaymentPO paymentPO = paymentPOList.get(i);
            if (paymentPO.getState().equals("yes")){
                model1.addElement(paymentPO);
            }

        }
        for(int i = 0; i < receiptPOList.size(); i++) {
            ReceiptPO receiptPO = receiptPOList.get(i);
            if (receiptPO.getState().equals("yes")) {
                model2.addElement(receiptPO);
            }

        }

        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_list1.setModel(model1);
        jl_list1.setCellRenderer(new PaymentRender());
        jl_list2.setModel(model2);
        jl_list2.setCellRenderer(new ReceiptRender());
        jsp_list.setVisible(false);
        jsp_list1.setVisible(true);
        jsp_list2.setVisible(true);
        jsp_list3.setVisible(false);
    }

    public void refreshStock(List<? extends StockPO> stockPOList1, List<? extends StockPO> stockPOList2, List<? extends StockPO> stockPOList3) {
        DefaultListModel<StockPO> model = new DefaultListModel<>();
        if (stockPOList1.size() == 0 && stockPOList2.size() == 0 && stockPOList3.size() == 0){
            JOptionPane.showMessageDialog(null, "无查询结果", "提示信息", JOptionPane.INFORMATION_MESSAGE);
        }
        for(int i = 0; i < stockPOList1.size(); i++) {
            StockPO stock = stockPOList1.get(i);
            model.addElement(stock);

        }
        for(int i = 0; i < stockPOList2.size(); i++) {
            StockPO stock = stockPOList2.get(i);
            model.addElement(stock);

        }
        for(int i = 0; i < stockPOList3.size(); i++) {
            StockPO stock = stockPOList3.get(i);
            model.addElement(stock);

        }

        jt_begintime.setText("");
        jt_endtime.setText("");
        jl_list.setModel(model);
        jl_list.setCellRenderer(new StockRender());
        jsp_list.setVisible(true);
        jsp_list1.setVisible(false);
        jsp_list2.setVisible(false);
        jsp_list3.setVisible(false);
    }
}
