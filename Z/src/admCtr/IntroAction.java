package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;
import admDTO.ShopInfoVO;
import shopDto.MemberVO;

public class IntroAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminVO loginUser = (AdminVO) session.getAttribute("loginUser"); 
		
	   
	   /* AdminVO adminVO = new AdminVO();*/
	    MemberVO memberVO = new MemberVO();
	    AdminDAO adminDAO = AdminDAO.getInstance();
		
		String url = "adminMember/intro.jsp"; 
		 
		 adminDAO.insertCusMember(memberVO, loginUser.getShop_admin_id());
		    
		 RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		 dispatcher.forward(request, response);

	}

}
