package com.itwill.marketcoli.dto;

import java.util.Date;

/*
이름        널?       유형             
--------- -------- -------------- 
R_NO      NOT NULL NUMBER(10)     
R_IMAGE            VARCHAR2(10)   
R_CONTENT NOT NULL VARCHAR2(3000) 
R_WDATE   NOT NULL DATE           
R_RATING  NOT NULL NUMBER(10)     
P_NO      NOT NULL NUMBER(10)     
U_NO               NUMBER(10)     
U_NAME             VARCHAR2(50)   
O_DATE             DATE  
 */
public class Review {

	private int r_no;			//후기 번호
	private String r_image;		//후기 이미지
	private String r_content;	//후기 글
	private Date r_wdate;		//후기 작성일자
	private int r_rating;		//후기 평가
	private Product product;	//상품번호, 상품이름
	private UserInfo userInfo;			//회원번호, 회원이름
	private Orders orders;		//주문일자
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_image, String r_content, Date r_wdate, int r_rating, Product product,
			UserInfo userInfo, Orders orders) {
		super();
		this.r_no = r_no;
		this.r_image = r_image;
		this.r_content = r_content;
		this.r_wdate = r_wdate;
		this.r_rating = r_rating;
		this.product = product;
		this.userInfo = userInfo;
		this.orders = orders;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_image() {
		return r_image;
	}

	public void setR_image(String r_image) {
		this.r_image = r_image;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public Date getR_wdate() {
		return r_wdate;
	}

	public void setR_wdate(Date r_wdate) {
		this.r_wdate = r_wdate;
	}

	public int getR_rating() {
		return r_rating;
	}

	public void setR_rating(int r_rating) {
		this.r_rating = r_rating;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Review [r_no=" + r_no + ", r_image=" + r_image + ", r_content=" + r_content + ", r_wdate=" + r_wdate
				+ ", r_rating=" + r_rating + ", product=" + product + ", userInfo=" + userInfo + ", orders=" + orders
				+ "]";
	}

	

	
	
}
