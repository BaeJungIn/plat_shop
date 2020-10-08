package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopDao.CartDAO;


public class CartDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	String url = "ShopServlet?command=cart_list&shopname="+ ShopServlet.adminid +"&contents="+ShopServlet.con+"&prodid="+ShopServlet.proid;
	
	System.out.println("-----------------Ä«Æ® µô¸®Æ® ¾×¼Ç ½ÇÇàµÊ");
	
	String[] cseqArr = request.getParameterValues("cart_id");
	for(String cart_id:cseqArr){
	System.out.println(cart_id);
	CartDAO cartDAO = CartDAO.getInstance();
	cartDAO.deleteCart(Integer.parseInt(cart_id));
	}
	request.getRequestDispatcher(url).forward(request, response);
	}
	}