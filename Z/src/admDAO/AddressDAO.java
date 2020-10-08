package admDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admDTO.AddressVO;

import util.DBManager;

public class AddressDAO {
	private AddressDAO() {
	  }

	  private static AddressDAO instance = new AddressDAO();

	  public static AddressDAO getInstance() {
	    return instance;
	  }


	  public ArrayList<AddressVO> selectAddressByDong(String dong) {    
	    ArrayList<AddressVO> list = new ArrayList<AddressVO>();
	    
	    String sql = "select * from admin.address where dong like '%'||?||'%'";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	      conn = DBManager.getConnection();
	      pstmt=conn.prepareStatement(sql);
	      pstmt.setString(1, dong);
	      rs = pstmt.executeQuery();

	      while (rs.next()) {
	        AddressVO addressVO = new AddressVO();
	        addressVO.setZipNum(rs.getString("zip_num"));
	        addressVO.setSido(rs.getString("sido"));
	        addressVO.setGugun(rs.getString("gugun"));
	        addressVO.setDong(rs.getString("dong"));
	        addressVO.setZipNum(rs.getString("zipcode"));
	        addressVO.setBunji(rs.getString("bunji"));

	        list.add(addressVO);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return list;
	  }
	}
