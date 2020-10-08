<%@page import="shopCtr.ShopServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../adminheader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Join</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<style type="text/css">
table#join {
	
	width:20%;
    margin-top: 15px; 
}

table#join th, table#join td{   
   text-align: center;
   color:#191919;   
}
</style>
<script type="text/javascript">
function go_save() {
	  if (document.formm.id.value == "") {
	    alert("아이디를 입력하여 주세요");
	    document.formm.id.focus();
	  } else if (document.formm.pass.value == "") {
	    alert("비밀번호를 입력하여 주세요.");
	    document.formm.pass.focus();
	  } else if ((document.formm.pass.value != document.formm.pwdCheck.value)) {
	    alert("비밀번호가 일치하지 않습니다.");
	    document.formm.pass.focus();
	  } else if (document.formm.name.value == "") {
	    alert("이름을 입력하여 주세요.");
	    document.formm.name.focus();
	  } else if (document.formm.email.value == "") {
	    alert("이메일을 입력해주세요.");
	    document.formm.email.focus();
	  } else {
	    document.formm.action = "AdminServlet?command=admin_join";
	    document.formm.submit();
	  }
	}

	function idcheck(shopname) {
	  if (document.formm.id.value == "") {
	    alert('아이디를 입력하여 주십시오.');
	    document.formm.id.focus();
	    
	    return;
	  }
	  var url = "AdminServlet?command=id_check_form&shopname="+shopname+"&id=" + document.formm.id.value;
	  window.open( url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
	}

	function post_zip() {
	  var url = "AdminServlet?command=find_zip_num";
	  window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=300, top=300, left=300, ");
	}
</script>
</head>
<body id="top">
<div class="wrapper row3">
  <div class="container clear"> 
    <!-- main body -->
    <div class="content">
 <form id="join" action="AdminServlet?command=admin_join" method="post" name="formm">
<fieldset>
					<h3>Join Us</h3>
					
						<label>ID*</label>
						<input type="text" name="id" size="12" id="id" >
       				    <input type="hidden" name="reid">
					    <input type="button"    value="중복 체크"  class="dup" onclick="idcheck('<%=ShopServlet.adminid%>')"><br>
						<label>PASSWORD*</label>
						 <input type="password" name="pass"><br>
						
						 <label>CONFRIM PASSWORD*</label>
						 <input type="password" name="pwdCheck"><br> 
					 
						 <label>NAME*</label>
						 <input type="text" name="name"><br>
						 
						 <label>EMAIL*</label>
						 <input type="text" name="email"><br>
						 
						 <label>PHONE*</label>
						 <input type="text" name="phone"><br>
						 
						 <label>ADDRESS CODE*</label>
						 <input type="text" name="zipNum" size="10" >      
        				 <input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
						
						 <label>ADDRESS*</label>
						 <input type="text" name="addr1" size="50">
        				 <input type="text" name="addr2" size="25"><br>
						 
						 <label>SHOP DESIGN</label>
						 <input type="text" name="shop_design"> <br>
						 
						 <label>SHOP NAME*</label>
						 <input type="text" name="shop_name"> <br><br>
						 </fieldset>
					
					 <div class="clear"> </div>
					 
					 <input type="submit"    value="회원가입"   class="submit" onclick="go_save()">
        			  <input type="reset"      value="취소"     class="cancel">
					
	</form>
	</div>
	</div>
	</div>

</body>
</html>