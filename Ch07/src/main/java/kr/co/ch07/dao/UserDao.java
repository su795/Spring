package kr.co.ch07.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.UserVO;

@Repository
public class UserDao {

	@Inject
	private JdbcTemplate jdbc;
	
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO `MEMBER` VALUES (?,?,?,?,?, NOW())";
		Object[] params = {vo.getUid(), 
						   vo.getName(), 
						   vo.getHp(), 
						   vo.getPos(),
						   vo.getDep()
						  };
		
		jdbc.update(sql, params);
		
	}	
	public void selectUser() {}	
	public List<UserVO> selectUsers() {
		String sql ="SELECT * FROM `MEMBER`";
		List<UserVO> users = jdbc.query(sql, new UserRowMapper());
		
		
		return users;
	}	
	public void updateUser() {}	
	public void deleteUser() {}
	
		
	
}
