package shopDao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import shopCtr.ShopServlet;
import shopDto.ProductVO;
import shopDto.ShopVO;
import util.DBManager;


public class ProductDAO {
		String categoryList[] = new String[5];
	public String adminid = ShopServlet.adminid;
	private String con = ShopServlet.con;
	private String proid = ShopServlet.proid;
	private ProductDAO() {
		
	  }

	  private static ProductDAO instance = new ProductDAO();

	  public static ProductDAO getInstance() {
	    return instance;
	  }
	  
	  
	  
	  public ArrayList<ShopVO> getMainImage() {
	        ArrayList<ShopVO> shopimgList = new ArrayList<ShopVO>();
	       String sql = "select main_img1, main_img2 from admin.shop_info1 where shop_admin_id='"+adminid+"'"; 
	       
	       Connection con = null;
	       PreparedStatement stmt = null;
	       ResultSet rs = null;    
	       
	       try {
	         con = DBManager.getConnection();
	         stmt = con.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while (rs.next()) { 
	            ShopVO shop = new ShopVO();
	            shop = new ShopVO();
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

	  public String listCategory(String command, int temp){
	      adminid = command;
	      System.out.println("adminid = "+adminid);
	      String sql = "select category_"+temp+" from admin.shop_info1 where shop_admin_id='"+adminid+"'";
	      String result =null;
	      Connection conn = null;
	      Statement pstmt = null;
	      ResultSet rs = null;
	      System.out.println("listca1");
	      
	      
	      try {
	           conn = DBManager.getConnection();
	            pstmt = conn.createStatement();
	            
	             rs = pstmt.executeQuery(sql);
	             while(rs.next()){
	                if(!rs.getString("category_"+temp).equals("")){
	                   categoryList[temp-1] = rs.getString("category_"+temp);
	                   System.out.println("category = "+categoryList[temp-1]);
	                }
	             }
	            
	      } catch (Exception e) {
	          System.out.println("listca1");
	          return null;
	      }finally {
	            DBManager.close(conn, pstmt, rs);
	          }
	          return result;
	        }
	
	  public ArrayList<ProductVO> listNewProduct(String command) {
		  adminid = command;
	    ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	    String sql = "";
	       
	       for(int i=0; i<categoryList.length;i++){
	          if(categoryList[i]!=null){
	          sql += "select * from "+adminid+"."+categoryList[i];
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
	 
	  
	  public ArrayList<ProductVO> productIndex(String contents) {
		  con = contents;
	    ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	    String sql = "select *  from "+adminid+"."+con;
	    
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
	       
	        System.out.println("1 : " + product.getProd_id());
	        System.out.println("2 : " + product.getProd_name());
	        System.out.println("3 : " + product.getProd_price());
	        
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt, rs);
	    }
	    
	    for(ProductVO vo : productList ){
	    	System.out.println( "result : " + vo.getProd_name() ); 
	    	System.out.println( "result : " + vo.getProd_price() );
	    }
	    
	    return productList;
	    
	  }
	  
	  
	  public ArrayList<ProductVO> productDetail(String prodid) {
		  proid = prodid;
	    ArrayList<ProductVO> productList = new ArrayList<ProductVO>();
	    System.out.println(proid);
	    String sql = "select *  from "+adminid+"."+con+" where prod_id = "+ proid;
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        ProductVO product = new ProductVO();
	        product.setProd_name(rs.getString("prod_name"));
	        product.setContents(rs.getString("contents"));
	        product.setCon_img(rs.getString("con_img"));
	        product.setProd_price(rs.getInt("prod_price"));
	        product.setProd_detail1(rs.getString("prod_detail1"));
	        product.setProd_detail2(rs.getString("prod_detail2"));
	        product.setProd_detail3(rs.getString("prod_detail3"));
	        product.setProd_detail4(rs.getString("prod_detail4"));
	        productList.add(product);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt, rs);
	    }
	    return productList;
	  }
	 
	  
	  public ProductVO getProduct(String prod_id) {
	    ProductVO product = null;
	    String sql = "select * from happyshop.acc_product";
	    
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;    
	    
	    try {
	      con = DBManager.getConnection();
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, prod_id);
	      rs = pstmt.executeQuery();
	      if (rs.next()) { 
	        product = new ProductVO();
	        product.setProd_id(rs.getInt("prod_id"));
	        product.setProd_name(rs.getString("prod_name"));
	        product.setProd_img(rs.getString("prod_img"));
	        product.setProd_price(rs.getInt("prod_price"));
	        
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(con, pstmt, rs);
	    }
	    return product;
	  }

	}