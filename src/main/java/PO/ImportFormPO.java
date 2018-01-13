package PO;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ImportFormPO implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String provider;//供应商id
    private String houseware;
    private String operator;//操作员
    private List<Commodity> Importcommoditylist;
    private String remark;
    private double sum;
    private String state;
    private Date date;
	
    public ImportFormPO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    public ImportFormPO(String id, String provider, String houseware, String operator,
			 String remark, double sum, String state, Date date) {
		super();
		this.id = id;
		this.provider = provider;
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
		this.provider = provider;
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

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
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
		return "ImportFormPO [id=" + id + ", provider=" + provider + ", houseware=" + houseware + ", operator="
				+ operator + ", Importcommoditylist=" + Importcommoditylist + ", remark=" + remark + ", sum=" + sum
				+ ", state=" + state + "]";
	}
	
    
    
}