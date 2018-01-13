package PO;

import java.sql.Date;

public class CashPO {
	
	private String listid;
	private String operator;
	private String account;
	private String name; //条目名
	private double amount; //金额
	private String remark;
	private double sum;
	private Date date;
	
	public CashPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CashPO(String listid, String operator, String account, String name, double amount, String remark, double sum,
			Date date) {
		super();
		this.listid = listid;
		this.operator = operator;
		this.account = account;
		this.name = name;
		this.amount = amount;
		this.remark = remark;
		this.sum = sum;
		this.date = date;
	}

	public String getListid() {
		return listid;
	}

	public void setListid(String listid) {
		this.listid = listid;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CashPO [listid=" + listid + ", operator=" + operator + ", account=" + account + ", name=" + name
				+ ", amount=" + amount + ", remark=" + remark + ", sum=" + sum + ", date=" + date + "]";
	}
	
	
	
}
