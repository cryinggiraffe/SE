package businesslogic.categorybl;
import DataService.DataServiceImpl.CategoryDataServiceImpl;
import PO.CategoryPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryBL {
    private CategoryDataServiceImpl cds=new CategoryDataServiceImpl();
    public void addCategory(CategoryPO po){
        cds.insert(po);

    }
    public String generateId(){
        Random r=new Random();

        return String.valueOf(r.nextInt(999999999));
    }
    public void deleteCategory(CategoryPO po){
        cds.delete(po);
    }
    public void editCategory(CategoryPO po){
        cds.update(po);
    }
    public List<CategoryPO> findAll(){
        return cds.listAll();
    }
    public List<CategoryPO> findByPid(int pid){
        List<CategoryPO> pos=findAll();
        List<CategoryPO> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            if(pos.get(i).getPid()==pid){
                res.add(pos.get(i));
            }

        }
        return res;
    }
}
