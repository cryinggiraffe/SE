package PO;

import java.io.Serializable;
public class CategoryPO implements Serializable {
    int id;
    String name;

    public CategoryPO(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
}