package PO;

public class IncomePO {
	
	private double saleincome;
	private Commodityincome commodityincome;
	
	public IncomePO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public IncomePO(double saleincome, Commodityincome commodityincome) {
		super();
		this.saleincome = saleincome;
		this.commodityincome = commodityincome;
	}

	public double getSaleincome() {
		return saleincome;
	}

	public void setSaleincome(double saleincome) {
		this.saleincome = saleincome;
	}

	public Commodityincome getCommodityincome() {
		return commodityincome;
	}

	public void setCommodityincome(Commodityincome commodityincome) {
		this.commodityincome = commodityincome;
	}



	@Override
	public String toString() {
		return "IncomePO [saleincome=" + saleincome + ", commodityincome=" + commodityincome + "]";
	}
	
	
}
