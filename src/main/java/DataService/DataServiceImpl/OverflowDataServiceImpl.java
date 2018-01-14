package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.OverflowDataService;
import JDBC.DAO;
import PO.OverflowPO;

public class OverflowDataServiceImpl implements OverflowDataService{

	DAO<OverflowPO> dao = new DAO<>();
	@Override
	public boolean insert(OverflowPO overflowPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Overflow(goodid, goodname, num, date) values(?,?,?,?)";
		return dao.update(sql, overflowPO.getGoodid(), overflowPO.getGoodname(), overflowPO.getNum(), overflowPO.getDate());
	}

	@Override
	public boolean update(OverflowPO overflowPO) {
		// TODO Auto-generated method stub
		String sql = "update Overflow set goodname = ? , num = ? , date = ? where goodid = ?";
		return dao.update(sql, overflowPO.getGoodname(), overflowPO.getNum(), overflowPO.getDate(), overflowPO.getGoodid());
	}

	@Override
	public List<OverflowPO> findForId(String goodid) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from  Overflow where = ?";
		return dao.getALL(OverflowPO.class, sql, goodid);
	}

	@Override
	public List<OverflowPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from  Overflow where date >= ? and date <=? ";
		return dao.getALL(OverflowPO.class, sql, begin, end);
	}

	@Override
	public List<OverflowPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from  Overflow";
		return dao.getALL(OverflowPO.class, sql);
	}

}
