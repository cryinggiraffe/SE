package PO;

public class Message {
	
	private int id; //自动+1
	private String message;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String message) {
		super();
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}
	
	
}
