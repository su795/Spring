package kr.co.ch10.vo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor 
//생성자 생성
public class UserVO {

	
	@NonNull public String uid;
	@NonNull public String name;
	@NonNull public int age;
	@NonNull public String rdate;
	
//  생성자 생성을 어노이트로 대신함
//	public UserVO(String uid, String name, int age, String rdate) {
//		this.uid = uid;
//		this.name = name;
//		this.age = age;
//		this.rdate = rdate;
//	}
	
}
