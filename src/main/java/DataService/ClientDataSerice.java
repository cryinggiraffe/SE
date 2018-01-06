package DataService;

import PO.ClientPO;

public interface ClientDataSerice {
	
	public boolean insert(ClientPO clientPO);
	public boolean delete(String id);
	public boolean update(ClientPO clientPO);
	public ClientPO find(String id);
	
}
