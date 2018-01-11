package businesslogic.approvebl;
import DataService.MessageDataService;
import PO.Message;
import  blService.MessageBLService;
import DataService.DataServiceImpl.MessageDataServiceImpl;
public class MessageBL  implements  MessageBLService{
    private MessageDataService ms=new MessageDataServiceImpl();

    @Override
    public boolean newMessage(String s) {
        return ms.insert(s);
    }

    @Override
    public Message getMessage() {
        return ms.get();
    }
    public static void main(String[] agrs){
        MessageBL mbl=new MessageBL();
        mbl.newMessage("hellow world");
        System.out.println(mbl.getMessage());

    }
}
