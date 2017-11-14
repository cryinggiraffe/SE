package PO;

import java.io.Serializable;
import java.util.ArrayList;

class ImportFormPO implements Serializable {
    private String id;
    private String provider;//供应商id
    private String houseware;
    private String operator;//操作员
    private ArrayList<Commodity> commodityList;
    private String remark;
    private Double totalPrice;
    private int state;
    public String getId(){
        return this.id;
    };
    public String getClientId(){
        return this.id;
    }
    public String getOperator(){
        return this.operator;
    }
    public ArrayList<Commodity> getCommodityList(){
        return this.commodityList;
    }
    public int getState(){
        return this.state;
    }
    public void setState(int nwstate){
        this.state=nwstate;
    }
}