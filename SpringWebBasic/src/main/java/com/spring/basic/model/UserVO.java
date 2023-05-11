package com.spring.basic.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserVO {
	
	//UserVO 의 변수명을 파라미터 변수명이랑 똑같이 맞춰야 한다.
	private String userId;
	private String userPw;
	private String userName;
	private List<String> hobby;
	
	
	
}
