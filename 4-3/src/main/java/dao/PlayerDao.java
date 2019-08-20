package dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import model.Player;

//팀 삽입을 위한 인터페이스
public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
	void deletePlayer(Player player) throws DataAccessException;
	   void updatePlayer(Player player) throws DataAccessException;
	   Player getPlayer(Integer id) throws DataAccessException;         //찾는 메소드
	   List<Player> getPlayerList(Integer id) throws DataAccessException;   //목록을 찾는 메소드
}
