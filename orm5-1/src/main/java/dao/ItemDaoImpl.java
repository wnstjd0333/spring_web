package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import model.Item;

public class ItemDaoImpl implements ItemDao {
	private EntityManagerFactory emf;
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<Item> findAll() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Item",Item.class).getResultList();
	}

	public Item findByPrimaryKey(Integer itemId) {
		EntityManager em = emf.createEntityManager();
		return em.createQuery(
			"from Item where item_id = :item_id", Item.class)
			.setParameter("item_id", itemId).getSingleResult();
	}

}




