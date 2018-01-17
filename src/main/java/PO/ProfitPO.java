package PO;

import java.sql.Date;

public class ProfitPO {
    private Date date;
    private double profit;

    public ProfitPO (Date date, double profit){
        this.date = date;
        this.profit = profit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
