package kr.co.ch12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch12.persistence.UserRepo;
import kr.co.ch12.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		// INSERT INTO `USER3` VALUES (?,?,?,?); 수행
		repo.save(vo);	
	}
	public UserVo selectUser(String uid) {		
//		SELECT * FROM `USER3` WHERE `uid` = ?; 수행	
//		UserVo vo = repo.findById(uid).get();	
//		return vo;
		
		return repo.findById(uid).get();
	}
	
	public List<UserVo> selectUsers() {	
//		SELECT * FROM `USER3`;
//		List<UserVo> users = repo.findAll();	// SELECT * FROM `USER3`;
//		return users;
		
		return repo.findAll();
	}
	
	public List<UserVo> selectUsersOrderBy(String sort) {	
		
		List<UserVo> users = null;
		
		if(sort.equals("asc")) {
			// SELECT * FROM `USER3` ORDER BY age ASC; 수행
			users = repo.findUserVoByOrderByAgeAsc();	
		}else {
			// SELECT * FROM `USER3` ORDER BY age DESC; 수행
			users = repo.findUserVoByOrderByAgeDesc();	
		}
		
		return users;	
	}
	
	public void updateUser(UserVo vo) {
		// UPDATE `USER3` SET `name`=?, `hp`=?, `age`=? WHERE `uid`=?; 수행
		repo.save(vo);	
	}
	
	public void deleteUser(String uid) {
		// DELETE FROM `USER3` WHERE `uid`=? 수행   	
		repo.deleteById(uid);	
	}
	
	

}
