<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
 <%@ include file="../../adminShopHeader.jsp"%>
<%@ include file="../../adminShopFooter.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="shopCtr.ShopServlet"%>
<article >
<br><br>
   <h2>Product List</h2><br><br>

   <form action="productList.jsp" name="formm" method="post">
      <c:choose>
         <c:when test="${productList.size() == 0}">
            <h3 style="color: red; text-align: center;">장바구니가 비었습니다.</h3>
         </c:when>
         <c:otherwise>
            <table id="productList">
               <tr>
                  <th>상품명&emsp;&emsp;&emsp;</th>
                  <th>카테고리&emsp;&emsp;&emsp;</th>
                  <th>수 량&emsp;&emsp;&emsp;</th>
                  <th>가 격&emsp;&emsp;&emsp;&emsp;&emsp;</th>
                  
                  <th>삭 제&emsp;</th>
               </tr>

               <c:forEach items="${productList}" var="productVO">
                  <tr>
                  <input type="hidden" name = "name" value="${productVO.prod_name}">
                  <input type="hidden" name = "categoryBox" value="">
                  <input type="hidden" name = "count" value="${productVO.count}">
                  <input type="hidden" name = "price" value="${productVO.prod_price}">
                     <td><a href="ShopServlet?command=ProDetail&shopname=<%=ShopServlet.adminid %>&contents=${cartVO.category}&prodid=${cartVO.prod_id}">
                     <!--  콘텐츠만 제대로 넘어오면 끝남   -->
                        <%-- <a href="ShopServlet?command=ProDetail&Shopname=<%=ShopServlet.adminid %>&contents=<%=ShopServlet.con %>&prodid=${cartVO.prod_id}"> --%>
                           <h4>${productVO.prod_name}&emsp;&emsp;&emsp;</h4></a></td>
                           <td>${productVO.contents}&emsp;&emsp;&emsp;</td>
                     <td>${productVO.count}&emsp;&emsp;&emsp;</td>
                        
                     <td>${productVO.prod_price}&emsp;&emsp;&emsp;</td>
                     
                     <td><input type="checkbox" name="prod_id"
                        value="${productVO.prod_id}">&emsp;</td>
                  </tr>
               </c:forEach>

               <%-- <tr>
                  <th colspan="2">총 액</th>
                  <th colspan="2"><fmt:formatNumber value="${totalPrice}"
                        type="currency" /><br></th> --%>
                        
                  <th><input type="button" onclick="go_cart_delete()" value="삭제하기"></button></th>
               </tr>
            </table>
      </c:otherwise>
      </c:choose>
      <br><br><br>
      <input type="button" value="쇼핑 계속하기" class="cancel"
            onclick="location.href='ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid %>&contents=&prodid='">
         <c:if test="${cartList.size() != 0}">
            <input type="button" value="주문하기" onclick="location.href='ShopServlet?command=order_insert&shopname=<%=ShopServlet.adminid %>&contents=&prodid='">
         </c:if>
<br><br><br>
      <div class="clear"></div>

      <div id="buttons" style="float: right">
         
      </div>
   </form>
</article>
</body>
</html>