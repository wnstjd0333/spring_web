package dao;

import org.springframework.dao.DataAccessException;

import model.Player;

//팀 삽입을 위한 인터페이스
public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
}
