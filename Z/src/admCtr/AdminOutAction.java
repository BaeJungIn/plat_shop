package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDAO.AdminProductDAO;
import admDAO.ShopInfoDAO;
import admDTO.AdminVO;
import admDTO.ShopInfoVO;
import shopDto.MemberVO;
import shopDto.ProductVO;

public class AdminOutAction implements AdminAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = "index_main.jsp"; 
		ShopInfoDAO shopInfoDAO = ShopInfoDAO.getInstance();
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		AdminVO adminVO = new AdminVO();
		AdminVO loginUser = (AdminVO) session.getAttribute("loginUser"); 
	    

	    adminVO.setShop_admin_id(loginUser.getShop_admin_id());

	    
	   
	    shopInfoDAO.adminOut(loginUser.getShop_admin_id());
	    adminDAO.adminOut(loginUser.getShop_admin_id());
	    adminDAO.schemaOut(loginUser.getShop_admin_id());
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
