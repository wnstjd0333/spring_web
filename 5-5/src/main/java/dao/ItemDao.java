package dao;

import java.util.List;

import model.Item;
//DAO : 데이터베이스에서 값을 꺼내와 적절한 값으로 반환해주는 계층
//인터페이스로 구성시 장점 : 확장성과 유연성이 좋아진다.
//DAO 추후 연동할 데이터베이스에 세션 및 Mybatis코드가 적용된다.
//Service에 의해 호출되어 처리결과를 Service에게 반환한다.
public interface ItemDao {
	List<Item> findAll();
	Item findByPrimaryKey(Integer itemId);
}
