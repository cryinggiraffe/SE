package DataService.DataServiceImpl;

import java.util.List;

import DataService.GoodDataService;
import JDBC.DAO;
import PO.GoodPO;
import presentation.goodui.Good;

public class GoodDataServiceImpl implements GoodDataService{

   DAO<GoodPO> dao = new DAO<>();
	
	@Override
	public boolean insert(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO Good VALUES(?,?,?,?,?,?,?,?,?)";
		return dao.update(sql, goodPO.getGoodid(), goodPO.getPid(), goodPO.getName(), goodPO.getType(), goodPO.getNum(),goodPO.getPur_price(),goodPO.getRet_price(),goodPO.getRece_price(),goodPO.getRece_ret_price());
	}

	@Override
	public boolean delete(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = "delete from Good where goodid = ?";
		return dao.update(sql, goodPO.getGoodid());
	}
	
	@Override
	public boolean update(GoodPO goodPO) {
		// TODO Auto-generated method stub
		String sql = "update Good set pid = ?, name = ? num = ?, pur_price = ? ret_price = ? rece_price = ? rece_ret_price = ? where goodid = ?";
		return dao.update(sql, goodPO.getPid(), goodPO.getName(), goodPO.getType(), goodPO.getNum(),goodPO.getPur_price(),goodPO.getRet_price(),goodPO.getRece_price(),goodPO.getRece_ret_price(), goodPO.getGoodid());
	}

	@Override
	public List<GoodPO> list() {
		// TODO Auto-generated method stub
		String sql = "select * from Good";
		return dao.getForList(GoodPO.class, sql);
	}

	@Override
	public GoodPO find (String id) {
		String sql = "SELECT * FROM test.good where goodid = ?";
		return dao.get(GoodPO.class, sql,id);
	}

}
