package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	 
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url="ShopServlet?command=shop_&shopname="+ShopServlet.adminid;
	    
	    HttpSession session=request.getSession(false);
	    if(session!=null){
	      session.invalidate();
	    }    
	    
	    request.getRequestDispatcher(url).forward(request, response);  
	  }
	}
