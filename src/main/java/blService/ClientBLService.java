package blService;

import PO.ClientPO;

import java.util.List;

public interface ClientBLService {
    String newClient(ClientPO po);
    boolean deleteClient(String id);
    boolean updateClient(ClientPO po);
    ClientPO findClient(String id);
    String newId();
    List<String> listIds();
}
