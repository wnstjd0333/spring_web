package dao;

import java.util.List;

import model.CartItem;

public interface CartDao {
	void insertCart(CartItem cartItem);
	void deleteCart(CartItem cartItem);
	void updateCart(CartItem cartItem);
	Integer selectMaxCart();//가장큰 일련번호
	List<CartItem> selectCart(String id);//지정된 ID의 상품목록
}
