package com.spring.mywebspring.freeboard.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.mywebspring.command.FreeBoardVO;

@ExtendWith(SpringExtension.class) //테스트 환경을 만들어주는 junit5 객체 로딩
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/config/db-root-config.xml"
})
public class FreeBoardMapperTest {
	
	@Autowired
	private IFreeBoardMapper mapper;
	
	//단위 테스트 (unit test) - 가장 작은 단위의 테스트
	//테스트 시나리오
	// -단언(Assertion) 기법
	
	@Test
	@DisplayName("Mapper 계층의 regist를 호출하면서 "
			+ "FreeBoardVO를 전달하면 데이터가 INSERT 된다.")
	void registTest() {
		//given - when - then 패턴을 따릅니다. (생략 가능)
		
		//given: 테스트를 위해 주어질 데이터 (ex: parameter)
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("첫번째 글");
		vo.setWriter("abc1234");
		vo.setContent("안녕하세요~ 감사해요~ 잘 있어요~ 다시 만나요~");
		
		//when: 테스트 실제 상황
		mapper.regist(vo);
		
		//then: 테스트 결과를 확인
		
		
	}
	
}


















