<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

<style>
@font-face {
  font-family: NanumSquareWeb;
  src: url(NanumSquareR.eot); /* IE 호환성 보기 */
  src: url(NanumSquareR.eot#iefix) format('embedded-opentype'), /* IE 6 ~ 8 */
       url(NanumSquareR.woff) format('woff'), /* 모던 브라우저 */
       url(NanumSquareR.ttf) format('truetype');
}

</style>

<script>
	$(document).ready(function(){
		$('.sidenav').sidenav();
	    $('.carousel').carousel();
	    $('.parallax').parallax();
	    $('.collapsible').collapsible();
	});
</script>