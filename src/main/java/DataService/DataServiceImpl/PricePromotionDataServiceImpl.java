package DataService.DataServiceImpl;

import java.util.List;

import JDBC.DAO;
import PO.PromotionPO;
import DataService.PromotionDataService;

public class PricePromotionDataServiceImpl implements PromotionDataService{

	DAO<PromotionPO> dao = new DAO<>();
	@Override
	public boolean insert(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO PricePromotion VALUES(?,?,?,?)";
		return dao.update(sql,promotionPO.getId(), promotionPO.getGiftname(), promotionPO.getNum(), promotionPO.getCash_coupon());
	
	}

	@Override
	public boolean delete(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "delete from PricePromotion where id = ?";
		return dao.update(sql, promotionPO.getId());
	}

	@Override
	public boolean update(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "PricePromotion set giftname = ?, num = ?, cash_coupon = ?"
				   + " where id = ?";
		return dao.update(sql, promotionPO.getGiftname(), promotionPO.getNum(), promotionPO.getCash_coupon(), promotionPO.getId());
	}

	@Override
	public List<PromotionPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from PricePromotion";
		return dao.getALL(PromotionPO.class, sql);
	}

}
