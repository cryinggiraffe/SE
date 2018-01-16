package businesslogic.businessProcessbl;
import DataService.DataServiceImpl.BusinessProcessDataServiceImpl;
import PO.*;

import java.util.Date;
import java.util.List;

public class BusinessProcessbl {
    private BusinessProcessDataServiceImpl bpds=new BusinessProcessDataServiceImpl();
    public List<SaleFormPO> findSaleFormForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findSaleFormForTime(begin,end);

    }
    public List<SaleFormPO> findSaleFormForType() {
        return bpds.findSaleFormForType();
    }
    public List<SaleFormPO> findSaleFormForClient(String client) {
        return bpds.findSaleFormForClient(client);
    }
    public List<SaleFormPO> findSaleFormForSalesman(String salesman) {
        return bpds.findSaleFormForSalesman(salesman);
    }
    public List<SaleFormPO> findSaleFormForHouseWare(String houseware) {
        return bpds.findSaleFormForHouseWare(houseware);
    }
    public List<SaleFormPO> findSaleReturnFormForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findSaleReturnFormForTime(begin,end);
    }
    public List<SaleFormPO> findSaleReturnFormForType() {
        return bpds.findSaleReturnFormForType();
    }
    public List<SaleFormPO> findSaleReturnFormForClient(String client){
        return bpds.findSaleReturnFormForClient(client);
    }
    public List<SaleFormPO> findSaleReturnFormForSalesman(String salesman){
        return bpds.findSaleReturnFormForSalesman(salesman);
    }
    List<SaleFormPO> findSaleReturnFormForHouseWare(String houseware){
        return bpds.findSaleReturnFormForHouseWare(houseware);
    }
    public List<ImportFormPO> findImportFormForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findImportFormForTime(begin,end);
    }
    public List<ImportFormPO> findImportFormForType(){
        return bpds.findImportFormForType();
    }
    public List<ImportFormPO> findImportFormForClient(String client){
        return bpds.findImportFormForClient(client);
    }
    public List<ImportFormPO> findImportFormForHouseWare(String houseware){
        return findImportFormForHouseWare(houseware);
    }
    public List<ImportFormPO> findImportReturnFormForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findImportReturnFormForTime(begin,end);
    }
    public List<ImportFormPO> findImportReturnFormForType(){
        return bpds.findImportReturnFormForType();
    }
    public List<ImportFormPO> findImportReturnFormForClient(String client){
        return bpds.findImportReturnFormForClient(client);
    }
    public List<ImportFormPO> findImportReturnFormForHouseWare(String houseware){
        return bpds.findImportReturnFormForHouseWare(houseware);
    }
    public List<PaymentPO> findPaymentForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findPaymentForTime(begin,end);
    }
    public List<PaymentPO> findPaymentForType(){
        return bpds.findPaymentForType();
    }
    public List<PaymentPO> findPaymentForClient(String client){
        return bpds.findPaymentForClient(client);
    }
    public List<ReceiptPO> findReceiptForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findReceiptForTime(begin,end);
    }
    public List<ReceiptPO> findReceiptForType(){
        return bpds.findReceiptForType();
    }
    public List<ReceiptPO> findReceiptForClient(String client){
        return bpds.findReceiptForClient(client);
    }
    public List<CashPO> findCashForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findCashForTime(begin,end);
    }
    public List<CashPO> findCashForType(){
        return bpds.findCashForType();
    }
    public List<GiftPO> findGiftForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findGiftForTime(begin,end);
    }
    public List<GiftPO> findGiftForType(){
        return bpds.findGiftForType();
    }
    public List<LossPO> findLossForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findLossForTime(begin,end);
    }
    public List<LossPO> findLossForType() {
        return bpds.findLossForType();
    }
    public List<OverflowPO> findOverflowForTime(Date tbegin, Date tend){
        java.sql.Date begin=new java.sql.Date(tbegin.getTime());
        java.sql.Date end=new java.sql.Date(tend.getTime());
        return bpds.findOverflowForTime(begin,  end);
    }
    public List<OverflowPO> findOverflowForType(){
        return bpds.findOverflowForType();
    }
}

