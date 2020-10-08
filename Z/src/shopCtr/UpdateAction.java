package shopCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.MemberDAO;
import shopDto.MemberVO;

public class UpdateAction implements Action {

	 @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "ShopServlet?command=shop_&shopname=" + ShopServlet.adminid ; 
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");   
	    //session.setAttribute("id", request.getParameter("id"));
	    System.out.println(loginUser);
	    if (loginUser == null ) {
	        url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid ;
	      } else {
	    	 
	    	  MemberVO memberVO = new MemberVO();
	    	  
	    	  memberVO.setPwd(request.getParameter("pwd"));
	    	  memberVO.setCus_email(request.getParameter("email"));
	    	  memberVO.setCus_phone(request.getParameter("phone"));
	    	  memberVO.setCus_addr(request.getParameter("addr1"));/* + request.getParameter("addr2"));*/
	    	  memberVO.setCus_age(request.getParameter("age"));
	    	  memberVO.setZip_num(request.getParameter("zipNum"));
	    	  memberVO.setId(loginUser.getId());
	    	  
	    	  System.out.println(loginUser.getId());
	    	  
	    	  MemberDAO memberDAO = MemberDAO.getInstance();
	    	  memberDAO.updateMember(memberVO);
	    	  
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    	  dispatcher.forward(request, response);	
	      }
	    
	  }
}
