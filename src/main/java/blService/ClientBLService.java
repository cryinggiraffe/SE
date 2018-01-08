package blService;

import PO.ClientPO;

public interface ClientBLService {
    boolean newClient(ClientPO po);
    boolean deleteClient(String id);
    boolean updateClient(ClientPO po);
    ClientPO findClient(String id);

}
