package DataService.DataServiceImpl;

import DataService.ClientDataService;
import JDBC.DAO;
import PO.ClientPO;

public class ClientDataServiceImpl implements ClientDataService{

	DAO<ClientPO> dao = new DAO<>();
	@Override
	public boolean insert(ClientPO clientPO) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Client VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		return dao.update(sql, clientPO.getId(), clientPO.getType(), clientPO.getRank(), 
				               clientPO.getName(), clientPO.getPhone(), clientPO.getAddress(), 
				               clientPO.getPostnum(), clientPO.getEmail(), clientPO.getReceive_limit(),
				               clientPO.getReceive(),clientPO.getSend(), clientPO.getDefaultsalesman());
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from Client where id = ?";
		return dao.update(sql, id);
	}

	@Override
	public boolean update(ClientPO clientPO) {
		// TODO Auto-generated method stub
		String sql = "update Client set type = ?, rank = ?, name = ?, phone = ?, address = ?, postnum = ?, "
				+ "email = ?, receive_limit = ? , receive = ? ,send = ? , defaultsalesman = ? "
				+ " where id = ?";
		return dao.update(sql, clientPO.getType(), clientPO.getRank(), clientPO.getName(), 
					           clientPO.getPhone(), clientPO.getAddress(), clientPO.getPostnum(), clientPO.getEmail(), 
					           clientPO.getReceive_limit(),clientPO.getReceive(),clientPO.getSend(), clientPO.getDefaultsalesman(),
	               			   clientPO.getId());
	}

	@Override
	public ClientPO find(String id) {
		// TODO Auto-generated method stub
		String sql = "select * from Client where id = ?";
		
		return dao.get(ClientPO.class, sql, id);
	}

}
