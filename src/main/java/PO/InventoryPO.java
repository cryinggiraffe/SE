package PO;

import java.sql.Date;

public class InventoryPO {

	private int id;  //行号
	private String goodid;
	private String goodname;
	private String type;
	private int price;
	private String batch; //批次
	private String batch_num;  //批号
	private Date date;  //出厂日期
	public InventoryPO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InventoryPO(String goodname, String type, int price, String batch, String batch_num, Date date) {
		super();
		this.goodname = goodname;
		this.type = type;
		this.price = price;
		this.batch = batch;
		this.batch_num = batch_num;
		this.date = date;
	}



	public InventoryPO(String goodid, String goodname, String type, int price, String batch, String batch_num,
			Date date) {
		super();
		this.goodid = goodid;
		this.goodname = goodname;
		this.type = type;
		this.price = price;
		this.batch = batch;
		this.batch_num = batch_num;
		this.date = date;
	}
	
	public InventoryPO(int id, String goodid, String goodname, String type, int price, String batch, String batch_num,
			Date date) {
		super();
		this.id = id;
		this.goodid = goodid;
		this.goodname = goodname;
		this.type = type;
		this.price = price;
		this.batch = batch;
		this.batch_num = batch_num;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getBatch_num() {
		return batch_num;
	}

	public void setBatch_num(String batch_num) {
		this.batch_num = batch_num;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InventoryPO [id=" + id + ", goodid=" + goodid + ", goodname=" + goodname + ", type=" + type + ", price="
				+ price + ", batch=" + batch + ", batch_num=" + batch_num + ", date=" + date + "]";
	}
	
	
	
	
	
}
