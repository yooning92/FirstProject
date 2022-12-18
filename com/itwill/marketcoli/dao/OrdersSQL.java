package com.itwill.marketcoli.dao;

public class OrdersSQL {

	// SQL 문장을 채워서 사용하세요

	public static final String ORDERS_INSERT = "insert into orders(o_no, o_date, o_price, u_id) values (orders_o_no_SEQ.nextval,sysdate, ?, ?)";
	public static final String ORDERITEM_INSERT
	//= "insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, ? ,?, ?)";
			= "insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, ? ,orders_o_no_SEQ.currval, ?)";
	/*
	insert into orders(o_no,o_date,o_price,u_id) values (orders_o_no_SEQ.nextval,sysdate,10500,'itwill7');
	insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,1,orders_o_no_SEQ.currval,3);
	*/
	
	//주문번호를 통해 주문내역 전체삭제
	public static final String ORDERS_DELETE_BY_ORDER_NO = "delete from orders where o_no=?";

	//아이디를 통해 주문내역 전체삭제
	public static final String ORDERS_DELETE_BY_USER_ID = "delete from orders where u_id=?";

	//주문내역 화면에서, 주문아이템 수량변경
	public static final String ORDERS_UPDATE_BY_ORDER_ITEM_NO = "update order_item set oi_qty = ? where oi_no = ?";

	public static final String ORDERS_SELECT_BY_ORDER_ITEM_NO 
	= "select * from orders o"
			+ "join order_item oi on o.o_no=oi.o_no"
			+ "join  product p on oi.p_no=p.p_no"
			+ "where o.u_id=? and o.o_no = ?";

	public static final String ORDERS_SELECT_BY_NO = "select * from orders where u_no = ?";

	// 주문 전체 출력 - 관리자
	public static final String ORDERS_SELECT_ALL = "select * from orders";

	// 유저 id를 이용한 주문내역 전체검색
	public static final String ORDERS_SELECT_BY_USERID = "select * from orders where u_id ";
}
