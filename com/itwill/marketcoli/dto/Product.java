package com.itwill.marketcoli.dto;


/*
이름           널?       유형             
------------ -------- -------------- 
P_NO         NOT NULL NUMBER(10)     
P_NAME       NOT NULL VARCHAR2(50)   
P_PRICE      NOT NULL NUMBER(10)     
P_EXP                 VARCHAR2(1000) 
P_CATEGORY_B          VARCHAR2(50)   
P_CATEGORY_S          VARCHAR2(50)  
 */
public class Product {

	private int p_no;				//상품번호	
	private String p_name;			//상품이름
	private int p_price;			//상품가격
	private String p_exp;			//상품설명
	private String p_category_b;	//상위카테고리
	private String p_category_s;	//하위카테고리
	
	public Product() {
		
	}

	public Product(int p_no, String p_name, int p_price, String p_exp, String p_category_b,	String p_category_s) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_exp = p_exp;
		this.p_category_b = p_category_b;
		this.p_category_s = p_category_s;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_exp() {
		return p_exp;
	}

	public void setP_exp(String p_exp) {
		this.p_exp = p_exp;
	}

	public String getP_category_b() {
		return p_category_b;
	}

	public void setP_category_b(String p_category_b) {
		this.p_category_b = p_category_b;
	}

	public String getP_category_s() {
		return p_category_s;
	}

	public void setP_category_s(String p_category_s) {
		this.p_category_s = p_category_s;
	}

	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price
				+ ", p_exp=" + p_exp + ", p_category_b=" + p_category_b + ", p_category_s=" + p_category_s + "]";
	}

	
	
	
}
