package blService;

import PO.SaleSituationPo;

import java.sql.Date;
import java.util.List;

public interface SaleSituationBLService {
    public List<SaleSituationPo> findForTime(Date begin, Date end);
    public List<SaleSituationPo> findForName(String name);
    public List<SaleSituationPo> findForClient(String client);
    public List<SaleSituationPo> findForSalesman(String salesman);
    public List<SaleSituationPo> findForHouseWare(String houseware);
}
