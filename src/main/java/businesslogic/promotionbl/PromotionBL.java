package businesslogic.promotionbl;
import DataService.DataServiceImpl.PricePromotionDataServiceImpl;
import DataService.DataServiceImpl.UserClassPromotionDataServiceImpl;
import PO.PromotionPO;
import blService.PromotionBLService;
import DataService.DataServiceImpl.CommodityPromotionDataServiceImpl;
public class PromotionBL implements PromotionBLService {
    private PricePromotionDataServiceImpl ppd = new PricePromotionDataServiceImpl();
    private CommodityPromotionDataServiceImpl cpd =new CommodityPromotionDataServiceImpl();
    private UserClassPromotionDataServiceImpl upd=new UserClassPromotionDataServiceImpl();
    @Override
    public boolean makePromotion(PromotionPO po) {
        ppd.insert(po);
        cpd.insert(po);
        upd.insert(po);

        return true;
    }

    @Override
    public void endPromotyion(int id) {
        PromotionPO po=new PromotionPO(id,"",0,0);
        //ppd.delete(po);
        //cpd.delete(po);
        //upd.delete(po);
    }
    public static void main(String[] agrs){
        PromotionBL pbl=new PromotionBL();
        PromotionPO po=new PromotionPO(233,"",0,0);
        pbl.makePromotion(po);
    }
}
