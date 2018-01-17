package businesslogic.translationSituationbl;

import DataService.DataServiceImpl.*;
import DataService.ImportDataService;
import PO.*;
import blService.SaleFormService;
import blService.TranslationSituationBLService;
import businesslogic.businessProcessbl.BusinessProcessbl;
import businesslogic.saleSituationbl.SaleSituationBL;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class TranslationSituationBL implements TranslationSituationBLService {

    private ExpenditureDataServiceImpl eds=new ExpenditureDataServiceImpl();
    private IncomeDataServiceImpl ids = new IncomeDataServiceImpl();
    private SaleDataServiceImpl saleDataService = new SaleDataServiceImpl();
    private SaleReturnDataServiceImpl saleReturnDataService = new SaleReturnDataServiceImpl();
    private OverflowDataServiceImpl overflowDataService = new OverflowDataServiceImpl();
    private LossDataServiceImpl lossDataService = new LossDataServiceImpl();
    private GiftDataServiceImpl giftDataService = new GiftDataServiceImpl();
    private GoodDataServiceImpl goodDataService = new GoodDataServiceImpl();
    private BusinessProcessbl businessProcessbl = new BusinessProcessbl();
    public void newExpenditure(){
        double salecost = 0;
        double commoditylostexpenditure = 0;
        double giftexpenditure = 0;
        double sumexpenditure = 0;
        java.sql.Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);//得到前1个月
        java.util.Date  formNow1Month = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.format(formNow1Month);
        java.sql.Date  beginDate = new java.sql.Date(formNow1Month.getTime());
        //计算销售成本
        List<SaleFormPO> saleFormPOS = businessProcessbl.findSaleFormForTime(beginDate,date);
        for (int i=0;i<saleFormPOS.size();i++) {
            SaleFormPO saleFormPO = saleFormPOS.get(i);
            List<Commodity> commodities = saleFormPO.getCommodityList();
            for (int j=0;j<commodities.size();j++) {
                Commodity commodity = commodities.get(j);
                GoodPO goodPO = goodDataService.find(commodity.getGoodid());
                salecost += goodPO.getRece_ret_price();
            }
        }
        List<SaleFormPO> saleReturnFormPOS = businessProcessbl.findSaleReturnFormForTime(beginDate,date);
        for (int i=0;i<saleReturnFormPOS.size();i++) {
            SaleFormPO saleReturnFormPO = saleReturnFormPOS.get(i);
            List<Commodity> commodities = saleReturnFormPO.getCommodityList();
            for (int j=0;j<commodities.size();j++) {
                Commodity commodity = commodities.get(j);
                GoodPO goodPO = goodDataService.find(commodity.getGoodid());
                salecost -= goodPO.getRece_ret_price();
            }
        }

        //计算商品报损
        List<LossPO> lossPOS = lossDataService.findForTime(beginDate,date);
        for (int i=0;i<lossPOS.size();i++) {
            LossPO lossPO = lossPOS.get(i);
            GoodPO goodPO = goodDataService.find(lossPO.getGoodid());
            int num = lossPO.getNum();
            commoditylostexpenditure += goodPO.getRece_ret_price() * num;
        }

        //计算商品赠出
        List<GiftPO> giftPOS = giftDataService.findForTime(beginDate,date);
        for (int i=0;i<giftPOS.size();i++) {
            GiftPO giftPO = giftPOS.get(i);
            GoodPO goodPO = goodDataService.find(giftPO.getGoodid());
            int num = giftPO.getNum();
            giftexpenditure = goodPO.getRece_ret_price() * num;
        }

        sumexpenditure = salecost + commoditylostexpenditure + giftexpenditure;

        ExpenditurePO po=new ExpenditurePO(salecost,commoditylostexpenditure,giftexpenditure,sumexpenditure,date);
        eds.insert(po);
    }

    public void newIncome(){
        double saleincome = 0; //销售收入
        double overflowincome = 0; //报溢收入
        double costincome = 0; //成本调价收入
        double importreturnincome = 0; //进货退货差价
        double vouchersincome = 0; //代金券与实际收款差额收入
        double sumincome = 0;  //折让后总收入
        double discount = 0;  //折让
        java.sql.Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);//得到前1个月
        java.util.Date  formNow1Month = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.format(formNow1Month);
        java.sql.Date  beginDate = new java.sql.Date(formNow1Month.getTime());

        //计算销售收入
        double afDiscount = 0;
        double bfDiscount = 0;
        double difVandR = 0;
        List<SaleFormPO> saleFormPOS = saleDataService.findForTime(beginDate,date);
        for (int i=0;i<saleFormPOS.size();i++) {
            SaleFormPO saleFormPO = saleFormPOS.get(i);
            afDiscount += saleFormPO.getTpafDiscounting();
            bfDiscount += saleFormPO.getTpafDiscounting();
            difVandR = saleFormPO.getVoucher() - saleFormPO.getTpafDiscounting();
            vouchersincome += difVandR;
        }
        List<SaleFormPO> saleFormPOS1 = saleReturnDataService.findForTime(beginDate,date);
        for (int i=0;i<saleFormPOS1.size();i++){
            SaleFormPO saleFormPO = saleFormPOS1.get(i);
            afDiscount -= saleFormPO.getTpafDiscounting();
            bfDiscount -= saleFormPO.getTpafDiscounting();
        }
        saleincome = afDiscount;
        discount = bfDiscount - afDiscount;

        //计算商品报溢
        List<OverflowPO> overflowPOS = overflowDataService.findForTime(beginDate,date);
        for (int i=0;i<overflowPOS.size();i++) {
            OverflowPO lossPO = overflowPOS.get(i);
            GoodPO goodPO = goodDataService.find(lossPO.getGoodid());
            int num = lossPO.getNum();
            overflowincome += goodPO.getRece_ret_price() * num;
        }

        //计算成本调价
        double dif = 0;
        List<GoodPO> goodPOS = goodDataService.list();
        for (int i=0;i<goodPOS.size();i++) {
            GoodPO goodPO = goodPOS.get(i);
            dif = goodPO.getRet_price() - goodPO.getRece_ret_price();
            costincome += dif;
        }

        //计算进货退货差价
        List<ImportFormPO> importFormPOS = businessProcessbl.findImportFormForTime(beginDate,date);
        for (int i=0;i<importFormPOS.size();i++){
            ImportFormPO importFormPO = importFormPOS.get(i);
            List<Commodity> commodities = importFormPO.getImportcommoditylist();
            for (int j=0;j<commodities.size();j++) {
                Commodity commodity = commodities.get(j);
                importreturnincome += commodity.getSubtotalprice();
            }
        }

        List<ImportFormPO> importReturnFormPOS = businessProcessbl.findImportReturnFormForTime(beginDate,date);
        for (int i=0;i<importReturnFormPOS.size();i++){
            ImportFormPO importReturnFormPO = importReturnFormPOS.get(i);
            List<Commodity> commodities = importReturnFormPO.getImportcommoditylist();
            for (int j=0;j<commodities.size();j++) {
                Commodity commodity = commodities.get(j);
                importreturnincome -= commodity.getSubtotalprice();
            }
        }
        sumincome = saleincome + overflowincome + costincome + importreturnincome +vouchersincome;

        IncomePO po = new IncomePO(saleincome,  overflowincome,  costincome,  importreturnincome,
                            vouchersincome,  sumincome,  discount,  date);
        ids.insert(po);
    }




    public List<ExpenditurePO> findForTime(java.util.Date begin, java.util.Date end){
        java.sql.Date begint=new java.sql.Date(begin.getTime());
        java.sql.Date endt=new java.sql.Date(end.getTime());
        return eds.findForTime(begint,endt);
    }

    public List<ProfitPO> getProfit() {
        List<IncomePO> incomePOS = ids.findAll();
        List<ExpenditurePO> expenditurePOS = eds.findAll();
        List<ProfitPO> profits = new ArrayList<ProfitPO>();
        double profit;
        for (int i=0;i<incomePOS.size();i++){
            profit = incomePOS.get(i).getSumincome() - expenditurePOS.get(i).getSumexpenditure();
            ProfitPO po = new ProfitPO(incomePOS.get(i).getDate(),profit);
            profits.add(po);
        }
        return profits;

    }
    public List<ExpenditurePO> findAllExpenditure(){
        return eds.findAll();
    }
    public List<IncomePO> findAllIncome(){
        return ids.findAll();
    }
}
