package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminProductDAO;
import shopCtr.ShopServlet;
import shopDto.MemberVO;
import shopDto.ProductVO;

public class AdminProductListAction implements AdminAction {

	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

	    String url = "adminMember/product/productList.jsp";
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
	   
	    
	    session.setAttribute("id", request.getParameter("id")); 
	    if (session == null) {
	      url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid + "&contents=&prodid=";
	    } else {
	    	AdminProductDAO adminproductDAO = AdminProductDAO.getInstance();
	    	System.out.println("AdminProductList 로그인 유저 -----" +  loginUser.getId());
	    	ArrayList<ProductVO> productList = adminproductDAO.listNewProduct(loginUser.getId());
	    	request.setAttribute("productList",productList);
	    
	    }
	   
	      
	    request.getRequestDispatcher(url).forward(request, response);
	  }
	}
