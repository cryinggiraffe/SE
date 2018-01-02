package PO;

//赠品单
public class GiftList {
	
	private int id;
	
	private String status; //赠单状态

	public GiftList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftList(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GiftList [id=" + id + ", status=" + status + "]";
	}
	
	
}
