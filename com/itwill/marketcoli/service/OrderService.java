package com.itwill.marketcoli.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.marketcoli.dao.CartDao;
import com.itwill.marketcoli.dao.OrdersDao;
import com.itwill.marketcoli.dao.ProductDao;
import com.itwill.marketcoli.dao.UserInfoDao;
import com.itwill.marketcoli.dto.Cart;
import com.itwill.marketcoli.dto.OrderItem;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.dto.UserInfo;

public class OrderService {
	private OrdersDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	private UserInfoDao userInfoDao;

	public OrderService() throws Exception {
		orderDao = new OrdersDao();
		productDao = new ProductDao();
		cartDao = new CartDao();
	}


	// 주문 1개 전체 삭제
	public int deleteOrderAllByOrderNo(int o_no) throws Exception {
		return orderDao.deleteOrdersByOrderNo(o_no);
	}

	// 유저아이디가 주문한 주문 전체삭제(u_id)
	public int deleteOrderByUserId(String u_id) throws Exception  {
		return orderDao.deleteOrdersByUserId(u_id);
	}

	// 주문 넣기
	public int insertOrderOne(int p_no, int o_qty, String u_id) throws Exception {
		ProductDao selectProduct = new ProductDao();
		Product product = selectProduct.selectByNo(p_no);
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList.add(new OrderItem(0, o_qty, 0, product));

		Orders insertOrder = new Orders(0, null, product.getP_price() * orderItemList.get(0).getOi_qty(),
				new UserInfo(0, u_id, null, null, null, null, null, 0, null, null), orderItemList);
		return orderDao.insertOrders(insertOrder);
	}

	// 주문을 넣은 상태에서, 추가하는 경우를 하고 싶었으나,
	// 동시에 2개를 주문을 넣는 경우
	public int addOrders(int p1_no, int o1_qty, int p2_no, int o2_qty, String u_id) throws Exception {
		ProductDao selectProduct = new ProductDao();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();

		// 총가격 계산 -> (확인 필요)메소드로 넣는 작업, SQL문을 추가하여 작업
		int totalPrice = 0;

		ArrayList<Product> productList = new ArrayList<Product>();

		Product product = selectProduct.selectByNo(p1_no);
		productList.add(product);
		orderItemList.add(new OrderItem(0, o1_qty, 0, product));

		product = selectProduct.selectByNo(p2_no);
		productList.add(product);

		orderItemList.add(new OrderItem(0, o2_qty, 0, product));

		for (int i = 0; i < orderItemList.size(); i++) {
			totalPrice += orderItemList.get(i).getOi_qty() * productList.get(i).getP_price();
		}

		Orders insertOrder = new Orders(0, null, totalPrice,
				new UserInfo(0, u_id, null, null, null, null, null, 0, null, null), orderItemList);

		// (확인 완료)order_item 테이블 - insert order_item이 안되는 상태 -> excuteQuery가 주석처리
		return orderDao.insertOrders(insertOrder);

	}

	// cart에서 주문 -> cart에서 Order로 옮겨닮기 -- 실행이 안되는 중
	public Orders cartToOrders(int u_no) throws Exception {
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();

		int oi_total_qty = 0;
		int o_total_price = 0;

		cartList = cartDao.selectCartByUserNo(u_no);
		for (Cart cart : cartList) {
			Product product = productDao.selectByNo(cart.getP_no());
			
			oi_total_qty = cart.getC_qty();
			o_total_price += oi_total_qty * product.getP_price();
			
			OrderItem orderItem = new OrderItem(0, oi_total_qty, 0, product);
			orderItemList.add(orderItem);
		}
		Orders cartToOrders = new Orders(0, null, o_total_price, userInfoDao.selectByNo(u_no), orderItemList);
		orderDao.insertOrders(cartToOrders);
		cartDao.deleteUserNo(u_no);

		return cartToOrders;
	}
	
	public ArrayList<Orders> selectOrderListbyUserId(String u_id) throws Exception{
		ArrayList<Orders> orderListAll = orderDao.selectAll();
		ArrayList<Orders> orderListByUserId = new ArrayList<Orders>();
		
		for (Orders orders : orderListAll) {
			if(orders.getUserInfo().getU_id().equals(u_id)) {
				orderListByUserId.add(orders);
			}
		}
		
		return orderListByUserId;
	}
	
	
	//주문내역 수량 변경
	public int updateOrderItemQty(int oi_qty, int oi_no) throws Exception {
		return orderDao.updateOrderItemQty(oi_qty, oi_no);
	}
	
	//주문번호 를 이용한 주문내역 전체 검색
	public OrderItem selectOrderItemByOiNo(int o_no)throws Exception {
		return orderDao.findOrderItemByOi_No(o_no);
		
	}
	
	public Orders findOrdersByO_No(int o_no) throws Exception {
		return orderDao.findOrdersByO_No(o_no);
	}

	
	
	
}