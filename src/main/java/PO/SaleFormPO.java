package PO;

import java.io.Serializable;
import java.util.ArrayList;

class SaleFormPO implements Serializable{
    private String id;
    private String client;//id
    private String operator;
    private String salesman;//业务员
    private String houseware;
    private ArrayList<Commodity> commodityList;
    private Double tpbfDiscounting;
    private Double tpafDiscounting;
    private Double discount;
    private Double voucher;//代金券
    private String remark;
    private int state;
    public String getId(){
        return this.id;
    };
    public String getClientId(){
        return this.client;
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
    public void setState(int newstate){
        this.state=newstate;
    }
}