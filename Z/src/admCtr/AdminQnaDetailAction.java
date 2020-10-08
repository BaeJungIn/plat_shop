package admCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDto.QnaVO;

public class AdminQnaDetailAction implements AdminAction {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "admin/qna/qnaDetail.jsp";

    String qseq = request.getParameter("qseq").trim();

    AdminDAO qnaDAO = AdminDAO.getInstance();
    QnaVO qnaVO = qnaDAO.getQna(Integer.parseInt(qseq));

    request.setAttribute("qnaVO", qnaVO);
        
    request.getRequestDispatcher(url).forward(request, response);
  }
}
