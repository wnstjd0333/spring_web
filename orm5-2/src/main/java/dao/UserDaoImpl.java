package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;

import model.User;

public class UserDaoImpl implements UserDao {
	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public User findByUserIdAndPassword(User user) {
		EntityManager em= emf.createEntityManager();
		try {
			return em.createQuery("from User where userId=:userId and password =:password",User.class)
					.setParameter("userId", user.getUserId()).setParameter("password", user.getPassword())
					.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		
	}


	

}
