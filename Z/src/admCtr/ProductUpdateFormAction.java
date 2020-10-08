package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import admDAO.AdminProductDAO;
import admDTO.AdminVO;
import shopCtr.Action;
import shopDto.ProductVO;

public class ProductUpdateFormAction implements AdminAction {
	String category;
	public ProductUpdateFormAction(String category) {
		this.category = category;
	}

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminProductDAO admProDao = AdminProductDAO.getInstance();
		String url = "/admin/product/UpdateProd.jsp";
		AdminVO aVo = (AdminVO) session.getAttribute("loginUser");
		
		String prod_id = request.getParameter("prod_id").trim();
		
		String adminid =  aVo.getShop_admin_id();
		ProductVO pVo = admProDao.getProductInfo(adminid,category,prod_id);

		request.setAttribute("prod", pVo);
		request.setAttribute("prod_id", prod_id);
		request.setAttribute("category", category);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}