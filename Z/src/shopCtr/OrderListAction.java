package shopCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.OrderDAO;
import shopDto.MemberVO;
import shopDto.OrderVO;

public class OrderListAction implements Action {

	  @Override
	  public void execute(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    String url = "mypage/orderList.jsp";
		  //String url = "member/order.jsp";
	    
	    HttpSession session = request.getSession();
	    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");    
	    //session.setAttribute("id", request.getParameter("id"));
	    
	    if (loginUser == null) {
	      url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid + "&contents=&prodid=";
	    } else {
	      OrderDAO orderDAO = OrderDAO.getInstance();
	      System.out.println("OrderListAction : -> "+loginUser.getId());
	      ArrayList<OrderVO> orderList = orderDAO.listOrderById(loginUser.getId(), "1");
	      
	      int totalPrice=0;
	      for(OrderVO orderVO :orderList){
	        totalPrice+=orderVO.getProd_price()*orderVO.getProd_num();
	      }
	      
	      request.setAttribute("orderList", orderList);
	      request.setAttribute("totalPrice", totalPrice);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	  }
	}

