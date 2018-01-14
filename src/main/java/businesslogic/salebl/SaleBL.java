package businesslogic.salebl;
import DataService.DataServiceImpl.*;
import PO.Commodity;
import PO.SaleFormPO;
import blService.SaleFormService;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SaleBL implements SaleFormService {
    private SaleCommodityDataServiceImpl scds=new SaleCommodityDataServiceImpl();
    private SaleReturnCommodityDataServiceImpl srcds=new SaleReturnCommodityDataServiceImpl();

    private SaleDataServiceImpl ids=new SaleDataServiceImpl();
    private SaleReturnDataServiceImpl irds=new SaleReturnDataServiceImpl();
    @Override
    public void newForm(String formtype, String client, String operator, String salesman, String houseware,
                        double tpbfDiscounting, double tpafDiscounting, double discount,
                        double voucher, String remark, java.util.Date date,List<Commodity> list) {
        String id=formtype+"-";
        SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
        Random r=new Random();
        id=id+sd.format(date)+"-"+r.nextInt(100000);
        java.sql.Date d=new java.sql.Date(date.getTime());
        if(formtype.equals("XSD")){
            ids.insert(new SaleFormPO(id,client,operator,salesman,houseware,tpbfDiscounting,tpafDiscounting,discount,voucher,remark,d));
            for(int i=0;i!=list.size();i++){
                scds.insert(list.get(i),id);
            }

        }else if(formtype.equals("XSTHD")){
            irds.insert(new SaleFormPO(id,client,operator,salesman,houseware,tpbfDiscounting,tpafDiscounting,discount,voucher,remark,d));
            for(int i=0;i!=list.size();i++){
                srcds.insert(list.get(i),id);
            }
        }else {
            System.out.println("销售单类型错误 请使用 XSD XSTHD");
        }
   


    }

    @Override
    public SaleFormPO findById(String id) {
        String[] tmp = id.split("-");
        String formtype = tmp[0];
        if(formtype.equals("XSD")){
            return ids.find(id);
        }else if(formtype.equals("XSTHD")){
            return irds.find(id);
        }else {
            return null;
        }
    }

    @Override
    public List<SaleFormPO> findByState() {
        List<SaleFormPO> SaleFormPOS=ids.findForState();
        SaleFormPOS.addAll(irds.findForState());
        return SaleFormPOS;
    }

    @Override
    public List<SaleFormPO> findByTime(Date begin, Date end){
        List<SaleFormPO> SaleFormPOS=ids.findForTime(begin,end);
        SaleFormPOS.addAll(irds.findForTime(begin,end));
        return SaleFormPOS;
    }
    @Override
    public List<SaleFormPO> findByType(){
        List<SaleFormPO> SaleFormPOS=ids.findForType();
        SaleFormPOS.addAll(irds.findForType());
        return SaleFormPOS;
    }
    @Override
    public List<SaleFormPO> findByClient(String client){
        List<SaleFormPO> SaleFormPOS=ids.findForClient(client);
        SaleFormPOS.addAll(irds.findForClient(client));
        return SaleFormPOS;
    }

    public static void main(String[] agrs){
        java.sql.Date d=new java.sql.Date((new java.util.Date()).getTime());
        SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
        System.out.println( sd.format(new java.util.Date()));
        SaleBL sb=new SaleBL();
        List<Commodity> ls=new ArrayList<>();
        ls.add(new Commodity());
        ls.add(new Commodity());
        ls.add(new Commodity());
        ls.add(new Commodity());
        sb.newForm("XSD","","","","",0,0,0,0,"",new java.util.Date(),ls);


    }
}
