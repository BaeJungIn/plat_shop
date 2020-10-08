package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;
import shopDto.MemberVO;

public class AdminInsertAction implements AdminAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adminMember/join2.jsp"; 
	    
	    HttpSession session = request.getSession();
	    AdminVO adminVO = new AdminVO();
	    AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");
	    MemberVO memberVO = new MemberVO();
	    
	    System.out.println(loginUser.getShop_admin_id());
	    adminVO.setShop_admin_id(loginUser.getShop_admin_id());
	    
	    session.setAttribute("id", request.getParameter("id")); 
	    
	    System.out.println("session : "+session.getAttribute("loginUser"));
	    
	    AdminDAO adminDAO = AdminDAO.getInstance();
	    adminDAO.insertCusMember(memberVO, loginUser.getShop_admin_id());
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
