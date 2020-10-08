<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Fashion Store</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
function go_update(adminid){
    if (document.formm.pwd.value == "") {
          alert("비밀번호를 입력하여 주세요.");
          document.formm.pwd.focus();
        } else if ((document.formm.pwd.value != document.formm.pwdCheck.value)) {
          alert("비밀번호가 일치하지 않습니다.");
          
          document.formm.pwd.focus();
        } else if (document.formm.email.value == "") {
          alert("이메일을 입력해주세요.");
          document.formm.email.focus();
        } else {
          document.formm.action = "ShopServlet?command=update&shopname="+adminid+"&contents=&prodid=";
          document.formm.submit();
      }
}
</script>
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
     <form id="join" action="ShopServlet?command=update&shopname=<%=ShopServlet.adminid%>&contents=&prodid=" method="post" name="formm"> 
     
   <div class="content">
      <div class="container">                   
      <div class="register">
             <div class="  register-top-grid">
             
               <h3>Update</h3>
               
               <div class="mation">
               
               
               <label style="color: orange">
                           ${sessionScope.loginUser.id}님 정보 수정</label>
                           
                        <%--  <span>ID<label>*</label></span>
                   <input type="text" name="id" value="${sessionScope.loginUser.id}"><br>  --%>
                           
                  <span>PASSWORD<label>*</label></span>
                   <input type="password" name="pwd"><br> 
                  
                  <span>CONFRIM PASSWORD<label>*</label></span>
                   <input type="password" name="pwdCheck"><br> 
                   
                   <span>EMAIL<label>*</label></span>
                   <input type="text" name="email">
                   
                   <span>PHONE<label>*</label></span>
                   <input type="text" name=phone>
                   
                   <span>ADDRESS CODE<label>*</label></span>
                   <input type="text" name="zipNum" size="10" >      
                     <input type="button" value="주소 찾기" class="dup" onclick="post_zip()">
                  
                   <span>ADDRESS<label>*</label></span>
                   <input type="text" name="addr1" size="50">
                     <!-- <input type="text" name="addr2" size="25"> -->
        
                   <span>AGE<label>*</label></span>
                   <input type="text" name="age"> 
               </div>
                <div class="clearfix"> </div>
                 <input type="button"    value="수정하기"   class="submit"  onclick="go_update('<%=ShopServlet.adminid%>')">
                   <input type="reset"      value="취소"     class="cancel">
                  </div>
                </div>
         </div>
       </div>
   </form>
   <%@ include file="../footer.jsp" %> 
</body>
</html>