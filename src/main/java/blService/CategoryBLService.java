package blService;

import PO.CategoryPO;

import java.util.List;

public interface CategoryBLService {
    void addCategory(CategoryPO po);
    void deleteCategory(CategoryPO po);
    void editCategory(CategoryPO po);
    List<CategoryPO> findAll();
}
