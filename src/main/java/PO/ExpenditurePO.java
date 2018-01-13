package PO;

import java.sql.Date;

public class ExpenditurePO {
	
	private double salecost;
	private double commoditylostexpenditure;
	private double giftexpenditure;
	private double sumexpenditure;
	private Date date;
	
	public ExpenditurePO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenditurePO(double salecost, double commoditylostexpenditure, double giftexpenditure,
			double sumexpenditure, Date date) {
		super();
		this.salecost = salecost;
		this.commoditylostexpenditure = commoditylostexpenditure;
		this.giftexpenditure = giftexpenditure;
		this.sumexpenditure = sumexpenditure;
		this.date = date;
	}



	public double getSalecost() {
		return salecost;
	}

	public void setSalecost(double salecost) {
		this.salecost = salecost;
	}

	public double getCommoditylostexpenditure() {
		return commoditylostexpenditure;
	}

	public void setCommoditylostexpenditure(double commoditylostexpenditure) {
		this.commoditylostexpenditure = commoditylostexpenditure;
	}

	public double getGiftexpenditure() {
		return giftexpenditure;
	}

	public void setGiftexpenditure(double giftexpenditure) {
		this.giftexpenditure = giftexpenditure;
	}

	public double getSumexpenditure() {
		return sumexpenditure;
	}

	public void setSumexpenditure(double sumexpenditure) {
		this.sumexpenditure = sumexpenditure;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ExpenditurePO [salecost=" + salecost + ", commoditylostexpenditure=" + commoditylostexpenditure
				+ ", giftexpenditure=" + giftexpenditure + ", sumexpenditure=" + sumexpenditure + ", date=" + date
				+ "]";
	}

	
	
	

}
