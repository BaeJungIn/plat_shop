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
import admDTO.AdminVO;
import admDTO.ShopInfoVO;
import shopDao.ProductDAO;
import shopDto.MemberVO;
import shopDto.ProductVO;
import shopDto.ShopVO;

public class AdminShopAction implements AdminAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/adminShop.jsp";
		
		    HttpSession session = request.getSession();
		    AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");
		    
		    AdminVO adminVO = new AdminVO();
		    AdminDAO adminDAO = AdminDAO.getInstance();
		    MemberVO memberVO = new MemberVO();
		    
		    AdminProductDAO adminProductDAO = AdminProductDAO.getInstance();
		    ShopInfoVO shopInfoVO = new ShopInfoVO();
		    System.out.println(loginUser.getShop_admin_id());
		    
		    shopInfoVO.setCategory_1(adminProductDAO.listCategory(loginUser.getShop_admin_id(), 1));
		    shopInfoVO.setCategory_2(adminProductDAO.listCategory(loginUser.getShop_admin_id(), 2));
		    shopInfoVO.setCategory_3(adminProductDAO.listCategory(loginUser.getShop_admin_id(), 3));
		    shopInfoVO.setCategory_4(adminProductDAO.listCategory(loginUser.getShop_admin_id(), 4));
		    shopInfoVO.setCategory_5(adminProductDAO.listCategory(loginUser.getShop_admin_id(), 5));
		    
		    ArrayList<ShopInfoVO> mainList = adminProductDAO.getMainImage(loginUser.getShop_admin_id());
		    ArrayList<ProductVO> newProductList = adminProductDAO.listNewProduct(loginUser.getShop_admin_id());
		    /*adminDAO.insertCusMember(memberVO, adminVO.getShop_admin_id());*/
		    
		   /* ArrayList<ProductVO> bestProductList = productDAO.listBestProduct();*/
		    
		    request.setAttribute("newProductList", newProductList);
		    /*request.setAttribute("bestProductList", bestProductList);*/
		    request.setAttribute("listCategory", shopInfoVO);
		    request.setAttribute("mainList", mainList);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		
		
		
		
	}

}
