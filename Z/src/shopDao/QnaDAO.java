package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopCtr.ShopServlet;
import shopDto.QnaVO;
import util.DBManager;

public class QnaDAO {
	public String adminid = ShopServlet.adminid;
	  private QnaDAO() {
	  }

	  private static QnaDAO instance = new QnaDAO();

	  public static QnaDAO getInstance() {
	    return instance;
	  }

	  public ArrayList<QnaVO> listQna(String id) {
	    ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
	    String sql = "select * from "+adminid+".qna where cus_id=? order by qseq desc";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        QnaVO qnaVO = new QnaVO();
	        qnaVO.setQseq(rs.getInt("qseq"));
	        qnaVO.setSubject(rs.getString("subject"));
	        qnaVO.setContent(rs.getString("content"));
	        qnaVO.setCus_id(rs.getString("cus_id"));
	        qnaVO.setIndate(rs.getTimestamp("indate"));
	        qnaVO.setReply(rs.getString("reply"));
	        qnaVO.setRep(rs.getString("rep"));
	        qnaList.add(qnaVO);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return qnaList;
	  }

	  public QnaVO getQna(int seq) {
	    QnaVO qnaVO = null;
	    String sql = "select * from "+adminid+".qna where qseq=?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setInt(1, seq);
	      rs = pstmt.executeQuery();
	      if (rs.next()) {
	        qnaVO = new QnaVO();
	        qnaVO.setQseq(seq);
	        qnaVO.setSubject(rs.getString("subject"));
	        qnaVO.setContent(rs.getString("content"));
	        qnaVO.setCus_id(rs.getString("cus_id"));
	        qnaVO.setIndate(rs.getTimestamp("indate"));
	        qnaVO.setReply(rs.getString("reply"));
	        qnaVO.setRep(rs.getString("rep"));
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt);
	    }
	    return qnaVO;
	  }

	  public void insertqna(QnaVO qnaVO, String session_id) {
	    String sql = "insert into "+adminid+".qna (subject, "
	        + "content, cus_id) values( ?, ?, ?)";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, qnaVO.getSubject());
	      pstmt.setString(2, qnaVO.getContent());
	      pstmt.setString(3, session_id);
	      pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt);
	    }
	  }

	  /* *
	   * ������ ��忡�� �ʿ��� �޼ҵ�
	   */
	  public ArrayList<QnaVO> listAllQna() {
	    ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
	    // �Խ����� �����͸� ������ ���� ���� rep:1:�Խù� 2: �亯
	    String sql = "select * from "+adminid+".qna order by indate desc";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        QnaVO qnaVO = new QnaVO();
	        qnaVO.setQseq(rs.getInt("qseq"));
	        qnaVO.setSubject(rs.getString("subject"));
	        qnaVO.setContent(rs.getString("content"));
	        qnaVO.setCus_id(rs.getString("cus_id"));
	        qnaVO.setIndate(rs.getTimestamp("indate"));
	        qnaVO.setReply(rs.getString("reply"));
	        qnaVO.setRep(rs.getString("rep"));
	        qnaList.add(qnaVO);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return qnaList;
	  }

	  public void updateQna(QnaVO qnaVO) {
	    String sql = "update "+adminid+".qna set reply=?, rep='2' where qseq=?";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, qnaVO.getReply());
	      pstmt.setInt(2, qnaVO.getQseq());      
	      pstmt.executeUpdate();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt);
	    }
	  }
	}