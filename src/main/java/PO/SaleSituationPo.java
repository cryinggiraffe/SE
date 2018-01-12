package PO;

import java.sql.Date;

public class SaleSituationPo {
	
	private Date date;
	private String name;
	private String version;
	private int quantity;
	private double pirce;
	private double subtotalprice;
	
	public SaleSituationPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleSituationPo(Date date, String name, String version, int quantity, double pirce, double subtotalprice) {
		super();
		this.date = date;
		this.name = name;
		this.version = version;
		this.quantity = quantity;
		this.pirce = pirce;
		this.subtotalprice = subtotalprice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPirce() {
		return pirce;
	}

	public void setPirce(double pirce) {
		this.pirce = pirce;
	}

	public double getSubtotalprice() {
		return subtotalprice;
	}

	public void setSubtotalprice(double subtotalprice) {
		this.subtotalprice = subtotalprice;
	}

	@Override
	public String toString() {
		return "SaleSituationPo [date=" + date + ", name=" + name + ", version=" + version + ", quantity=" + quantity
				+ ", pirce=" + pirce + ", subtotalprice=" + subtotalprice + "]";
	}
	
	
}
