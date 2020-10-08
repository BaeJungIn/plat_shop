package admCtr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDto.ProductVO;

public class ProductUpdateAction implements AdminAction {
	String category;
	public ProductUpdateAction(String category){
		this.category = category;
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "AdminServlet?command=admin_shop";
		
			ProductVO prodVO = new ProductVO();
			
			System.out.println(request.getParameter("prod_name"));
			
			int prod_id = Integer.parseInt(request.getParameter("prod_id"));
			prodVO.setProd_id(prod_id);
			prodVO.setProd_name(request.getParameter("prod_name"));
			int price = Integer.parseInt(request.getParameter("prod_price"));
			prodVO.setProd_price(price);
			prodVO.setProd_img(request.getParameter("prod_img"));
			prodVO.setContents(request.getParameter("prod_contents"));
			prodVO.setCon_img(request.getParameter("con_img"));
			prodVO.setProd_detail1(request.getParameter("prod_detail1"));
			prodVO.setProd_detail2(request.getParameter("prod_detail2"));
			prodVO.setProd_detail3(request.getParameter("prod_detail3"));
			prodVO.setProd_detail4(request.getParameter("prod_detail4"));
			
			int count = Integer.parseInt(request.getParameter("count"));
			prodVO.setCount(count);
		
		System.out.println("prod_id : "+prod_id);
		
	    AdminDAO productDAO = AdminDAO.getInstance();
	    productDAO.updateProduct(category, prod_id, prodVO);
	    System.out.println("category : "+category);
	    //ArrayList<ProductVO> ProUpdate = productDAO.updateProduct(contents, prod_id, prodVO);
	    
	   // request.setAttribute("ProUpdate", ProUpdate);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    


	    
	    
	    
	}

}
