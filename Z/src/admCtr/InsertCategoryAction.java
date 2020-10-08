package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDAO.ShopInfoDAO;
import admDTO.AdminVO;
import admDTO.ShopInfoVO;




public class InsertCategoryAction implements AdminAction {

	  
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "/adminInsert/success.jsp"; 
	    
	    HttpSession session = request.getSession();
	    AdminVO loginUser = (AdminVO) session.getAttribute("loginUser"); 
	    AdminDAO adminDAO = AdminDAO.getInstance();
	    
	    ShopInfoVO shopinfoVO = new ShopInfoVO();
	    AdminVO adminVO = new AdminVO();
	    
	    shopinfoVO.setShop_admin_id(loginUser.getShop_admin_id());
	    shopinfoVO.setLogo_img1(request.getParameter("logo1"));
	    shopinfoVO.setLogo_img2(request.getParameter("logo2"));
	    shopinfoVO.setMain_img1(request.getParameter("mainimg1"));
	    shopinfoVO.setMain_img2(request.getParameter("mainimg2"));
	    shopinfoVO.setCategory_1(request.getParameter("category1"));
	    shopinfoVO.setCategory_2(request.getParameter("category2"));
	    shopinfoVO.setCategory_3(request.getParameter("category3"));
	    shopinfoVO.setCategory_4(request.getParameter("category4"));
	    shopinfoVO.setCategory_5(request.getParameter("category5"));
	      
	    session.setAttribute("id", request.getParameter("shopid"));    
	    
	    ShopInfoDAO shopinfoDao = ShopInfoDAO.getInstance();
	    shopinfoDao.insertShopInfo(shopinfoVO);
	    adminDAO.createTable_m(loginUser.getShop_admin_id());
	    adminDAO.createTable_c(loginUser.getShop_admin_id());
	    adminDAO.createTable_o(loginUser.getShop_admin_id());
	    adminDAO.createTable_q(loginUser.getShop_admin_id());
	    System.out.println("shopinfoid : "+request.getParameter("shopid"));

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	  }
	}