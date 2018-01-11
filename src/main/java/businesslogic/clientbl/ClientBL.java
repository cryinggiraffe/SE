package businesslogic.clientbl;
import DataService.ClientDataService;
import PO.ClientPO;
import blService.ClientBLService;
import DataService.DataServiceImpl.ClientDataServiceImpl;

import java.sql.Time;
import java.util.Date;


public class ClientBL implements ClientBLService{
    private ClientDataServiceImpl cds=new ClientDataServiceImpl();
    public String newClient(ClientPO po){


        cds.insert(po);
        return po.getId();
    }
    public boolean updateClient(ClientPO po){
        cds.update(po);
        return true;

    }
    public String newId(){
        Date d=new Date();
        return String.valueOf(d.getTime());
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
        //po.setId("12344555");
        //String ids=cbl.newClient(po);
        //System.out.println(cbl.findClient(ids));


    }
}
