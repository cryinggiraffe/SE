package PO;

<<<<<<< HEAD
import java.io.Serializable;

public class GiftPO implements Serializable extends GoodPO {
    //把赠品信息发送给总经理
    public void sendToManager(){
        sendMessager();
    }
    //接受总经理的回复
    public String receiveFromManager(){
        return receiveMessage();
    }
}
=======
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
>>>>>>> 4b22ddbb451f9bd194035198cf09af136455b6c4
