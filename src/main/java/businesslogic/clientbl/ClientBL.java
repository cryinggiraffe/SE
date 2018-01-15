package businesslogic.clientbl;
import DataService.ClientDataService;
import PO.ClientPO;
import blService.ClientBLService;
import DataService.DataServiceImpl.ClientDataServiceImpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    public List<String> listIds(){
        List<ClientPO> pos=cds.findAll();
        List<String> res=new ArrayList<>();
        for(int i=0;i!=pos.size();i++){
            res.add(pos.get(i).getId());
        }
        return res;
    }


    public static void main(String[] agrs){
        ClientBL cbl=new ClientBL();
        ClientPO po=new ClientPO();
        //po.setId("12344555");
        //String ids=cbl.newClient(po);
        //System.out.println(cbl.findClient(ids));


    }
}
