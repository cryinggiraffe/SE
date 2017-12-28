package PO;

import java.io.Serializable;

public class GiftPO implements Serializable extends GoodPO {
    //把赠品信息发送给总经理
    public void sendToManager(){
        sendMessager();
    }
    //接受总经理的回复
    public String receiveFromManager(){
        return receiveMessage();
    }
}