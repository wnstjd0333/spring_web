package logic;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteCatalog {
	Integer getMaxBbsId();
	void putBbs(Bbs bbs);
	List<Bbs> readBbs(Condition c);
	Integer getBbsCount();
	Bbs getBbsDetail(Integer id);
	
	void updateWriting(Writing writing);//게시글 수정
	void deleteWriting(Writing writing);
	Writing getWritingById(Integer id);
	void insertWriting(Writing writing);
	Integer getMaxWritingId();
	List<Writing> getWriting(Condition c);//글목록 검색
}








