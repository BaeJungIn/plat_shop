<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Fashion Store A Fashion Category Flat Bootstarp Resposive Website Template | Home :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--//fonts-->
</head>
<body> 
	  <!--header-->
		  <jsp:include page="adminShopHeader.jsp"/> 
		  
		  
	<!--content-->
	<div class="content">
		<div class="container">
		<div class="women-in">
			<div class="col-md-9 col-d">
			
				<div class="banner">
					<c:forEach items="${mainList }"  var="shopVO">
					<img src="${shopVO.main_img1}.png" width="809" height="425"/>		
					</c:forEach>  
				</div>
				
				<div class="in-line">
					<div class="para-an">
						<h3>NEW  ARRIVALS</h3>
						<p>Check our all latest products in this section.</p>
					</div>
					<div class="lady-in">
					<c:forEach items="${newProductList }"  var="productVO">
						<div class="col-md-4 you-para">
						
           				 <img src="${productVO.prod_img}.png" width="254" height="409" alt=" " ></a> <!-- 나중에 images빼고 상품 다시 넣어야됨 -->
           				 <h3> ${productVO.prod_name} </h3>    
          				  <p>${productVO.prod_price} </p>
       				
     				 
     				 </div>
     				 </c:forEach>  
						
						<div class="clearfix"> </div> 
					</div>
				</div>
			</div>
			<div class="col-md-3 col-m-left">
				<div class="in-left">				
					<c:forEach items="${mainList }"  var="shopVO">
					<img src="${shopVO.main_img2}.png" width="309" height="425"/>		
					</c:forEach>  		
					</div>		
				</div>
				<!-- <div class="discount">
					<img class="img-responsive pic-in" src="images/p2.jpg" alt=" " >	</a>		
											
					<a class="know-more">know more</a>
				</div> -->
				<!-- <div class="discount">
					<img class="img-responsive pic-in" src="images/p3.jpg" alt=" " ></a>			
						<p class="no-more no-get">Get Exclusive <b>discount on</b> <span>Ladies wear</span></p>					
					<a  class="know-more">know more</a>
				</div> -->
				<!-- <div class="twitter-in">
					<h5>TWITTER  UPDATES</h5>
					<span class="twitter-ic">	</span>
					<div class="up-date">
						<p>@suniljoshi Looks like nice and dicent design</p>
						<a >http://bit.ly/sun</a>
						<p class="ago">About 1 hour ago via twitterfeed</p>
					</div>
					<div class="up-date">
						<p>@suniljoshi Looks like nice and dicent design</p>
						<a >http://bit.ly/sun</a>
						<p class="ago">About 1 hour ago via twitterfeed</p>
					</div>
					<a  class="tweets">More Tweets</a>
					<div class="clearfix"> </div>
				</div> -->
			</div>
			<div class="clearfix"> </div>
			</div>
			<!---->
			<div class="lady-in-on">
			<!-- <div class="buy-an">
						<h3>OTHER PRODUCTS</h3>
						<p>Check our all latest products in this section.</p>
					</div> -->
					<ul id="flexiselDemo1">			
				<li><a ><img class="img-responsive women" src="images/pic.jpg" alt=""></a>
				<div class="hide-in">
				<p>Premium Denim Women's Hidden</p>
				<span>$179.00  |  <a >Buy Now </a></span>
				</div></li>
				<li><a><img class="img-responsive women" src="images/pic1.jpg" alt=""></a>
				<div class="hide-in">
				<p>Premium Denim Women's Hidden</p>
				<span>$179.00  |  <a>Buy Now </a></span>
				</div></li>
				<li><a><img class="img-responsive women" src="images/pic.jpg" alt=""></a>
				<div class="hide-in">
				<p>Premium Denim Women's Hidden</p>
				<span>$179.00  |  <a>Buy Now </a></span>
				</div></li>
				<li><a><img class="img-responsive women" src="images/pic2.jpg" alt=""></a>
				<div class="hide-in">
				<p>Premium Denim Women's Hidden</p>
				<span>$179.00  |  <a>Buy Now </a></span>
				</div></a></li>
            </ul>
            		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>
	</div>
	</div>
	
	
	
	 <jsp:include page="adminShopFooter.jsp"/>
</body>
</html>