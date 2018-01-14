package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.GiftDataService;
import JDBC.DAO;
import PO.GiftPO;

public class GiftDataServiceImpl implements GiftDataService{

	DAO<GiftPO> dao = new DAO<>();
	@Override
	public boolean insert(GiftPO giftPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Gift(giftlistid, giftid, name, price, num, state, date) values(?,?,?,?,?,?,?)";
		return dao.update(sql, giftPO.getGiftlistid(), giftPO.getGiftid(), giftPO.getName(),
				               giftPO.getPrice(), giftPO.getNum(), giftPO.getState(),
				               giftPO.getDate());
	}

	@Override
	public boolean delete(String giftlistid) {
		// TODO Auto-generated method stub
		String sql = "delete from Gift where  giftlistid = ?";
		
		return dao.update(sql, giftlistid);
	}

	@Override
	public boolean update(GiftPO giftPO) {
		// TODO Auto-generated method stub
		String sql = "update Gift set  name = ?, price = ? , num = ?, state = ? "
			     + ", date = ? where giftlistid = ? and giftid = ?";
		return dao.update(sql, giftPO.getName(), giftPO.getPrice(), giftPO.getNum(), giftPO.getState(),
	               			   giftPO.getDate(), giftPO.getGiftlistid(), giftPO.getGiftid());
	}
	
	@Override
	public boolean updateliststate(GiftPO giftPO) {
		// TODO Auto-generated method stub
		String sql = "update Gift set  name = ?, price = ? , num = ?, state = ? "
				     + ", date = ? where giftlistid = ?";
		
		return dao.update(sql, giftPO.getName(),giftPO.getPrice(), giftPO.getNum(), giftPO.getState(),
	               			   giftPO.getDate(),giftPO.getGiftlistid());
	}

	@Override
	public List<GiftPO> list(String giftlistid) {
		// TODO Auto-generated method stub
		String sql = "select giftlistid, giftid, name, price, num, state, date from Gift where giftlistid = ?";
		return dao.getALL(GiftPO.class, sql, giftlistid);
	}

	@Override
	public List<GiftPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select giftlistid, giftid, name, price, num, state, date from Gift";
		return dao.getALL(GiftPO.class, sql);
	}

	@Override
	public List<GiftPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select giftlistid, giftid, name, price, num, state, date from Gift where date >= ? and date <= ?";
		return dao.getALL(GiftPO.class, sql, begin, end);
	}
	
	

}
