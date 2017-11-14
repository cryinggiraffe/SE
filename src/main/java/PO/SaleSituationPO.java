package PO;

public class SaleSituationPO implements Serializable {
    Date bengin;
    Date end;
    String Type;
    Customer customer;
    User user;
    int wareHouse;

    public SaleSituationPO(){
        super();
    }

    public SaleSituationPO(Date bengin, Date end,  String Type, Customer customer,User user,int wareHouse){
        bengin = this.begin;
        end = this.end;
        Type = this.Type;
        customer = this.customer;
        user = this.user;
        wareHouse = this.wareHouse;
    }

    public Date getBegin(){
        return bengin;
    }

    public void setBegin(Date begin){
        bengin = this.begin;
    }

    public Date getEnd(){
        return end;
    }

    public Date setEnd(Date end){
        end = this.end;
    }

    public String Type(){
        return Type;
    }

    public void setType(String Type){
        Type = this.Type;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        customer = this.customer;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        user = this.user;
    }

    public int getWareHouse(){
        return wareHouse;
    }

    public void setWareHouse(){
        wareHouse = this.wareHouse;
    }


}