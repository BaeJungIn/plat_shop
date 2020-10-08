package admCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopCtr.Action;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static String con;
  /*public static String adminloginid;*/
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
	
    String command = request.getParameter("command");
    String category = request.getParameter("category");
    System.out.println("AdminServlet command : " + command);

    AdminActionFactory af = AdminActionFactory.getInstance();
    /*AdminAction action = af.getAction(command, shopname);*/
    AdminAction action = af.getAction(command, category);

    if (action != null) {
      action.execute(request, response);
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    doGet(request, response);
  }
}

 