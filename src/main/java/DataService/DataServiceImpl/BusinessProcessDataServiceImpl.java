package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.BusinessProcessDataService;
import PO.CashPO;
import PO.GiftPO;
import PO.ImportFormPO;
import PO.LossPO;
import PO.OverflowPO;
import PO.PaymentPO;
import PO.ReceiptPO;
import PO.SaleFormPO;

public class BusinessProcessDataServiceImpl implements BusinessProcessDataService{

	SaleDataServiceImpl saleDataServiceImpl = new SaleDataServiceImpl();
	SaleCommodityDataServiceImpl saleCommodityDataServiceImpl = new SaleCommodityDataServiceImpl();
	
	@Override
	public List<SaleFormPO> findSaleFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForTime(begin, end);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleFormForType() {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForType();
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleFormForClient(String client) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForClient(client);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleFormForSalesman(String salesman) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForSalesman(salesman);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleFormForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForHouseWare(houseware);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	
	SaleReturnDataServiceImpl saleReturnDataServiceImpl = new SaleReturnDataServiceImpl();
	SaleReturnCommodityDataServiceImpl saleReturnCommodityDataServiceImpl = new SaleReturnCommodityDataServiceImpl();
	
	@Override
	public List<SaleFormPO> findSaleReturnFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForTime(begin, end);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleReturnFormForType() {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForType();
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleReturnFormForClient(String client) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForClient(client);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleReturnFormForSalesman(String salesman) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForSalesman(salesman);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findSaleReturnFormForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForHouseWare(houseware);
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	
	
	ImportDataServiceImpl importDataServiceImpl = new ImportDataServiceImpl();
	ImportCommodityDataServiceImpl importCommodityDataServiceImpl = new ImportCommodityDataServiceImpl();
	@Override
	public List<ImportFormPO> findImportFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForTime(begin, end);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	@Override
	public List<ImportFormPO> findImportFormForType() {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForType();
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	@Override
	public List<ImportFormPO> findImportFormForClient(String client) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForClient(client);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

//	@Override
//	public List<ImportFormPO> findImportFormForSalesman(String salesman) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<ImportFormPO> findImportFormForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForHouseWare(houseware);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	
	
	ImportReturnDataServiceImpl importReturnDataServiceImpl = new ImportReturnDataServiceImpl();
	ImportReturnCommodityDataServiceImpl ImportReturnCommodityDataServiceImpl = new ImportReturnCommodityDataServiceImpl();
	
	@Override
	public List<ImportFormPO> findImportReturnFormForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForTime(begin, end);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	
	@Override
	public List<ImportFormPO> findImportReturnFormForType() {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForType();
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	@Override
	public List<ImportFormPO> findImportReturnFormForClient(String client) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForClient(client);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

//	@Override
//	public List<ImportFormPO> findImportReturnFormForSalesman(String salesman) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<ImportFormPO> findImportReturnFormForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		List<ImportFormPO> importFormPOs = importDataServiceImpl.findForHouseWare(houseware);
		for(ImportFormPO importFormPO : importFormPOs){
			importFormPO.setImportcommoditylist(importCommodityDataServiceImpl.getForImportformId(importFormPO.getId()));
		}
		return importFormPOs;
	}

	
	
	PaymentDataServiceImpl paymentDataServiceImpl = new PaymentDataServiceImpl();
	@Override
	public List<PaymentPO> findPaymentForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return paymentDataServiceImpl.findForTime(begin, end);
	}

	
	@Override
	public List<PaymentPO> findPaymentForType() {
		// TODO Auto-generated method stub
		return paymentDataServiceImpl.findForType();
	}

	@Override
	public List<PaymentPO> findPaymentForClient(String client) {
		// TODO Auto-generated method stub
		return paymentDataServiceImpl.findForClient(client);
	}

	
	
	ReceiptDataServiceImpl receiptDataServiceImpl = new ReceiptDataServiceImpl();
	@Override
	public List<ReceiptPO> findReceiptForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return receiptDataServiceImpl.findForTime(begin, end);
	}

	@Override
	public List<ReceiptPO> findReceiptForType() {
		// TODO Auto-generated method stub
		return receiptDataServiceImpl.findForType();
	}

	@Override
	public List<ReceiptPO> findReceiptForClient(String client) {
		// TODO Auto-generated method stub
		return receiptDataServiceImpl.findForClient(client);
	}

	
	CashDataServiceImpl cashDataServiceImpl = new CashDataServiceImpl();
	@Override
	public List<CashPO> findCashForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return cashDataServiceImpl.findForTime(begin, end);
	}

	@Override
	public List<CashPO> findCashForType() {
		// TODO Auto-generated method stub
		return cashDataServiceImpl.findForType();
	}

	
	GiftDataServiceImpl giftDataServiceImpl = new GiftDataServiceImpl();
	@Override
	public List<GiftPO> findGiftForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return giftDataServiceImpl.findForTime(begin, end);
	}

	@Override
	public List<GiftPO> findGiftForType() {
		// TODO Auto-generated method stub
		return giftDataServiceImpl.findForType();
	}

	LossDataServiceImpl lossDataServiceImpl = new LossDataServiceImpl();
	@Override
	public List<LossPO> findLossForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return lossDataServiceImpl.findForTime(begin, end);
	}

	@Override
	public List<LossPO> findLossForType() {
		// TODO Auto-generated method stub
		return lossDataServiceImpl.findForType();
	}

	OverflowDataServiceImpl overflowDataServiceImpl = new OverflowDataServiceImpl();
	@Override
	public List<OverflowPO> findOverflowForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		return overflowDataServiceImpl.findForTime(begin, end);
	}

	@Override
	public List<OverflowPO> findOverflowForType() {
		// TODO Auto-generated method stub
		return overflowDataServiceImpl.findForType();
	}


}
