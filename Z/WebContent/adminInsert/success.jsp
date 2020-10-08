<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
h4 {
  font-family: 'Jeju Gothic';
  font-size: 20px;
   color: #191919; 
  font-weight: normal;
}

input[type=submit] {
   font-family: FontAwesome;
   color: #191919;
   background-color:#4C4C4C: 
}
</style>
</head>
<body id="top">



<div class="wrapper row3">
  <div class="container clear"> 
    <!-- main body -->
    <div class="content"> 
      <form method="post" action="AdminServlet?command=admin_intro">
      <center>
		 <h4> 등록이 완료되었습니다.</h4>
        <div class="clear"></div>
        <br><br>
      <div id="buttons">
 <input type="submit"    value="확인"   class="submit"  >
  </div>
  </center>
 </form>
 </div>
 </div>
 </div>
</body>
</html>