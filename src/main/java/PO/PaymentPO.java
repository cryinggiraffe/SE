package PO;

public class PaymentPO {
	
	private String id;
	private String username;
	private String account;
	private double amount;
	private String remark;
	private double sum;
	private String state;
	
	public PaymentPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentPO(String id, String username, String account, double amount, String remark, double sum) {
		super();
		this.id = id;
		this.username = username;
		this.account = account;
		this.amount = amount;
		this.remark = remark;
		this.sum = sum;
		this.state = "no";
	}
	
	

	public PaymentPO(String id, String username, String account, double amount, String remark, double sum,
			String state) {
		super();
		this.id = id;
		this.username = username;
		this.account = account;
		this.amount = amount;
		this.remark = remark;
		this.sum = sum;
		this.state = state;
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

	@Override
	public String toString() {
		return "PaymentPO [id=" + id + ", username=" + username + ", account=" + account + ", amount=" + amount
				+ ", remark=" + remark + ", sum=" + sum + ", state=" + state + "]";
	}
	
	
}
