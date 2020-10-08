package shopDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shopDto.HeaderVO;
import util.DBManager;

public class HeaderDAO {
	private HeaderDAO() {
	}

	private static HeaderDAO instance = new HeaderDAO();

	public static HeaderDAO getInstance() {
		return instance;
	}

	public HeaderVO getHeader(String id) {
		HeaderVO headerVO = null;

		String shop_info1 = "1";
		String shop_info2 = "2";

		int design = 0;

		int design1 = Integer.parseInt(shop_info1);
		int design2 = Integer.parseInt(shop_info2);

		
		
		String sql1 = "select shop_design from admin.shop_admin where shop_admin_id = happyshop";

		
		String sql2 = "select * from admin.shop_info1 where shop_admin_id = ?";
		String sql3 = "select * from admin.shop_info2 where shop_admin_id = happyshop";

		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		 try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql2);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				headerVO = new HeaderVO();
				headerVO.setCategory_1(rs.getString("category_1"));
				headerVO.setCategory_2(rs.getString("category_2"));
				headerVO.setCategory_3(rs.getString("category_3"));
				headerVO.setCategory_4(rs.getString("category_4"));
				headerVO.setCategory_5(rs.getString("category_5"));
				headerVO.setLogo_img1(rs.getString("logo_img1"));
				headerVO.setLogo_img2(rs.getString("logo_img2"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		
		return headerVO;
	}
}

