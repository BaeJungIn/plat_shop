<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script type="text/javascript">
function admin_save() {
	if (document.formadm.logo1.value == "") {
		alert("로고이미지1을 등록하여 주세요.");
		document.formadm.logo1.focus();
	} else if (document.formadm.logo2.value == "") {
		alert("로고이미지2를 등록하여 주세요.");
		document.formadm.logo2.focus();
	} else if (document.formadm.mainimg1.value == "") {
		alert("메인이미지1을 등록하여 주세요.");
		document.formadm.mainimg1.focus();
	} else if (document.formadm.mainimg2.value == "") {
		alert("메인이미지2를 등록하여 주세요.");
		document.formadm.mainimg2.focus();
	} else if (document.formadm.category1.value == "") {
		alert("한 개 이상의 카테고리가 등록되어야 합니다.");
		document.formadm.category1.focus();
	} else {
		document.formadm.action = "AdminServlet?command=InsertCategory";
		document.formadm.submit();
	}
}
</script>
</head>
<body> 
<%-- <jsp:include page="../../adminShopHeader.jsp"/>  --%>
	  <form id="insertCategory" action="AdminServlet?command=InsertCategory" method="post" name="formadm">
	<div class="content">
		<div class="container"> 			         
		<div class="register">
		  	  <!-- <form>  -->
				 <div class="  register-top-grid">
				 
					<h3>카테고리 등록</h3>
					
					<div class="mation">
					
					     <label style="color: orange">
                        ${user.shop_admin_id }님 쇼핑몰 등록</label> 

						<span>Logo_img1<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
						 <input type="text" name="logo1"><br> 
						
						<span>Logo_img2<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
						 <input type="text" name="logo2"><br>  
						
						<span>MainImg1<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
						 <input type="text" name="mainimg1"><br> 
					 
						 <span>MainImg2<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
						 <input type="text" name="mainimg2">
						 
						 <span>Category1<label>*</label></span>
						 <input type="text" name="category1">
						 
						 <span>Category2</span>
						 <input type="text" name="category2">
						 
						 <span>Category3</span>
						 <input type="text" name="category3" >      
						
						 <span>Category4</span>
						 <input type="text" name="category4">
        
						 <span>Category5</span>
						 <input type="text" name="category5"> 
						 
					</div>
					 <div class="clearfix"> </div>
					  <input type="button"    value="등록"   class="submit" onclick="admin_save()">
        			  <input type="reset"      value="취소"     class="cancel">
					   </div>
					  
					 </div>
		   </div>
		 </div>
	</form>
<%-- 	<jsp:include page="../../adminShopFooter.jsp"/>  --%>
</body>
</html>
