package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.AlarmDataService;
import JDBC.DAO;
import PO.AlarmPO;


public class AlarmDataServiceImpl implements AlarmDataService{

	DAO<AlarmPO> dao = new DAO<>();
	@Override
	public boolean insert(AlarmPO alarmPO) {
		// TODO Auto-generated method stub
		String sql = "insert into Alarm(goodid, goodname, num, date) values(?,?,?,?)";
		return dao.update(sql, alarmPO.getGoodid(), alarmPO.getGoodname(), alarmPO.getNum(), alarmPO.getDate());
	}

	@Override
	public boolean update(AlarmPO alarmPO) {
		// TODO Auto-generated method stub
		String sql = "update Alarm set goodname = ? , num = ? , date = ? where goodid = ?";
		return dao.update(sql, alarmPO.getGoodname(), alarmPO.getNum(), alarmPO.getDate(), alarmPO.getGoodid());
	}

	@Override
	public List<AlarmPO> findForId(String goodid) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from Alarm where goodid = ?";
		return dao.getALL(AlarmPO.class, sql, goodid);
	}

	@Override
	public List<AlarmPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date  from  Alarm where date >= ? and date <=? ";
		return dao.getALL(AlarmPO.class, sql, begin, end);
	}

	@Override
	public List<AlarmPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select goodid, goodname, num, date from  Alarm";
		return dao.getALL(AlarmPO.class, sql);
	}

}
