package PO;

import java.io.Serializable;

public class GoodPO implements Serializable {
    int id;
    String name;
    String type;
    int num;
    int pur_price;
    int ret_price;
    int rece_price;
    int rece_ret_price;

    public GoodPO(String name, String type, int num, int pur_price, int ret_price, int rece_price, int rece_ret_price){
        this.name = name;
        this.type = type;
        this.num = num;
        this.pur_price = pur_price;
        this.ret_price = rece_price;
        this.rece_ret_price = rece_ret_price;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getNum(){
        return num;
    }
    public int getPur_price(){
        return pur_price;
    }
    public int getRet_price(){
        return ret_price;
    }
    public int getRece_ret_price(){
        return rece_ret_price;
    }
}