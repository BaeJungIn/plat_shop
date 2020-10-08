package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.QnaDAO;
import shopDto.MemberVO;
import shopDto.QnaVO;

public class QnaListAction implements Action {

	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "qna/qnaList.jsp";
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
	    
	    if (loginUser == null) {
	      url = "ShopServlet?command=login_form&shopname="+ShopServlet.adminid+"&contents=&prodid=";
	    } else {
	      QnaDAO qnaDAO = QnaDAO.getInstance();      
	      ArrayList<QnaVO> qnaList = qnaDAO.listQna(loginUser.getId());
	      System.out.println("loginUser : "+loginUser.getId());
	      request.setAttribute("qnaList", qnaList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	  }
	}
