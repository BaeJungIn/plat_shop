<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Fashion Store A Fashion Category Flat Bootstarp Resposive
	Website Template | Men :: w3layouts</title>
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
</head>
<body>
	<!--header-->
	<jsp:include page="header.jsp" />
	<!--content-->
	<div class="content"> 
		<div class="container">
			<div class="  col-m-on">
				<!---->
				<div class="in-line">
					
					<div class="lady-on">
					
						<c:forEach items="${ProIndex}" var="productVO" step="1">
							<div class="col-md-4 you-men">
								<a href="ShopServlet?command=ProDetail&shopname=<%=ShopServlet.adminid%>&contents=<%=ShopServlet.con%>&prodid=${productVO.prod_id}">
								<img class="img-responsive pic-in" src="${productVO.prod_img}.png" width="358" height="455" alt=" "></a>
								<p>${productVO.prod_name}</p>
								<span>${productVO.prod_price} $<!-- | 
								<label class="cat-in"></label>  -->
								<!-- <input type="button" value="장바구니" class="submit" onclick="go_cart()"> -->
								<!-- <a href="#">Add to Cart </a></span> -->
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<!---->
			<div class="lady-in-on">
				
				<ul id="flexiselDemo1">
					<li><a href="#"><img class="img-responsive women"
							src="images/faa.jpg" alt=""></a>
						<div class="hide-in">
							<p>Premium Denim Women's Hidden</p>
							<span>$179.00 | <a href="#">Buy Now</a></span>
						</div></li>
					<li><a href="#"><img class="img-responsive women"
							src="images/faa1.jpg" alt=""></a>
						<div class="hide-in">
							<p>Premium Denim Women's Hidden</p>
							<span>$179.00 | <a href="#">Buy Now</a></span>
						</div></li>
					<li><a href="#"><img class="img-responsive women"
							src="images/faa.jpg" alt=""></a>
						<div class="hide-in">
							<p>Premium Denim Women's Hidden</p>
							<span>$179.00 | <a href="#">Buy Now </a></span>
						</div></li>
					<li><a href="#"><img class="img-responsive women"
							src="images/faa1.jpg" alt=""></a>
						<div class="hide-in">
							<p>Premium Denim Women's Hidden</p>
							<span>$179.00 | <a href="#">Buy Now</a></span>
						</div>
						</li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo1").flexisel({
							visibleItems : 4,
							animationSpeed : 1000,
							autoPlay : true,
							autoPlaySpeed : 3000,
							pauseOnHover : true,
							enableResponsiveBreakpoints : true,
							responsiveBreakpoints : {
								portrait : {
									changePoint : 480,
									visibleItems : 1
								},
								landscape : {
									changePoint : 640,
									visibleItems : 2
								},
								tablet : {
									changePoint : 768,
									visibleItems : 3
								}
							}
						});

					});
				</script>
				<script type="text/javascript" src="js/jquery.flexisel.js"></script>
			</div>
		</div>
	</div>
	<!---->
	<jsp:include page="footer.jsp" />
</body>
</html>