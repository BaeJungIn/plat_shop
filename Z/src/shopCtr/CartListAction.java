package shopCtr;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.CartDAO;
import shopDto.CartVO;
import shopDto.MemberVO;



public class CartListAction implements Action {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	//String url = "ShopServlet?command=cart_list&shopname="+ ShopServlet.adminid +"&contents="+ShopServlet.con+"&prodid="+ShopServlet.proid;
    String url = "mypage/cartList.jsp";

    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
   
    //System.out.println("loginUser : " + loginUser.getId());
    //session.setAttribute("id", request.getParameter("id")); 
    if (loginUser == null) {
      url = "ShopServlet?command=login_form&shopname=" + ShopServlet.adminid + "&contents=&prodid=";
    } else {
    	
      CartDAO cartDAO = CartDAO.getInstance();
      /*CartVO cartVO = new CartVO();
      cartVO.setCus_id(loginUser.getId());*/
      //ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());
      System.out.println("CartListAction : -> "+loginUser.getId());
      ArrayList<CartVO> cartList = cartDAO.listCart(loginUser.getId());
      
      int totalPrice = 0;
      for (CartVO cartVO : cartList) {
        totalPrice += cartVO.getProd_price() * cartVO.getCart_num();
      }

      request.setAttribute("cartList", cartList);
      request.setAttribute("totalPrice", totalPrice);
    } 
    request.getRequestDispatcher(url).forward(request, response);
  }
}
