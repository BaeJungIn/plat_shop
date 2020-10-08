package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.QnaDAO;
import shopDto.MemberVO;
import shopDto.QnaVO;

public class QnaWriteAction implements Action {

	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "ShopServlet?command=qna_list&shopname="+ShopServlet.adminid+"&contents=&prodid=";
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
	    
	    if (loginUser == null) {
	      url = "ShopServlet?command=login_form&shopname="+ShopServlet.adminid+"&contents=&prodid=";
	    }else{      
	      QnaVO qnaVO = new QnaVO();
	      qnaVO.setSubject(request.getParameter("subject"));
	      qnaVO.setContent(request.getParameter("content"));      
	      QnaDAO qnaDAO = QnaDAO.getInstance();
	      qnaDAO.insertqna(qnaVO, loginUser.getId());      
	    }    
	    response.sendRedirect(url);
	  }
	}
