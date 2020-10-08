<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*, shopCtr.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Fashion Store A Fashion Category Flat Bootstarp Resposive
	Website Template | Single :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<link rel="stylesheet" href="css/etalage.css">
<script src="js/jquery.etalage.min.js"></script>
<script>
	jQuery(document)
			.ready(
					function($) {

						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,
											source_image_width : 900,
											source_image_height : 1200,
											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
											}
										});

					});
</script>
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
<script type="text/javascript" id="sourcecode">
	$(function() {
		$('.scroll-pane').jScrollPane();
	});
</script>
</head>
<body>
	<!--header-->
	<jsp:include page="header.jsp" />
	<!--content-->
	<div class="content">
		<form method="post" name="formm">
			<div class="container">
				<div class="single">
					<div class="col-md-9">
						<c:forEach items="${ProDetail}" var="productVO">
							<div class="single_grid">
								<!-- 여기가 사진 보여지는 곳 -->
								<div class="grid images_3_of_2">
									<ul id="etalage">
										<li>
											<!-- <a href="optionallink.html"> --> <img
											class="etalage_thumb_image img-responsive"
											src="${productVO.prod_detail1}.png" alt=""> <img
											class="etalage_source_image"
											src="${productVO.prod_detail1}.png" alt=""> <!-- </a> -->
										</li>
										<li><img class="etalage_thumb_image img-responsive"
											src="${productVO.prod_detail2}.png" alt=""> <img
											class="etalage_source_image"
											src="${productVO.prod_detail2}.png" alt=""></li>
										<li><img class="etalage_thumb_image img-responsive"
											src="${productVO.prod_detail3}.png" alt=""> <img
											class="etalage_source_image"
											src="${productVO.prod_detail3}.png" alt=""></li>
										<li><img class="etalage_thumb_image img-responsive"
											src="${productVO.prod_detail4}.png" alt=""> <img
											class="etalage_source_image"
											src="${productVO.prod_detail4}.png" alt=""></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<!-- 여기가 옆에 상품설명 -->
								<div class="span1_of_1_des">
									<div class="desc1">
										<h3>${productVO.prod_name}</h3>
										<p>${productVO.contents}</p>
										<h5>${productVO.prod_price}원</h5>
										<div class="available">
											<label> 수 량 : </label> <input type="text" name="cart_num"
												size="2" value="1" /><br> 
												<input type="hidden" name="prod_name" value="${productVO.prod_name}" /> 
												<input type="hidden" name="prod_price" value="${productVO.prod_price}" /> 
												<input type="hidden" name="prodid" value=<%=ShopServlet.proid%> /> 
												<input type="hidden" name="contents" value=<%=ShopServlet.con%> />
												<input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
											<%-- <input type="hidden" name=cart_num value=<%=CartVO.cart_num%> /> --%>
											<div class="form-in">
												<div id="buttons">
													<%-- <input type="button" value="장바구니" class="submit" onclick="go_cart(<%= ShopServlet.adminid %>)"> --%>
													<input type="button" value="장바구니" class="submit" onclick="go_cart()">
													 <input type="button" value="즉시 구매" class="submit" onclick="go_order('<%=ShopServlet.adminid%>')">
												</div>
												<!-- <a href="javascript:go_cart()">장바구니</a> -->
												<%-- <a
													href="ShopServlet?command=cart_insert&shopname=<%=ShopServlet.adminid%>&contents=<%=ShopServlet.con%>&prodid=<%=ShopServlet.proid%>">장바구니</a><a
													href="#">바로 결제</a> --%>
											</div>
											<!-- <span class="span_right"><a href="#">login to save
													in wishlist </a></span> -->
											<!-- #부분은 인화 로그인 창으로 연결 -->
											<div class="clearfix"></div>
										</div>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<h2>상품 상세 설명</h2>
							<img src="${productVO.con_img}.png" />
						</c:forEach>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>