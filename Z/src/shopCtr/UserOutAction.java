package shopCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.MemberDAO;
import shopDto.MemberVO;

public class UserOutAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      HttpSession session = request.getSession();
	      String url = "index.jsp"; 
	      
	      
	      MemberDAO memberDAO = MemberDAO.getInstance();
	      
	      
	      MemberVO memberVO = new MemberVO();
	      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser"); 
	      if (loginUser == null) {
		        url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid + "&contents=&prodid=";
		      } else {

	       memberVO.setId(loginUser.getId());

	       
	      
	      
	       memberDAO.userOut(loginUser.getId());
	     
	       
	       
	       RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	       dispatcher.forward(request, response);

	   }
	}
}
