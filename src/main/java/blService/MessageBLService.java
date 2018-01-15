package blService;

import PO.Message;

public interface MessageBLService {
    boolean newMessage(String s);
    Message getMessage();
}
