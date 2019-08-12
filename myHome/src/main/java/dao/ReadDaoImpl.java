package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Condition;

@Repository
public class ReadDaoImpl implements ReadDao {

	@Autowired
	private SqlSession session;
	
	public List<Bbs> readBbs(Condition c) {
		return session.selectList("mappers.myMapper.getBBSList",c);
	}

	public Integer getBbsCount() {
		return session.selectOne("mappers.myMapper.getBBSCount");
	}

	public Bbs getBbsDetail(Integer id) {
		return session.selectOne("mappers.myMapper.getBBSDetail",id);
	}


}
