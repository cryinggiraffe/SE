package PO;

public class PromotionPO implements Serializable {

    int giftId;
    String giftName;
    int giftcount;
    double discount;
    double cash;
    List<Integer> commodityId;

    Date begin;
    Date end;


    public PromotionPO(){
        super();
    }

    public void setGiftId(int giftId){
        this.giftId = giftId;
    }

    public int getGiftId(){
        return giftId;
    }

    public void setGiftName(String giftName){
        this.giftName = giftName;
    }

    public String getGiftName(){
        return giftName;
    }

    public void setGiftcount(int giftcount){
        this.giftcount = giftcount;
    }

    public String getGiftcount(){
        return giftcount;
    }

    public void setDiscount(int discount){
        this.discount = discount;
    }

    public String getDiscount(){
        return discount;
    }

    public void setCash(int Cash){
        this.cash = cash;
    }

    public String getCash(){
        return cash;
    }

    public void setCommodityId(int ...commodityId){
        for(int i = 0; i < commodity.size(); i++){
            commodityId.add(commityId[i]);
        }
    }

    public List<Integer> getCommodityId(){
        return commodityId;
    }

    public void setBegin(Date begin){
        this.begin = begin;
    }

    public Date getBegin(){
        return begin;
    }

    public void setEnd(Date end){
        this.end = end;
    }

    public Date end(){
        return end;
    }
}