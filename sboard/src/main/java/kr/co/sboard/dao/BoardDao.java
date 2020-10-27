package kr.co.sboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.BoardVO;
import kr.co.sboard.vo.FileVO;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertBoard(BoardVO vo) {
		// 글을 insert 한 후 바로 해당 테이블 행의 seq값을 vo객체 seq멤버에 저장
		mybatis.insert("mapper.board.INSERT_BOARD", vo);
		return vo.getSeq();
		
		// return mybatis.insert("mapper.board.INSERT_BOARD", vo);
	}
	
	public void insertFile(FileVO fvo) {
		mybatis.insert("mapper.board.INSERT_FILE", fvo);
	}
	
	public BoardVO selectBoard(int seq) {
		return mybatis.selectOne("mapper.board.SELECT_BOARD", seq);		
	}
	
	public List<BoardVO> selectBoards(int start) {
//		List<BoardVO> boards = mybatis.selectList("mapper.board.SELECT_BOARDS");		
//		return boards;
		
		return mybatis.selectList("mapper.board.SELECT_BOARDS", start);		
	}
	
	public void updateBoard(BoardVO vo) {		
		mybatis.update("mapper.board.UPDATE_BOARD", vo);		 
	}
	public void deleteBoard() {}
	
	public int selectCountBoard() {
		return mybatis.selectOne("mapper.board.SELECT_COUNT_BOARD");
	}	
	
}
