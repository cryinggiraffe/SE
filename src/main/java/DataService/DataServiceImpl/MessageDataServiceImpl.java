package DataService.DataServiceImpl;

import DataService.MessageDataService;
import JDBC.DAO;
import PO.Message;

public class MessageDataServiceImpl implements MessageDataService{

	DAO<Message> dao = new DAO<>();
	@Override
	public boolean insert(String message) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Message(message) VALUES(?)";
		return dao.update(sql, message);
	}

	@Override
	public Message get() {
		// TODO Auto-generated method stub
		String sql = "select * from Message where id = (select max(id) from Message)";
		return dao.get(Message.class, sql);
	}

}
