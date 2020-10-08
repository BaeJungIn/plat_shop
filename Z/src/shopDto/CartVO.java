package shopDto;

import java.sql.Timestamp;

public class CartVO {
	private int cart_id;//장바구니  번호
	private String cus_id;//주문자 아이디
	private int prod_id;//상품번호
	private String prod_name;//물품 이름
	private int prod_price;//물품가격
	private int cart_num;//장바구니에 넣은 물품 개수
	private int prod_price2;//상품 개수 * 물품 가격
	private String category; // 물품 카테고리
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getProd_price2() {
		return prod_price2;
	}
	public void setProd_price2(int prod_price2) {
		this.prod_price2 = prod_price2;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
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
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
}
