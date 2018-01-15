package DataService.DataServiceImpl;

import java.util.List;

import DataService.PromotionDataService;
import JDBC.DAO;
import PO.PromotionPO;

public class CommodityPromotionDataServiceImpl implements PromotionDataService{

	DAO<PromotionPO> dao = new DAO<>();
	
	@Override
	public boolean insert(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO CommodityPromotion VALUES(?,?,?,?)";
		return dao.update(sql,promotionPO.getId(), promotionPO.getSpecialgoodname1(), promotionPO.getSpecialgoodname2(), promotionPO.getDiscountprice());
		
	}

	@Override
	public boolean delete(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "delete from CommodityPromotion where id = ?";
		return dao.update(sql, promotionPO.getId());
	}

	@Override
	public boolean update(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "update CommodityPromotion set specialname1 = ?, specialname2 = ?, discountprice = ?"
						+ " where id = ?";
		return dao.update(sql, promotionPO.getSpecialgoodname1(), promotionPO.getSpecialgoodname2(), promotionPO.getDiscountprice(), promotionPO.getId());
	}

	@Override
	public List<PromotionPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from CommodityPromotion";
		return dao.getALL(PromotionPO.class, sql);
	}

}
