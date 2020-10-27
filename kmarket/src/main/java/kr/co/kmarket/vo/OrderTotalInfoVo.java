package kr.co.kmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
// @AllArgsConstructor 생성자 선언 어노테이션
public class OrderTotalInfoVo {

	int count;
	int price;
	int sale;
	int delivery;
	int point;
	int total;
	
}
