package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findByPrimaryKey(Integer id); //특정 상품만 검색
	List<Item> findbyItemName(String name); //이름으로 상품 검색
	void create(Item item);
	void update(Item item);
	void delete(Integer id);
}
