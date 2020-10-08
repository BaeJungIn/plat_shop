package admCtr;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLoginFormAction implements AdminAction {

	  
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {    
	    String url = "adminMember/login.jsp";  
	     
	    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);    
	  }
	}

