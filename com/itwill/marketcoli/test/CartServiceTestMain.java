package com.itwill.marketcoli.test;

import com.itwill.marketcoli.service.CartService;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception {
		CartService cartService = new CartService();
		int rowCount;
		
		System.out.println("1. add Cart");
		rowCount = cartService.addCart(88,8,7);
		System.out.println(">> " + rowCount);
		
		System.out .println("2-1. update Cart_Qty < Cart_No");
		rowCount =cartService.updateCartQty(99999, 7);
		System.out.println(">> " + rowCount);
		
		System.out.println("2-2. update Cart_Product < User_No");
		rowCount = cartService.updateCartProduct(5, 13);
		System.out.println(">> " + rowCount);
		
		System.out.println("3-1. delete Cart_No");
		rowCount = cartService.deleteCartNo(49); 
		System.out.println(">> " + rowCount);
		
		System.out.println("3-2. delete Cart_User_No");
		rowCount = cartService.deleteUserNo(7);
		System.out.println(">> " + rowCount);
		
		System.out.println("4-1. getCartNo");
		System.out.println(cartService.getCartNo(7));
		
		System.out.println("4-2 getCartList");
		System.out.println(cartService.getCartList(7));
	}

}
