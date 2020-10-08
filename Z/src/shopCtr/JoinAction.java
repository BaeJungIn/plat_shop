package shopCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.MemberDAO;
import shopDto.MemberVO;

public class JoinAction implements Action {

	  
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "member/login.jsp"; 
	    
	    HttpSession session = request.getSession();
	    
	    MemberVO memberVO = new MemberVO();
	    
	    memberVO.setId(request.getParameter("id"));
	    memberVO.setPwd(request.getParameter("pwd"));
	    memberVO.setCus_name(request.getParameter("name"));
	    memberVO.setCus_email(request.getParameter("email"));
	    memberVO.setCus_phone(request.getParameter("phone"));
	    memberVO.setZip_num(request.getParameter("zipNum"));
	    memberVO.setCus_addr(request.getParameter("addr1") + request.getParameter("addr2"));
	    memberVO.setCus_age(request.getParameter("age"));    
	      
	    session.setAttribute("id", request.getParameter("id"));    
	    
	    MemberDAO memberDAO = MemberDAO.getInstance();
	    memberDAO.insertMember(memberVO);

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
	}