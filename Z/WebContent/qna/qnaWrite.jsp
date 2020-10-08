<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<style>
form {
	margin: 10px 0 0 0;
	width: 670px;
}

form fieldset {
	padding: 10px 0 20px 5px;
	border: none;
}

form fieldset legend {
	font-size: 20px; /* 제목으로 사용되기 때문에 크기를 크게 잡아 줍니다. */
	border-bottom: 1px dotted #666; /* 제목 하단 부에 점선을 넣어 제목이라는 것을 표시해 줍니다. */
	width: 600px; /* 전체 크기를 잡아 줍니다. */
	padding: 5px 0; /* 위와 아래로 여백을 주고 좌우로는 여백을 없애버립니다. 
                                      여백을 안 주게 되면 밑줄과 너무 붙어버려 보기에 좋지 않습니다. */
}

form label {
	width: 140px; /* 전체의 크기를 정의합니다. */
	float: left; /* 왼쪽으로 이동시킵니다. */
	margin: 5px 0; /* 마진을 이용해서 상하로 간격을 줍니다. */
}

form input {
	margin: 5px 0; /* label과 마찬가지로 여기도 동일하게 상하로 간격을 줍니다. */
	border: 1px solid #999; /* input 박스의 테두리 모양을 정의해 줍니다. */
	background-color: #FCFDEA; /* 배경색을 이용하여 바탕화면 색과 차별을 줍니다. */
}
</style> 
<center>
	    <h2> 1:1 고객 게시판 </h2>
	    <h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>    
		<form name="formm" method="post" action="ShopServlet?command=qna_write&shopname=<%=ShopServlet.adminid%>&contents=&prodid=">
			<fieldset>	
				<legend>Board Info</legend>		
			    <label>Title</label>
			    <input type="text" name="subject"  size="77" ><br>
				<label>Content</label>
			    <textarea rows="8" cols="65" name="content"></textarea><br>
			</fieldset>   
		<div class="clear"></div>
			<input type="submit"  value="글쓰기"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel">
			<input type="button"  value="쇼핑 계속하기"  class="submit"  onclick="location.href='ShopServlet?command=shop_&shopname=<%=ShopServlet.adminid%>&contents=&prodid='">	
		</form>
</center>
<%@ include file="../footer.jsp" %>