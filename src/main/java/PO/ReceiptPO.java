package PO;

import java.sql.Date;

public class ReceiptPO {
	
	private String id;
	private String client;
	private String username;
	private String account;
	private double amount;
	private String remark;
	private double sum;
	private String state;
	private Date date;
	
	public ReceiptPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ReceiptPO(String id, String client, String username, String account, double amount, String remark,
			double sum, Date date) {
		super();
		this.id = id;
		this.client = client;
		this.username = username;
		this.account = account;
		this.amount = amount;
		this.remark = remark;
		this.sum = sum;
		this.state = "no";
		this.date = date;
	}

	

	public ReceiptPO(String id, String username, String client, String account, double amount, String remark,
			double sum, String state, Date date) {
		super();
		this.id = id;
		this.username = username;
		this.client = client;
		this.account = account;
		this.amount = amount;
		this.remark = remark;
		this.sum = sum;
		this.state = state;
		this.date = date;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public String getState() {
		return state;
	}

	
	public void setState(String state) {
		this.state = state;
	}



	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "ReceiptPO [id=" + id + ", username=" + username + ", client=" + client + ", account=" + account
				+ ", amount=" + amount + ", remark=" + remark + ", sum=" + sum + ", state=" + state + ", date=" + date
				+ "]";
	}

		
	
}
