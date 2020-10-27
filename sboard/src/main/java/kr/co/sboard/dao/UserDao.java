package kr.co.sboard.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Repository
public class UserDao {
	
	@Inject
	private SqlSessionTemplate mybatis;
	
	public UserVO selectUser(UserVO vo) {
		return mybatis.selectOne("mapper.user.SELECT_USER", vo);
		// �Ű� ������ uid�� pass�� �ʿ������� selectOne�� �Ű������� 2������ ��� �����ϱ� ������ 
		// selectOne("mapper~", uid, pass) ������ �Ű������� 2�� �̻� �� �� ����.
		// �׷��� uid�� pass�� �����ϰ� �ִ�  UserVO�� �ҷ��ͼ� ����Ѵ�.
	}
	
	public void selectUsers() {}
	
	public void insertUser(UserVO vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public void updateUser() {}
	
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		
//		TermsVO vo = mybatis.selectOne("mapper.user.SELECT_TERMS");
//		return vo;
		
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	
	public int selectUserCount(String uid) {
		
//		int result = mybatis.selectOne("mapper.user.SELECT_USER_COUNT");		
//		return result;
				
		return mybatis.selectOne("mapper.user.SELECT_USER_COUNT", uid);
	}
	
	
}
