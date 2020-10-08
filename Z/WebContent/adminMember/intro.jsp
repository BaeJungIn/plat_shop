<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
.text_box, .text_box h6 {
	font-family: 'Jeju Gothic';
	text-align : center;
}
</style>
</head>
<body id="top">
<section id="pageintro" class="clear"> 
    
      <div class="text_box";>
      <ul class="nospace group services">
        <li class="one_third first">
          <article class="overlay"><a href="AdminServlet?command=admin_shop"><i class="fa fa-legal"></i></a>
            <h6 class="heading">쇼핑몰 이동</h6>
            <footer><a href="AdminServlet?command=admin_shop">쇼핑몰로 이동하기&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="AdminServlet?command=CategoryForm"><i class="fa fa-line-chart"></i></a>
            <h6 class="heading">쇼핑몰 구축</h6>
            <footer><a href="AdminServlet?command=CategoryForm">쇼핑몰 만들기&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="https://imgur.com/"><i class="fa fa-archive"></i></a>
            <h6 class="heading">이미지 등록</h6>
            <footer><a href="https://imgur.com/">이미지 등록하러가기 &raquo;</a></footer>
          </article>
        </li>
      </ul>
      </div>
    </section>



<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>