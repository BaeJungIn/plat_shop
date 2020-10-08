package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDao.MemberDAO;

	

public class IdCheckAdminAction implements AdminAction {

	  
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "/adminMember/idcheck.jsp";  
	    
	    String shop_admin_id = request.getParameter("id").trim();
	    
	    AdminDAO adminDAO=AdminDAO.getInstance();
	    int message = adminDAO.confirmID(shop_admin_id);
	        
	    request.setAttribute("message", message);
	    request.setAttribute("id", shop_admin_id);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
	}