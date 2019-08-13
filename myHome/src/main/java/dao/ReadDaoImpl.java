package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Condition;
import model.Writing;

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

	public Integer selectImageCount() {
		return session.selectOne("mappers.myMapper.selectImageCount");
	}

	public Integer selectReplyPages(Integer seqno) {
		return session.selectOne("mappers.myMapper.selectReplyPages",seqno);
	}

	public Writing readWriting(Integer id) {
		return session.selectOne("mappers.myMapper.getWritingInfoById",id);
	}


}
