package PO;

public class BillPO implements Serializable {
    String id;
    String operator;
    BillList list;
    double total;

    public BillPO(String id, String operator, BillList list, double total){
        this.id = id;
        this.operator = operator();
        this.list = list
        this.total = total;
    }

    public double getTotal(){
        return total;
    }

    public String getId(){
        return id;
    }

    public String getOperator(){
        return operator;
    }

}