package admCtr;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDto.QnaVO;

public class AdminQnaListAction implements AdminAction {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/qna/qnaList.jsp";
    
    AdminDAO qnaDAO = AdminDAO.getInstance();
    ArrayList<QnaVO> qnaList = qnaDAO.listAllQna();

    request.setAttribute("qnaList", qnaList);

    request.getRequestDispatcher(url).forward(request, response);
  }
}
