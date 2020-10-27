package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVo;

// JpaRepository의 매개변수 <VO명, ID(primary key)의 자료형> 

@Repository
public interface AdminProductsRepo extends JpaRepository<ProductsVo, Integer>{
	
}
