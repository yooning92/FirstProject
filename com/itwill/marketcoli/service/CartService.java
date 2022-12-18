package com.itwill.marketcoli.service;

import java.util.ArrayList;

import com.itwill.marketcoli.dao.CartDao;
import com.itwill.marketcoli.dto.Cart;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception {
		cartDao = new CartDao();
	}
	
	public int addCart(int c_qty, int p_no, int u_no) throws Exception {
		return cartDao.insertCart(c_qty, p_no, u_no);
	}
	
	public int updateCartQty(int c_qty, int c_no) throws Exception {
		return cartDao.updateCartQty(c_qty, c_no);
	}
	
	public int updateCartProduct(int p_no, int u_no) throws Exception {
		return cartDao.updateCartProduct(p_no, u_no);
	}
	
	public int deleteCartNo(int c_no) throws Exception {
		return cartDao.deleteCartNo(c_no);
	}
	
	public int deleteUserNo(int u_no) throws Exception {
		return cartDao.deleteUserNo(u_no);
	}
	
	public Cart getCartNo(int c_no) throws Exception {
		return cartDao.selectCartByCartNo(c_no);
	}
	
	public ArrayList<Cart> getCartList(int c_no) throws Exception {
		return cartDao.selectAll(c_no);
	}
	
	
}
