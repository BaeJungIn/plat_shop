<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
</style>
<title>Fashion Store</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>

<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />   
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,700,300' rel='stylesheet' type='text/css'>
<!--//fonts-->
</head>
<body> 
 
    
    <form name="formm" method="post">
    <input type="hidden" name="shopname" value=<%=ShopServlet.adminid%> />
            <center>
            <br><br>
     <h3> 상품 주문 내역 </h3> 
     <br>
     <table id="cartList" >
     <tr>
       <th>상품번호</th> <th>상품명</th> <th>수량</th> <th>가격</th>    
     </tr>
     
     <c:forEach items="${orderList}"  var="orderVO">
     <tr>
       <td> ${orderVO.prod_id} </td>
       <td> ${orderVO.prod_name} </td>          
       <td> ${orderVO.prod_num} </td>
       <td> <fmt:formatNumber type="currency" value="${orderVO.prod_price*orderVO.prod_num}" /> </td>
     </tr>
     </c:forEach>    
     
     <tr>
        <th colspan="2">총 액</th>
        <th colspan="2">
        <fmt:formatNumber value="${totalPrice}" type="currency"/><br> </th>
     </table>   
          <h5> 주문 처리가 완료되었습니다.</h5>
          <br> <br>
    <%--  <div class="clear"></div>
     <div id="buttons" style="float: right">
       <input type="button"    value="쇼핑 계속하기"  class="cancel"  
onclick="location.href='ShopServlet?command=shop_&shopname=${shopname}'"> <!-- 수정 -->
     </div> --%>
    </center>
    </form> 
   
   
   <%@ include file="../footer.jsp" %> 
</body>
</html>
 
 
 
 