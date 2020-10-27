package kr.co.kmarket.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.Category2Vo;

// JpaRepository의 매개변수 <VO명, ID(primary key)의 자료형> 

@Repository
public interface AdminCategory2Repo extends JpaRepository<Category2Vo, Integer>{
	
	public List<Category2Vo> findByCode1OrderBySeq(int code1);
	
}
