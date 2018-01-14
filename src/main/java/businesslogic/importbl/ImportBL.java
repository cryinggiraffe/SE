package businesslogic.importbl;
import DataService.DataServiceImpl.ImportCommodityDataServiceImpl;
import DataService.DataServiceImpl.ImportDataServiceImpl;
import DataService.DataServiceImpl.ImportReturnCommodityDataServiceImpl;
import DataService.DataServiceImpl.ImportReturnDataServiceImpl;
import DataService.ImportReturnCommodityDataService;
import DataService.ImportReturnDataService;
import PO.Commodity;
import PO.ImportFormPO;
import blService.ImportFormService;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

public class ImportBL implements ImportFormService{
    private ImportCommodityDataServiceImpl icds=new ImportCommodityDataServiceImpl();
    private ImportReturnCommodityDataService ircds=new ImportReturnCommodityDataServiceImpl();

    private ImportDataServiceImpl ids=new ImportDataServiceImpl();
    private ImportReturnDataServiceImpl irds=new ImportReturnDataServiceImpl();
    @Override
    public String newForm(String formtype, String provider, String houseware, String operator,String remark, double sum, String state, java.util.Date date,List<Commodity> list) {
        String id=formtype+"-";
        SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
        Random r=new Random();
        id=id+sd.format(date)+"-"+r.nextInt(100000);
        java.sql.Date d=new java.sql.Date(date.getTime());
        if(formtype.equals("JHD")){
            ids.insert(new ImportFormPO(id,provider,houseware,operator,list,remark,sum,state,d));
            for(int i=0;i!=list.size();i++){
                icds.insert(list.get(i),id);
            }
        }else if(formtype.equals("JHTHD")){
            irds.insert(new ImportFormPO(id,provider,houseware,operator,list,remark,sum,state,d));
            for(int i=0;i!=list.size();i++){
                ircds.insert(list.get(i),id);
            }
        }else {
            System.out.println("进货单类型错误 请使用 JHD JHTHD");
        }
        return id;

    }

    @Override
    public ImportFormPO findById(String id) {
        String[] tmp = id.split("-");
        String formtype = tmp[0];
        if(formtype.equals("JHD")){
            return ids.find(id);
        }else if(formtype.equals("JHTHD")){
            return irds.find(id);
        }else {
            return null;
        }
    }

    @Override
    public List<ImportFormPO> findByState() {
        List<ImportFormPO> importFormPOS=ids.findForState();
        importFormPOS.addAll(irds.findForState());
        return importFormPOS;
    }

    @Override
    public List<ImportFormPO> findByTime(Date begin, Date end){
        List<ImportFormPO> importFormPOS=ids.findForTime(begin,end);
        importFormPOS.addAll(irds.findForTime(begin,end));
        return importFormPOS;
    }
    @Override
    public List<ImportFormPO> findByType(){
        List<ImportFormPO> importFormPOS=ids.findForType();
        importFormPOS.addAll(irds.findForType());
        return importFormPOS;
    }
    @Override
    public List<ImportFormPO> findByClient(String client){
        List<ImportFormPO> importFormPOS=ids.findForClient(client);
        importFormPOS.addAll(irds.findForClient(client));
        return importFormPOS;
    }
    
    
    
    

    public List<ImportFormPO> findAllForm(){
        return ids.findForState_Commities();
    }
    public List<ImportFormPO> findAllReturnForm(){
        return irds.findForState_Commities();
    }


    public static void main(String[] agrs){
        java.sql.Date d=new java.sql.Date((new java.util.Date()).getTime());
        SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
        System.out.println( sd.format(new java.util.Date()));


    }
}
