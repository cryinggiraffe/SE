package DataService.DataServiceImpl;

import java.util.List;

import JDBC.DAO;
import PO.CategoryPO;
import dataService.CategoryDataService;

public class CategoryDataServiceImpl implements CategoryDataService{

	DAO<CategoryPO> dao = new DAO<>();
	
	@Override
	public boolean insert(CategoryPO categoryPO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO Category VALUES(?,?)";
		return dao.update(sql, categoryPO.getId() , categoryPO.getName());
	}

	@Override
	public boolean delete(CategoryPO categoryPO) {
		// TODO Auto-generated method stub
		String sql = "delete from Category where id = ?";
		return dao.update(sql, categoryPO.getId());
	}

	@Override
	public boolean update(CategoryPO categoryPO) {
		// TODO Auto-generated method stub
		String sql = "update Category set name = ? where id = ?";
		return dao.update(sql, categoryPO.getName() , categoryPO.getId() );
	}

	@Override
	public List<CategoryPO> list(CategoryPO categoryPO) {
		// TODO Auto-generated method stub
		String sql = "select * from Category where id like ? and name like ?";
		return dao.getForList(CategoryPO.class, sql, categoryPO.getId() == 0 ? "%%" : categoryPO.getId(), 
													 categoryPO.getName() == null ? "%%" : categoryPO.getName());
	}
	
	@Override
	public List<CategoryPO> listAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Category";
		return dao.getALL(CategoryPO.class, sql);
	}

	
	
}
