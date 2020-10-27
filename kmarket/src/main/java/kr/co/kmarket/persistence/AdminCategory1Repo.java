package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category1Vo;

// JpaRepository의 매개변수 <VO명, ID(primary key)의 자료형> 

@Repository
public interface AdminCategory1Repo extends JpaRepository<Category1Vo, Integer>{
	
}
