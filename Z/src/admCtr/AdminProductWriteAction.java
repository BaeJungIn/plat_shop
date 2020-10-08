package admCtr;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import admDAO.AdminProductDAO;
import admDTO.AdminVO;
import shopDto.ProductVO;



public class AdminProductWriteAction implements AdminAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "AdminServlet?command=admin_shop";

		HttpSession session = request.getSession();
	    AdminVO adminVO = new AdminVO();
	    AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");
	   
	    System.out.println("----------> " + request.getParameter("categoryBox"));
	    System.out.println(request.getParameter("price"));
	    System.out.println(request.getParameter("img"));
	    
	    
	    System.out.println(loginUser.getShop_admin_id());
	    adminVO.setShop_admin_id(loginUser.getShop_admin_id());
	    
	    session.setAttribute("id", request.getParameter("id"));
			ProductVO prodVO = new ProductVO();
			
			prodVO.setCategory(request.getParameter("categoryBox"));
			String category = request.getParameter("categoryBox");
			prodVO.setProd_name(request.getParameter("name"));
			
			int price = Integer.parseInt(request.getParameter("price"));
			prodVO.setProd_price(price);
			
			prodVO.setProd_img(request.getParameter("img"));
			prodVO.setContents(request.getParameter("contents"));
			prodVO.setCon_img(request.getParameter("con_img"));
			prodVO.setProd_detail1(request.getParameter("prod_detail1"));
			prodVO.setProd_detail2(request.getParameter("prod_detail2"));
			prodVO.setProd_detail3(request.getParameter("prod_detail3"));
			prodVO.setProd_detail4(request.getParameter("prod_detail4"));
			
			int count = Integer.parseInt(request.getParameter("count"));
			prodVO.setCount(count);
			
			AdminProductDAO adminproductDAO = AdminProductDAO.getInstance();
			adminproductDAO.insertProduct(prodVO, loginUser.getShop_admin_id(), category );
			 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			    dispatcher.forward(request, response);
			
	}
}
