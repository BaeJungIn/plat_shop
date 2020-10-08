package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDao.ProductDAO;
import shopDto.ProductVO;
import shopDto.ShopVO;



public class IndexAction implements Action {
	String command;
	public IndexAction(String command){
		this.command = command;
	}
	@Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {    
		 String url = "/index.jsp";
		    String cmd = request.getParameter("shopname");
		    System.out.println("cmd = "+cmd);
		    ProductDAO	 productDAO=ProductDAO.getInstance();
		    
		    ShopVO shopVO = new ShopVO();
		    
		    shopVO.setCategory_1(productDAO.listCategory(cmd, 1));
		    shopVO.setCategory_2(productDAO.listCategory(cmd, 2));
		    shopVO.setCategory_3(productDAO.listCategory(cmd, 3));
		    shopVO.setCategory_4(productDAO.listCategory(cmd, 4));
		    shopVO.setCategory_5(productDAO.listCategory(cmd, 5));
		    
		    ArrayList<ShopVO> mainList = productDAO.getMainImage();
		    
		    ArrayList<ProductVO> newProductList = productDAO.listNewProduct(cmd);
		   /* ArrayList<ProductVO> bestProductList = productDAO.listBestProduct();*/
		    
		    request.setAttribute("newProductList", newProductList);
		    /*request.setAttribute("bestProductList", bestProductList);*/
		    request.setAttribute("listCategory", shopVO);
		    request.setAttribute("mainList", mainList);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		    dispatcher.forward(request, response);
		  }
		}