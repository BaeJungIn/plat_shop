<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>    
<style>
table#notice {
	width: 670px;
	border-collapse: collapse;
	border-top: 1px solid #999;
}

table#notice th {
	height: 20px;
	width: 70px;
	font-size: 14px; 
	font-weight: bold;
	padding: 5px; 
	color: #4a4a4a;
	border-bottom: 1px dotted #999;
}

table#notice td {
	text-align: left;
	padding: 6px 0;
	border-bottom: 1px dotted #999;
}

table#notice tr:hover {
	background-color: #DDF;
	cursor: pointer;
	color: red;
}
</style>
<center>
     <br> <h2> 1:1 고객 게시판 </h2><br>
     <br> <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    <br>
    <form name="formm" method="post">
    <table id="notice">
      <tr>
              <th>제목</th>
              <td>${qnaVO.subject}</td> 
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
      </tr>
      <tr>
        <th>질문내용</th>
        <td>${qnaVO.content} 
      </tr>
      <tr>
        <th>답변 내용</th>
        <td>${qnaVO.reply}  
      </tr>
    </table>
    <div class="clear"></div>
    <br><br>  <input type="button"  value="목록보기"     class="submit"  onclick="location.href='ShopServlet?command=qna_list&shopname=<%=ShopServlet.adminid%>&contents=&prodid='"> 
      <input type="button"  value="쇼핑 계속하기"  class="cancel"  onclick="location.href='ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid%>&contents=&prodid='">  <br><br>
    </form>
</center>
<%@ include file="../footer.jsp" %>