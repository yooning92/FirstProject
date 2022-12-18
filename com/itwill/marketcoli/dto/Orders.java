package com.itwill.marketcoli.dto;
/*
 이름      널?       유형            
------- -------- ------------- 
O_NO    NOT NULL NUMBER(10)    
O_DATE           DATE          
O_PRICE          NUMBER(10)    
U_ID           VARCHAR2(100)
 */

import java.util.ArrayList;
import java.util.Date;

public class Orders {
	private int o_no; // 주문번호
	private Date o_date; // 주문일시
	private int o_price; // 주문 총가격 total_price
	private UserInfo userInfo; // u_no 또는 u_id를 얻기 위함

	private ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>(); // OrderItem을 담아야함. rentBook을 생각하자

	/*	<<UserInfo>>
	 	private int u_no;			//회원번호
		private String u_id;		//아이디
		private String u_pw;		//비밀번호
		private String u_name;		//이름
		private String u_email;		//이메일
		private String u_phone;		//휴대폰번호
		private String u_address;	//주소
		private int u_birth;		//생년월일
		private String u_job;		//직업
		private Date u_joindate;	//java.util.Date
	*/
	public Orders() {
	}

	public Orders(int o_no, Date o_date, int o_price, UserInfo userInfo, ArrayList<OrderItem> orderItemList) {
		super();
		this.o_no = o_no;
		this.o_date = o_date;
		this.o_price = o_price;
		this.userInfo = userInfo;
		this.orderItemList = orderItemList;
	}

	public int getO_no() {
		return o_no;
	}

	public void setO_no(int o_no) {
		this.o_no = o_no;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getO_price() {
		return o_price;
	}

	public void setO_price(int o_price) {
		this.o_price = o_price;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	@Override
	public String toString() {
		return "Orders [o_no=" + o_no + ", o_date=" + o_date + ", o_price=" + o_price + ", userInfo=" + userInfo
				+ ", orderItemList=" + orderItemList + "]";
	}

}