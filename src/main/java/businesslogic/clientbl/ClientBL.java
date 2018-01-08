package businesslogic.clientbl;
import DataService.ClientDataService;
import PO.ClientPO;
import blService.ClientBLService;
import DataService.DataServiceImpl.ClientDataServiceImpl;

public class ClientBL implements ClientBLService{
    private ClientDataServiceImpl cds=new ClientDataServiceImpl();
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

        return cds.find(id);
    }
    public static void main(String[] agrs){
        ClientBL cbl=new ClientBL();
        ClientPO po=new ClientPO();
        po.setId("12344555");
        //cbl.newClient(po);

        System.out.println(cbl.findClient(po.getId()).toString());
    }
}
