package DataService.DataServiceImpl;

import java.sql.Date;
import java.util.List;

import DataService.SaleSituationDataService;
import JDBC.DAO;
import PO.SaleSituationPo;

public class SaleSituationDataServiceImpl implements SaleSituationDataService{

	
	DAO<SaleSituationPo> dao = new DAO<>();
	@Override
	public List<SaleSituationPo> findForTime(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql = "select date, name, version, quantity, price, subtotalprice from SaleForm,SaleCommodity where "
				+ " SaleCommodity.saleformid = SaleForm.id and date >=? and date <= ?";
		return dao.getALL(SaleSituationPo.class, sql, begin, end);
	}

	@Override
	public List<SaleSituationPo> findForName(String name) {
		// TODO Auto-generated method stub
		String sql = "select date, name, version, quantity, price,subtotalprice from SaleForm,SaleCommodity where "
				+ " SaleCommodity.saleformid = SaleForm.id and SaleCommodity.name = ?";
		return dao.getALL(SaleSituationPo.class, sql, name);
	}

	@Override
	public List<SaleSituationPo> findForClient(String client) {
		// TODO Auto-generated method stub
		String sql = "select date, name, version, quantity, price,subtotalprice from SaleForm,SaleCommodity where "
				+ " SaleCommodity.saleformid = SaleForm.id and client = ?";
		return dao.getALL(SaleSituationPo.class, sql, client);
	}

	@Override
	public List<SaleSituationPo> findForSalesman(String salesman) {
		// TODO Auto-generated method stub
		String sql = "select date, name, version, quantity, price,subtotalprice from SaleForm,SaleCommodity where "
				+ " SaleCommodity.saleformid = SaleForm.id and salesman = ?";
		return dao.getALL(SaleSituationPo.class, sql, salesman);
	}

	@Override
	public List<SaleSituationPo> findForHouseWare(String houseware) {
		// TODO Auto-generated method stub
		String sql = "select date, name, version, quantity, price,subtotalprice from SaleForm,SaleCommodity where "
				+ " SaleCommodity.saleformid = SaleForm.id and houseware = ?";
		return dao.getALL(SaleSituationPo.class, sql, houseware);
	}

}
