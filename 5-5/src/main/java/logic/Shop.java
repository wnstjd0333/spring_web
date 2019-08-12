package logic;

import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

public interface Shop {
	Integer caculateTotal(List<ItemSet> itemList);
	Cart getCart();
	void checkout(User user, Cart cart);
	
	List<Item> getItemList();
	Item getItemByItemId(Integer itemId);
	User getUserByUserIdAndPassword(User user);
	void entryUser(User user);
}
