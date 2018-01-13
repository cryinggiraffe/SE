package PO;

import java.sql.Date;

public class GiftPO {
	
	private String giftlistid;
	private String giftid;
	private String name;
	private double price;
	private int num;
	private String state;
	private Date date;
	
	public GiftPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public GiftPO(String giftlistid, String giftid, String name, double price, int num, Date date) {
		super();
		this.giftlistid = giftlistid;
		this.giftid = giftid;
		this.name = name;
		this.price = price;
		this.num = num;
		this.state = "no";
		this.date = date;
	}



	public GiftPO(String giftlistid, String giftid, String name, double price, int num, String state, Date date) {
		super();
		this.giftlistid = giftlistid;
		this.giftid = giftid;
		this.name = name;
		this.price = price;
		this.num = num;
		this.state = state;
		this.date = date;
	}



	public String getGiftlistid() {
		return giftlistid;
	}



	public void setGiftlistid(String giftlistid) {
		this.giftlistid = giftlistid;
	}



	public String getGiftid() {
		return giftid;
	}



	public void setGiftid(String giftid) {
		this.giftid = giftid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
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
		return "GiftPO [giftlistid=" + giftlistid + ", giftid=" + giftid + ", name=" + name + ", price=" + price
				+ ", num=" + num + ", state=" + state + ", date=" + date + "]";
	}
	
	
	
}
