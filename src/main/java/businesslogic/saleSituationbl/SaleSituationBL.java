package businesslogic.saleSituationbl;

import DataService.DataServiceImpl.SaleSituationDataServiceImpl;
import PO.SaleSituationPo;
import blService.SaleSituationBLService;

import java.sql.Date;
import java.util.List;

public class SaleSituationBL implements SaleSituationBLService {
    SaleSituationDataServiceImpl ssd = new SaleSituationDataServiceImpl();

    public List<SaleSituationPo> findForTime(Date begin, Date end){ return ssd.findForTime(begin,end); }
    public List<SaleSituationPo> findForName(String name){ return ssd.findForName(name); }
    public List<SaleSituationPo> findForClient(String client){ return ssd.findForClient(client); }
    public List<SaleSituationPo> findForSalesman(String salesman){ return ssd.findForSalesman(salesman); }
    public List<SaleSituationPo> findForHouseWare(String houseware){ return ssd.findForHouseWare(houseware); }
}
