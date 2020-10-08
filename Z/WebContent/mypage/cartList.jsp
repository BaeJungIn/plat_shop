<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shopCtr.ShopServlet"%>
<%@ page import="java.util.*, util.*, shopDao.*, shopDto.*"%>
<%@ include file="../header.jsp"%>
<style>
table#cartList {
    border-collapse:collapse;    
    border-top: 2px solid  #333;    
    border-bottom: 1px solid  #333; 
    width:80%;                 
    margin-bottom: 50px;
    
}
 
table#cartList th, td{   
    border-bottom: 1px dotted  #333; 
   text-align: center;
}

.wrap {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -86px;
    margin-left: -89px;
    text-align: center;
}

a {
    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);
    display: block;
    margin: 20px auto;
    max-width: 180px;
    text-decoration: none;
    border-radius: 4px;
    padding: 20px 30px;
}

a.button {
    color: rgba(30, 22, 54, 0.6);
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
}

a.button:hover {
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}

a.button2 {
    color: rgba(30, 22, 54, 0.6);
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
}

a.button2:hover {
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(30, 22, 54, 0.7) 0 80px 0px 2px inset;
}
</style>
<center>

<article >
<br>
	<h2>Cart List</h2>
	<br><br>
	<form name="formm" method="post">
		<c:choose>
			<c:when test="${cartList.size() == 0}">
				<h3 style="color: red; text-align: center;">장바구니가 비었습니다.</h3>
				<input type = "hidden" name = "prod_id" value = "${cartVO.prod_id }"/>
				<input type="hidden" name="prod_name" value="${productVO.prod_name}" />
				<input type="hidden" name="shopname" value= <%=ShopServlet.adminid%> />
			</c:when>
			<c:otherwise>
				<table id="cartList">
					<tr>
						<th>상품명&emsp;</th>
						<th>수 량&emsp;</th>
						<th>가 격&emsp;</th>
						<!-- <th>주문일</th> -->
						<th>삭 제&emsp;</th>
					</tr>

					<c:forEach items="${cartList}" var="cartVO">
						<tr>
							<td><a
								href="ShopServlet?command=ProDetail&shopname=<%=ShopServlet.adminid%>&contents=<%=ShopServlet.con %>&prodid=${cartVO.prod_id}"> <!-- http://localhost:8080/platshop1/ShopServlet?command=ProDetail&shopname=happyshop&contents=acc2_product&prodid=3 -->
									<h3>${cartVO.prod_name}&emsp;</h3> <!-- 상품명 --><%-- ${cartVO.category} --%>
							</a></td>
							<td>${cartVO.prod_price}&emsp;</td><!-- 수량 -->
							<td><fmt:formatNumber
									value="${cartVO.prod_price*cartVO.cart_num}" type="currency" /> <!-- 수량 * 가격 -->
							&emsp;</td>
							<%-- <td> <fmt:formatDate value="${cartVO.indate}" type="date"/></td>  --%>
							<td><input type="checkbox" name="cart_id"
								value="${cartVO.cart_id}">&emsp;</td>
						</tr>
					</c:forEach>

					<tr>
						<th colspan="2">총 액</th>
						<th colspan="2"><fmt:formatNumber value="${totalPrice}"
								type="currency" /><br></th>
								<!-- <input type="button" value="장바구니" class="submit" onclick="go_cart()"> -->
						
						
						
					</tr>
				</table>
				<input  type="button" value="주문하기" class="submit" onclick="go_order_insert('<%=ShopServlet.adminid%>')">
					<input type="button" value="삭제하기" class="submit" onclick="go_cart_delete('<%=ShopServlet.adminid%>')"><br><br>
						<!-- <a href="#" onclick="go_cart_delete()" ><h3>삭제하기</h3></a> -->
			</c:otherwise>
		</c:choose>

		<div class="clear"></div>

		<%-- <div id="buttons" style="float: right">
			<input type="button" value="쇼핑 계속하기" class="cancel"
				onclick="location.href='ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid %>&contents=&prodid='">
			<c:if test="${cartList.size() != 0}">
				<input type="button" value="주문하기" class="submit"
					onclick="go_order_insert('<%=ShopServlet.adminid%>')">
			</c:if>
		</div> --%>
	</form>
</article>
</center>
<%@ include file="../footer.jsp"%>