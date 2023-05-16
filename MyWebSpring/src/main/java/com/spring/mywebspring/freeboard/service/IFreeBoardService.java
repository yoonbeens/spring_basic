package com.spring.mywebspring.freeboard.service;

import java.util.List;

import com.spring.mywebspring.command.FreeBoardVO;

public interface IFreeBoardService {

	//글 등록
	void regist(FreeBoardVO vo);
	
	//글 목록
	List<FreeBoardVO> getList();
	
	//상세보기
	FreeBoardVO getContent(int bno);	
	
	//수정
	void update(FreeBoardVO vo);
	
	//삭제
	void delete(int bno);
	
}
