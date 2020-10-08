/*package admCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;


public class AdminLoginAction implements AdminAction{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "ShopServlet?command=admin_login_form";
	    String msg = "";
	    String admin_id = request.getParameter("admin_id").trim();
	    String admin_pass = request.getParameter("admin_pass").trim();

	    AdminDAO workerDAO = AdminDAO.getInstance();

	    int result = workerDAO.workerCheck(admin_id, admin_pass);
	    
	    if (result == 1) {
	      HttpSession session = request.getSession();
	      session.setAttribute("admin_id", admin_id);
	      url = "ShopServlet?command=admin_update";
	    } else if (result == 0) {
	      msg = "비밀번호를 확인하세요.";
	    } else if (result == -1) {
	      msg = "아이디를 확인하세요.";
	    }
	    request.setAttribute("message", msg);
	    request.getRequestDispatcher(url).forward(request, response);
	  }
}*/

package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;


public class AdminLoginAction implements AdminAction {
     
     public void execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
       String url="member/login_fail.jsp";
       HttpSession session=request.getSession();
     
       String shop_admin_id = request.getParameter("shop_admin_id");
       String shop_admin_pass = request.getParameter("shop_admin_pass");
       System.out.println(shop_admin_id);
       System.out.println(shop_admin_pass);
       
       AdminDAO adminDAO = AdminDAO.getInstance();
         
       AdminVO adminVO = adminDAO.getAdminMember(shop_admin_id);
      
       

	   System.out.println(adminVO.getShop_admin_pass());
  	   System.out.println(shop_admin_pass);
       
       if(adminVO!=null){
         if(adminVO.getShop_admin_pass().equals(shop_admin_pass)){ 
        	
           session.removeAttribute("shop_admin_id");
           session.setAttribute("loginUser", adminVO);
           
           //url="ShopServlet?command=index";
           /*url="AdminServlet?command=admin_shop";*/
           url="/adminMember/intro.jsp";
				
           
           
         }
       }
       
       request.getRequestDispatcher(url).forward(request, response);  
     }
   }
