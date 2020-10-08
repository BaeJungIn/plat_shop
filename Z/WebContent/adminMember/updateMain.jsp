<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@page import="admCtr.AdminServlet"%>
<%@ include file="../adminheader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, admCtr.*, admDAO.*, admDTO.*"%>
<%-- <%
	ShopInfoDAO shopInfoDAO = ShopInfoDAO.getInstance();
	ShopInfoVO shopInfoVO = new ShopInfoVO();
%> --%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Viral | Pages | Full Width</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<script type="text/javascript">
function go_update(){
	 if (document.formm.shop_admin_pass.value == "") {
		    alert("비밀번호를 입력하여 주세요.");
		    document.formm.pwd.focus();
		  } else if ((document.formm.pwd.value != document.formm.pwdCheck.value)) {
		    alert("비밀번호가 일치하지 않습니다.");
		    document.formm.pwd.focus();
		  } else if (document.formm.email.value == "") {
			 alert("이메일을 입력해주세요.");
			 document.formm.email.focus();
		  } else {
			 document.formm.action = "AdminServlet?command=admin_main_update";
			 document.formm.submit();
		}
}
</script>
</head>
<body> 
     <form id="CategoryForm" action="AdminServlet?command=admin_main_update" method="post" name="formm">
   <div class="content">
      <div class="container">                   
      <div class="register">
             <!-- <form>  -->
             <div class="  register-top-grid">
             
               <h3>카테고리 등록</h3>
               
               <div class="mation">
                  <span>Shop ID<label>*</label></span><!-- 이 값은 정인이 로그인부분에서 id 받아오는걸로 -->
<!--                   <input type="text" name="shopid" size="12"  value=""> -->
                       <input type="hidden" name="id">
                       
                  <label style="color: orange">
                        ${user.shop_admin_id }님 쇼핑몰 수정</label> 
                       
                  <span>Logo_img1<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
                  
                   <input type="text" name="logo_img1" value="${user.logo_img1 }"><br> 
                  
                  <span>Logo_img2<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
                   <input type="text" name="logo_img2" value="${user.logo_img2 }"><br>  
                  
                  <span>MainImg1<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
                   <input type="text" name="main_img1" value="${user.main_img1 }"><br> 
                
                   <span>MainImg2<label>*사진을 인터넷에 등록 후 주소를 넣어주세요*</label></span>
                   <input type="text" name="main_img2" value="${user.main_img2 }">
                   
                   <span>Category1<label>*</label></span>
                   <input type="text" name="category_1" value="${user.category_1 }">
                   
                   <span>Category2</span>
                   <input type="text" name="category_2" value="${user.category_2 }">
                   
                   <span>Category3</span>
                   <input type="text" name="category_3" value="${user.category_3 }">      
                  
                   <span>Category4</span>
                   <input type="text" name="category_4" value="${user.category_4 }">
        
                   <span>Category5</span>
                   <input type="text" name="category_5" value="${user.category_5 }"> 
                   
               </div>
                <div class="clearfix"> </div>
                 <input type="submit"    value="수정하기"   class="submit" onclick="go_update()">
                   <input type="reset"      value="취소"     class="cancel">
                  </div>
                 
                </div>
         </div>
       </div>
   </form>
   <%-- <%@ include file="../footer.jsp" %> --%> 
</body>
</html>