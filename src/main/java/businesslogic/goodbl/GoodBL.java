package businesslogic.goodbl;

import DataService.DataServiceImpl.GoodDataServiceImpl;
import PO.GoodPO;

import java.util.ArrayList;
import java.util.List;

public class GoodBL {
    private GoodDataServiceImpl gds=new GoodDataServiceImpl();
    public void newGood(GoodPO po){
        gds.insert(po);

    }
    public void updateGood(GoodPO po){
        gds.update(po);

    }
    public void deleteGood(GoodPO po){
        gds.delete(po);
    }
    public List<GoodPO> findGoodById(int id){
        String sid=String.valueOf(id);
        List<GoodPO> pos=gds.list();
        List<GoodPO> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            if(pos.get(i).getGoodid().equals(sid)){
                res.add(pos.get(i));
            }
        }
        return res;
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
    public List<String> listNames(){
        List<GoodPO> pos=gds.list();
        List<String> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            res.add(pos.get(i).getName());
        }
        return res;
    }

}
