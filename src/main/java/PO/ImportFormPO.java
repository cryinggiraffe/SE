package PO;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ImportFormPO extends RecordPO implements Serializable {
    
	private static final long serialVersionUID = 1L;

    private String houseware;
    private List<Commodity> Importcommoditylist;
    private String remark;
    private double sum;
    private Date date;
	
    public ImportFormPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    public ImportFormPO(String id, String provider, String houseware, String operator,
			 String remark, double sum, String state, Date date) {
		super();
		this.id = id;
		this.client = provider;
		this.houseware = houseware;
		this.operator = operator;
		this.remark = remark;
		this.sum = sum;
		this.state = "no";
		this.date = date;
	}

	
	public ImportFormPO(String id, String provider, String houseware, String operator,
			List<Commodity> importcommoditylist, String remark, double sum, String state, Date date) {
		super();
		this.id = id;
		this.client = provider;
		this.houseware = houseware;
		this.operator = operator;
		Importcommoditylist = importcommoditylist;
		this.remark = remark;
		this.sum = sum;
		this.state = state;
		this.date = date;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String provider) {
		this.client = provider;
	}

	public String getHouseware() {
		return houseware;
	}

	public void setHouseware(String houseware) {
		this.houseware = houseware;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}


	public List<Commodity> getImportcommoditylist() {
		return Importcommoditylist;
	}

	public void setImportcommoditylist(List<Commodity> importcommoditylist) {
		Importcommoditylist = importcommoditylist;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return  id + "," + client + "," + houseware + ","
				+ operator + "," + Importcommoditylist + "," + remark + "," + sum
				+ "," + state;
	}
	
    
    
}