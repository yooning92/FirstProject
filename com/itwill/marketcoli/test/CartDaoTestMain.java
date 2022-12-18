package com.itwill.marketcoli.test;

import java.util.ArrayList;
import java.util.List;

import com.itwill.marketcoli.dao.CartDao;
import com.itwill.marketcoli.dto.Cart;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception{
		CartDao CartDao = new CartDao();
		
		System.out.println(">> 카트 담기");
		Cart insertCart = new Cart(1,2,4,10);
		System.out.println(CartDao.insertCart(insertCart));
		
		System.out.println(">> 카트 번호로 카트 삭제");
		System.out.println(CartDao.deleteCartNo(0));
		
		System.out.println(">> 유저 번호로 카트 삭제");
		System.out.println(CartDao.deleteUserNo(1));
		
		System.out.println(">> 카트 번호로 카트에 담긴 상품 수량 변경");
		Cart updateCart1 = new Cart(10,6,0,0);
		System.out.println(CartDao.updateCartQty(updateCart1));

		System.out.println(">> 유저 번호로 카트에 담긴 상품 변경");
		Cart updateCart2 = new Cart(0,0,7,1);
		System.out.println(CartDao.updateCartProduct(updateCart2));
		
		System.out.println(">> 카트 번호로 출력");
		ArrayList<Cart> selectCartByNo = CartDao.selectCartByUserNo(12);
		for (Cart cart : selectCartByNo) {
			System.out.println(cart);
		}
		
		
		System.out.println(">> 카트 전체 출력");
		ArrayList<Cart> cartList = CartDao.selectAll();
		System.out.println(cartList);
		
	}

}