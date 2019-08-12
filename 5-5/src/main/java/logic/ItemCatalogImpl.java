package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Item;

@Service // Repository를 쓰려면 이 객체가 DB에 접근하는 객체를 써야한다.
public class ItemCatalogImpl implements ItemCatalog {
	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}

	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}

}
