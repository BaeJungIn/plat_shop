package admCtr;

import java.io.IOException;

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
import shopDto.ShopVO;

public class MainUpdateAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopInfoDAO shopInfoDAO = ShopInfoDAO.getInstance();
		String url = "AdminServlet?command=admin_shop"; 
	    
       //AdminServlet?command=admin_login
		HttpSession session = request.getSession();
		AdminVO loginUser = (AdminVO) session.getAttribute("loginUser"); 
		
	    ShopInfoVO shopInfoVO = new ShopInfoVO();
	    AdminVO adminVO = new AdminVO();
	    /*
	    session.setAttribute("loginUser", adminVO);*/
	    adminVO.setShop_admin_id(loginUser.getShop_admin_id());
	    shopInfoVO.setLogo_img1(request.getParameter("logo_img1"));
	    shopInfoVO.setLogo_img2(request.getParameter("logo_img2"));
	    shopInfoVO.setMain_img1(request.getParameter("main_img1"));
	    shopInfoVO.setMain_img2(request.getParameter("main_img2"));
	    shopInfoVO.setCategory_1(request.getParameter("category_1"));
	    shopInfoVO.setCategory_2(request.getParameter("category_2"));
	    shopInfoVO.setCategory_3(request.getParameter("category_3"));
	    shopInfoVO.setCategory_4(request.getParameter("category_4"));
	    shopInfoVO.setCategory_5(request.getParameter("category_5"));
	    System.out.println(loginUser.getShop_admin_id());
	    
	   
	    shopInfoDAO.listCategory(loginUser.getShop_admin_id() ,1);
	    shopInfoDAO.listCategory(loginUser.getShop_admin_id() ,2);
	    shopInfoDAO.listCategory(loginUser.getShop_admin_id() ,3);
	    shopInfoDAO.listCategory(loginUser.getShop_admin_id() ,4);
	    shopInfoDAO.listCategory(loginUser.getShop_admin_id() ,5);
	    
	    /*String[] category = {"category_1", "category_2", "category_3", "category_4", "category_5"};*/
	    
	   /* for(int i=0; i<category.length;i++){
	          if(category[i]!=null){
	        	  shopInfoDAO.categoryUpdate(loginUser.getShop_admin_id(), category[i]);
	          }
          }*/
	    
	    shopInfoDAO.categoryUpdate(loginUser.getShop_admin_id(), request.getParameter("category_1"),
	    		request.getParameter("category_2"), request.getParameter("category_3"),
	    		request.getParameter("category_4"), request.getParameter("category_5"));
	    
	    shopInfoDAO.updateShopInfo(shopInfoVO ,loginUser.getShop_admin_id());
	   
	    
	    
	    
	    

	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    //response.sendRedirect(url);
	    dispatcher.forward(request, response);


	}

}
