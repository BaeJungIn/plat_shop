package admCtr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admDAO.AdminDAO;
import shopDto.QnaVO;

public class AdminQnaResaveAction implements AdminAction {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String url = "AdminServlet?command=admin_qna_list";

    String qseq = request.getParameter("qseq").trim();
    String reply =request.getParameter("reply").trim();
    
    QnaVO qnaVO = new QnaVO();
    qnaVO.setQseq(Integer.parseInt(qseq));
    qnaVO.setReply(reply);    
    
    AdminDAO qnaDAO = AdminDAO.getInstance();
    qnaDAO.updateQna(qnaVO);
      
    response.sendRedirect(url);
  }
}
