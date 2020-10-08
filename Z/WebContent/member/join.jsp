<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Fashion Store</title>
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
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<!--//fonts-->
</head>
<body> 
	  <form id="join" action="ShopServlet?command=join" method="post" name="formm">
	<div class="content">
		<div class="container"> 			         
		<div class="register">
		  	  <!-- <form>  -->
		  	  <form method="post" name="formm">
				 <div class="  register-top-grid">
				 <input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
					<h3>Join Us</h3>
					
					<div class="mation">
						<span>User ID<label>*</label></span>
						<input type="text" name="id" size="12"  >
       				    <input type="hidden" name="reid">
					<input type="button"    value="중복 체크"  class="dup" onclick="idcheck('<%=ShopServlet.adminid%>')"><br>
						<span>PASSWORD<label>*</label></span>
						 <input type="password" name="pwd"><br> 
						
						<span>CONFRIM PASSWORD<label>*</label></span>
						 <input type="password" name="pwdCheck"><br> 
					 
						 <span>NAME<label>*</label></span>
						 <input type="text" name="name">
						 
						 <span>EMAIL<label>*</label></span>
						 <input type="text" name="email">
						 
						 <span>PHONE<label>*</label></span>
						 <input type="text" name=phone>
						 
						 <span>ADDRESS CODE<label>*</label></span>
						 <input type="text" name="zipNum" size="10" >      
        				 <input type="button" value="주소 찾기" class="dup" onclick="post_zip('<%=ShopServlet.adminid%>')">
						
						 <span>ADDRESS<label>*</label></span>
						 <input type="text" name="addr1" size="50">
        				 <input type="text" name="addr2" size="25">
        
						 <span>AGE<label>*</label></span>
						 <input type="text" name="age"> 
					</div>
					 <div class="clearfix"> </div>
					  <input type="button"    value="회원가입"   class="submit" onclick="go_save('<%=ShopServlet.adminid%>')"> 
        			  <input type="reset"      value="취소"     class="cancel">
					   </div>
					   </form>
					 
					 </div>
		   </div>
		 </div>
	</form>
	<%@ include file="../footer.jsp" %> 
</body>
</html>
