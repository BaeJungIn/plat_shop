package shopCtr;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDto.MemberVO;


public class UpdateFormAction implements Action {
	     public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {    
	       String url = "member/update.jsp";  
	       
		    
		    HttpSession session = request.getSession();
		    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");   
		    //session.setAttribute("id", request.getParameter("id"));
		    System.out.println(loginUser);
		    if (loginUser == null ) {
		       // url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid ;
		    	url = "member/login.jsp";
		    } else {
	       
	       
	       RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	       dispatcher.forward(request, response);
		      }
	     }
	   }

