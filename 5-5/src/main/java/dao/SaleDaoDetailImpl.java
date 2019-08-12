package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.SaleDetail;

@Repository
public class SaleDaoDetailImpl implements SaleDetailDao {

	@Autowired
	private SqlSession session;
	public void create(SaleDetail detail) {
		detail.setSaleId(detail.getSale().getSaleId());
		detail.setItemId(detail.getItem().getItemId());
		this.session.insert("mappers.myMapper.putSaleDetail",detail);

	}

}
