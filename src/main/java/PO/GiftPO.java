package PO;

import java.sql.Date;

public class GiftPO extends StockPO{
	
	private String giftlistid;
	
	private double price;
	
	private String state;
	
	
	public GiftPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public GiftPO(String giftlistid, String giftid, String name, double price, int num, Date date) {
		super();
		this.giftlistid = giftlistid;
		this.goodid = giftid;
		this.goodname = name;
		this.price = price;
		this.num = num;
		this.state = "no";
		this.date = date;
	}



	public GiftPO(String giftlistid, String giftid, String name, double price, int num, String state, Date date) {
		super();
		this.giftlistid = giftlistid;
		this.goodid = giftid;
		this.goodname = name;
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



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "GiftPO [giftlistid=" + giftlistid + ", price=" + price + ", state=" + state + "]";
	}



	
	
	
}
