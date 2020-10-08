package shopDao;

import java.sql.ResultSet;
import java.util.ArrayList;

import shopCtr.ShopServlet;
import shopDto.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;



import util.DBManager;

public class MemberDAO {
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public int confirmID(String id) {
		int result = -1;
		
		String sql = "select * from "+ShopServlet.adminid+".member where cus_id = ?";
		
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

		  public MemberVO getMember(String id) {       
		    MemberVO memberVO= null;
		    String sql = "select * from "+ ShopServlet.adminid+".member where cus_id = ?";
		     
		    Connection connn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;

		    try {
		      connn = DBManager.getConnection();
		      pstmt = connn.prepareStatement(sql);
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery();
		      if(rs.next()){
		        memberVO = new MemberVO();
		        memberVO.setId(rs.getString("cus_id"));
		        memberVO.setPwd(rs.getString("cus_pass"));
		        memberVO.setCus_name(rs.getString("cus_name"));
		        memberVO.setCus_email(rs.getString("cus_email"));
		        memberVO.setCus_phone(rs.getString("cus_phone"));
		        memberVO.setCus_addr(rs.getString("cus_addr"));
		        memberVO.setCus_age(rs.getString("cus_age"));
		        memberVO.setZip_num(rs.getString("zip_num"));
		       } 
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(connn, pstmt, rs);
		    }
		    return memberVO;
		  }

		  public int insertMember(MemberVO memberVO) {
		    int result = 0;
		    String sql = "insert into "+ShopServlet.adminid+".member(cus_id, cus_pass, cus_name, cus_email, cus_phone, cus_addr, cus_age, zip_num)";
		    sql += " values(?, ?, ?, ?, ?, ?, ?, ?)";
		    
		    

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		   
		      pstmt.setString(1, memberVO.getId());      
		      pstmt.setString(2, memberVO.getPwd());
		      pstmt.setString(3, memberVO.getCus_name());
		      pstmt.setString(4, memberVO.getCus_email());
		      pstmt.setString(5, memberVO.getCus_phone());
		      pstmt.setString(6, memberVO.getCus_addr());
		      pstmt.setString(7, memberVO.getCus_age());
		      pstmt.setString(8, memberVO.getZip_num());
		      result = pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, pstmt);
		    }
		    return result;
		  }


	      public int updateMember(MemberVO memberVO) {
	         
	         int result = 0;
	         String sql = "update "+ShopServlet.adminid+".member set cus_pass=?, cus_email=?, cus_phone=?, cus_addr=?, cus_age=?, zip_num=? WHERE cus_id=?";
	         
	          Connection conn = null;
	          PreparedStatement pstmt = null;
	          
	          try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	                  
	            pstmt.setString(1, memberVO.getPwd());
	            pstmt.setString(2, memberVO.getCus_email());
	            pstmt.setString(3, memberVO.getCus_phone());
	            pstmt.setString(4, memberVO.getCus_addr());
	            pstmt.setString(5, memberVO.getCus_age());
	            pstmt.setString(6, memberVO.getZip_num());
	            pstmt.setString(7, memberVO.getId());
	            pstmt.executeUpdate();
	            
	          } catch (Exception e) {
	            e.printStackTrace();
	          } finally {
	            DBManager.close(conn, pstmt);
	          }
	          return result;
	      }

		public void userOut(String id) {
			      String sql = "DELETE FROM "+ShopServlet.adminid+".member WHERE cus_id=?";
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
		
	        
	      
	         /* *
	         
	          */
	         /*public ArrayList<MemberVO> listMember(String member_name) {
	            ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
	            String sql = "select * from member where name like '%'||?||'%' " +
	                  "order by indate desc";

	            Connection conn = null;
	            PreparedStatement pstmt = null;
	            ResultSet rs = null;

	            try {
	               conn = DBManager.getConnection();
	               pstmt = conn.prepareStatement(sql);
	               if (member_name == "") {
	                  pstmt.setString(1, "%");
	               } else {
	                  pstmt.setString(1, member_name);
	               }
	               rs = pstmt.executeQuery();
	               while (rs.next()) {
	                  MemberVO memberVO = new MemberVO();
	                  memberVO.setId(rs.getString("id"));
	                    memberVO.setPwd(rs.getString("pwd"));
	                    memberVO.setName(rs.getString("name"));
	                    memberVO.setEmail(rs.getString("email"));
	                    memberVO.setZipNum(rs.getString("zip_num"));
	                    memberVO.setAddress(rs.getString("address"));
	                    memberVO.setPhone(rs.getString("phone"));
	                    memberVO.setUseyn(rs.getString("useyn"));
	                    memberVO.setIndate(rs.getTimestamp("indate"));
	                    memberList.add(memberVO);
	               }
	            } catch (Exception e) {
	               e.printStackTrace();
	            } finally {
	               DBManager.close(conn, pstmt, rs);
	            }
	            return memberList;
	         }*/
	      }