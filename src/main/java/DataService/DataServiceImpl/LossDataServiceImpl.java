package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.LossDataService;
import JDBC.DAO;
import PO.LossPO;


public class LossDataServiceImpl implements LossDataService{

	DAO<LossPO> dao = new DAO<>();
	@Override
	public boolean insert(LossPO lossPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Loss(goodid, goodname, num, date) values(?,?,?,?)";
		return dao.update(sql, lossPO.getGoodid(), lossPO.getGoodname(), lossPO.getNum(), lossPO.getDate());
		
	}

	@Override
	public boolean update(LossPO lossPO) {
		// TODO Auto-generated method stub
		String sql = "update Loss set goodname = ? , num = ? , date = ? where goodid = ?";
		return dao.update(sql, lossPO.getGoodname(), lossPO.getNum(), lossPO.getDate(), lossPO.getGoodid());
	}

	@Override
	public List<LossPO> findForId(String goodid) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from Loss where goodid = ?";
		return dao.getALL(LossPO.class, sql, goodid);
	}

	@Override
	public List<LossPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date  from  Loss where date >= ? and date <=? ";
		return dao.getALL(LossPO.class, sql, begin, end);
	}

	@Override
	public List<LossPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from  Loss";
		return dao.getALL(LossPO.class, sql);
	}

}
