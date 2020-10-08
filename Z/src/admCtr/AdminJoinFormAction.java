package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminJoinFormAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url = "adminMember/join.jsp";  
		    
		    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
	}

}
