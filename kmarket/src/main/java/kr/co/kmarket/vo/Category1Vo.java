package kr.co.kmarket.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="km_category1")
public class Category1Vo {

	// @Table 어노테이션은 자동으로 `km_category1` 테이블과 매핑
	// @Id 어노테이션은 테이블의 `기본키(primary key)` 위에 선언
	
	@Id
	private int code1;
	private String title;
}
