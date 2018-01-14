package DataService;

import java.sql.Date;
import java.util.List;

import PO.ExpenditurePO;

public interface ExpenditureDataService {

	public boolean insert(ExpenditurePO expenditurePO);
	public List<ExpenditurePO> findForTime(Date begin, Date end);
	public List<ExpenditurePO> findAll();
}
