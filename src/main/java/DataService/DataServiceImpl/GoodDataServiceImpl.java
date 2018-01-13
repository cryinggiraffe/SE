package DataService.DataServiceImpl;

import java.util.List;

import DataService.GoodDataService;
import JDBC.DAO;
import PO.GoodPO;

public class GoodDataServiceImpl implements GoodDataService{

   DAO<GoodPO> dao = new DAO<>();
	
	@Override
	public boolean insert(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO Good VALUES(?,?,?,?,?,?,?,?)";
		return dao.update(sql, goodPO.getId(), goodPO.getName(), goodPO.getType(), goodPO.getNum(),goodPO.getPur_price(),goodPO.getRet_price(),goodPO.getRece_price(),goodPO.getRece_ret_price());
	}

	@Override
	public boolean delete(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = "delete from Good where id = ?";
		return dao.update(sql, goodPO.getId());
	}
	
	@Override
	public boolean update(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = "update Good set name = ? num = ?, pur_price = ? ret_price = ? rece_price = ? rece_ret_price = ? where id = ?";
		return dao.update(sql, goodPO.getName(), goodPO.getType(), goodPO.getNum(),goodPO.getPur_price(),goodPO.getRet_price(),goodPO.getRece_price(),goodPO.getRece_ret_price(), goodPO.getId());
	}

	@Override
	public List<GoodPO> list() {
		// TODO Auto-generated method stub
		String sql = "select * from Good";
		return dao.getForList(GoodPO.class, sql);
	}

}
