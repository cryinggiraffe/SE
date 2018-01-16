package businesslogic.translationSituationbl;

import DataService.DataServiceImpl. ExpenditureDataServiceImpl;
import PO.ExpenditurePO;
import blService.TranslationSituationBLService;

import java.sql.Date;
import java.util.List;

public class TranslationSituationBL implements TranslationSituationBLService {

    private ExpenditureDataServiceImpl eds=new ExpenditureDataServiceImpl();
    public void newExpenditure(double salecost, double commoditylostexpenditure, double giftexpenditure,
                               double sumexpenditure, java.util.Date date){
        ExpenditurePO po=new ExpenditurePO(salecost,commoditylostexpenditure,giftexpenditure,sumexpenditure,new java.sql.Date(date.getTime()));
        eds.insert(po);
    }
    public List<ExpenditurePO> findForTime(java.util.Date begin, java.util.Date end){
        java.sql.Date begint=new java.sql.Date(begin.getTime());
        java.sql.Date endt=new java.sql.Date(end.getTime());
        return eds.findForTime(begint,endt);
    }
    public List<ExpenditurePO> findAll(){
        return eds.findAll();
    }
}
