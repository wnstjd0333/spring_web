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
		return list;											//목록으로 팀을 검색
	}

	@Override      //특정 팀을 찾는 메소드
	public Team getTeam(Integer teamId) throws DataAccessException {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Team where team_id =:team_id",Team.class).setParameter("team_id", teamId).getSingleResult();
	}												  //:team_id 는 파라미터									//기본키로 검색해서 1건의 결과
	

}
