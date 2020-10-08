package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDao.ProductDAO;
import shopDto.ProductVO;

public class ProIndexAction implements Action {
	String contents;
	public ProIndexAction(String contents){
		this.contents = contents;
	}
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    String url = "/ProIndex.jsp";
    
    ProductDAO productDAO=ProductDAO.getInstance();
    ArrayList<ProductVO> ProIndex = productDAO.productIndex(contents);
    
    //System.out.println(((ProductVO)ProIndex.get(3)).getProd_name());
    //System.out.println(((ProductVO)ProIndex.get(4)).getProd_name());
    
    request.setAttribute("ProIndex", ProIndex);
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    dispatcher.forward(request, response);
  }
}
