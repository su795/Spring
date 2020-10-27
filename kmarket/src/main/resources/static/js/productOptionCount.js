// 상품 수량 +, - 기능 구현
$(document).ready(function(){
	
	let btnPlus  = $('.option > input[name=plus]'),
		btnMinus = $('.option > input[name=minus]'),
		txtCount = $('.option > input[name=count]');
	let	priceTag = $('.dis_price > ins'),
		totPriceTag = $('.total > span');
	
	btnPlus.click(function(){
		
		let count = txtCount.val(),			
			num = parseInt(count) + 1,
			txtPrice = priceTag.text(),
			intPrice = parseInt(txtPrice.replace(/,/g,"")),
			totPrice = num * intPrice;
							
		txtCount.val(num);
		totPriceTag.text(totPrice.toLocaleString());
		
	});
	
	btnMinus.click(function(){
		let count = txtCount.val(),			
			num = parseInt(count) - 1;
			
			if(num <= 0){
				alert('최소 수량은 1개 입니다.');
				return;
			}
		
		let txtPrice = priceTag.text(),
			intPrice = parseInt(txtPrice.replace(/,/g,"")),
			totPrice = num * intPrice;

		txtCount.val(num);
		totPriceTag.text(totPrice.toLocaleString());
		
	});
});