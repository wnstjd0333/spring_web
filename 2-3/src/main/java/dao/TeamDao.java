package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Team;

public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
	Team getTeam(Integer teamId) throws DataAccessException; //운동선수가 소속될 팀을 찾는 메소드
}
