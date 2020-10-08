package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminProductDAO;
import admDTO.AdminVO;
import shopDto.ProductVO;

public class AdmProIndexAction implements AdminAction {
	String category;

	public AdmProIndexAction(String category) {
		this.category = category;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");
		String url = "/admin/product/AdmProd.jsp";
		AdminProductDAO productDAO = AdminProductDAO.getInstance();
		ArrayList<ProductVO> admProIndex = productDAO.admProductIndex(loginUser.getShop_admin_id(), category);
		System.out.println("login id : "+loginUser.getShop_admin_id());
		
		request.setAttribute("admProIndex", admProIndex);
		request.setAttribute("category", category);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
