<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*"%>
<%
	HeaderDAO header = HeaderDAO.getInstance();
	HeaderVO hvo = new HeaderVO();
	HeaderVO vo = header.getHeader(ShopServlet.adminid);
%>
<!DOCTYPE html>
<html>
<head>
<title>Fashion Store A Fashion Category Flat Bootstarp Resposive
	Website Template | Home :: w3layouts</title>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="mypage/mypage.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Fashion Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="text/javascript" src="member/member.js"></script>
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>

<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
</head>

<header>
	<%
		
	%>
	<!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-grid">
					<ul>
						<!-- 상세페이지 jsp 넣기  시작 -->

						<li><a href="ShopServlet?command=mypage_detail&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="scroll">MYPAGE</a></li>
						<li><a href="ShopServlet?command=cart_list&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="scroll">CART </a></li>
						<li><a href="ShopServlet?command=order_list&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="scroll">ORDER</a></li>
						<li><a href="ShopServlet?command=qna_list&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="scroll">Q&A</a></li>
						<!-- 상세 페이지 jsp 넣기 끝 -->
					</ul>
				</div>
				<div class="header-grid-right">
					<!-- 로그인 & 회원가입  시작 -->


					<form method="post" action="ShopServlet?command=login&shopname=<%=ShopServlet.adminid%>&contents=&prodid=">
						<c:choose>
							<c:when test="${empty sessionScope.loginUser}">
								<input name="id" type="text" value="${id}" value="one">
								<input name="pwd" type="password" value="1111">
								<input type="submit" value="Login" class="submit">
								<label>|</label>
								<!-- 회원가입 -->
								<a href="ShopServlet?command=contract&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="sign-up">JOIN</a>
							</c:when>
							<c:otherwise>
								<label style="color: orange">
									${sessionScope.loginUser.cus_name}(${sessionScope.loginUser.id})님
									환영합니다.</label>
								<a href="ShopServlet?command=logout&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" class="sign-up">LOGOUT</a>
							</c:otherwise>
						</c:choose>


					</form>


				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="container">
			<div class="header-bottom">
				<div class="logo">
					<!-- <a href="index.jsp"><img src="https://imgur.com/2MjpQK8.png" alt=" "></a> -->
					<a href="ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid %>&contents=&prodid="><img src="<%=vo.getLogo_img1()%>.png" width="243" height="79" alt=" "></a>
					
				</div>
				<div class="ad-right">
					<!-- <img class="img-responsive" src="images/ad.png" alt=" " > -->
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="header-bottom-bottom">
				<div class="top-nav">
					<span class="menu"> </span>
					<ul>

						<li class="active"><a href="ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid %>&contents=&prodid=">HOME </a></li>
						
						<% if( vo.getCategory_1() != null && vo.getCategory_1().length() > 0 ){ %>
						<li>
						<a href="ShopServlet?command=ProIndex&shopname=<%=ShopServlet.adminid%>&contents=<%hvo.getCategory_1();						
			System.out.print(vo.getCategory_1());%> <%=vo.getCategory_1()%>&prodid="><%=vo.getCategory_1()%>
						</a></li><% } %>
						
						<% if( vo.getCategory_2() != null && vo.getCategory_2().length() > 0 ){ %>
						<li>
						<a href="ShopServlet?command=ProIndex&shopname=<%=ShopServlet.adminid%>
						&contents=<%hvo.getCategory_2();
			System.out.print(vo.getCategory_2());%><%=vo.getCategory_2()%>&prodid=">
								<%=vo.getCategory_2()%>
						</a></li><% } %>
						
						
						<% if( vo.getCategory_3() != null && vo.getCategory_3().length() > 0){ %>
						<li>
						<a
							href="ShopServlet?command=ProIndex&shopname=<%=ShopServlet.adminid%>
						&contents=<%hvo.getCategory_3();
			System.out.print(vo.getCategory_3());%><%=vo.getCategory_3()%>&prodid=">
								<%=vo.getCategory_3()%>
						</a></li><% } %>
						
						
						<% if( vo.getCategory_4() != null && vo.getCategory_4().length() > 0){ %>
						<li>
						<a href="ShopServlet?command=ProIndex&shopname=<%=ShopServlet.adminid%>
						&contents=<%hvo.getCategory_4();
			System.out.print(vo.getCategory_4());%><%=vo.getCategory_4()%>&prodid=">
								<%=vo.getCategory_4()%>
						</a></li>
						<% } %> 

						
						<% if( vo.getCategory_5() != null && vo.getCategory_5().length() > 0 ){ %>
						<li>
						<a href="ShopServlet?command=ProIndex&shopname=<%=ShopServlet.adminid%>
						&contents=<%hvo.getCategory_5();
			System.out.print(vo.getCategory_5());%><%=vo.getCategory_5()%>&prodid=">
								<%=vo.getCategory_5()%>
						</a></li>
						<% } %> 
					</ul>
					<script>
						$("span.menu").click(function() {
							$(".top-nav ul").slideToggle(500, function() {
							});
						});
					</script>

					<div class="clearfix"></div>
				</div>
				<!-- <div class="search">
					<form>
						<input type="text" value="Search" onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = '';}"> <input
							type="submit" value="">
					</form>
				</div> -->
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</header>

<footer>

<%-- <div class="footer">
<div class="container">

<div class="footer-left">
				<a href="ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid%>&contents=&prodid=">
					<img src="<%=vo.getLogo_img2()%>" alt=" ">
				</a>
			</div>
			</div>
			</div> --%>
			
			
</footer>
</html>
