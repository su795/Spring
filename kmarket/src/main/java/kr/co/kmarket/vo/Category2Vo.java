package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="km_category2")
public class Category2Vo {

	// @Table 어노테이션은 자동으로 `km_category1` 테이블과 매핑
	// @Id 어노테이션은 테이블의 `기본키(primary key)` 위에 선언
	
	@Id
	private int seq;
	private int code1;
	private int code2;
	private String title;
	
}
