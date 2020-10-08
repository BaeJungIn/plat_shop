package admDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import admCtr.AdminServlet;
import admDTO.ShopInfoVO;
import shopCtr.ActionFactory;
import shopCtr.ShopServlet;
import util.DBManager;

import shopDto.ProductVO;
import shopDto.ShopVO;

public class AdminProductDAO {
	String categoryList[] = new String[5];
	

  private AdminProductDAO() {
  }
  
  private static AdminProductDAO instance = new AdminProductDAO();
  
  public static AdminProductDAO getInstance() {
    return instance;
  }
  
  
  
  
  public ArrayList<ShopInfoVO> getMainImage(String id) {
	  	ArrayList<ShopInfoVO> shopimgList = new ArrayList<ShopInfoVO>();
	    String sql = "select main_img1, main_img2 from admin.shop_info1 where shop_admin_id='"+id+"'"; 
	    
	    Connection con = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;    
	    
	    try {
	      con = DBManager.getConnection();
	      stmt = con.prepareStatement(sql);
	      rs = stmt.executeQuery();
	      while (rs.next()) { 
	    	  ShopInfoVO shop = new ShopInfoVO();
	    	  shop = new ShopInfoVO();
	    	  shop.setMain_img1(rs.getString("main_img1"));
	    	  shop.setMain_img2(rs.getString("main_img2"));
	    	  shopimgList.add(shop);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(con, stmt, rs);
	    }
	    return shopimgList;
	  }
  
  public String listCategory(String id, int temp){
      System.out.println("adminid = "+id);
      String sql = "select category_"+temp+" from admin.shop_info1 where shop_admin_id='"+id+"'";
      // String sql = "select category_"+temp+"from admin.
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
          System.out.println("오류");
          return null;
      }finally {
            DBManager.close(conn, stmt, rs);
          }
          return result;
        }
//새로운 아이템
  public ArrayList<ProductVO> listNewProduct(String id) {
       ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
       String sql = "";
       
       for(int i=0; i<categoryList.length;i++){
          if(categoryList[i]!=null){
          sql += "select * from "+id+"."+categoryList[i];
          System.out.println(categoryList[i]);
          }else
             break;
          
          if(categoryList[i+1]!=null){
             sql+= " UNION ALL ";
          }else
             sql += " order by reg_time DESC";
       }
       
       System.out.println(sql);
       
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         System.out.println("1");
         while (rs.next()) {
           System.out.println("2");
           ProductVO product = new ProductVO();
           product.setProd_id(rs.getInt("prod_id"));
           product.setProd_name(rs.getString("prod_name"));
           product.setProd_img(rs.getString("prod_img"));
           product.setProd_price(rs.getInt("prod_price"));
           productList.add(product);
         }
       } catch (Exception e) {
         e.printStackTrace();
       } finally {
         DBManager.close(conn, pstmt, rs);
       }
       return productList;
     }



  public void insertProduct(ProductVO pvo, String id, String category) {
		/*
		 * String sql = "insert into "+ShopServlet.adminid+"."+선택한 카테고리
		 * 값+"(prod_name, prod_price, prod_img, contents, con_img, prod_detail1, prod_detail2, prod_detail3, prod_detail4)"
		 * sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 */
		String sql = "insert into " + id + "." + category
				+ "(prod_name, prod_price, prod_img, contents, con_img, prod_detail1, prod_detail2, prod_detail3, prod_detail4, count)";
		sql += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pvo.getProd_name());
			pstmt.setInt(2, pvo.getProd_price());
			pstmt.setString(3, pvo.getProd_img());
			pstmt.setString(4, pvo.getContents());
			pstmt.setString(5, pvo.getCon_img());
			pstmt.setString(6, pvo.getProd_detail1());
			pstmt.setString(7, pvo.getProd_detail2());
			pstmt.setString(8, pvo.getProd_detail3());
			pstmt.setString(9, pvo.getProd_detail4());
			pstmt.setInt(10, pvo.getCount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
  
//목록별 상품
	public ArrayList<ProductVO> admProductIndex(String adminid, String con) {
		ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
		String sql = "select * from " + adminid + "." + con;
		System.out.println("adminid : " + adminid + " contents : " + con);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO product = new ProductVO();
				product.setProd_id(rs.getInt("prod_id"));
				product.setProd_name(rs.getString("prod_name"));
				product.setProd_img(rs.getString("prod_img"));
				product.setProd_price(rs.getInt("prod_price"));
				productList.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return productList;
	}
	public ProductVO getProductInfo(String adminid, String category, String prod_id) {
		ProductVO pVo = new ProductVO();
		String sql = "select * from "+adminid+"."+category+" where prod_id='" + prod_id + "'";

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				pVo.setProd_name(rs.getString("prod_name"));
				pVo.setProd_price(rs.getInt("prod_price"));
				pVo.setProd_img(rs.getString("prod_img"));
				pVo.setContents(rs.getString("contents"));
				pVo.setCon_img(rs.getString("con_img"));
				pVo.setProd_detail1(rs.getString("prod_detail1"));
				pVo.setProd_detail2(rs.getString("prod_detail2"));
				pVo.setProd_detail3(rs.getString("prod_detail3"));
				pVo.setProd_detail4(rs.getString("prod_detail4"));
				pVo.setCount(rs.getInt("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, stmt, rs);
		}
		return pVo;
	}
}
  


