<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">



<div class="wrapper row3">
  <div class="container clear"> 
    <!-- main body -->
    <div class="content"> 
      <form method="post" action="AdminServlet?command=admin_login">
      <fieldset>
         <h3>Login</h3>
         <label>User ID</label>
         <input name="shop_admin_id" type="text" value="${id}" value="one"><br>
          <label>Password</label>
          <input name="shop_admin_pass" type="password"><br><br>
         <!-- value="1111" -->
      </fieldset>
      <div class="clear"></div>
      <div id="buttons">
         <input type="submit" value="login" class="submit">
         <input type="button" value="join" class="cancel" onclick="location='AdminServlet?command=admin_join_form'">
         <input type="button" value="find" class="submit" onclick="location='AdminServlet?command=admin_find_id_form'">
      </div>
   </form>
    </div>
    <!-- / main body -->
    <div class="clear"></div>
  </div>
</div>

<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS -->
<script src="../layout/scripts/jquery.min.js"></script>
<script src="../layout/scripts/jquery.backtotop.js"></script>
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>