package com.spring.mywebspring.snsboard.mapper;

import java.util.List;

import com.spring.mywebspring.command.SnsBoardVO;
import com.spring.mywebspring.util.PageVO;

public interface ISnsBoardMapper {

	//글 등록
	void insert(SnsBoardVO vo);
	
	//글 목록
	List<SnsBoardVO> getList(PageVO vo);
	
	//상세 보기
	SnsBoardVO getDetail(int bno);
	
	//글 삭제
	void delete(int bno);
}
