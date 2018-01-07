package businesslogic.clientbl;
import DataService.ClientDataSerice;
import PO.ClientPO;
import blService.ClientBLService;
import DataService.DataServiceImpl.ClientDataSericeImpl;

public class ClientBL implements ClientBLService{
    private ClientDataSericeImpl cds=new ClientDataSericeImpl();
    public boolean newClient(ClientPO po){
        cds.insert(po);
        return true;
    }
    public boolean updateClient(ClientPO po){
        cds.update(po);
        return true;

    }

    public boolean deleteClient(String id){
        cds.delete(id);
        return true;
    }


    public ClientPO findClient(String id) {
        cds.find(id);
        return null;
    }
    public static void main(String[] agrs){
        ClientBL cbl=new ClientBL();
        ClientPO po=new ClientPO();
        po.setId("12344555");
        cbl.newClient(po);

        System.out.println(cbl.findClient(po.getId())==null);
    }
}
