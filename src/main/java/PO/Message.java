package PO;

public class Message implements Serializable {

    int messageId;
    String message;

    public UserPO(int messageId,String message){
        this.messageId = messageId;
        this.password = message;
    }

    public int getMessageId(){
        return username;
    }

    public String getMessage(){
        return password;
    }
}