package shopDto;

import java.sql.Timestamp;

public class CartVO {
	private int cart_id;//��ٱ���  ��ȣ
	private String cus_id;//�ֹ��� ���̵�
	private int prod_id;//��ǰ��ȣ
	private String prod_name;//��ǰ �̸�
	private int prod_price;//��ǰ����
	private int cart_num;//��ٱ��Ͽ� ���� ��ǰ ����
	private int prod_price2;//��ǰ ���� * ��ǰ ����
	private String category; // ��ǰ ī�װ�
	
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
