package PO;

import java.io.Serializable;

public class CategoryPO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String id;  //商品编号
	private int pid;
    private String name;
	
    public CategoryPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CategoryPO(String id, int pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	@Override
	public String toString() {
		return "CategoryPO [id=" + id + ", pid=" + pid + ", name=" + name + "]";
	}

	

    
}