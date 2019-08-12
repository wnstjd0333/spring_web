package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository//객체 주입, 객체의 값을 보증해주기 위해 도메인 내부에서 데이터베이스와 소통하는 객체
public class ItemDaoImpl implements ItemDao {
	@Autowired //자동 주입, 세터 필요x, 속성 주입
	private SqlSession session;
	
	public List<Item> findAll() {
		List<Item> list=session.selectList("mappers.myMapper.getItemList");
		return list;
	}

	public Item findByPrimaryKey(Integer itemId) {
		Item item = session.selectOne("mappers.myMapper.getItem",itemId);
		return item;
	}

}
