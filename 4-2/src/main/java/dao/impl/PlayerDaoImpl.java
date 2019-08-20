package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {
	@PersistenceContext
	private EntityManager em;
	
	
//	private EntityManagerFactory emf;
//
//	@PersistenceUnit
//	public void setEmf(EntityManagerFactory emf) {
//		this.emf = emf;
//	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction trans=em.getTransaction();
//		trans.begin();
		em.persist(player);
//		trans.commit();
	}

}
