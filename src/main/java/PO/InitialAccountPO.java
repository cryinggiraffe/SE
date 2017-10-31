package PO;

public class InitialAccountPO implements Serializable {
    Commodity commodity;
    double importPrice;
    double exportPrice;
    Customer customer;
    Account account;

    public InitialAccountPO(Commodity commodity, double importPrice, double exportPrice, Customer customer, Account account){
        this.commodity = commodity;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.customer = customer;
        this.account = account;
    }

    public Commodity getCommodity(){
        return commodity;
    }

    public double getImportPrice(){
        return importPrice;
    }

    public double getExportPrice(){
        return exportPrice;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Customer getAccount(){
        return account;
    }


}