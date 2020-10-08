package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDto.MemberVO;

public class QnaWriteFormAction implements Action {

	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "qna/qnaWrite.jsp";
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
	    
	    if (loginUser == null) {
	    	System.out.println("�α����� �ʿ��� �����Դϴ�. ���̵� Ȯ���Ͽ� �ּ��� : "+loginUser);
	      url = "ShopServlet?command=login_form&shopname="+ShopServlet.adminid+"&contents=&prodid=";
	    } 
	    
	    request.getRequestDispatcher(url).forward(request, response);
	  }
	}
