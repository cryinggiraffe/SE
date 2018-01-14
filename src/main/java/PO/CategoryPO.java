package PO;

import java.io.Serializable;

public class CategoryPO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String id;  //商品编号
	private String pid;
    private String name;
	
    public CategoryPO() {
		super();
		id="0";
		// TODO Auto-generated constructor stub
	}

	

	public CategoryPO(String id, String pid, String name) {
		super();
		this.id = id;
		this.pid = pid;
		this.name = name;
	}
	public CategoryPO(int id, int pid, String name) {
		super();
		this.id =String.valueOf(id) ;
		this.pid = pid;
		this.name = name;
	}
	public CategoryPO(int id, String name) {
		super();
		this.id =String.valueOf(id) ;
		this.pid =0;
		this.name = name;
	}

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
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