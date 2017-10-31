package PO;

import java.io.Serializable;

class Commodity implements Serializable {
    public String goodid;
    public String name;
    public String version;//型号
    public int quantity;
    public Double pirce;//单价
    public Double subtotalprice;
    public String remark;
}