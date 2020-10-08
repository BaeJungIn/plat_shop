<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
.text_box, .text_box h6 {
	font-family: 'Jeju Gothic', serif;
	text-align : center;
}
</style>
<head>

<title>Viral</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body id="top">

<div class="wrapper row2 bgded" style="background-color : black;">
  <div class="overlay">
    <section id="pageintro" class="clear"> 
      <div class="center btmspace-80">
        <h2 class="heading xxl uppercase btmspace-30">PlatShop</h2>
        <p class="xl nospace capitalise">Do you need a shopping mall? </p>
        <p class="xl nospace capitalise">Make it!</p>
      </div>
      <div class="text_box";>
      <ul class="nospace group services">
        <li class="one_third first">
          <article class="overlay"><a href="#"><i class="fa fa-legal"></i></a>
            <h6 class="heading">회원가입</h6>
            <p>간단한 가입으로 플랫폼 회원이 &nbsp; 되어 다양한 해택을 누려보세요!</p>
            <footer><a href="AdminServlet?command=admin_join_form">운영자 회원가입&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="#"><i class="fa fa-line-chart"></i></a>
            <h6 class="heading">쇼핑몰 구축</h6>
            <p>비용 무료, 시간 절감! 간단하게 &nbsp; 자신만의 쇼핑몰을 만들어보세요!</p>
            <footer><a href="AdminServlet?command=admin_login_form">운영자 로그인&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="adminMember/info.jsp"><i class="fa fa-archive"></i></a>
            <h6 class="heading">사용 방법</h6>
            <p>회원가입부터 홈페이지 구축까지 차근차근 배워봐요!</p>
            <footer><a href="adminMember/info.jsp">사용법 보기 &raquo;</a></footer>
          </article>
        </li>
      </ul>
      </div>
    </section>
  </div>
</div>


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>