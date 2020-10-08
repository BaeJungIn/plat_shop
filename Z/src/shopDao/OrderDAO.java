package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopCtr.ShopServlet;
import shopDto.CartVO;
import shopDto.OrderVO;
import util.DBManager;

public class OrderDAO {

	public String adminid = ShopServlet.adminid;

	private OrderDAO() {

	}

	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}
	
	
	public void insertOrder(OrderVO orderVO) {
		
		String sql = "insert into "+adminid+".order( cus_id, prod_id, prod_name, prod_price ,order_num, order_category, total_price)" + " values(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("1 : " + orderVO.getCus_id());
			System.out.println("2 : " + orderVO.getProd_id());
			System.out.println("3 : " + orderVO.getProd_name());
			System.out.println("4 : " + orderVO.getProd_price());
			System.out.println("5 : " + orderVO.getProd_num());
			System.out.println("6 : " + orderVO.getOrder_category());
			System.out.println("7 : " + (orderVO.getProd_num() * orderVO.getProd_price()));
			
			pstmt.setString(1, orderVO.getCus_id()); 
			pstmt.setInt(2, orderVO.getProd_id());
			pstmt.setString(3, orderVO.getProd_name()); 
			pstmt.setInt(4, orderVO.getProd_price());
			pstmt.setInt(5, orderVO.getProd_num()); 
			pstmt.setString(6, orderVO.getOrder_category());
			pstmt.setInt(7, (orderVO.getProd_num() * orderVO.getProd_price()));
			
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
	public ArrayList<OrderVO> listOrder(String cus_id) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select * from "+adminid+".order where cus_id=? order by order_id desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO orderVO = new OrderVO();
				orderVO.setOrder_id(rs.getInt("order_id")); 
				orderVO.setCus_id(rs.getString("cus_id")); 
				orderVO.setProd_id(rs.getInt("prod_id")); 
			
				orderVO.setProd_name(rs.getString("prod_name")); 
				orderVO.setProd_num(rs.getInt("order_num")); 
				
				orderVO.setOrder_time(rs.getTimestamp("order_time"));
				orderVO.setProd_price(rs.getInt("prod_price")); 
				orderVO.setTotal_price(rs.getInt("total_price"));
				orderList.add(orderVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return orderList;
	}
	
	
	
	public void CartInsertOrder(int cart_id) {
		String sql = "insert into "+adminid+".order( cus_id, prod_id, prod_name, prod_price ,order_num, order_category, total_price, count)" + " values(?,?,?,?,?,?,?,?)";
		
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
		
	
	
	
	
	public int insertOrder(ArrayList<CartVO> cartList, String id) {
		int maxOseq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		try {
			conn = DBManager.getConnection();
			
			String maxcount = "select max(order_id) from "+ShopServlet.adminid+".order";
			//String selectMaxOseq = "select max(order_id) from "+ShopServlet.adminid+"order";
			pstmt = conn.prepareStatement(maxcount);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxOseq = rs.getInt(1); 
			}
			pstmt.close();
		
			
			String insertOrder = "insert into "+ShopServlet.adminid+".order(cus_id) values(?)";
			
			pstmt = conn.prepareStatement(insertOrder);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			for (CartVO cartVO : cartList) {
				insertOrderDetail(cartVO, maxOseq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return maxOseq;
	}

	public void insertOrderDetail(CartVO cartVO, int maxOseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			String insertOrderDetail="insert into "+adminid+".order(cus_id, prod_id, prod_name, prod_price, "
					+ "order_num, order_category, total_price) values(?,?,?,?,?,?,?)";
		
			pstmt = conn.prepareStatement(insertOrderDetail);
			
			pstmt.setString(1, cartVO.getCus_id());
			pstmt.setInt(2, cartVO.getProd_id()); 
			pstmt.setString(3, cartVO.getProd_name()); 
			pstmt.setInt(4, cartVO.getProd_price());
			pstmt.setInt(5, cartVO.getCart_num());
			pstmt.setString(6, cartVO.getCategory()); 
			pstmt.setInt(7, cartVO.getProd_price2()); 
			pstmt.executeUpdate();
			pstmt.close();
			String updateCartResult = "delete from "+adminid+".cart where cart_id=?";
			
			pstmt = conn.prepareStatement(updateCartResult);
			pstmt.setInt(1, cartVO.getCart_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ArrayList<Integer> selectSeqOrderIng(String id) {
		ArrayList<Integer> oseqList = new ArrayList<Integer>();
		String sql = "select distinct oseq from order_view " + "where id=? and result='1' order by oseq desc";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				oseqList.add(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return oseqList;
	}

	public ArrayList<OrderVO> listOrderById(String id, String string) {
		ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
		String sql = "select prod_name, prod_price, prod_id, order_num from " + ShopServlet.adminid + ".order where cus_id=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO order = new OrderVO();
				order = new OrderVO();
				order.setProd_name(rs.getString("prod_name"));
				order.setProd_price(rs.getInt("prod_price"));
				order.setProd_id(rs.getInt("prod_id"));
				order.setProd_num(rs.getInt("order_num"));
				orderList.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return orderList;
	}

}
