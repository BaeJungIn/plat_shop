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
            <h6 class="heading">ȸ������</h6>
            <p>������ �������� �÷��� ȸ���� &nbsp; �Ǿ� �پ��� ������ ����������!</p>
            <footer><a href="AdminServlet?command=admin_join_form">��� ȸ������&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="#"><i class="fa fa-line-chart"></i></a>
            <h6 class="heading">���θ� ����</h6>
            <p>��� ����, �ð� ����! �����ϰ� &nbsp; �ڽŸ��� ���θ��� ��������!</p>
            <footer><a href="AdminServlet?command=admin_login_form">��� �α���&raquo;</a></footer>
          </article>
        </li>
        <li class="one_third">
          <article class="overlay"><a href="adminMember/info.jsp"><i class="fa fa-archive"></i></a>
            <h6 class="heading">��� ���</h6>
            <p>ȸ�����Ժ��� Ȩ������ ������� �������� �������!</p>
            <footer><a href="adminMember/info.jsp">���� ���� &raquo;</a></footer>
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