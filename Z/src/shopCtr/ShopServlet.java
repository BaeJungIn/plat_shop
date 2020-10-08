package shopCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static String adminid;
  public static String con;
  public static String proid;
  public static String shopname;
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
	
    String command = request.getParameter("command");
    String shopname = request.getParameter("shopname");
    String contents = request.getParameter("contents");
    String prodid = request.getParameter("prodid");
    
    System.out.println("prodid result : " + prodid);
    System.out.println("ShopServlet command : " + command);
   
 
    adminid=shopname;
    con = contents;
    proid = prodid;
    ActionFactory af = ActionFactory.getInstance();
    System.out.println(contents);
    System.out.println(prodid);
    String cart_num = (String)request.getAttribute("cart_num");
   
    Action action = af.getAction(command, shopname, contents, prodid);

    if (action != null) {
      action.execute(request, response);
    }
   
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    System.out.println(request.getParameter("cart_num") + " -> cart_num ");
  
    
    String cart_num = request.getParameter("cart_num");
    String prod_name = request.getParameter("prod_name");
    String prod_price = request.getParameter("prod_price");
    
    System.out.println("ddd: " + prod_name);
    
    if( cart_num != null ){    
    	request.setAttribute("cart_num", cart_num);
    	request.setAttribute("prod_name", prod_name);
    	request.setAttribute("prod_price", prod_price);
    }
    
    doGet(request, response);
  }
}

 