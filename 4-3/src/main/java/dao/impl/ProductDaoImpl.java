package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.dao.DataAccessException;

import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao {
	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Product> getProductList() throws DataAccessException {
		EntityManager em = emf.createEntityManager();
		List<Product> list = em.createQuery("from Product", Product.class).getResultList();
		return list;
	}

	
	@Override
	public Product getProduct(Integer code) throws DataAccessException {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Product where code =:code",Product.class).setParameter("code", code).getSingleResult();
	}

}
