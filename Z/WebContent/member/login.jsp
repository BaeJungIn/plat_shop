<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*"%>

<article>
	<center>
		<h1>Login</h1>
		<form method="post" name =formm action="ShopServlet?command=login&shopname=<%=ShopServlet.adminid%>&contents=&prodid=">
			<fieldset>
				<legend></legend>
				<input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
				<label>User ID</label> <input name="id" type="text" value="${id}"
					value="one"><br> <label>Password</label> <input
					name="pwd" type="password"><br>
				<!-- value="1111" -->
			</fieldset>
			<div class="clear"></div>
			<div id="buttons">
				<input type="submit" value="로그인" class="submit">
				<input type="button" value="회원가입" class="cancel"
					onclick="location='ShopServlet?command=join_form&shopname=<%=ShopServlet.adminid%>&contents=&prodid='">
				
			</div>
		</form>
	</center>

</article>
<%@ include file="../footer.jsp"%>
