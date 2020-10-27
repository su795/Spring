package kr.co.kmarket.vo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "km_products")
public class ProductsVo {
	
	// @ToString 어노테이션 : 멤버 변수들의 값을 출력해주는 메서드를 만들어줌
	// @Entity, @Table 어노테이션은 Jpa가 ProductsVo를 DB의 테이블로 인식하게 해줌
	
	@Id
	private int code;
	private int cate1;
	private int cate2;
	private String name;
	private String descript;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String dutyFree;
	private String receipt;
	private String bizClass;
	private String origin;
	private String ip;
	private String rdate;
	private int etc1;
	private int etc2;
	private String etc3;
	private String etc4;
	private String etc5;
	
	// 추가 필드 
	// @Transient 어노테이션은 지속되어서는 안되는 필드를 표시하는 데 사용, 필드가 데이터베이스에 유지되지 않도록 제외시킬 때 사용
	// @entity와 @table 어노테이션을 썼기 때문에 Jpa에서는 ProductsVo를 DB의 테이블로 인식하지만 @Transient 어노테이션이 붙은 항목은 해당
	// 테이블에 속하는 레이블로 인식을 하지 않는다.
	
	@Transient
	private int salePrice;
	@Transient
	private MultipartFile file1;
	@Transient
	private MultipartFile file2;
	@Transient
	private MultipartFile file3;
	@Transient
	private MultipartFile file4;
	
	
}
