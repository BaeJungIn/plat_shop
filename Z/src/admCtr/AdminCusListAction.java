package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;
import shopDao.OrderDAO;
import shopDto.MemberVO;
import shopDto.OrderVO;

public class AdminCusListAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adminMember/cusList.jsp";
	    
	    HttpSession session = request.getSession();
	    AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");    
	    
	   
	      AdminDAO adminDAO = AdminDAO.getInstance();
	      System.out.println("admin cusList id : " + loginUser.getShop_admin_id());
	      ArrayList<MemberVO> cusList = adminDAO.adminCusList(loginUser.getShop_admin_id());
	      System.out.println("ÂïÂï");
	    	  request.setAttribute("cusList", cusList);
	    	  System.out.println("ÂïÂï");
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	  	    dispatcher.forward(request, response);

	}

}
