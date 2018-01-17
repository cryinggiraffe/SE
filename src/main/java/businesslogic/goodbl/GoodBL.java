package businesslogic.goodbl;

import DataService.DataServiceImpl.GoodDataServiceImpl;
import DataService.DataServiceImpl.InventoryDataServiceImpl;
import DataService.DataServiceImpl.LossDataServiceImpl;
import DataService.DataServiceImpl.OverflowDataServiceImpl;
import PO.GoodPO;
import PO.InventoryPO;
import PO.LossPO;
import PO.OverflowPO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

public class GoodBL {
    private OverflowDataServiceImpl ofds=new OverflowDataServiceImpl();
    private LossDataServiceImpl lds=new LossDataServiceImpl();
    private GoodDataServiceImpl gds=new GoodDataServiceImpl();
    private InventoryDataServiceImpl ids=new InventoryDataServiceImpl();
    public void newInventoryPO(InventoryPO po){
        ids.insert(po);

    }
    public void newGood(GoodPO po){
        gds.insert(po);

    }
    public void updateGood(GoodPO po){
        gds.update(po);

    }
    public void deleteGood(GoodPO po){
        gds.delete(po);
    }

    public List<GoodPO> findGoodByName(String name){
        List<GoodPO> pos=gds.list();
        List<GoodPO> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            if(pos.get(i).getName().equals(name)){
                res.add(pos.get(i));
            }
        }
        return res;
    }
    public GoodPO findGoodById(String id){
        List<GoodPO> pos=gds.list();
        GoodPO res=null;
        for(int i=0;i!=pos.size();i++){
            if(pos.get(i).getGoodid().equals(id)){
                res=pos.get(i);
            }
        }
        return res;
    }
    public List<String> listNames(){
        List<GoodPO> pos=gds.list();
        List<String> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            res.add(pos.get(i).getName());
        }
        return res;
    }
    public List<String> recommend(){
        List<GoodPO> pos=gds.list();
        List<String> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            if(pos.get(i).getPur_price()>=20&&pos.get(i).getPur_price()<=100)
            res.add(pos.get(i).getGoodid());
        }
        return res;
    }
    public void overflow(String id,int num){
        GoodPO po=this.findGoodById(id);
        ofds.insert(new OverflowPO(po.getGoodid(),po.getName(),num,new java.sql.Date(new java.util.Date().getTime())));
    }
    public void loss(String id,int num){
        GoodPO po=this.findGoodById(id);
        lds.insert(new LossPO(po.getGoodid(),po.getName(),num,new java.sql.Date(new java.util.Date().getTime())));
    }
    public List<InventoryPO> viewPeriod(Date begin,Date end){

        Date i=(Date)begin.clone();
        List<InventoryPO> res=new ArrayList<>();
        while(i.compareTo(end)<0){
            res.addAll(ids.findForTime(new java.sql.Date(i.getTime())));
            Calendar c=Calendar.getInstance();
            c.setTime(i);
            c.add(Calendar.DAY_OF_MONTH,1);
            i=c.getTime();
        }
        return res;
    }
    public List<InventoryPO> dayCheck(){
        java.sql.Date d=new java.sql.Date(new java.util.Date().getTime());
        return ids.findForTime(d);
    }
    public void makeExcel(String path){
        List<InventoryPO> re=dayCheck();
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("test");
        HSSFRow row1=sheet.createRow(0);
        HSSFCell cell=row1.createCell(0);
        cell.setCellValue("goodid");
        row1.createCell(1).setCellValue("goodname");
        row1.createCell(2).setCellValue("type");
        row1.createCell(3).setCellValue("price");
        row1.createCell(4).setCellValue("batch");
        row1.createCell(5).setCellValue("batch-num");
        row1.createCell(6).setCellValue("date");
        for(int i=0;i!=re.size();i++){
            HSSFRow row=sheet.createRow(i+1);
            row.createCell(0).setCellValue(re.get(i).getGoodid());

            row.createCell(1).setCellValue(re.get(i).getGoodname());
            row.createCell(2).setCellValue(re.get(i).getType());
            row.createCell(3).setCellValue(re.get(i).getPrice());
            row.createCell(4).setCellValue(re.get(i).getBatch());
            row.createCell(5).setCellValue(re.get(i).getBatch_num());
            row.createCell(6).setCellValue(re.get(i).getDate().toString());

        }
        try{
            OutputStream output=new FileOutputStream("e:\\workbook.xls");
            wb.write(output);
            output.flush();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public List<GoodPO> findAll(){
        return gds.list();
    }
    public String generateId(){
        Random r=new Random();

        return String.valueOf(r.nextInt(999999999));
    }
    public static void main(String[] agrs){
        
        InventoryDataServiceImpl ids=new InventoryDataServiceImpl();
        InventoryPO po1=new InventoryPO("sldfjasdf", "", 1, "1", "1",new java.sql.Date(new java.util.Date().getTime()));
        ids.insert(po1);
        //System.out.println(new java.sql.Date(new java.util.Date().getTime()));
        //System.out.println(new java.util.Date());
        GoodBL gbl=new GoodBL();
        Calendar c=Calendar.getInstance();
        c.setTime(new java.util.Date());c.add(Calendar.DATE,-1);
        java.util.Date d1=c.getTime();
        c.add(Calendar.DATE,2);
        java.util.Date d2=c.getTime();
        System.out.println(gbl.dayCheck());
    }
}
