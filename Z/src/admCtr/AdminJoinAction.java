package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;
import shopDao.MemberDAO;
import shopDto.MemberVO;

public class AdminJoinAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index_main.jsp"; //index_main.jsp ·Î ¹Ù²Þ
	    
	    HttpSession session = request.getSession();
	    AdminVO adminVO = new AdminVO();
	    /*MemberVO memberVO = new MemberVO();*/
	    
	    System.out.println(request.getParameter("id"));
	    adminVO.setShop_admin_id(request.getParameter("id"));
	    adminVO.setShop_admin_pass(request.getParameter("pass"));
	    adminVO.setShop_admin_name(request.getParameter("name"));
	    adminVO.setShop_admin_email(request.getParameter("email"));
	    adminVO.setShop_admin_phone(request.getParameter("phone"));
	    adminVO.setShop_design(request.getParameter("shop_design"));
	    adminVO.setShop_name(request.getParameter("shop_name"));
	      
	    session.setAttribute("id", request.getParameter("id")); 
	    
	    System.out.println("session : "+session.getAttribute("id"));
	    System.out.println("adminVO.getShop_id : "+adminVO.getShop_admin_id());
	    System.out.println("requst : "+request.getParameter("id"));
	    
	    
	    AdminDAO adminDAO = AdminDAO.getInstance();
	    adminDAO.insertMember(adminVO);
	    adminDAO.createSchema(adminVO.getShop_admin_id());
	    /*adminDAO.createTable_m(adminVO.getShop_admin_id());
	    adminDAO.createTable_c(adminVO.getShop_admin_id());
	    adminDAO.createTable_o(adminVO.getShop_admin_id());
	    adminDAO.createTable_q(adminVO.getShop_admin_id());
	    adminDAO.insertCusMember(memberVO, adminVO.getShop_admin_id());*/
	    
	    
	    

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);

	}

}
