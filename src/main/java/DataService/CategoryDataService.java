package DataService;

import java.util.List;

import PO.CategoryPO;

public interface CategoryDataService {
	
	public boolean insert(CategoryPO categoryPO);
	public boolean delete(CategoryPO categoryPO);
	public boolean update(CategoryPO categoryPO);
	public List<CategoryPO> list(CategoryPO categoryPO);
	public List<CategoryPO> listAll();
	
}
