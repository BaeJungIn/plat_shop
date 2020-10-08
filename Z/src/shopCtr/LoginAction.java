package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.MemberDAO;
import shopDto.MemberVO;

public class LoginAction implements Action {

	  
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url="member/login_fail.jsp";
	    HttpSession session=request.getSession();
	  
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    System.out.println(id);
	    System.out.println(pwd);
	    
	    MemberDAO memberDAO=MemberDAO.getInstance();
	    MemberVO memberVO=memberDAO.getMember(id);
	    
	    if(memberVO!=null){
	      if(memberVO.getPwd().equals(pwd)){    
	        session.removeAttribute("cus_id");
	        session.setAttribute("id", request.getParameter("id"));   
	        session.setAttribute("loginUser", memberVO);
	        url="ShopServlet?command=shop_&shopname="+ShopServlet.adminid;
	      }
	    }
	    
	    request.getRequestDispatcher(url).forward(request, response);  
	  }
	}
