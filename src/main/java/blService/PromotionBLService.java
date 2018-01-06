package blService;
import PO.PromotionPO;
public interface PromotionBLService {
    boolean makePromotion(PromotionPO po);
    void endPromotyion(int id);
}
