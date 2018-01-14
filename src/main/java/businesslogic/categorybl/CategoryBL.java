package businesslogic.categorybl;
import DataService.DataServiceImpl.CategoryDataServiceImpl;
import PO.CategoryPO;

import java.util.List;

public class CategoryBL {
    private CategoryDataServiceImpl cds=new CategoryDataServiceImpl();
    public void addCategory(CategoryPO po){
        cds.insert(po);

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
