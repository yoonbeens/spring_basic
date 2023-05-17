package com.spring.mywebspring.user.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.mywebspring.command.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/db-root-config.xml")
public class UserMapperTest {

	@Autowired
	private IUserMapper mapper;
	
	
	@Test
	@DisplayName("회원가입을 진행했을 때 회원가입에 성공해야 한다.")
	void registTest() {
		UserVO vo = new UserVO();
		vo.setUserId("abc1234");
		vo.setUserPw("aaa1111");
		vo.setUserName("홍길동");
		
		mapper.join(vo);
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디를 조회했을 시 1이 리턴되어야 한다.")
	void checkIdTest() {
		String id = "abc1234";
		
		mapper.idCheck(id);
		
		assertEquals(1, mapper.idCheck(id));
	}
	
	@Test
	@DisplayName("존재하는 회원 아이디와 올바른 비밀번호를 입력했을 시 회원의 정보가 리턴되어야 한다.")
	void loginTest() {
		String id = "abc1234";
		String pw = "aaa111";
		
		UserVO vo = mapper.login(id, pw);
		
	}
	
	@Test
	@DisplayName("존재하지 않는 회원의 아이디를 입력하면 null이 올 것이다.")
	void getInfoTest() {
		String id = "asdf";
		
		mapper.getInfo(id);
		
		assertNull(mapper.getInfo(id));
	}
	
	@Test
	@DisplayName("id를 제외한 회원의 정보를 수정할 수 있다.")
	void updateTest() {
		
		UserVO vo = new UserVO();
		vo.setUserId("abc1234");
		
		mapper.updateUser(vo);
		
	}
	
	
}




















