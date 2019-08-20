package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.dao.DataAccessException;

import dao.TeamDao;
import model.Team;

public class TeamDaoImpl implements TeamDao {
	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Team> getTeamList() throws DataAccessException {
		EntityManager em = emf.createEntityManager();
		List<Team> list = em.createQuery("from Team",Team.class).getResultList();
		return list;
	}

}
