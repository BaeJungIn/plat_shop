<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color:#191919;
  font-family: 'Jeju Gothic';
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: 'Jeju Gothic';
  font-size: 45px;
  color: #FFFFFF;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(){
  opener.formm.id.value=document.formm.id.value; 
  self.close();
}
</script>
</head>
<body>
<div id="wrap">
  <h1>ID 중복확인</h1>
  <form method=post name=formm style="margin-right:0 "
action="AdminServlet?command=id_check_form" >
    User ID <input type=text name="id" value=""> 
            <input type=submit value="검색" class="submit"><br>     
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.id.value="";
        </script>
        <label style="color:white;" >${id}는 이미 사용중인 아이디입니다.</label>
      </c:if>
      <c:if test="${message==-1}">
        ${id}는 사용 가능한 ID입니다.
        <input type="button" value="사용" class="cancel" onclick="idok()">
      </c:if>
    </div>
  </form>
</div>  
</body>
</html> --%>

<%@page import="shopDto.HeaderVO"%>
<%@page import="shopDao.HeaderDAO"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, admDAO.*, admDTO.*"%>
<%
	HeaderDAO header = HeaderDAO.getInstance();
	HeaderVO hvo = new HeaderVO();
	HeaderVO vo = header.getHeader(ShopServlet.adminid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
  background-color:#FFFFFF;
  font-family: 'Jeju Gothic';
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-family: 'Jeju Gothic';
  font-size: 45px;
  color: #191919;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(userid){
  opener.formm.id.value="${id}"; 
  self.close();
}
</script>
</head>
<body>
	<div id="wrap">
		<h1>ID 중복확인</h1>
		<form method=post name=formm style="margin-right: 0"
			action="ShopServlet?command=id_check_form">
			User ID <input type=text name="id" value=""> <input
				type=submit value="검색" class="submit"><br>
				<input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
			<div style="margin-top: 20px">
				<c:if test="${message == 1}">
					<script type="text/javascript">
						opener.formm.id.value = "";
					</script>
        ${id}는 이미 사용중인 아이디입니다.
      </c:if>
				<c:if test="${message==-1}">
				<script type="text/javascript">
				opener.formm.id.value=document.formm.id.value;
					</script>
        ${id}는 사용 가능한 ID입니다.
        <input type="button" value="사용" class="cancel" onclick="idok()">
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>