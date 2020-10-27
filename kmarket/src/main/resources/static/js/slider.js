$(document).ready(function(){
          $('.slider > ul').bxSlider({
              pager: false,
              easing: 'linear'
          });
        });
      
      $(function(){

        let best = $('aside > .best');

        $(window).scroll(function(){

          let t = $(this).scrollTop();

          if(t > 620){
            best.css({
              'position':'fixed',
              'top': '0'
            });
          }else{
            best.css({'position':'static'});
          }
        });
      });