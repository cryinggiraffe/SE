package presentation.approveui;

import PO.*;
import businesslogic.ReceiptBL.ReceiptBL;
import businesslogic.clientbl.ClientBL;
import businesslogic.importbl.ImportBL;
import businesslogic.paymentbl.PaymentBL;
import businesslogic.salebl.SaleBL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ApproveUI extends JPanel {
    private static JButton bt_refresh;
    private static JButton bt_approve;

    private static JList jl_accountlist;
    private static JScrollPane jsp_accountlist;

    private static int Width = 900;
    private static int Height = 700;
    private static Color background = new Color(135, 206, 250);
    private static Color background_table = new Color(52,89,134);
    
    public ApproveUI () {
        //设置界面的按钮
        Font font1 =new Font("微软雅黑", Font.PLAIN, 15);//设置按钮字体1
        bt_refresh = new JButton("刷新列表");
        bt_refresh.setBounds(600,90,120,30);
        bt_refresh.setFont(font1);

        bt_approve = new JButton("通过审批");
        bt_approve.setBounds(730,90,120,30);
        bt_approve.setFont(font1);

        //显示所有待审批单据
        DefaultListModel<RecordPO> model = new DefaultListModel<>();
        ImportBL importBL = new ImportBL();
        SaleBL saleBL = new SaleBL();
        PaymentBL paymentBL = new PaymentBL();
        ReceiptBL receiptBL = new ReceiptBL();
        List<? extends RecordPO> importPOList = importBL.findByState();
        List<? extends RecordPO> salePOList = saleBL.findByState();
        List<? extends RecordPO> paymentPOList = paymentBL.findByState();
        List<? extends RecordPO> receiptPOList = receiptBL.findByState();
        for(int i = 0; i < importPOList.size(); i++)
        {
            RecordPO importForm = importPOList.get(i);
            System.out.println(importForm.toString());
            model.addElement(importForm);
        }
        for(int i = 0; i < salePOList.size(); i++)
        {
            RecordPO saleForm = salePOList.get(i);
            System.out.println(saleForm.toString());
            model.addElement(saleForm);
        }
        for(int i = 0; i < paymentPOList.size(); i++)
        {
            RecordPO payment = paymentPOList.get(i);
            System.out.println(payment.toString());
            model.addElement(payment);
        }
        for(int i = 0; i < receiptPOList.size(); i++)
        {
            RecordPO receipt = receiptPOList.get(i);
            System.out.println(receipt.toString());
            model.addElement(receipt);
        }


        jl_accountlist = new JList(model);
        jl_accountlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jl_accountlist.setCellRenderer(new MyApproveRender());
        jl_accountlist.setFont(font1);

        jsp_accountlist = new JScrollPane(jl_accountlist);
        jsp_accountlist.setBounds(50,140,800,500);
        jsp_accountlist.setBackground(background_table);

        //向panel添加组件
        this.setBounds(0,30,Width,Height-30);
        this.setLayout(null);
        this.setBackground(background);

        this.add(bt_refresh);
        this.add(bt_approve);
        this.add(jsp_accountlist);

        this.setVisible(true);

        //刷新按钮事件
        ActionListener btRefresh_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("refresh approve");
                refresh();
            }
        };
        bt_refresh.addActionListener(btRefresh_ls);

        //审批按钮事件
        ActionListener btApprove_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("approve");
                ImportFormPO importFormPO = new ImportFormPO();
                SaleFormPO saleFormPO = new SaleFormPO();
                ReceiptPO receiptPO = new ReceiptPO();
                PaymentPO paymentPO = new PaymentPO();
                List<Object> valuesList = jl_accountlist.getSelectedValuesList();
                for (int i=0;i<valuesList.size();i++){
                    String str = valuesList.get(i).toString();
                    String[] tmp = str.split(",");
                    String id= tmp[0];
                    String[] tmp2 = id.split("-");
                    String type = tmp2[0];
                    if (type.equals("JHD")){
                        importFormPO = importBL.findById(id);
                        importFormPO.setState("yes");
                        importBL.update(importFormPO);
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(importFormPO.getClient());
                        double receive = client.getReceive() + importFormPO.getSum();
                        client.setReceive(receive);
                        clientBL.updateClient(client);
                        System.out.println("add num");
                    }else if(type.equals("JHTHD")){
                        importFormPO = importBL.findById(id);
                        importFormPO.setState("yes");
                        importBL.update(importFormPO);
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(importFormPO.getClient());
                        double receive = client.getReceive() - importFormPO.getSum();
                        client.setReceive(receive);
                        clientBL.updateClient(client);
                        System.out.println("minus num");
                    }else if(type.equals("XSD")){
                        saleFormPO = saleBL.findById(id);
                        saleFormPO.setState("yes");
                        saleBL.update(saleFormPO);
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(saleFormPO.getClient());
                        double send = client.getSend() + saleFormPO.getTpafDiscounting();
                        client.setSend(send);
                        clientBL.updateClient(client);
                        System.out.println("minus num");
                    }else if(type.equals("XSTHD")){
                        saleFormPO = saleBL.findById(id);
                        saleFormPO.setState("yes");
                        saleBL.update(saleFormPO);
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(saleFormPO.getClient());
                        double send = client.getSend() - saleFormPO.getTpafDiscounting();
                        client.setSend(send);
                        clientBL.updateClient(client);
                        System.out.println("add num");
                    }else if(type.equals("SKD")){
                        receiptPO = receiptBL.findById(id);
                        receiptPO.setState("yes");
                        receiptBL.update(receiptPO);
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(receiptPO.getClient());
                        double send = client.getSend() - receiptPO.getSum();
                        client.setSend(send);
                        clientBL.updateClient(client);
                    }else if(type.equals("FKD")){
                        paymentPO = paymentBL.findById(id);
                        paymentPO.setState("yes");
                        paymentBL.update(paymentPO);
                        System.out.println(paymentPO.toString() + "approve");
                        ClientBL clientBL = new ClientBL();
                        ClientPO client = clientBL.findClient(paymentPO.getClient());
                        double receive = client.getReceive() + paymentPO.getSum();
                        client.setReceive(receive);
                        clientBL.updateClient(client);
                    }
                    refresh();
                    System.out.println("第" + i +"个单子审批通过");
                }
            }
        };
        bt_approve.addActionListener(btApprove_ls);
    }

    public void refresh() {
        DefaultListModel<RecordPO> model = new DefaultListModel<>();
        ImportBL importBL = new ImportBL();
        SaleBL saleBL = new SaleBL();
        PaymentBL paymentBL = new PaymentBL();
        ReceiptBL receiptBL = new ReceiptBL();
        List<? extends RecordPO> importPOList = importBL.findByState();
        List<? extends RecordPO> salePOList = saleBL.findByState();
        List<? extends RecordPO> paymentPOList = paymentBL.findByState();
        List<? extends RecordPO> receiptPOList = receiptBL.findByState();
        for(int i = 0; i < importPOList.size(); i++)
        {
            RecordPO importForm = importPOList.get(i);
            model.addElement(importForm);
        }
        for(int i = 0; i < salePOList.size(); i++)
        {
            RecordPO saleForm = salePOList.get(i);
            model.addElement(saleForm);
        }
        for(int i = 0; i < paymentPOList.size(); i++)
        {
            RecordPO payment = paymentPOList.get(i);
            model.addElement(payment);
        }
        for(int i = 0; i < receiptPOList.size(); i++)
        {
            RecordPO receipt = receiptPOList.get(i);
            model.addElement(receipt);
        }
        jl_accountlist.setModel(model);
    }


}
