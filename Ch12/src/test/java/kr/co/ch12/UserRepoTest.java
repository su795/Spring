package kr.co.ch12;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ch12.persistence.UserRepo;
import kr.co.ch12.vo.UserVo;

@SpringBootTest
class UserRepoTest {

	@Autowired
	private UserRepo repo;
	
	@Test
	public void test() {
		
		List<UserVo> users = repo.findUserVoByOderByAgeAsc();
		System.out.println("테스트 완료...");
	}
}
