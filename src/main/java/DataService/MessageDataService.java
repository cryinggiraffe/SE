package DataService;

import PO.Message;

public interface MessageDataService {
	
	public boolean insert(String message);
	public Message get();
}
