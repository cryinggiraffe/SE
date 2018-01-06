package PO;

import java.io.Serializable;

public class SupervisePO implements Serializable {
    int id;
    String name;
    int num;

    public SupervisePO(int id, String name, int num){
        this.id = id;
        this.name = name;
        this.num = num;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getNum(){
        return num;
    }

}