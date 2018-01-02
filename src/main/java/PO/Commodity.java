package PO;

import java.io.Serializable;

public class Commodity implements Serializable {
    
	
	private static final long serialVersionUID = 1L;
	
	private String goodid;
    private String name;
    private String version;//型号
    private int quantity;
    private Double pirce;//单价
    private Double subtotalprice;
    private String remark;
	
    public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commodity(String goodid, String name, String version, int quantity, Double pirce, Double subtotalprice,
			String remark) {
		super();
		this.goodid = goodid;
		this.name = name;
		this.version = version;
		this.quantity = quantity;
		this.pirce = pirce;
		this.subtotalprice = subtotalprice;
		this.remark = remark;
	}

	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
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

	public Double getPirce() {
		return pirce;
	}

	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}

	public Double getSubtotalprice() {
		return subtotalprice;
	}

	public void setSubtotalprice(Double subtotalprice) {
		this.subtotalprice = subtotalprice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Commodity [goodid=" + goodid + ", name=" + name + ", version=" + version + ", quantity=" + quantity
				+ ", pirce=" + pirce + ", subtotalprice=" + subtotalprice + ", remark=" + remark + "]";
	}
    
    
    
}