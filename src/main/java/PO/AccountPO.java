package PO;

public class AccountPO {
	
	private String name;
	private double balance;
	
	public AccountPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountPO(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return  name + "," +balance;
	}
	
	
	
}
