package PO;

import java.util.ArrayList;

public class SaleFormPO {
	
	private String id;
    private String client;//id
    private String operator;
    private String salesman;//业务员
    private String houseware;
    private ArrayList<Commodity> commodityList;
    private Double tpbfDiscounting;
    private Double tpafDiscounting;
    private Double discount;
    private Double voucher;//代金券
    private String remark;
    private int state;
	
    public SaleFormPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaleFormPO(String id, String client, String operator, String salesman, String houseware,
			 Double tpbfDiscounting, Double tpafDiscounting, Double discount,Double voucher, String remark, int state) {
		super();
		this.id = id;
		this.client = client;
		this.operator = operator;
		this.salesman = salesman;
		this.houseware = houseware;
		this.tpbfDiscounting = tpbfDiscounting;
		this.tpafDiscounting = tpafDiscounting;
		this.discount = discount;
		this.voucher = voucher;
		this.remark = remark;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public String getHouseware() {
		return houseware;
	}

	public void setHouseware(String houseware) {
		this.houseware = houseware;
	}

	public ArrayList<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(ArrayList<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public Double getTpbfDiscounting() {
		return tpbfDiscounting;
	}

	public void setTpbfDiscounting(Double tpbfDiscounting) {
		this.tpbfDiscounting = tpbfDiscounting;
	}

	public Double getTpafDiscounting() {
		return tpafDiscounting;
	}

	public void setTpafDiscounting(Double tpafDiscounting) {
		this.tpafDiscounting = tpafDiscounting;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getVoucher() {
		return voucher;
	}

	public void setVoucher(Double voucher) {
		this.voucher = voucher;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SaleFormPO [id=" + id + ", client=" + client + ", operator=" + operator + ", salesman=" + salesman
				+ ", houseware=" + houseware + ", commodityList=" + commodityList + ", tpbfDiscounting="
				+ tpbfDiscounting + ", tpafDiscounting=" + tpafDiscounting + ", discount=" + discount + ", voucher="
				+ voucher + ", remark=" + remark + ", state=" + state + "]";
	}
    
    
    
}
