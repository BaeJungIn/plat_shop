<!-- 마이페이지 메인 -->

<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>

<meta name="viewport" content="width=device-width">
<title>마이페이지</title>

<link rel="stylesheet" href="CSS/grid-guide.css">

<style>
.boxA:after {
	content: "";
	display: block;
	clear: both
}

.box1 {
	float: left;
	width: 70%
}

.box2 {
	float: left;
	width: 10%
}

.box3 {
	float: left;
	width: 50%
}

.box4 {
	float: left;
	width: 50%
}
</style>
</head>
<body>

	<center>
		<h1>mypage</h1>
		<br>
		<table>
			<tr>
				<td><a href="ShopServlet?command=update_form&shopname=<%=ShopServlet.adminid %>&contents=&prodid="><img src="images/mypage1.png" alt=" "></a></td>
				<td><a href="ShopServlet?command=userout&shopname=<%=ShopServlet.adminid %>&contents=&prodid="><img src="images/mypage2.png" alt=" "></a></td>
				<td><a href="ShopServlet?command=order_list&shopname=<%=ShopServlet.adminid %>&contents=&prodid="><img src="images/mypage3.png" alt=" "></a></td>
			</tr>	
		</table>
		<br><br>
	</center>
</body>
<%@ include file="../footer.jsp"%>
</html>
