package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Item;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemList() {
		return itemDao.findAll();
	}
	
	public Item getItembyItemId(Integer id) {
		return itemDao.findByPrimaryKey(id);
	}

	public List<Item> getItemByItemName(String name) {
		return itemDao.findbyItemName(name);
	}

	public void entryItem(Item item) {
		itemDao.create(item);
	}

	public void updateItem(Item item) {
		itemDao.update(item);
	}

	public void deleteItem(Integer id) {
		itemDao.delete(id);
	}

}
