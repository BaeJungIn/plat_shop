<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, util.*, shopDao.*, shopDto.*, javax.servlet.*, admDTO.*"%>
<%
	HttpSession ses1 = request.getSession();
	AdminVO loginUser1 = (AdminVO) ses1.getAttribute("loginUser");
	FooterDAO footer = FooterDAO.getInstance();
	FooterVO fvo = new FooterVO();
	FooterVO fo = footer.getFooter(loginUser1.getShop_admin_id());
	//안될경우 밑에 fvoo 삭제
	FooterVO fvoo = new FooterVO();
	FooterVO foo = footer.getFooter1(loginUser1.getShop_admin_id());
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
	href='http://fonts.googleapis.com/css?family=Libre+Baskerville:400,700,400italic'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
</head>
<footer>
	<div class="footer">
		<div class="container">
			<div class="footer-class">
				<p class="footer-grid">
					&copy;
					<%-- 	<!-- 
					<%
	HeaderDAO header = HeaderDAO.getInstance();
	HeaderVO hvo = new HeaderVO();
	HeaderVO vo = header.getHeader(ShopServlet.adminid);
%>
					<%=vo.getLogo_img1()%>
					 --> --%>

					<%=fo.getShop_addr()%>
					<%=fo.getShop_tel()%>
					<%=fo.getShop_email()%>



					<%
						System.out.print(fo.getShop_addr());
					%>
					<%
						System.out.print(fo.getShop_tel());
					%>
					<%
						System.out.print(fo.getShop_email());
					%>
					<%
						System.out.println("로고 이미지 이름 : " + foo.getLogo_img2());
					%>

				</p>

			</div>
			<div class="footer-left">
				<a href="AdminServlet?command=admin_shop">
					<img src="<%=foo.getLogo_img2()%>.png" width="209" height="69" alt=" ">
				</a>
			</div>
			<!-- <div class="clearfix"></div> -->
		</div>
	</div>
</footer>

</html>