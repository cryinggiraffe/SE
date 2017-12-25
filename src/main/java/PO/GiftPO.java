package PO;

public class GiftPO {
	
	private int id;
	private String name;
	private double price;
	private int num;
	private int GiftListId; //赠单类型
	
	public GiftPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftPO(int id, String name, double price, int num, int giftListId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
		GiftListId = giftListId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getGiftListId() {
		return GiftListId;
	}

	public void setGiftListId(int giftListId) {
		GiftListId = giftListId;
	}

	@Override
	public String toString() {
		return "GiftPO [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + ", GiftListId="
				+ GiftListId + "]";
	}
	
	
	
}
