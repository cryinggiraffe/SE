package blService;

import PO.ExpenditurePO;
import PO.IncomePO;

import java.sql.Date;
import java.util.List;

public interface TranslationSituationBLService {
    void newExpenditure();

    void newIncome();
    List<ExpenditurePO> findForTime(java.util.Date begin, java.util.Date end);
    List<ExpenditurePO> findAllExpenditure();
    public List<IncomePO> findAllIncome();
}
