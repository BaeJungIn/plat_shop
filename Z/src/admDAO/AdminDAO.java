package admDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admCtr.AdminServlet;
import admDAO.AdminDAO;
import admDTO.AdminVO;
import admDTO.ShopInfoVO;
import shopCtr.ShopServlet;
import shopDto.MemberVO;
import shopDto.OrderVO;
import shopDto.ProductVO;
import shopDto.QnaVO;
import shopDto.ShopVO;
import util.DBManager;

public class AdminDAO {
	public static String adminid;
	private AdminDAO() {
		
	}

	private static AdminDAO instance = new AdminDAO();

	public static AdminDAO getInstance() {
		return instance;
	}

	 public AdminVO getAdminMember(String id) {       
		 AdminVO adminVO= null;
		    String sql = "select * from admin.shop_admin where shop_admin_id = ?";
		 
		    adminid = id;
		    Connection connn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    
		    try {
		      connn = DBManager.getConnection();
		      pstmt = connn.prepareStatement(sql);
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
		      if(rs.next()){
		    	  adminVO = new AdminVO();
		    	  adminVO.setShop_admin_id(rs.getString("shop_admin_id"));
		    	  adminVO.setShop_admin_pass(rs.getString("shop_admin_pass"));
		    	  adminVO.setShop_admin_name(rs.getString("shop_admin_name"));
		    	  adminVO.setShop_admin_email(rs.getString("shop_admin_email"));
		    	  adminVO.setShop_admin_phone(rs.getString("shop_admin_phone"));
		    	  adminVO.setShop_name(rs.getString("shop_name"));
		    	  adminVO.setShop_design(rs.getString("shop_design"));
		    	  
		    	  System.out.println("id1="+id);
		    	  System.out.println("id2="+rs.getString("shop_admin_id"));
		       } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(connn, pstmt, rs);
		    }
		    return adminVO;
		  }

	
	
	public int workerCheck(String userid, String userpw) {
		String sql = "select pwd from worker where id=?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;			
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) { 
				result = 0; 
				String dbPwd = rs.getString(1); 
				if (dbPwd.equals(userpw)) {
					result = 1; // 
				}
			}
			DBManager.close(conn, pstmt, rs);
		} catch (Exception e) {
		}
		return result;
	}
	


	public int insertMember(AdminVO adminVO) {
		    int result = 0;
		    String sql = "insert into admin.shop_admin(shop_admin_id, shop_admin_pass, shop_admin_name, shop_admin_email, shop_admin_phone, shop_design, shop_name)";
		    sql += " values(?, ?, ?, ?, ?, ?, ?)";
		    

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		   
		      pstmt.setString(1, adminVO.getShop_admin_id()); 
		      System.out.println(adminVO.getShop_admin_id());
		      pstmt.setString(2, adminVO.getShop_admin_pass());
		      pstmt.setString(3, adminVO.getShop_admin_name());
		      pstmt.setString(4, adminVO.getShop_admin_email());
		      pstmt.setString(5, adminVO.getShop_admin_phone());
		      pstmt.setString(6, adminVO.getShop_design());
		      pstmt.setString(7, adminVO.getShop_name());
		      result = pstmt.executeUpdate();
		      
		      
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, pstmt);
		    }
		    return result;
		
	}
	
	public int createSchema(String id){
		
	    String sql = "CREATE DATABASE "+id;
	    int rs = 0;
	      Connection conn = null;
	      Statement stmt = null;
	      System.out.println("스키마:"+id);
	      
	      
	      try {
	           conn = DBManager.getConnection();
	           stmt = conn.createStatement();
	            
	          rs = stmt.executeUpdate(sql);
	          System.out.println("스키마");
	             
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, stmt);
	    }
	    return rs;
	}
	
public int createTable_m(String id){
		
	    String sql = "CREATE table "+id+".member ("
	    		+ "`cus_id` VARCHAR(45) NOT NULL ,  "
	    		+ "`cus_pass` VARCHAR(45) NULL ,  `cus_name` VARCHAR(45) NULL , "
	    		+ " `cus_email` VARCHAR(45) NULL ,  `cus_phone` VARCHAR(45) NULL ,  "
	    		+ "`cus_addr` VARCHAR(45) NULL ,  `cus_age` VARCHAR(45) NULL , "
	    		+ "`zip_num` VARCHAR(45) NULL, PRIMARY KEY (`cus_id`) )";
	      int rs = 0;
	      Connection conn = null;
	      Statement stmt = null;
	      System.out.println("m:"+id);
	      
	      
	      try {
	           conn = DBManager.getConnection();
	           stmt = conn.createStatement();
	            
	          rs = stmt.executeUpdate(sql);
	          System.out.println("m");
	             
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, stmt);
	    }
	    return rs;
	}


public int createTable_c(String id){
	
    String sql = "CREATE table "+id+".cart (`cart_id` INT NOT NULL AUTO_INCREMENT, `cus_id` VARCHAR(45) , "
    		+ "`prod_id` VARCHAR(45) NULL ,  `prod_name` VARCHAR(45) NULL , `category` VARCHAR(45) NULL, `prod_price2` INT NULL, "
    		+ "`prod_price` INT NULL ,  `cart_num` INT NULL, PRIMARY KEY (`cart_id`))";
      int rs = 0;
      Connection conn = null;
      Statement stmt = null;
      System.out.println("c:"+id);
      
      
      try {
           conn = DBManager.getConnection();
           stmt = conn.createStatement();
            
          rs = stmt.executeUpdate(sql);
          System.out.println("c");
             
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBManager.close(conn, stmt);
    }
    return rs;
}
	



public int createTable_o(String id){
	
    String sql = "CREATE table "+id+".order (`order_id` INT NOT NULL AUTO_INCREMENT ,  "
    		+ "`cus_id` VARCHAR(45) NULL ,  `prod_id` VARCHAR(45) NULL ,  "
    		+ "`prod_name` VARCHAR(45) NULL ,  `prod_price` INT NULL , "
    		+ " `order_num` VARCHAR(45) NULL ,  `order_time` TIMESTAMP NULL , `order_category` VARCHAR(45) NULL, `total_price` INT NULL, "
    		+ " PRIMARY KEY (`order_id`) )";
      int rs = 0;
      Connection conn = null;
      Statement stmt = null;
      System.out.println("o:"+id);
      
      
      try {
           conn = DBManager.getConnection();
           stmt = conn.createStatement();
            
          rs = stmt.executeUpdate(sql);
          System.out.println("o");
             
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBManager.close(conn, stmt);
    }
    return rs;
}
	

public int createTable_q(String id){
	
    String sql = "CREATE table "+id+".qna  (qseq INT NOT NULL AUTO_INCREMENT , "
    		+ "subject varchar(300), content varchar(1000), reply varchar(1000), "
    		+ "cus_id varchar(20), rep char(1) default '1', indate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,"
    		+ "PRIMARY KEY (`qseq`) )";
      int rs = 0;
      Connection conn = null;
      Statement stmt = null;
      System.out.println("q:"+id);
      
      
      try {
           conn = DBManager.getConnection();
           stmt = conn.createStatement();
            
          rs = stmt.executeUpdate(sql);
          System.out.println("q");
             
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      DBManager.close(conn, stmt);
    }
    return rs;
}
	

	public int confirmID(String id) {
		int result = -1;
		
		String sql = "select * from admin.shop_admin where shop_admin_id = ?";
		
		
		Connection connn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		 try {
		      connn = DBManager.getConnection();
		      pstmt = connn.prepareStatement(sql);
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
		      if (rs.next()) { 
		        result = 1;
		      } else { 
		        result = -1;
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(connn, pstmt, rs);
		    }
		    return result;
		  }

	public int insertCusMember(MemberVO memberVO, String id) {
		 int result = 0;
		    String sql = "insert into "+id+".member(cus_id, cus_pass, cus_name, cus_email, cus_phone, cus_addr, cus_age, zip_num)";
		    sql += " values(?, ?, ?, ?, ?, ?, ?, ?)";
		    

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		   
		      pstmt.setString(1, id);      
		      pstmt.setString(2, null);
		      pstmt.setString(3, null);
		      pstmt.setString(4, null);
		      pstmt.setString(5, null);
		      pstmt.setString(6, null);
		      pstmt.setString(7, null);
		      pstmt.setString(8, null);
		      result = pstmt.executeUpdate();
		      
		      System.out.println(id);
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, pstmt);
		    }
		    return result;
		
	}
	
	
	public ArrayList<QnaVO> listAllQna() {
		ArrayList<QnaVO> qnaList = new ArrayList<QnaVO>();
		// 게시판의 데이터를 가지고 오는 쿼리 rep:1:게시물 2: 답변
		System.out.println(adminid);
		String sql = "select * from " + adminid + ".qna order by indate desc";

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
		String sql = "update " + adminid + ".qna set reply=?, rep='2' where qseq=?";
		System.out.println(adminid);
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

	public QnaVO getQna(int seq) {
		QnaVO qnaVO = null;
		System.out.println(adminid);
		String sql = "select * from " + adminid + ".qna where qseq=?";
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

	public void adminOut(String id) {
		String sql = "DELETE FROM admin.shop_info1 WHERE shop_admin_id=?";
		System.out.println(id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("delete2-"+id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void schemaOut(String id) {
		String sql = "DROP DATABASE "+id;
		System.out.println(id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			System.out.println("delete3-"+id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public ArrayList<MemberVO> adminCusList(String id) {
		ArrayList<MemberVO> cusList = new ArrayList<MemberVO>();
		 String sql = "select * from "+id+".member";
		    
		    Connection con = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;    
		    
		    try {
		      con = DBManager.getConnection();
		      pstmt = con.prepareStatement(sql);
		      rs = pstmt.executeQuery();
		      while (rs.next()) { 
		    	  MemberVO cus = new MemberVO();
		    	  cus = new MemberVO();
		    	  cus.setId(rs.getString("cus_id"));
		    	  cus.setPwd(rs.getString("cus_pass"));
		    	  cus.setCus_name(rs.getString("cus_name"));
		    	  cus.setCus_email(rs.getString("cus_email"));
		    	  cus.setCus_phone(rs.getString("cus_phone"));
		    	  cus.setCus_addr(rs.getString("cus_addr"));
		    	  cus.setCus_age(rs.getString("cus_age"));
		    	  cus.setZip_num(rs.getString("zip_num"));
		    	  cusList.add(cus);
		    	 System.out.println("ddd="+id);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(con, pstmt, rs);
		    }
		    return cusList;
	}
	
	public ArrayList<OrderVO> listOrder(String id) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from "+id+".order order by order_time desc";
		System.out.println(id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO orderVO = new OrderVO();
				orderVO.setOrder_id(rs.getInt("order_id"));
				orderVO.setCus_id(rs.getString("cus_id"));
				orderVO.setProd_name(rs.getString("prod_name"));
				orderVO.setProd_price(rs.getInt("prod_price"));
				orderVO.setProd_num(rs.getInt("order_num"));
				orderVO.setTotal_price(rs.getInt("total_price"));
				orderVO.setOrder_time(rs.getTimestamp("order_time"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return orderList;
	}
	//상품 삭제
	public ProductVO deleteProduct(String con, String prod_id){
		ProductVO deleteProd = new ProductVO();
		String sql = "delete from "+adminid+"."+con+" where prod_id = ?";
		System.out.println(con);
		System.out.println(prod_id);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		int result = 0;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prod_id);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return deleteProd;
	}
	//상품 수정
	public int updateProduct(String con, int prod_id, ProductVO prodVO) {
		int result = 0;
		String sql = "update " + adminid + "." + con
				+ " set prod_name=?, prod_price=?, prod_img=?, contents=?, con_img=?, prod_detail1=?, "
				+ "prod_detail2=?, prod_detail3=?, prod_detail4=?, count=? where prod_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodVO.getProd_name());
			pstmt.setInt(2, prodVO.getProd_price());
			pstmt.setString(3, prodVO.getProd_img());
			pstmt.setString(4, prodVO.getContents());
			pstmt.setString(5, prodVO.getCon_img());
			pstmt.setString(6, prodVO.getProd_detail1());
			pstmt.setString(7, prodVO.getProd_detail2());
			pstmt.setString(8, prodVO.getProd_detail3());
			pstmt.setString(9, prodVO.getProd_detail4());
			pstmt.setInt(10, prodVO.getCount());
			pstmt.setInt(11, prod_id);
			System.out.println("상품이름 : "+prodVO.getProd_name());
			System.out.println("prod_id : "+prod_id);
			System.out.println("con : "+con);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}