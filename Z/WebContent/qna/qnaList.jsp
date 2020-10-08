<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>    
<style>
article {
	float: right;
	width: 680px;
	padding-right: 10px;
	font-family: Verdana, Geneva, sans-serif;
	font-size: 1em;
	line-height: 1.5em; 
}
article h2, div h2{
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
table#cartList {
    border-collapse:collapse;    /* border 사이의 간격 없앰 */
    border-top: 2px solid  #333;    
    border-bottom: 1px solid  #333; 
    width:100%;                  /* 전체 테이블 길이 설정 */
    margin-bottom: 20px;
}

table#cartList th, td{	
    border-bottom: 1px dotted  #333; 
	text-align: center;
}
</style>
 <!--  <article> -->
 <center>
    <h2> 1:1 고객 게시판 </h2>
    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
    <form name="formm" method="post">
      <table id="cartList">
      <tr>
        <th>번호</th> <th>제목</th> <th>등록일</th> <th>답변 여부</th>    
      </tr>
      <c:forEach items="${qnaList}"  var="qnaVO">
      <tr>  
        <td> ${qnaVO.qseq} </td>    
        <td> <a href="ShopServlet?command=qna_view&shopname=<%=ShopServlet.adminid%>&contents=&prodid=&qseq=${qnaVO.qseq}"> ${qnaVO.subject} </td>      
        <td> <fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
        <td> 
          <c:choose>
            <c:when test="${qnaVO.rep==1}"> no </c:when>
            <c:when test="${qnaVO.rep==2}"> yes </c:when>
          </c:choose>
        </td>    
      </tr>
      </c:forEach>    
      </table>
      <div class="clear"></div>
      <input type="button"  value="1:1 질문하기"  class="submit" onclick="location.href='ShopServlet?command=qna_write_form&shopname=<%=ShopServlet.adminid%>&contents=&prodid='">
      <input type="button" value="쇼핑 계속하기" class="cancel"  onclick="location.href='ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid%>&contents=&prodid='">
    </form>
 </center>
<!--   </article> -->
<%@ include file="../footer.jsp" %>