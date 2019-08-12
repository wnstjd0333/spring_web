package dao;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface WriteDao {
	//게시글을 위한 메서드
	Integer getMaxId();
	void insertBBS(Bbs bbs);
	//이미지 게시글을 위한 메서드
	void updateWriting(Writing writing);//게시글 수정
	void deleteWriting(Writing writing);
	Writing getWritingById(Integer id);
	void insertWriting(Writing writing);
	Integer getMaxWritingId();
	List<Writing> getWriting(Condition c);//글목록 검색
}
