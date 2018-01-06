package PO;

public class PromotionPO {
	
	private int id;
	private int userclass;
	private String giftname;
	private int num;
	private double discount;
	private double cash_coupon;
	
	private String specialgoodname1;
	private String specialgoodname2;
	private double discountprice;
	
	public PromotionPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PromotionPO(int id, int userclass, String giftname, int num, double discount, double cash_coupon) {
		super();
		this.id = id;
		this.userclass = userclass;
		this.giftname = giftname;
		this.num = num;
		this.discount = discount;
		this.cash_coupon = cash_coupon;
	}
	
	public PromotionPO(int id, String specialgoodname1, String specialgoodname2, double discountprice){
		super();
		this.id = id;
		this.specialgoodname1 = specialgoodname1;
		this.specialgoodname2 = specialgoodname2;
		this.discountprice = discountprice;
	}
	
	public PromotionPO(int id, String giftname, int num, double cash_coupon) {
		super();
		this.id = id;
		this.giftname = giftname;
		this.num = num;
		this.cash_coupon = cash_coupon;
	}

	public String getGiftname() {
		return giftname;
	}

	public void setGiftname(String giftname) {
		this.giftname = giftname;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getCash_coupon() {
		return cash_coupon;
	}
	
	public void setCash_coupon(double cash_coupon) {
		this.cash_coupon = cash_coupon;
	}

	
	public int getUserclass() {
		return userclass;
	}

	public void setUserclass(int userclass) {
		this.userclass = userclass;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSpecialgoodname1() {
		return specialgoodname1;
	}

	public void setSpecialgoodname1(String specialgoodname1) {
		this.specialgoodname1 = specialgoodname1;
	}

	public String getSpecialgoodname2() {
		return specialgoodname2;
	}

	public void setSpecialgoodname2(String specialgoodname2) {
		this.specialgoodname2 = specialgoodname2;
	}

	public double getDiscountprice() {
		return discountprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDiscountprice(double discountprice) {
		this.discountprice = discountprice;
	}

	@Override
	public String toString() {
		return "PromotionPO [userclass=" + userclass + ", giftname=" + giftname + ", num=" + num + ", discount="
				+ discount + ", cash_coupon=" + cash_coupon + ", specialgoodname1=" + specialgoodname1
				+ ", specialgoodname2=" + specialgoodname2 + ", discountprice=" + discountprice + "]";
	}
	
	
}
