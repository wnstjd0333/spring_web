package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	
	public void create(User user) {
		this.session.insert("mappers.myMapper.putUser",user);
		
	}

	public User findByUserIdAndPassword(User user) {
		User list = session.selectOne("mappers.myMapper.getUser",user);
	      return list;
	}

}
