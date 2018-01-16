package businesslogic.categorybl;
import DataService.DataServiceImpl.CategoryDataServiceImpl;
import PO.CategoryPO;

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
}
