<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*,admDTO.*, admDAO.*, javax.servlet.http.HttpSession"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ include file="../../adminShopHeader.jsp"%>

<!-- <script>
function setSelectBox(){
	[document.getElementByName("categoryBox").selelctedIndex].text
	document.formm.action = "ShopServlet?admin_product_list";
}
</script> -->


<style>
/* 폰트 스타일  */
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);

article {
	padding-left: 30px;
}

body { 
	font-family: 'Hanna', serif;
	
	
}
</style>


<body>
<center>
	<form id="AdminProductUpdate" action="AdminServlet?admin_prod_update&category=${category}" method="post" name="formm">
		<input type="hidden" name="command" value="admin_prod_update"/> 
		<%-- <center> --%>	
		<h1>상품수정</h1><br><br>
		
		<span>상품번호 ${prod_id}의 상품수정</span> <br> 
		<input type="hidden" name="prod_id" value="${prod_id}">
		<span>상품명<label>*</label></span> <br> 
		<input type="text" name="prod_name" value="${prod.prod_name}"><br>
		<br> <span>상품가격<label>*</label></span> <br> 
		<input type="text" name="prod_price" value="${prod.prod_price}"><br>
		<br> <span>상품 이미지<label>*</label></span> <br> 
		<input type="text" name="prod_img" value="${prod.prod_img}"><br>
		<br> <span>상품 설명<label>*</label></span> <br> 
		<input type="text" name="prod_contents" value="${prod.contents}"><br>
		<br>  <span>상품 상세 설명 이미지<label>*</label></span> <br>
		<input type="text" name="con_img" value="${prod.con_img}"><br>
		<br> <span>상품 상세 이미지1<label>*</label></span> <br>
		<input type="text" name="prod_detail1" value="${prod.prod_detail1}"><br>
		<br> <span>상품 상세 이미지2<label>*</label></span> <br>
		<input type="text" name="prod_detail2" value="${prod.prod_detail2}"><br>
		<br> <span>상품 상세 이미지3<label>*</label></span> <br>
		<input type="text" name="prod_detail3" value="${prod.prod_detail3}"><br>
		<br> <span>상품 상세 이미지4<label>*</label></span> <br>
		<input type="text" name="prod_detail4" value="${prod.prod_detail4}"> 
			<br>
		<br> <span>상품 수량<label>*</label></span> <br> 
		<input type="text" name="count" value="${prod.count }"><br>
		<br> <input class="btn" type="submit" value="수정" onClick="location='AdminServlet?command=admin_prod_update&category=${category}'"/> <!--  onClick="location='AdminServlet?command=admin_product_write'" --> 
			<input class="btn" type="button" value="취소" onClick="go_mov()"/>
	</form>
	</center>
</body>
<%@ include file="../../adminShopFooter.jsp"%>
</html>
