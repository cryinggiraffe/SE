package Dataservice.DataServiceImpl;

import java.util.List;

import Dataservice.PromotionDataService;
import JDBC.DAO;
import PO.PromotionPO;

public class UserClassPromotionDataServiceImpl implements PromotionDataService{

	DAO<PromotionPO> dao = new DAO<>();
	@Override
	public boolean insert(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		String sql ="INSERT INTO UserClassPromotion VALUES(?,?,?,?,?)";
		return dao.update(sql, promotionPO.getUserclass(), promotionPO.getGiftname(), promotionPO.getNum(), promotionPO.getDiscount(), promotionPO.getCash_coupon());
	}

	@Override
	public boolean delete(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PromotionPO promotionPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PromotionPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from UserClassPromotion";
		return dao.getALL(PromotionPO.class, sql);
	}

}
