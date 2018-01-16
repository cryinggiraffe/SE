package blService;
import PO.PromotionPO;

import java.util.List;

public interface PromotionBLService {
    boolean makePromotion(PromotionPO po);
    void endPromotyion(String id);
    List<PromotionPO> findAll();
    String getType(PromotionPO po);
    String getId();
}
