package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.OrderDAO;
import shopDto.MemberVO;
import shopDto.OrderVO;



	public class OrderInsertAction implements Action {
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
				OrderVO orderVO = new OrderVO();
				orderVO.setCus_id(loginUser.getId());
				 orderVO.setProd_name((String)request.getAttribute("prod_name"));
			      String prod_name =(String)request.getAttribute("prod_name");
			      
			      System.out.println("orderInsertAction  : " + prod_name);
			      
			       
			      String prod_price_num = (String)request.getAttribute("prod_price");
			      if( prod_price_num != null )
			    	  orderVO.setProd_price(Integer.parseInt(prod_price_num));
			    
			      String prodid = request.getParameter("proid");
			  	  String category = request.getParameter("category");
			  	  String prod_num = (String)request.getAttribute("cart_num");
			  	
			  	  prodid = ShopServlet.proid;
			  	  category = ShopServlet.con;
			  	  
			  	  
			  	String Userid = loginUser.getId();
			  	 
			   	orderVO.setProd_num(Integer.parseInt(prod_num));
			   	
			  	System.out.println(" ID -> "+ loginUser.getId());
			  	System.out.println("cartInsert action : prodid result : " + ShopServlet.proid);
			    System.out.println("cartInsert action : prod_num result ---------- : " + prod_num);
			    System.out.println("cartInsert action : prod_name result ---------- : " + prod_name);
			    System.out.println("cartInsert action : prod price result ---------- : " + prod_price_num);
			    System.out.println("cartInsert action : category result ---------- : " + category);
			    
			    
			    orderVO.setProd_id(Integer.parseInt(ShopServlet.proid));
			    orderVO.setOrder_category(category);
			    
			      orderVO.setCus_id(Userid);
			      //product.setProd_id(rs.getInt("prod_id"));
			      OrderDAO orderDAO = OrderDAO.getInstance();
			      orderDAO.insertOrder(orderVO);
			  	  
			  	  
			  		}
			response.sendRedirect(url);
		}
	}
