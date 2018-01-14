package PO;

public class LossPO {

    private int goodId;
    private int num;
    LossPO(int goodId,int num){
        this.goodId=goodId;
        this.num=num;
    }

    public int getGoodId() {
        return goodId;
    }

    public int getNum() {
        return num;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
