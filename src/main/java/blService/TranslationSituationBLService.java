package blService;

import PO.ExpenditurePO;
import PO.IncomePO;

import java.util.List;

public interface TranslationSituationBLService {
    void newExpenditure(double salecost, double commoditylostexpenditure, double giftexpenditure,
                        double sumexpenditure, java.util.Date date);
    List<ExpenditurePO> findForTime(java.util.Date begin, java.util.Date end);
    List<ExpenditurePO> findAllExpenditure();
    public List<IncomePO> findAllIncome();
}
