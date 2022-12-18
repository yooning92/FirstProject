package com.itwill.marketcoli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.marketcoli.common.DataSource;
import com.itwill.marketcoli.dto.Cart;

public class CartDao {
	private DataSource dataSource;

	public CartDao() {
		dataSource = new DataSource();
	}

	public int insertCart(Cart cart) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);

		pstmt.setInt(1, cart.getC_qty());
		pstmt.setInt(2, cart.getP_no());
		pstmt.setInt(3, cart.getU_no());

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	/*
	 * 카트 담기
	 */
	public int insertCart(int c_qty, int p_no, int u_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_INSERT);

		pstmt.setInt(1, c_qty);
		pstmt.setInt(2, p_no);
		pstmt.setInt(3, u_no);

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	/*
	 * 카트 번호로 카트 삭제
	 */
	public int deleteCartNo(int c_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_CART_NO);

		pstmt.setInt(1, c_no);

		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return rowCount;
	} 
	
	/*
	 * 유저 번호로 카트 삭제
	 */
	public int deleteUserNo(int u_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_DELETE_USER_NO);
		
		pstmt.setInt(1, u_no);
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	} 

	public int updateCartQty(Cart cart) throws Exception {
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_QTY);
		
		pstmt.setInt(1, cart.getC_qty());
		pstmt.setInt(2, cart.getC_no());


		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return rowCount;
	}
	/*
	 * 카트 번호로 카트 수량 업데이트
	 */
	public int updateCartQty(int c_qty, int c_no) throws Exception {
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_QTY);
		
		pstmt.setInt(1, c_qty);
		pstmt.setInt(2, c_no);


		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return rowCount;
	}
	
	public int updateCartProduct(Cart cart) throws Exception {
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_PRODUCT);
		
		pstmt.setInt(1, cart.getP_no());
		pstmt.setInt(2, cart.getU_no());
		
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	/*
	 * 유저 번호로 상품 변경
	 */
	public int updateCartProduct(int p_no, int u_no) throws Exception {
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_UPDATE_PRODUCT);
		
		pstmt.setInt(1, p_no);
		pstmt.setInt(2, u_no);
		
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	
	public ArrayList<Cart> selectCartByUserNo(int u_no) throws Exception {
		Cart findCart = null;
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_USER_NO);
		pstmt.setInt(1, u_no);
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			cartList.add(new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getInt("p_no"),
									rs.getInt("u_no")));

		}
		rs.close();
		pstmt.close();
		con.close();
		
		rs.close();
		pstmt.close();
		con.close();
		return cartList;
	}
	
	public Cart selectCartByCartNo(int c_no) throws Exception {
		Cart findCart = null;
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
		pstmt.setInt(1, c_no);
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {

			findCart=new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getInt("p_no"),
									rs.getInt("u_no"));

		}
		rs.close();
		pstmt.close();
		con.close();
		return findCart;
	}

	public ArrayList<Cart> selectAll() throws Exception {
		//String selectAllSql = "select * from user";
		ArrayList<Cart> cartList = new ArrayList<Cart>();

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			cartList.add(new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getInt("p_no"),
									rs.getInt("u_no")));

		}
		rs.close();
		pstmt.close();
		con.close();

		return cartList;
	}
	
	public ArrayList<Cart> selectAll(int c_no) throws Exception {
		//String selectAllSql = "select * from user";
		ArrayList<Cart> cartList = new ArrayList<Cart>();

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_ALL);
		pstmt.setInt(1, c_no);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			cartList.add(new Cart(rs.getInt("c_no"),
									rs.getInt("c_qty"),
									rs.getInt("p_no"),
									rs.getInt("u_no")));

		}
		rs.close();
		pstmt.close();
		con.close();

		return cartList;
	}
	
}