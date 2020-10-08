<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
   function go_list()
   {
    var theForm = document.frm;
    theForm.action="AdminServlet?command=admin_qna_list";
    theForm.submit();
   }

   function go_rep(qseq)
   {
      var theForm = document.frm;
    theForm.qseq.value=qseq;
    theForm.action="AdminServlet?command=admin_qna_repsave";
    theForm.submit();
   }   
</script>
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
<jsp:include page="../../adminShopHeader.jsp"/> 
<center>
<h1>Q&amp;A 게시판</h1>   
<form name="frm" method="post">
<input type="hidden" name="qseq">
<table id="orderList">
    <tr>
        <th width="20%">제목</th>
        <td> ${qnaVO.subject} ${qnaVO.rep} </td>
    </tr>
   <tr>
         <th>등록일</th>
         <td> <fmt:formatDate value="${qnaVO.indate}"/> </td>  
    </tr>
    <tr>
        <th>내용</th>
        <td> ${qnaVO.content}</td>  
    </tr>
</table>
<c:choose>          
  <c:when test='${qnaVO.rep=="1"}'>
  <table id="orderList">
      <tr>
          <td colspan="2">
      <img src="admin/images/opinionimg01.gif">
      </td>
      </tr>
    <tr>
          <td colspan="2">    
      <textarea name="reply" rows="3" cols="50"></textarea>
      <input type="button" class="btn" value="저장" style="width: 200px" onClick="go_rep('${qnaVO.qseq}')">    
      </td>
      </tr>
  </table>
  <br>
  </c:when>
  <c:otherwise>  
  <table id="orderList">
    <tr>
     <th>댓글</th>
     <td> ${qnaVO.reply}</td>
    </tr>
  </table>
  </c:otherwise>
</c:choose>    
<input type="button" class="btn" value="목록" style="width: 200px" onClick="go_list()">
</form>
</center>
<jsp:include page="../../adminShopFooter.jsp"/> 
</body>
</html>