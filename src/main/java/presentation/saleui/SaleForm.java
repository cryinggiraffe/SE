package presentation.saleui;

import PO.Commodity;
import PO.GoodPO;
import businesslogic.goodbl.GoodBL;
import businesslogic.importbl.ImportBL;
import businesslogic.salebl.SaleBL;
import presentation.importui.Mytable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class SaleForm {
    public void init() {
        JFrame iframe = new JFrame("制定销售单");
        JPanel ipanel = new JPanel();
        iframe.add(ipanel);
        ipanel.setLayout(new FlowLayout());
        ipanel.setBackground(Color.orange);


        String id = "(系统自动生成）";
        JLabel lid = new JLabel("单据编号");
        JTextField tid = new JTextField(id);
        tid.setEditable(false);
        JLabel lclient = new JLabel("客户");
        JTextField tclient = new JTextField("销售商");
        tclient.setEditable(false);
        JLabel lprovider = new JLabel("业务员");
        JTextField tprovider = new JTextField();
        JLabel loperator = new JLabel("操作员");
        JTextField toperator = new JTextField();
        JLabel lhouseware = new JLabel("仓库");
        JTextField thouseware = new JTextField();


        tid.setColumns(10);
        tclient.setColumns(10);
        tprovider.setColumns(10);
        toperator.setColumns(10);
        thouseware.setColumns(10);

        ipanel.add(lid);
        ipanel.add(tid);
        ipanel.add(lclient);
        ipanel.add(tclient);
        ipanel.add(lprovider);
        ipanel.add(tprovider);
        ipanel.add(loperator);
        ipanel.add(toperator);
        ipanel.add(lhouseware);
        ipanel.add(thouseware);


        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) new Mytable().init_table(table);

        JComboBox goodNam = new JComboBox();
        ipanel.add(goodNam);
        GoodBL goodBL = new GoodBL();
        java.util.List<String> names = goodBL.listNames();
//        java.util.List<String> names = new ArrayList<>();
//        names.add("牙膏");
        for (String str : names) {
            goodNam.addItem(str);
        }
        JButton addRow = new JButton("添加出货商品");
        ipanel.add(addRow);
        JLabel hint = new JLabel("(提示：表中的数量、单价和备注可以修改。)");
        ipanel.add(hint);
        addRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (names.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有可以选择的商品！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String choose_name = goodNam.getSelectedItem().toString();
//                //
//
//                GoodPO good = new GoodPO("123", 12, "12", "12", 1, 1, 1, 1, 1);
//                //
                java.util.List<GoodPO> selected_goodList = goodBL.findGoodByName(choose_name);
                if (selected_goodList.size() == 0) {
                    JOptionPane.showMessageDialog(null, "没有该商品的历史记录！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
//
                GoodPO good = selected_goodList.get(0);
//                商品编号，名称（从商品选择界面进行选择），型号，数量（手动输入），单价（默认为商品信息中的进价），金额，备注（手动输入）。
                Vector vRow = new Vector();
                vRow.add(good.getGoodid());
                vRow.add(good.getName());
                vRow.add(good.getType());
                vRow.add(null);
                vRow.add(good.getPur_price());
                vRow.add(null);
                vRow.add(null);

                model.addRow(vRow);
            }
        });

        table.setPreferredScrollableViewportSize(new Dimension(760, 200));
        JScrollPane scrollPane = new JScrollPane(table);
        ipanel.add(scrollPane);


        JLabel lbeforeSum = new JLabel("折让前总额");
        JTextField tbeforeSum = new JTextField();
        tbeforeSum.setColumns(12);
        tbeforeSum.setEditable(false);
        JLabel ldiscount = new JLabel("折让");
        JTextField tdiscount = new JTextField();
        tdiscount.setColumns(10);
        JLabel lvoucher = new JLabel("使用代金券金额");
        JTextField tvoucher = new JTextField();
        tvoucher.setColumns(10);
        JLabel lafterSum = new JLabel("折让后总额");
        JTextField tafterSum = new JTextField();
        tafterSum.setColumns(10);
        tafterSum.setEditable(false);
        JLabel lremark = new JLabel("备注");
        JTextArea tremark = new JTextArea();
        tremark.setColumns(20);
        tremark.setRows(5);

        ipanel.add(lbeforeSum);
        ipanel.add(tbeforeSum);
        ipanel.add(ldiscount);
        ipanel.add(tdiscount);
        ipanel.add(lvoucher);
        ipanel.add(tvoucher);
        ipanel.add(lafterSum);
        ipanel.add(tafterSum);
        ipanel.add(lremark);
        ipanel.add(tremark);

        JButton submit = new JButton("提交");

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Date date = new Date();
                String client = tclient.getText();
                String provider = tprovider.getText();
                String houseware = thouseware.getText();
                String operator = toperator.getText();
                double sum = 0.0;

                java.util.List<Commodity> commidyList = new ArrayList<>();
                int row = table.getRowCount();
//                System.out.println("行数" + row);
                String cgoodid;
                String cname;
                String cversion;//型号
                int cquantity;
                double cpirce;//单价
                double csubtotalprice;
                String cremark;
                for (int i = 0; i < row; i++) {
                    cgoodid = table.getValueAt(i, 0).toString();
                    cname = table.getValueAt(i, 1).toString();
                    cversion = table.getValueAt(i, 2).toString();
                    cquantity = 0;
                    try {
                        cquantity = Integer.valueOf(table.getValueAt(i, 3).toString());
                    } catch (NumberFormatException excep) {
                        String s = "第" + (i + 1) + "行数量格式不正确！";
                        JOptionPane.showMessageDialog(null, s, "错误消息", JOptionPane.WARNING_MESSAGE);
                        return;
                    } catch (NullPointerException exception_null) {
                        String s = "第" + (i + 1) + "行数量不能为空！";
                        JOptionPane.showMessageDialog(null, s, "错误消息", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    try {
                        cpirce = Double.valueOf(table.getValueAt(i, 4).toString());
                    } catch (NumberFormatException ee) {
                        String s = "第" + (i + 1) + "行单价格式不正确！";
                        JOptionPane.showMessageDialog(null, s, "错误消息", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    csubtotalprice = cquantity * cpirce;
                    sum = sum + csubtotalprice;
                    if (table.getValueAt(i, 6) == null)
                        cremark = null;
                    else
                        cremark = table.getValueAt(i, 6).toString();

                    Commodity commodity = new Commodity(cgoodid, cname, cversion, cquantity, cpirce, csubtotalprice, cremark);
                    System.out.println(cgoodid + " " + cname + " " + cversion + " " + cquantity + " " + cpirce + " " + csubtotalprice + " " + cremark);
                }

                Double tpbfDiscounting = sum;

                Double discount = 0.0;
                try {
                    discount = Double.valueOf(tdiscount.getText().toString());
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "折让格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Double voucher = 0.0;
                try {
                    voucher = Double.valueOf(tvoucher.getText().toString());
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "代金券金额格式有误！", "错误消息", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Double tpafDiscounting = tpbfDiscounting - voucher - discount;
                if (tpafDiscounting < 0) {
                    tpafDiscounting = 0.0;
                }
                String remark = tremark.getText();
                System.out.println(tpafDiscounting);

                new SaleBL().newForm("XSD", client, operator, provider, houseware, tpbfDiscounting, tpafDiscounting, discount, voucher, remark, date, commidyList);
                iframe.setVisible(false);
            }
        });
        ipanel.add(submit);


        iframe.setBounds(550, 250, 800, 600);
        iframe.setVisible(true);
//        iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SaleForm().init();
    }
}
