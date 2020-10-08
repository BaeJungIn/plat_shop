package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.CartDAO;
import shopDao.OrderDAO;
import shopDto.CartVO;
import shopDto.MemberVO;





public class CartOrderInsertAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopServlet?command=order_list&shopname=" + ShopServlet.adminid + "&contents=" + ShopServlet.con
				+ "&prodid=" + ShopServlet.proid;
		
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		
		if (loginUser == null) {
			url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid + "&contents=" + ShopServlet.con
					+ "&prodid=" + ShopServlet.proid;
		} else {
			CartDAO cartDAO = CartDAO.getInstance();
			ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());
			OrderDAO orderDAO = OrderDAO.getInstance();
			int maxOseq=orderDAO.insertOrder(cartList, loginUser.getId());
			url = "ShopServlet?command=order_list&shopname=" + ShopServlet.adminid +"&contents=&prodid=&oseq="+maxOseq;
			}
			response.sendRedirect(url);
		  	  
		  	  
		  	  
				}
		
	}
