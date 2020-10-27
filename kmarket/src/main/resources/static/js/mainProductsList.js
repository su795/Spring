// 추천, 최신, 할인 상태변수
let isCompleteReco = false,
	isCompleteNew = false,
	isCompleteDisc = false;			

$(document).ready(function(){		
	
	// section 객체 선택
	let sectionHit 		 = $('section.hit'),
		sectionRecommend = $('section.recommend'),
		sectionNew		 = $('section.new'),
		sectionDiscount  = $('section.discount');
	
	$(window).scroll(function(){
		
		let pos = $(this).scrollTop();
		
		// console.log(pos);
		
		if(pos >= 200 && !isCompleteReco) {
			isCompleteReco = true;
			getProducts(sectionRecommend, '/kmarket/main/recommendItems');
		}else if(pos >= 400 && !isCompleteNew) {
			isCompleteNew = true;
			getProducts(sectionNew, '/kmarket/main/newItems');
		}else if(pos >= 600 && !isCompleteDisc) {
			isCompleteDisc = true;
			getProducts(sectionDiscount, '/kmarket/main/discountItems');
		}
		
	}); //scroll end
	
	function getProducts(section, url){						
		$.ajax({
			url: url,
			type: 'get',
			dataType: 'json',
			success: function(data) {
				
				section.find('img').remove();
				
				$.each(data, function(i, item) {		
					// dom객체 - 해당 클래스나 선택자 하나만이 아니라 자손들의 html구조를 포함하고 있는 객체를 말함.
					let dom = $('.hit > article:eq(0)').clone();
					
					let imgUrl = '/kmarket/thumb/'+item.cate1+'/'+item.cate2+'/'+item.thumb1,
						aUrl   = '/kmarket/shop/view?code=' + item.code;
					dom.find('.thumb > img').attr('src', imgUrl);
					dom.find('a').attr('href', aUrl);
					
					dom.find('h2').text(item.name);
					dom.find('p').text(item.descript);
					dom.find('.org_price > del').text(item.price.toLocaleString());
					dom.find('.org_price > span').text(item.discount+'%');
					
					dom.find('.dis_price > ins').text(item.salePrice.toLocaleString());
					
					if(item.delivery != 0) {
						dom.find('.dis_price > span').remove();
					}
					
					section.append(dom);
				});
				
			}
		});
	}

	
});