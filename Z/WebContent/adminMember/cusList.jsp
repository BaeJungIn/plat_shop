<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../adminShopHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<body> 
 
    
    <form name="formm" method="post">
            <center>
            <br><br>
     <h3> 고객 리스트 </h3> 
     <br>
     <table id="cartList" >
     <tr>
       <th>아이디</th> <th>비밀번호</th> <th>이름</th> <th>이메일</th> <th>번호</th> <th>주소</th>
       <th>나이</th> <th>우편번호</th>    
     </tr>
     
     <c:forEach items="${cusList}"  var="cusVO">
     <tr>
       <td> ${cusVO.id} </td>
       <td> ${cusVO.pwd} </td>          
       <td> ${cusVO.cus_name} </td>
       <td> ${cusVO.cus_email} </td>
       <td> ${cusVO.cus_phone} </td>
       <td> ${cusVO.cus_addr} </td>
       <td> ${cusVO.cus_age} </td>
       <td> ${cusVO.zip_num} </td>
      
     </tr>
     </c:forEach>    
     
    
     </table>   
        
    </center>
    </form> 
	
	
	<%@ include file="../adminShopFooter.jsp" %> 
</body>
</html>
 
 
 
 
