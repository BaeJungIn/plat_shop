package shopCtr;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopDao.CartDAO;
import shopDto.CartVO;
import shopDto.MemberVO;




public class CartInsertAction implements Action {
  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = "ShopServlet?command=cart_list&shopname="+ ShopServlet.adminid +"&contents="+ShopServlet.con+"&prodid="+ShopServlet.proid;
    
    //request.setCharacterEncoding("UTF-8");
    
    HttpSession session = request.getSession();
    MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");   
    
    
    //MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");   
    
    
    //session.setAttribute("id", request.getParameter("id")); 
    if (loginUser == null) {
      url = "ShopServlet?command=login_form&shopname="+ ShopServlet.adminid +"&contents="+ShopServlet.con+"&prodid="+ShopServlet.proid;
    } else {
    	
      CartVO cartVO = new CartVO();
      cartVO.setCus_id(loginUser.getId());
      
/*      cartVO.setProd_name(ProductVO.prod_name);
      cartVO.setProd_price(ProductVO.prod_price);*/
      cartVO.setProd_name((String)request.getAttribute("prod_name"));
      String prod_name =(String)request.getAttribute("prod_name");
      
      System.out.println("cartInsertAction  : " + prod_name);
      
      
      String prod_price_num = (String)request.getAttribute("prod_price");
      if( prod_price_num != null )
    	  cartVO.setProd_price(Integer.parseInt(prod_price_num));
      //memberVO.setId(loginUser.getId());
      String prodid = request.getParameter("prodid");
  	  String category = request.getParameter("category");
  	  String cart_num = (String)request.getAttribute("cart_num");
  	  
  	  category = ShopServlet.con;
  	  prodid = ShopServlet.proid;
  	
  	  //System.out.println(loginUser.getId());
  	 String Userid = loginUser.getId();
  	 
   	cartVO.setCart_num(Integer.parseInt(cart_num));
   	
  	System.out.println(" ID -> "+ loginUser.getId());
  	System.out.println("cartInsert action : prodid result : " + ShopServlet.proid);
    System.out.println("cartInsert action : cart_num result ---------- : " + cart_num);
    System.out.println("cartInsert action : prod_name result ---------- : " + prod_name);
    System.out.println("cartInsert action : cart price result ---------- : " + prod_price_num);
    
  
  	  cartVO.setCategory(ShopServlet.con);
     cartVO.setProd_id(Integer.parseInt(ShopServlet.proid));
      
      //product.setProd_id(rs.getInt("prod_id"));
      CartDAO cartDAO = CartDAO.getInstance();
      cartDAO.insertCart(cartVO);
    }
    response.sendRedirect(url);
  }
}
