<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*"%>
<%
	HeaderDAO header = HeaderDAO.getInstance();
	HeaderVO hvo = new HeaderVO();
	HeaderVO vo = header.getHeader(ShopServlet.adminid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편 번호 검색</title>
<link href="CSS/subpage.css" rel="stylesheet">
<style type="text/css">
body{   
   background-color:#191919;
   font-family: 'Jeju Gothic';
}
#popup{   
   padding: 0 10px;
}
#popup h1 {
   font-family: 'Jeju Gothic';
   font-size: 45px;
   color: #FFFFFF;
   font-weight: normal;
}

table#zipcode {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */   
    border-top: 3px solid  #FFFFFF;  
    border-bottom: 3px solid  #FFFFFF;
    width: 100%;  
    margin-top: 15px; 
}
table#zipcode th, table#zipcode td{   
   text-align: center;
   border-bottom: 1px dotted  #FFFFFF;  
   color:#FFFFFF;   
}
table th, td{
  padding: 10px;
}
table#zipcode  a{
   display:block; 
    height:20px;
    text-decoration:none;
    color:#FFFFFF;
    padding: 10px;
}
table#zipcode a:hover{
    color: #F90;
    font-weight: bold;
}dmd
</style>
<style type="text/css">
body{   
   background-color:#191919;
   font-family: 'Jeju Gothic';
}
#popup{   
   padding: 0 10px;
}
#popup h1 {
   font-family: 'Jeju Gothic';
   font-size: 45px;
   color: #FFFFFF;
   font-weight: normal;
}

table#zipcode {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */   
    border-top: 3px solid  #FFFFFF;  
    border-bottom: 3px solid  #FFFFFF;
    width: 100%;  
    margin-top: 15px; 
}
table#zipcode th, table#zipcode td{   
   text-align: center;
   border-bottom: 1px dotted  #FFFFFF;  
   color:#FFFFFF;   
}
table th, td{
  padding: 10px;
}
table#zipcode  a{
   display:block; 
    height:20px;
    text-decoration:none;
    color:#FFFFFF;
    padding: 10px;
}
table#zipcode a:hover{
    color: #F90;
    font-weight: bold;
}dmd
</style>

<script type="text/javascript">
	function result(zipNum, sido, gugun, dong) {
		opener.document.formm.zipNum.value = zipNum;
		opener.document.formm.addr1.value = sido + " " + gugun + " " + dong;
		self.close();
	};
</script>
</head>
<body>
	<div id="popup">
		<h1>우편번호검색</h1>
		<form method=post name=formm action="ShopServlet?command=find_zip_num&shopname=<%=ShopServlet.adminid%>">
			동 이름 : <input name="dong" type="text">
			 <input type="submit" value="찾기" class="submit">
				<input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
		</form>
		<table id="zipcode">
			<tr>
				<th>우편번호</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${addressList}" var="addressVO">
				<tr>
					<td>${addressVO.zipNum}</td>
					<td><a href="#"
						onclick="return result('${addressVO.zipNum}'
,'${addressVO.sido}', '${addressVO.gugun}','${addressVO.dong}')">
							${addressVO.sido} ${addressVO.gugun} ${addressVO.dong} </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>