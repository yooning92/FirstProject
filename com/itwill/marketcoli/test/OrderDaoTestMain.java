package com.itwill.marketcoli.test;

import java.util.ArrayList;
import java.util.List;

import com.itwill.marketcoli.dao.OrdersDao;
import com.itwill.marketcoli.dao.ProductDao;
import com.itwill.marketcoli.dto.OrderItem;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.dto.UserInfo;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception {

		OrdersDao ordersDao = new OrdersDao();

		/*
		insert into orders(o_no,o_date,o_price,u_id) values (orders_o_no_SEQ.nextval,sysdate,10500,'itwill7');
		insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
		*/

		System.out.println("1-1.insertOrders - 상품1개");
		//1. 1가지 상품 주문 넣기
		ProductDao selectProduct = new ProductDao();
		Product product = selectProduct.selectByNo(12);
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList.add(new OrderItem(0, 2, 0, product));
		// System.out.println(orderItemList.get(0).getOi_qty());
		Orders insertOrder = new Orders(0, null, product.getP_price() * orderItemList.get(0).getOi_qty(),
				new UserInfo(0, "itwill4", null, null, null, null, null, 0, null, null), orderItemList);

		// (확인 완료)order_item 테이블 - insert order_item이 안되는 상태 -> excuteQuery가 주석처리
		// 되어있었음...
		System.out.println(ordersDao.insertOrders(insertOrder));

		System.out.println("1-2.insertOrders - 상품 여러개");
		// 2. 2가지 상품 주문 넣기
		selectProduct = new ProductDao();
		orderItemList = new ArrayList<OrderItem>();
		
		
		//총가격 계산		-> (확인 필요)메소드로 넣는 작업, SQL문을 추가하여 작업
		int totalPrice = 0;

		ArrayList<Product> productList = new ArrayList<Product>();

		product = selectProduct.selectByNo(13);
		productList.add(product);
		orderItemList.add(new OrderItem(0, 2, 0, product));
		
		product = selectProduct.selectByNo(14);
		productList.add(product);
		
		orderItemList.add(new OrderItem(0, 5, 0, product));
		// System.out.println(orderItemList.get(0).getOi_qty());
		
		for (int i = 0; i < orderItemList.size(); i++) {
			totalPrice += orderItemList.get(i).getOi_qty()*productList.get(i).getP_price();
		}
		
		insertOrder = new Orders(0, null, totalPrice,
				new UserInfo(0, "itwill5", null, null, null, null, null, 0, null, null), orderItemList);

		// (확인 완료)order_item 테이블 - insert order_item이 안되는 상태 -> excuteQuery가 주석처리
		System.out.println(ordersDao.insertOrders(insertOrder));

		
		System.out.println("2-1.deleteOrdersByOrderNo - 주문내역 번호로 주문전체 삭제");
		System.out.println(ordersDao.deleteOrdersByOrderNo(76));
		
		System.out.println("2-2.deleteOrdersByUserId - 아이디로 주문전체 삭제");
		System.out.println(ordersDao.deleteOrdersByUserId("itwill6"));
		
		System.out.println("3.ORDERS_UPDATE_BY_ORDER_iTEM_NO - 주문아이템 수량변경");
		System.out.println(ordersDao.updateOrderItemQty(3,74));
		/*		
				System.out.println("4.SelectOrderItemByOrderNo - 아이디, 주문번호로 주문목록 조회");
				List<Orders> orderItemList2 = new ArrayList<Orders>();
						orderItemList2.add(ordersDao.selectOrderItemByOrderNo("itwill5", 73));
						
						for (Orders orders : orderItemList2) {
							System.out.println(orders);
						}
				*/
		
	    /**************************************************************/
		System.out.println("1. 주문 전체 검색");
		List<Orders>orderList = ordersDao.selectAll();
		for (Orders orders : orderList) {
			System.out.println(orders);
		}
		
		System.out.println("2. U_id를 이용한 주문검색");
		Orders findOrders = ordersDao.findOrders("itwill5");
		System.out.println(findOrders);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}