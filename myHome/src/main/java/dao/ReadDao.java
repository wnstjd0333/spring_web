package dao;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.Writing;

public interface ReadDao {
	List<Bbs> readBbs(Condition c);//전체 게시글 검색(조건 검색)
	Integer getBbsCount();//페이지 갯수 검색
	Bbs getBbsDetail(Integer id);//특정 게시글 검색

	Integer selectImageCount();//게시글의 갯수 리턴
	Integer selectReplyPages(Integer seqno);//글번호로 일련번호 찾음
	Writing readWriting(Integer id);//글번호로 이미지 게시글 검색
}
