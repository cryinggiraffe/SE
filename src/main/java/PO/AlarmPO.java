package PO;

import java.sql.Date;

public class AlarmPO {
	
	private String goodid;
    private String goodname;
    private int num;
    private Date date;
	
    public AlarmPO() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
	public AlarmPO(String goodid, String goodname, int num) {
		super();
		this.goodid = goodid;
		this.goodname = goodname;
		this.num = num;
	}


	public AlarmPO(String goodid, String goodname, int num, Date date) {
		super();
		this.goodid = goodid;
		this.goodname = goodname;
		this.num = num;
		this.date = date;
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
		return "AlarmPO [goodid=" + goodid + ", goodname=" + goodname + ", num=" + num + ", date=" + date + "]";
	}
    
	
    
}
