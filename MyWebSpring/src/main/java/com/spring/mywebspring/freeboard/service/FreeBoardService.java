package com.spring.mywebspring.freeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mywebspring.command.FreeBoardVO;
import com.spring.mywebspring.freeboard.mapper.IFreeBoardMapper;
import com.spring.mywebspring.util.PageVO;

@Service
public class FreeBoardService implements IFreeBoardService {

	@Autowired
	private IFreeBoardMapper mapper;
	//여기서 왜 IService가 아니라 IMapper가 필요하지?
	//Mapper.xml이랑 연관이 되나?
	
	@Override
	public void regist(FreeBoardVO vo) {
		mapper.regist(vo);
	}

	@Override
	public List<FreeBoardVO> getList(PageVO vo) {
		return mapper.getList(vo);
	}
	
	@Override
	public int getTotal(PageVO vo) {
		return mapper.getTotal(vo);
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		return mapper.getContent(bno);
	}

	@Override
	public void update(FreeBoardVO vo) {
		mapper.update(vo);
	}

	@Override
	public void delete(int bno) {
		mapper.delete(bno);
	}

}
