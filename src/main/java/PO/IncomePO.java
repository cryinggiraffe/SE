package PO;

import java.sql.Date;

public class IncomePO {
	
	private double saleincome; //销售收入
	private double overflowincome; //报溢收入
	private double costincome; //成本调价收入
	private double importreturnincome; //进货退货差价
	private double vouchersincome; //代金券与实际收款差额收入
	private double sumincome;  //折让后总收入
	private double discount;  //折让
	private Date date;
	
	public IncomePO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public IncomePO(double saleincome, double overflowincome, double costincome, double importreturnincome,
			double vouchersincome, double sumincome, double discount, Date date) {
		super();
		this.saleincome = saleincome;
		this.overflowincome = overflowincome;
		this.costincome = costincome;
		this.importreturnincome = importreturnincome;
		this.vouchersincome = vouchersincome;
		this.sumincome = sumincome;
		this.discount = discount;
		this.date = date;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getOverflowincome() {
		return overflowincome;
	}



	public void setOverflowincome(double overflowincome) {
		this.overflowincome = overflowincome;
	}



	public double getSaleincome() {
		return saleincome;
	}

	public void setSaleincome(double saleincome) {
		this.saleincome = saleincome;
	}

	public double getCostincome() {
		return costincome;
	}

	public void setCostincome(double costincome) {
		this.costincome = costincome;
	}

	public double getImportreturnincome() {
		return importreturnincome;
	}

	public void setImportreturnincome(double importreturnincome) {
		this.importreturnincome = importreturnincome;
	}

	public double getVouchersincome() {
		return vouchersincome;
	}

	public void setVouchersincome(double vouchersincome) {
		this.vouchersincome = vouchersincome;
	}

	public double getSumincome() {
		return sumincome;
	}

	public void setSumincome(double sumincome) {
		this.sumincome = sumincome;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	@Override
	public String toString() {
		return "IncomePO [saleincome=" + saleincome + ", overflowincome=" + overflowincome + ", costincome="
				+ costincome + ", importreturnincome=" + importreturnincome + ", vouchersincome=" + vouchersincome
				+ ", sumincome=" + sumincome + ", discount=" + discount + ", date=" + date + "]";
	}

	
	
	
	
}
