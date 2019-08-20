package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
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
	public void deletePlayer(Player player) throws DataAccessException{
		em.remove(player);
	}
	public void updatePlayer(Player player) throws DataAccessException{
		em.merge(player);
	}
	public Player getPlayer(Integer id) throws DataAccessException{
		Player player = em.createQuery("from Player where player_id=:player_id",Player.class).setParameter("player_id", id).getSingleResult();
		return player;
	}
	public List<Player> getPlayerList(Integer id) throws DataAccessException{
		List<Player> list = em.createQuery("from Player as player where player.team.team_id =:teamId",Player.class).setParameter("teamId", id).getResultList();
		return list;
	}
}
