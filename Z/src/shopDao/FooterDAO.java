package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopDto.FooterVO;
import util.DBManager;

public class FooterDAO {
	private FooterDAO() {
	}

	private static FooterDAO instance = new FooterDAO();

	public static FooterDAO getInstance() {
		return instance;
	}

	public FooterVO getFooter(String id) {
		FooterVO footerVO = null;

		String sql = "select * from admin.shop_admin where shop_admin_id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				footerVO = new FooterVO();
				footerVO.setShop_addr(rs.getString("shop_address"));
				footerVO.setShop_tel(rs.getString("shop_admin_phone"));
				footerVO.setShop_email(rs.getString("shop_admin_email"));
				//footerVO.setShop_num(rs.getString("shop_num"));
				//footerVO.setLogo_img2(rs.getString("logo_img2"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return footerVO;
	}
	
	public FooterVO getFooter1(String id){
		FooterVO footerVO = null;
		String sql = "select * from admin.shop_info1 where shop_admin_id = ?";
		
		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				footerVO = new FooterVO();
				footerVO.setLogo_img2(rs.getString("logo_img2"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		
		return footerVO;
	}
	}
 
