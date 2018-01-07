package PO;

import java.io.Serializable;

public class ClientPO implements Serializable {
    
	
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String type;
    private int rank;
    private String name;
    private String phone;
    private String address;
    private String postnum;
    private String email;
    private double receive_limit;
    private double receive;
    private double send;
    private String defaultsalesman;
	
    public ClientPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ClientPO(String id, String type, int rank, String name, String phone, String address, String postnum,
			String email, double receive_limit, double receive, double send, String defaultsalesman) {
		super();
		this.id = id;
		this.type = type;
		this.rank = rank;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.postnum = postnum;
		this.email = email;
		this.receive_limit = receive_limit;
		this.receive = receive;
		this.send = send;
		this.defaultsalesman = defaultsalesman;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostnum() {
		return postnum;
	}

	public void setPostnum(String postnum) {
		this.postnum = postnum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public double getReceive_limit() {
		return receive_limit;
	}

	public void setReceive_limit(double receive_limit) {
		this.receive_limit = receive_limit;
	}

	public double getReceive() {
		return receive;
	}

	public void setReceive(double receive) {
		this.receive = receive;
	}

	public double getSend() {
		return send;
	}

	public void setSend(double send) {
		this.send = send;
	}

	public String getDefaultsalesman() {
		return defaultsalesman;
	}

	public void setDefaultsalesman(String defaultsalesman) {
		this.defaultsalesman = defaultsalesman;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClientPO [id=" + id + ", type=" + type + ", rank=" + rank + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", postnum=" + postnum + ", email=" + email + ", receive_limit="
				+ receive_limit + ", receive=" + receive + ", send=" + send + ", defaultsalesman=" + defaultsalesman
				+ "]";
	}
    
	
    
}