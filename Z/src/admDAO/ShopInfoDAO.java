package admDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admDTO.ShopInfoVO;
import shopDto.ProductVO;
import util.DBManager;

public class ShopInfoDAO {
	String categoryList[] = new String[5];
	private ShopInfoDAO() {
	}

	private static ShopInfoDAO instance = new ShopInfoDAO();

	public static ShopInfoDAO getInstance() {
		return instance;
	}

	public int insertShopInfo(ShopInfoVO ShopInfoVO) {
	      int result = 0;
	      String id = ShopInfoVO.getShop_admin_id();
	      String category[] = {ShopInfoVO.getCategory_1(),ShopInfoVO.getCategory_2(),ShopInfoVO.getCategory_3(),ShopInfoVO.getCategory_4(),ShopInfoVO.getCategory_5()};
	      String sql = "insert into admin.shop_info1(shop_admin_id, logo_img1, logo_img2, main_img1, main_img2, "
	            + "category_1, category_2, category_3, category_4, category_5)";
	      sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      Statement stmt = null;

	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         stmt = conn.createStatement();

	         pstmt.setString(1, ShopInfoVO.getShop_admin_id());
	         pstmt.setString(2, ShopInfoVO.getLogo_img1());
	         pstmt.setString(3, ShopInfoVO.getLogo_img2());
	         pstmt.setString(4, ShopInfoVO.getMain_img1());
	         pstmt.setString(5, ShopInfoVO.getMain_img2());
	         pstmt.setString(6, ShopInfoVO.getCategory_1());
	         pstmt.setString(7, ShopInfoVO.getCategory_2());
	         pstmt.setString(8, ShopInfoVO.getCategory_3());
	         pstmt.setString(9, ShopInfoVO.getCategory_4());
	         pstmt.setString(10, ShopInfoVO.getCategory_5());

	         result = pstmt.executeUpdate();
	         for (int i = 0; i < category.length; i++) {
	            if (!category[i].equals(null)) {
	               sql = "CREATE  TABLE " + id + "." + category[i] + " (  `prod_id` INT NOT NULL AUTO_INCREMENT ,  "
	                     + "`prod_name` VARCHAR(45) NULL ,  `prod_price` INT NULL ,  `prod_img` VARCHAR(45) NULL , "
	                     + " `contents` VARCHAR(500) NULL ,  `con_img` VARCHAR(45) NULL ,  `prod_detail1` VARCHAR(45) NULL , "
	                     + "`prod_detail2` VARCHAR(45) NULL , `prod_detail3` VARCHAR(45) NULL , `prod_detail4` VARCHAR(45) NULL , "
	                     + "`reg_time`  TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, `count` INT NULL , "
	                     + "PRIMARY KEY (`prod_id`) );";
	               System.out.println("create");
	               System.out.println(sql);
	               stmt.executeUpdate(sql);
	            }else
	               break;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt);
	      }
	      return result;
	   }

	public ShopInfoVO getShopInfo(String id) {
		ShopInfoVO sVo = new ShopInfoVO();
		String sql = "select * from admin.shop_info1 where shop_admin_id='" + id + "'";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				sVo.setCategory_1(rs.getString("category_1"));
				sVo.setCategory_2(rs.getString("category_2"));
				sVo.setCategory_3(rs.getString("category_3"));
				sVo.setCategory_4(rs.getString("category_4"));
				sVo.setCategory_5(rs.getString("category_5"));
				sVo.setLogo_img1(rs.getString("logo_img1"));
				sVo.setLogo_img2(rs.getString("logo_img2"));
				sVo.setMain_img1(rs.getString("main_img1"));
				sVo.setMain_img2(rs.getString("main_img2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, stmt, rs);
		}
		return sVo;
	}

	public int updateShopInfo(ShopInfoVO ShopInfoVO, String id) {
		int result = 0;
		String sql = "update admin.shop_info1 set logo_img1=?, logo_img2=?, main_img1=?, main_img2=?, category_1=?, category_2=?, category_3=?, category_4=?, category_5=? where shop_admin_id=?"; // info1,2

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ShopInfoVO.getLogo_img1());
			pstmt.setString(2, ShopInfoVO.getLogo_img2());
			pstmt.setString(3, ShopInfoVO.getMain_img1());
			pstmt.setString(4, ShopInfoVO.getMain_img2());
			pstmt.setString(5, ShopInfoVO.getCategory_1());
			pstmt.setString(6, ShopInfoVO.getCategory_2());
			pstmt.setString(7, ShopInfoVO.getCategory_3());
			pstmt.setString(8, ShopInfoVO.getCategory_4());
			pstmt.setString(9, ShopInfoVO.getCategory_5());
			pstmt.setString(10, id);

			System.out.println(ShopInfoVO.getLogo_img1());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public String listCategory(String id, int temp){
	      String sql = "select category_"+temp+" from admin.shop_info1 where shop_admin_id='"+id+"'";
	      String result =null;
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      
	      
	      try {
	           conn = DBManager.getConnection();
	            stmt = conn.createStatement();
	            
	             rs = stmt.executeQuery(sql);
	             while(rs.next()){
	                if(!rs.getString("category_"+temp).equals("")){
	                   categoryList[temp-1] = rs.getString("category_"+temp);
	                   System.out.println("category = "+categoryList[temp-1]);
	                }
	             }
	            
	      } catch (Exception e) {
	          return null;
	      }finally {
	            DBManager.close(conn, stmt, rs);
	          }
	          return result;
	        }
	
	
	
	public int categoryUpdate(String id, String category1, String category2, String category3, String category4, String category5) {
       String sql = "";
       String category[] = {category1, category2, category3, category4, category5};
       /*for(int i=0; i<categoryList.length;i++){
          if(categoryList[i] != null){
        		 sql += "ALTER TABLE "+id+"."+categoryList[i]+" RENAME "+id+"."+category[i]+"; ";
        	 	 System.out.println("alter");
          }else{
        	 sql += "CREATE TABLE "+id+"."+category[i]+"(`prod_id` INT NOT NULL AUTO_INCREMENT ,  `prod_name` VARCHAR(45) NULL ,  `prod_price` INT NULL ,  `prod_img` VARCHAR(45) NULL ,  `contents` VARCHAR(500) NULL ,  `con_img` VARCHAR(45) NULL ,  `prod_detail1` VARCHAR(45) NULL , `prod_detail2` VARCHAR(45) NULL , `prod_detail3` VARCHAR(45) NULL , `prod_detail4` VARCHAR(45) NULL , `reg_time`  TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, `count` INT NULL , PRIMARY KEY (`prod_id`) ); ";
        	 System.out.println("create");
        	 break;
             
          }
         
       }*/
       
          int rs = 0;
	      Connection conn = null;
	      Statement stmt = null;
	      
	      
	      try {
	           conn = DBManager.getConnection();
	           stmt = conn.createStatement();
	           
	           for(int i=0; i<categoryList.length;i++){
	        	   if(categoryList[i] != null){
	        		   conn = DBManager.getConnection();
	    	           stmt = conn.createStatement();
	        		   sql = "ALTER TABLE "+id+"."+categoryList[i]+" RENAME "+id+"."+category[i]+"; ";
	        		   System.out.println("alter");
	        		   stmt.executeUpdate(sql);
	        		   System.out.println(sql);
	        		   DBManager.close(conn, stmt);
	        	   }else{
	        		 conn = DBManager.getConnection();
	    	         stmt = conn.createStatement();
	              	 sql = "CREATE  TABLE "+id+"."+category[i]+" (  `prod_id` INT NOT NULL AUTO_INCREMENT ,  "
	              	 		+ "`prod_name` VARCHAR(45) NULL ,  `prod_price` INT NULL ,  `prod_img` VARCHAR(45) NULL , "
	              	 		+ " `contents` VARCHAR(500) NULL ,  `con_img` VARCHAR(45) NULL ,  `prod_detail1` VARCHAR(45) NULL , "
	              	 		+ "`prod_detail2` VARCHAR(45) NULL , `prod_detail3` VARCHAR(45) NULL , `prod_detail4` VARCHAR(45) NULL , "
	              	 		+ "`reg_time`  TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, `count` INT NULL , "
	              	 		+ "PRIMARY KEY (`prod_id`) );";
	            	 System.out.println("create");
	            	 System.out.println(sql);
	            	 stmt.executeUpdate(sql);
	            	 DBManager.close(conn, stmt);
	            	 break;
	                 
	              }
	           }
	            
	          /*stmt.executeUpdate(sql);*/
	          
	             
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, stmt);
	    }
		return rs;
	
       
     }

	public void adminOut(String id) {
		String sql = "DELETE FROM admin.shop_admin WHERE shop_admin_id=?";
		System.out.println(id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("delete1-"+id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
		
}