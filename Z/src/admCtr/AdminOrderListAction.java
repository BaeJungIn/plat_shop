package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admDAO.AdminDAO;
import admDTO.AdminVO;
import shopDto.OrderVO;

public class AdminOrderListAction implements AdminAction {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/order/orderList.jsp";
    
    HttpSession session = request.getSession();
    admDTO.AdminVO loginUser = (AdminVO) session.getAttribute("loginUser");

    AdminDAO orderDAO = AdminDAO.getInstance();
    ArrayList<OrderVO> orderList = orderDAO.listOrder(loginUser.getShop_admin_id());

    request.setAttribute("orderList", orderList);

    request.getRequestDispatcher(url).forward(request, response);
  }
}
