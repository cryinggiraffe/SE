package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.SaleDataService;
import JDBC.DAO;
import PO.Commodity;
import PO.SaleFormPO;

public class SaleDataServiceImpl implements SaleDataService{

	DAO<SaleFormPO> dao = new DAO<>();
	SaleCommodityDataServiceImpl saleCommodityDataServiceImpl = new SaleCommodityDataServiceImpl();
	
	@Override
	public boolean insert(SaleFormPO saleFormPO) {
		// TODO Auto-generated method stub
		String sql = "insert into SaleForm values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return dao.update(sql, saleFormPO.getId(), saleFormPO.getClient(), saleFormPO.getOperator(), 
				               saleFormPO.getSalesman(), saleFormPO.getHouseware(), saleFormPO.getTpbfDiscounting(),
				               saleFormPO.getTpafDiscounting(), saleFormPO.getDiscount(), saleFormPO.getVoucher(),
				               saleFormPO.getRemark(), saleFormPO.getState(), saleFormPO.getDate());
	}

	@Override
	public boolean update(SaleFormPO saleFormPO) {
		// TODO Auto-generated method stub
		String sql = "update SaleForm set client = ?, operator = ?, salesman = ?, houseware = ?, "
		   + " tpbfDiscounting = ? ,tpafDiscounting = ?, discount = ?, voucher = ?,  remark = ?, "
		   + " state = ?, date = ?  where id = ?";
		return dao.update(sql, saleFormPO.getClient(), saleFormPO.getOperator(), 
	               saleFormPO.getSalesman(), saleFormPO.getHouseware(), saleFormPO.getTpbfDiscounting(),
	               saleFormPO.getTpafDiscounting(), saleFormPO.getDiscount(), saleFormPO.getVoucher(),
	               saleFormPO.getRemark(), saleFormPO.getState(), saleFormPO.getDate(), saleFormPO.getId());
	}

	@Override
	public SaleFormPO find(String id) {
		// TODO Auto-generated method stub
		List<Commodity> commodities = saleCommodityDataServiceImpl.getForSaleformId(id);
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date from SaleForm where id = ?";
		SaleFormPO saleFormPO = dao.get(SaleFormPO.class, sql, id);
		saleFormPO.setCommodityList(commodities);
		return saleFormPO;
	}

	@Override
	public List<SaleFormPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date from SaleForm where state = ?";
		return dao.getALL(SaleFormPO.class, sql, "no");
	}

	@Override
	public List<SaleFormPO> findForState_Commities() {
		// TODO Auto-generated method stub
		SaleDataServiceImpl saleDataServiceImpl = new SaleDataServiceImpl();
		List<SaleFormPO> saleFormPOs = saleDataServiceImpl.findForState();
		
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
					+ " from SaleForm where date >= ? and date <= ?";
		return dao.getALL(SaleFormPO.class, sql, begin, end);
	}

	@Override
	public List<SaleFormPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleForm";
		return dao.getALL(SaleFormPO.class, sql);
	}

	@Override
	public List<SaleFormPO> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleForm where client = ?";
		return dao.getALL(SaleFormPO.class, sql, client);
	}

	@Override
	public List<SaleFormPO> findForSalesman(String salesman) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleForm where salesman = ?";
		return dao.getALL(SaleFormPO.class, sql, salesman);
	}

	@Override
	public List<SaleFormPO> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
		+ " from SaleForm where houseware = ?";
		return dao.getALL(SaleFormPO.class, sql, houseware);
	}

}
