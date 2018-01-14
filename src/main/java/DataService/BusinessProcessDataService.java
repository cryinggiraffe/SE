package DataService;

import java.sql.Date;
import java.util.List;

import PO.CashPO;
import PO.ImportFormPO;
import PO.PaymentPO;
import PO.ReceiptPO;
import PO.SaleFormPO;


public interface BusinessProcessDataService {
	
	public List<SaleFormPO> findSaleFormForTime(Date begin, Date end);
	public List<SaleFormPO>	findSaleFormForType(); //单据类型，可以根据单据编号的前几位进行判断，然后传入单据编号进行查询
	public List<SaleFormPO> findSaleFormForClient(String client);
	public List<SaleFormPO> findSaleFormForSalesman(String salesman);
	public List<SaleFormPO> findSaleFormForHouseWare(String houseware);
	
	
	public List<SaleFormPO> findSaleReturnFormForTime(Date begin, Date end);
	public List<SaleFormPO>	findSaleReturnFormForType();
	public List<SaleFormPO> findSaleReturnFormForClient(String client);
	public List<SaleFormPO> findSaleReturnFormForSalesman(String salesman);
	public List<SaleFormPO> findSaleReturnFormForHouseWare(String houseware);
	
	
	public List<ImportFormPO> findImportFormForTime(Date begin, Date end);
	public List<ImportFormPO> findImportFormForType(); //单据类型，可以根据单据编号的前几位进行判断，然后传入单据编号进行查询
	public List<ImportFormPO> findImportFormForClient(String client);
//	public List<ImportFormPO> findImportFormForSalesman(String salesman);
	public List<ImportFormPO> findImportFormForHouseWare(String houseware);
	
	
	public List<ImportFormPO> findImportReturnFormForTime(Date begin, Date end);
	public List<ImportFormPO> findImportReturnFormForType(); //单据类型，可以根据单据编号的前几位进行判断，然后传入单据编号进行查询
	public List<ImportFormPO> findImportReturnFormForClient(String client);
//	public List<ImportFormPO> findImportReturnFormForSalesman(String salesman);
	public List<ImportFormPO> findImportReturnFormForHouseWare(String houseware);
	
	
	public List<PaymentPO> findPaymentForTime(Date begin, Date end);
	public List<PaymentPO> findPaymentForType();
	public List<PaymentPO> findPaymentForClient(String client);
	
	
	public List<ReceiptPO> findReceiptForTime(Date begin, Date end);
	public List<ReceiptPO> findReceiptForType();
	public List<ReceiptPO> findReceiptForClient(String client);
	
	
	public List<CashPO> findCashForTime(Date begin, Date end);
	public List<CashPO> findCashForType();
	
}
