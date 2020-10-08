<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
  function go_view(qseq) {
    var theForm = document.frm;
    theForm.qseq.value = qseq;
    theForm.action = "AdminServlet?command=admin_qna_detail";
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
<br><h1>Q&amp;A 게시글 리스트</h1>  <br>
<form name="frm" method="post">
<input type="hidden" name="qseq">  
<table id="orderList">
  <tr>
    <th>번호(답변여부)</th> <th>제목</th> <th>작성자</th> <th>작성일</th>    
  </tr>
  <c:forEach items="${qnaList}" var="qnaVO">  
      <tr>
      <td>
      ${qnaVO.qseq}  
      <c:choose>          
        <c:when test='${qnaVO.rep=="1"}'>(미처리)</c:when>
        <c:otherwise>(답변처리완료)</c:otherwise>
      </c:choose>      
      </td>
      <td> 
      <a href="#" onClick="javascript:go_view('${qnaVO.qseq}')">
        ${qnaVO.subject} 
      </a>
      </td>
      <td> ${qnaVO.cus_id} </td>
      <td> <fmt:formatDate value="${qnaVO.indate}"/></td>
      </tr>
    </c:forEach>
    </table>
    <input type="button" value="쇼핑몰로 이동" style="width: 200px" onclick="location='AdminServlet?command=admin_shop'"><br><br>
    </form>    
    </center>
<jsp:include page="../../adminShopFooter.jsp"/> 
</body>
</html>