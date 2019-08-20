package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Product;

public interface ProductDao {
	List<Product> getProductList() throws DataAccessException;
	Product getProduct(Integer code) throws DataAccessException;
}
