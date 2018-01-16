package businesslogic.promotionbl;
import DataService.DataServiceImpl.PricePromotionDataServiceImpl;
import DataService.DataServiceImpl.UserClassPromotionDataServiceImpl;
import PO.PromotionPO;
import blService.PromotionBLService;
import DataService.DataServiceImpl.CommodityPromotionDataServiceImpl;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class PromotionBL implements PromotionBLService {
    private PricePromotionDataServiceImpl ppd = new PricePromotionDataServiceImpl();
    private CommodityPromotionDataServiceImpl cpd =new CommodityPromotionDataServiceImpl();
    private UserClassPromotionDataServiceImpl upd=new UserClassPromotionDataServiceImpl();

    @Override
    public boolean makePromotion(PromotionPO po) {
        int userClass = po.getUserclass();
        String specialgoodname1 = po.getSpecialgoodname1();
        double cash_coupon = po.getCash_coupon();
        if (userClass != 0){
            upd.insert(po);
        }else if (specialgoodname1 != null) {
            cpd.insert(po);
        }else if (cash_coupon != 0.0) {
            ppd.insert(po);
        }

        return true;
    }

    @Override
    public void endPromotyion(String id) {
        PromotionPO po=new PromotionPO(id,"",0,0);
        //以下实现不了
        int userClass = po.getUserclass();
        String specialgoodname1 = po.getSpecialgoodname1();
        double cash_coupon = po.getCash_coupon();
        if (userClass != 0){
            upd.delete(po);
        }else if (specialgoodname1 != null) {
            cpd.delete(po);
        }else if (cash_coupon != 0.0) {
            ppd.delete(po);
        }
    }

    @Override
    public List<PromotionPO> findAll() {
        List<PromotionPO> promotionPOS = ppd.findAll();
        promotionPOS.addAll(cpd.findAll());
        promotionPOS.addAll(upd.findAll());
        return promotionPOS;
    }

    public String getType(PromotionPO po) {
        int userClass = po.getUserclass();
        String specialgoodname1 = po.getSpecialgoodname1();
        double cash_coupon = po.getCash_coupon();
        if (userClass != 0){
            return "userclass";
        }else if (specialgoodname1 != null) {
            return "commodity";
        }else if (cash_coupon != 0.0) {
            return "price";
        }else {
            return "no";
        }
    }

    @Override
    public String getId(){
        String id = "CXCL-";
        List<PromotionPO> promotionPOS = this.findAll();
        int length = promotionPOS.size() + 1;
        Calendar now = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-");
        id = id +  sdf.format(now.getTime()) + String.format("%05d",length);
        return id;

    }

    public static void main(String[] agrs){
        PromotionBL pbl=new PromotionBL();
        //PromotionPO po=new PromotionPO(233,"",0,0);
        //pbl.makePromotion(po);
    }
}
