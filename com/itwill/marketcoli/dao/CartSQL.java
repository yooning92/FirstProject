package com.itwill.marketcoli.dao;


public class CartSQL {

	//SQL 문장을 채워서 사용하세요
	
	public static final String CART_INSERT
								= "insert into cart values(cart_c_no_seq.nextval,?,?,?)";
	
	public static final String CART_UPDATE_QTY
								= "update cart set c_qty=? where c_no=?";
	
	public static final String CART_UPDATE_PRODUCT
								= "update cart set p_no=? where u_no=?";
	
	public static final String CART_DELETE_CART_NO
								= "delete from cart where c_no = ?";

	public static final String CART_DELETE_USER_NO
								= "delete from cart where u_no = ?";
	
	public static final String CART_SELECT_BY_USER_NO 
								= "select * from cart where u_no = ?";
	public static final String CART_SELECT_BY_CART_NO 
								= "select * from cart where c_no = ?";
	
	public static final String CART_SELECT_ALL 
								= "select * from cart";
	
	public static final String CART_SELECT_BY_ALL 
								= "select * from cart where u_no = ?";
}
