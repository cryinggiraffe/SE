package PO;

import java.io.Serializable;

public class GoodPO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String goodid;
	private int pid;
    private String name;
    private String type;
    private int num;
    private int pur_price;
    private int ret_price;
    private int rece_price;
    private int rece_ret_price;

    public GoodPO() {
		super();
		goodid="0";
		// TODO Auto-generated constructor stub
	}
    

	public GoodPO(String goodid, int pid, String name, String type, int num, int pur_price, int ret_price,
			int rece_price, int rece_ret_price) {
		super();
		this.goodid = goodid;
		this.pid = pid;
		this.name = name;
		this.type = type;
		this.num = num;
		this.pur_price = pur_price;
		this.ret_price = ret_price;
		this.rece_price = rece_price;
		this.rece_ret_price = rece_ret_price;
	}
	
	

	public String getGoodid() {
		return goodid;
	}


	public void setGoodid(String googid) {
		this.goodid = googid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getPur_price() {
		return pur_price;
	}


	public void setPur_price(int pur_price) {
		this.pur_price = pur_price;
	}


	public int getRet_price() {
		return ret_price;
	}


	public void setRet_price(int ret_price) {
		this.ret_price = ret_price;
	}


	public int getRece_price() {
		return rece_price;
	}


	public void setRece_price(int rece_price) {
		this.rece_price = rece_price;
	}


	public int getRece_ret_price() {
		return rece_ret_price;
	}


	public void setRece_ret_price(int rece_ret_price) {
		this.rece_ret_price = rece_ret_price;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "GoodPO [googid=" + goodid + ", pid=" + pid + ", name=" + name + ", type=" + type + ", num=" + num
				+ ", pur_price=" + pur_price + ", ret_price=" + ret_price + ", rece_price=" + rece_price
				+ ", rece_ret_price=" + rece_ret_price + "]";
	}


	
    
    
}