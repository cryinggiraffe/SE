package PO;

import java.sql.Date;
import java.util.List;

public class SaleFormPO {
	
	private String id;
    private String client;//id
    private String operator;
    private String salesman;//业务员
    private String houseware;
    private List<Commodity> commodityList;
    private double tpbfDiscounting;
    private double tpafDiscounting;
    private double discount;
    private double voucher;//代金券
    private String remark;
    private String state;
    private Date date;
	
    public SaleFormPO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SaleFormPO(String id, String client, String operator, String salesman, String houseware,
			double tpbfDiscounting, double tpafDiscounting, double discount,
			double voucher, String remark,  Date date) {
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
		this.state = "no";
		this.date = date;
	}


	

	public SaleFormPO(String id, String client, String operator, String salesman, String houseware,
			List<Commodity> commodityList, double tpbfDiscounting, double tpafDiscounting, double discount,
			double voucher, String remark, String state, Date date) {
		super();
		this.id = id;
		this.client = client;
		this.operator = operator;
		this.salesman = salesman;
		this.houseware = houseware;
		this.commodityList = commodityList;
		this.tpbfDiscounting = tpbfDiscounting;
		this.tpafDiscounting = tpafDiscounting;
		this.discount = discount;
		this.voucher = voucher;
		this.remark = remark;
		this.state = state;
		this.date = date;
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

	public List<Commodity> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Commodity> commodityList) {
		this.commodityList = commodityList;
	}

	public double getTpbfDiscounting() {
		return tpbfDiscounting;
	}

	public void setTpbfDiscounting(double tpbfDiscounting) {
		this.tpbfDiscounting = tpbfDiscounting;
	}

	public double getTpafDiscounting() {
		return tpafDiscounting;
	}

	public void setTpafDiscounting(double tpafDiscounting) {
		this.tpafDiscounting = tpafDiscounting;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getVoucher() {
		return voucher;
	}

	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "SaleFormPO [id=" + id + ", client=" + client + ", operator=" + operator + ", salesman=" + salesman
				+ ", houseware=" + houseware + ", commodityList=" + commodityList + ", tpbfDiscounting="
				+ tpbfDiscounting + ", tpafDiscounting=" + tpafDiscounting + ", discount=" + discount + ", voucher="
				+ voucher + ", remark=" + remark + ", state=" + state + "]";
	}
    
    
    
}
