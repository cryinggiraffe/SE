package PO;

public class ViewPO implements Serializable extends GoodPO {

    public list get_Period_Message(Period period){
    /*period_message()的返回值是包含了该时间段内的出库数量及金额，入库数量及金额，销售数量及金额，进货数量及金额，库存数量的合的列表*/
        return period_message();
    }

    public list get_Today_Message(){
    /*today_message()的返回值是包含了当天各种商品的名称、型号、库存数量、库存均价、批次、批号、出场日期的列表*/
        return today_message();
    }
}