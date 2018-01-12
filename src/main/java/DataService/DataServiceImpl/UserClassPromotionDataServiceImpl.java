package DataService.DataServiceImpl;

import java.util.List;

import DataService.PromotionDataService;
import JDBC.DAO;
import PO.PromotionPO;

public class UserClassPromotionDataServiceImpl implements PromotionDataService{

	DAO<PromotionPO> dao = new DAO<>();
	@Override
	public boolean insert(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO UserClassPromotion VALUES(?,?,?,?,?,?)";
		return dao.update(sql,promotionPO.getId(), promotionPO.getUserclass(), promotionPO.getGiftname(), promotionPO.getNum(), promotionPO.getDiscount(), promotionPO.getCash_coupon());
	}

	@Override
	public boolean delete(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "delete from UserClassPromotion where id = ?";
		return dao.update(sql, promotionPO.getId());
	}

	@Override
	public boolean update(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql = "update UserClassPromotion set userclass = ?, giftname = ?, num = ?, discount = ?, cash_coupon = ?"
						+ " where id = ?";
		return dao.update(sql, promotionPO.getUserclass(), promotionPO.getGiftname(), promotionPO.getNum(), promotionPO.getDiscount(), promotionPO.getCash_coupon(), promotionPO.getId());
	}

	@Override
	public List<PromotionPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from UserClassPromotion";
		return dao.getALL(PromotionPO.class, sql);
	}

}
