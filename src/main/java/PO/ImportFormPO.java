package PO;

import java.io.Serializable;
import java.util.ArrayList;

public class ImportFormPO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String provider;//供应商id
    private String houseware;
    private String operator;//操作员
    private ArrayList<Commodity> commodityList;
    private String remark;
    private Double totalPrice;
    private int state;
	
    public ImportFormPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImportFormPO(String id, String provider, String houseware, String operator,
			ArrayList<Commodity> commodityList, String remark, Double totalPrice, int state) {
		super();
		this.id = id;
		this.provider = provider;
		this.houseware = houseware;
		this.operator = operator;
		this.commodityList = commodityList;
		this.remark = remark;
		this.totalPrice = totalPrice;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getHouseware() {
		return houseware;
	}

	public void setHouseware(String houseware) {
		this.houseware = houseware;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public ArrayList<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(ArrayList<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ImportFormPO [id=" + id + ", provider=" + provider + ", houseware=" + houseware + ", operator="
				+ operator + ", commodityList=" + commodityList + ", remark=" + remark + ", totalPrice=" + totalPrice
				+ ", state=" + state + "]";
	}
    
   
}