package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.SaleReturnDataService;
import JDBC.DAO;
import PO.Commodity;
import PO.SaleFormPO;

public class SaleReturnDataServiceImpl implements SaleReturnDataService{

	DAO<SaleFormPO> dao = new DAO<>();
	SaleReturnCommodityDataServiceImpl saleReturnCommodityDataServiceImpl = new SaleReturnCommodityDataServiceImpl();
	@Override
	public boolean insert(SaleFormPO saleFormPO) {
		// TODO Auto-generated method stub
		String sql = "insert into SaleReturnForm values(?,?,?,?,?,?,?,?,?,?,?,?)";
		return dao.update(sql, saleFormPO.getId(), saleFormPO.getClient(), saleFormPO.getOperator(), 
				               saleFormPO.getSalesman(), saleFormPO.getHouseware(), saleFormPO.getTpbfDiscounting(),
				               saleFormPO.getTpafDiscounting(), saleFormPO.getDiscount(), saleFormPO.getVoucher(),
				               saleFormPO.getRemark(), saleFormPO.getState(), saleFormPO.getDate());
	}

	@Override
	public boolean update(SaleFormPO saleFormPO) {
		// TODO Auto-generated method stub
		String sql = "update SaleReturnForm set state = ? where id = ?";
		return dao.update(sql, "yes", saleFormPO.getId());
		
	}

	@Override
	public SaleFormPO find(String id) {
		// TODO Auto-generated method stub
		List<Commodity> commodities = saleReturnCommodityDataServiceImpl.getForSaleformId(id);
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date from SaleReturnForm where id = ?";
		SaleFormPO saleFormPO = dao.get(SaleFormPO.class, sql, id);
		saleFormPO.setCommodityList(commodities);
		return saleFormPO;
		
	}

	@Override
	public List<SaleFormPO> findForState() {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date from SaleReturnForm where state = ?";
		return dao.getALL(SaleFormPO.class, sql, "no");
	}

	@Override
	public List<SaleFormPO> findForState_Commities() {
		// TODO Auto-generated method stub
		SaleReturnDataServiceImpl saleReturnDataServiceImpl = new SaleReturnDataServiceImpl();
		List<SaleFormPO> saleFormPOs = saleReturnDataServiceImpl.findForState();
		
		for(SaleFormPO saleFormPO : saleFormPOs){
			saleFormPO.setCommodityList(saleReturnCommodityDataServiceImpl.getForSaleformId(saleFormPO.getId()));
		}
		return saleFormPOs;
	}

	@Override
	public List<SaleFormPO> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date from SaleReturnForm "
				+ " where date >= ? and date <= ?";
		return dao.getALL(SaleFormPO.class, sql, begin, end);
	}

	@Override
	public List<SaleFormPO> findForType() {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleReturnForm";
		return dao.getALL(SaleFormPO.class, sql);
	}

	@Override
	public List<SaleFormPO> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleReturnForm where client = ?";
		return dao.getALL(SaleFormPO.class, sql, client);
	}

	@Override
	public List<SaleFormPO> findForSalesman(String salesman) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
				+ " from SaleReturnForm where salesman = ?";
		return dao.getALL(SaleFormPO.class, sql, salesman);
	}

	@Override
	public List<SaleFormPO> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		String sql = "select id, client, operator, salesman, houseware,tpbfDiscounting,tpafDiscounting, discount, voucher, remark, state, date "
		+ " from SaleReturnForm where houseware = ?";
		return dao.getALL(SaleFormPO.class, sql, houseware);
	}

}
