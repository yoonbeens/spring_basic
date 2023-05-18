package com.spring.mywebspring.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mywebspring.command.UserVO;
import com.spring.mywebspring.user.mapper.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}

	@Override
	public void join(UserVO vo) {

	}

	@Override
	public UserVO login(String id, String pw) {
		return null;
	}

	@Override
	public UserVO getInfo(String id) {
		return null;
	}

	@Override
	public void updateUser(UserVO vo) {

	}

}
