package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.ShopInfoDAO;
import admDTO.AdminVO;
import admDTO.ShopInfoVO;


public class CategoryFormAction implements AdminAction {

	  
	public void execute(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    String url = "/adminInsert/InsertCategory.jsp"; 
	    
		    HttpSession session = request.getSession();
			ShopInfoDAO sDao = ShopInfoDAO.getInstance();
			
			AdminVO aVo = (AdminVO) session.getAttribute("loginUser");
			
			String id =  aVo.getShop_admin_id();
			ShopInfoVO sVo = sDao.getShopInfo(id);

			sVo.setShop_admin_id(id);
			request.setAttribute("user", sVo);
		    
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		  }
	}