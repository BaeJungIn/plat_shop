package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDao.ProductDAO;
import shopDto.ProductVO;

public class ProDetailAction implements Action {
	String prodid;
	public ProDetailAction(String prodid){
		this.prodid = prodid;
	}
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "/ProDetail.jsp";
    
    ProductDAO productDAO=ProductDAO.getInstance();
    ArrayList<ProductVO> ProDetail = productDAO.productDetail(prodid);
    
    request.setAttribute("ProDetail", ProDetail);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
