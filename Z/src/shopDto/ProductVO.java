package shopDto;

import java.sql.Timestamp;

public class ProductVO {
	private int prod_id;
//	public static String prod_name;
//	public static int prod_price;
	private String category;
	private String prod_name;
	private int prod_price;
	private String prod_img;
	private String contents;
	private String con_img;
	private String prod_detail1;
	private String prod_detail2;
	private String prod_detail3;
	private String prod_detail4;
	private Timestamp reg_time;
	private int count;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProd_detail1() {
		return prod_detail1;
	}

	public void setProd_detail1(String prod_detail1) {
		this.prod_detail1 = prod_detail1;
	}

	public String getProd_detail2() {
		return prod_detail2;
	}

	public void setProd_detail2(String prod_detail2) {
		this.prod_detail2 = prod_detail2;
	}

	public String getProd_detail3() {
		return prod_detail3;
	}

	public void setProd_detail3(String prod_detail3) {
		this.prod_detail3 = prod_detail3;
	}

	public String getProd_detail4() {
		return prod_detail4;
	}

	public void setProd_detail4(String prod_detail4) {
		this.prod_detail4 = prod_detail4;
	}

	public Timestamp getReg_time() {
		return reg_time;
	}

	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCon_img() {
		return con_img;
	}

	public void setCon_img(String con_img) {
		this.con_img = con_img;
	}


}
