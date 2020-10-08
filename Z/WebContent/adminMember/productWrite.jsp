<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*,admDTO.*, admDAO.*, javax.servlet.http.HttpSession"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ include file="../../adminShopHeader.jsp"%>

<script>
function setSelectBox(){
   [document.getElementByName("categoryBox").selelctedIndex].text
   document.formm.action = "ShopServlet?admin_product_list";
}
</script>


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
<!--    <form id="AdminProductWrite" action="ShopServlet?admin_product_write" method="post" name="formm"> -->
   <form id="AdminProductWrite" action="AdminServlet?command=admin_product_write" method="post" name="formm">
      <input type="hidden" name="command" value="admin_product_write"/> 
      <%-- <center> --%>   
      <h1>상품등록</h1><br><br>
      <label>카테고리를 선택해주세요*</label><br>
         <select name="categoryBox" id="categoryBox" >
            <option value="${user.category_1}" >${user.category_1}</option>
            <option value="${user.category_2}" >${user.category_2}</option>
            <option value="${user.category_3}" >${user.category_3}</option>
            <option value="${user.category_4}" >${user.category_4}</option>
            <option value="${user.category_5}" >${user.category_5}</option>
         </select><br><br>
      
      <span>상품명<label>*</label></span> <br> <input type="text"
         name="name"><br>
      <br> <span>상품가격<label>*</label></span> <br> <input
         type="text" name="price"><br>
      <br> <span>상품 이미지<label>*</label></span> <br> <input
         type="text" name=img><br>
      <br>  <span>상품 상세 설명 이미지<label>*</label></span> <br> <input
         type="text" name="con_img"><br>
         <br>  <span>상품 상세 설명 <label>*</label></span> <br> <input
         type="text" name="contents"><br>
      <br> <span>상품 상세 이미지1<label>*</label></span> <br> <input
         type="text" name="prod_detail1"><br>
      <br> <span>상품 상세 이미지2<label>*</label></span> <br> <input
         type="text" name="prod_detail2"><br>
      <br> <span>상품 상세 이미지3<label>*</label></span> <br> <input
         type="text" name="prod_detail3"><br>
      <br> <span>상품 상세 이미지4<label>*</label></span> <br> <input
         type="text" name="prod_detail4"> 
         <br>
      <br> <span>상품 수량<label>*</label></span> <br> <input
         type="text" name="count"><br>
      <br> <input class="btn" type="submit" value="등록" /> <!--  onClick="location='AdminServlet?command=admin_product_write'" --> 
         <input class="btn" type="button" value="취소" onClick="go_mov()"/>


   </form>
</center>   
</body>
<%@ include file="../../adminShopFooter.jsp"%>
</html>