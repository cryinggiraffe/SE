package DataService;

import java.util.List;

import PO.ClientPO;

public interface ClientDataService {
	
	public boolean insert(ClientPO clientPO);
	public boolean delete(String id);
	public boolean update(ClientPO clientPO);
	public ClientPO find(String id);
	public List<ClientPO> findAll();
	
}
