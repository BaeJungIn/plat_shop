<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
	function go_delete(prod_id) {
		if (confirm("상품을 삭제하시겠습니까?")) {
			var theForm = document.frm;
			theForm.prod_id.value = prod_id;
			theForm.action = "AdminServlet?command=admin_prod_delete&category=${category}";
			theForm.submit();
		}
	}
	function go_proupdate(prod_id) {	
		var theForm = document.frm;
		theForm.prod_id.value = prod_id;
		theForm.action = "AdminServlet?command=admin_prod_updateform&category=${category}";
		theForm.submit();
	}
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
	<jsp:include page="../../adminShopHeader.jsp"/> 
	<!--content-->
<form name="frm" method="post">
<input type="hidden" name="prod_id">  
	<div class="content"> 
		<div class="container">
			<div class="  col-m-on">
				<!---->
				<div class="in-line">
					<div class="para-all">
						<h3>LATEST ARRIVALS</h3>
						<p>Check our all latest products in this section.</p> 
					</div>
					<div class="lady-on">
						<c:forEach items="${admProIndex}" var="productVO">
							<div class="col-md-4 you-men">
								<%-- <a href="ShopServlet?command=ProDetail&shopname=<%=ShopServlet.adminid%>&contents=<%=ShopServlet.con%>&prodid=${productVO.prod_id}"> --%>
								<img class="img-responsive pic-in" src="${productVO.prod_img}.png" alt=" ">
								<!-- </a> -->
								<p>${productVO.prod_name}</p>
								<span>${productVO.prod_price}</span>
								<input type="button" class="proudt" style="width: 80px" value="상품 수정" onClick="go_proupdate('${productVO.prod_id}')">
								<input type="button" class="prodel" style="width: 80px" value="상품 삭제" onClick="go_delete('${productVO.prod_id}')">
							</div>
						</c:forEach>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	<!---->
	<jsp:include page="../../adminShopFooter.jsp"/> 
</body>
</html>