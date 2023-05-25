package com.spring.mywebspring.snsboard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.mywebspring.command.SnsBoardVO;
import com.spring.mywebspring.util.PageVO;

public interface ISnsBoardService {

	//글 등록
	void insert(SnsBoardVO vo, MultipartFile file);
	
	//글 목록
	List<SnsBoardVO> getList(PageVO vo);
	
	//상세 보기
	SnsBoardVO getDetail(int bno);
	
	//글 삭제
	void delete(int bno);
	
}
