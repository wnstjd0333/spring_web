package dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

import dao.PlayerDao;
import model.Player;
import model.PlayerTeam;
import model.Team;

public class PlayerDaoImpl implements PlayerDao {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void deletePlayer(Player player) throws DataAccessException {
		sqlSession.delete("mappers.myMapper.deletePlayer",player);
		
	}

	@Override
	public void updatePlayer(Player player) throws DataAccessException {
		sqlSession.update("mappers.myMapper.updatePlayer",player);
		
	}

	@Override
	public Player getPlayer(Integer id) throws DataAccessException {
		PlayerTeam pt = sqlSession.selectOne("mappers.myMapper.getPlayerTeam",id);
		if(pt != null) { //검색결과가 존재하는 경우
			Player player = new Player();
			player.setPlayer_id(pt.getPlayer_id());
			player.setName(pt.getPlayerName());
			Team team = new Team();
			team.setTeam_id(pt.getPlayer_id());
			team.setName(pt.getPlayerName());
			player.setTeam(team);
			return player;
		} else { //검색결과가 없는 경우
			
		}
		return null;
	}

	@Override
	public List<PlayerTeam> getPlayerList(Integer teamId) throws DataAccessException {
		List<PlayerTeam> list = sqlSession.selectList("mappers.myMapper.getTeamPlayer",teamId);
		return list;
	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		sqlSession.insert("mappers.myMapper.putPlayer",player);
	}

}
