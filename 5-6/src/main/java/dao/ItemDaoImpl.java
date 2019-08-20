package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;
@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private SqlSession session;
	
	public List<Item> findAll() {
		return session.selectList("mappers.myMapper.getItemList");
	}
	
	public Item findByPrimaryKey(Integer id) {
		return session.selectOne("mappers.myMapper.getItem",id);
	}
	
	public List<Item> findbyItemName(String name) {
		return session.selectList("mappers.myMapper.findItem",name);
	}
	
	public void create(Item item) {
		session.insert("mappers.myMapper.putItem",item);
	}

	
	public void update(Item item) {
		session.update("mappers.myMapper.updateItem",item);
	}

	
	public void delete(Integer item) {
		session.delete("mappers.myMapper.deleteItem",item);
	}

}
