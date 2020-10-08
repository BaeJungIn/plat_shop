package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDto.ProductVO;

public class ProductDeleteAction implements AdminAction {
	String category;
	public ProductDeleteAction(String category){
		this.category = category;
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "AdminServlet?command=admin_shop";
	    
		String prod_id = request.getParameter("prod_id").trim();
		
	    AdminDAO productDAO = AdminDAO.getInstance();
	    ProductVO ProDelete = productDAO.deleteProduct(category,prod_id);
	    
	    System.out.println("prod_id : "+prod_id);
	    System.out.println("category1111 : "+category);
	    request.setAttribute("ProDelete", ProDelete);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
	}
}
