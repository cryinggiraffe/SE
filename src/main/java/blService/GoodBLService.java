package blService;

import PO.GoodPO;

import java.util.List;

public interface GoodBLService {
    List<String> listNames();
    List<GoodPO> findGoodByName(String name);
    GoodPO findGoodById(int id);
    void deleteGood(GoodPO po);
    void updateGood(GoodPO po);
    void newGood(GoodPO po);
    List<String> recommend();
}
