package PO;

public class OverflowPO {
    private int goodId;
    private int num;
    OverflowPO(int goodId,int num){
        this.goodId=goodId;
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getGoodId() {
        return goodId;
    }
}
