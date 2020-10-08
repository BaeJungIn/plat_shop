<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../../adminShopHeader.jsp"/> 
<style>
h2, div h2{
	font-family: "Times New Roman", Times, serif;
	font-size: 30px; 
	color: #CCC;
	padding-bottom: 15px;
	border-bottom: 1px dotted #666; /* 제목 하단 부에 점선을 넣어 제목이라는 것을 표시해 줍니다. */	
}
form {
	margin: 10px 0 0 0;
	width: 670px;
}
table#orderList {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */
    border-top: 2px solid  #333;    
    border-bottom: 1px solid  #333; 
    width:100%;                  /* 전체 테이블 길이 설정 */
    margin-bottom: 20px;
}

table#orderList th, td{	
    border-bottom: 1px dotted  #333; 
	text-align: center;
}
</style>
  <center>
<h1>주문리스트</h1>
<form name="frm" method="post">
  <table id="orderList">
  <tr>
    <th>주문번호</th><th>주문자</th><th>상품명</th><th>상품가격</th>
    <th>수량</th><th>총가격</th><th>주문일</th>
  </tr>
  <c:forEach items="${orderList}" var="orderVO">
  <tr>
    <td>${orderVO.order_id}</td> <td>${orderVO.cus_id}</td>
    <td>${orderVO.prod_name}</td> <td>${orderVO.prod_price}</td>
    <td>${orderVO.prod_num}</td>  <td>${orderVO.total_price}</td>
    <td><fmt:formatDate value="${orderVO.order_time}" /></td>
  </tr>
  </c:forEach>
  </table>
  <input type="button" class="btn" style="width: 200px"
      value="쇼핑몰로 이동" onClick="location='AdminServlet?command=admin_shop'">

</form>
</center>
<jsp:include page="../../adminShopFooter.jsp"/> 
</body>
</html>