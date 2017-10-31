package PO;

import java.io.Serializable;

class ClientPO implements Serializable {
    private String id;
    private String type;
    private int rank;
    private String name;
    private String phone;
    private String address;
    private int postnum;
    private String email;
    private Double receive;
    private Double send;
    private String defaultsalesman;
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhone(String np){
        this.phone=np;
    }
    public Double getReceive(){
        return this.receive;
    }
    public void setReceive(Double n){
        this.receive=n;
    }
    public void setSend(Double n){
        this.send=n;
    }
    public Double getSend(){
        return send;
    }
}