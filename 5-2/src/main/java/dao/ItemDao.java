package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findByPrimaryKey(Integer itemId);
}
