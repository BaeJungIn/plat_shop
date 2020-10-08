package shopDao;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopCtr.ShopServlet;
import shopDto.CartVO;
import util.DBManager;
import java.util.*;


public class CartDAO {
	
	public String adminid = ShopServlet.adminid;
	
	private CartDAO() {
	}
	
	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
		return instance;
	}

	public void insertCart(CartVO cartVO) {
		//String sql = "insert into happyshop.cart( cus_id, prod_id, prod_name, prod_price ,cart_num, prod_price2, category)" + " values(?,?,?,?,?,?,?)";
		String sql = "insert into "+adminid+".cart( cus_id, prod_id, prod_name, prod_price ,cart_num, category, prod_price2)" + " values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cartVO.getCus_id()); 
			pstmt.setInt(2, cartVO.getProd_id());
			pstmt.setString(3, cartVO.getProd_name()); 
			pstmt.setInt(4, cartVO.getProd_price());
			pstmt.setInt(5, cartVO.getCart_num()); 
			pstmt.setString(6, cartVO.getCategory());
			pstmt.setInt(7, cartVO.getProd_price() * cartVO.getCart_num());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<CartVO> listCart(String cus_id) {
		ArrayList<CartVO> cartList = new ArrayList<CartVO>();
		String sql = "select * from "+adminid+".cart where cus_id=? order by cart_id desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartVO cartVO = new CartVO();
				cartVO.setCart_id(rs.getInt("cart_id")); 
				cartVO.setCus_id(rs.getString("cus_id")); 
				cartVO.setProd_id(rs.getInt("prod_id")); 
				//cartVO.set(rs.getString(4)); 
				cartVO.setProd_name(rs.getString("prod_name")); 
				cartVO.setCart_num(rs.getInt("cart_num")); 
				
				
				cartVO.setProd_price(rs.getInt("prod_price")); 
				cartVO.setProd_price2(rs.getInt("prod_price2"));
				cartList.add(cartVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cartList;
	}

	public void deleteCart(int cart_id) {
		String sql = "delete from "+adminid+".cart where cart_id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
