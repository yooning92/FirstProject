package com.itwill.marketcoli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.marketcoli.common.DataSource;
import com.itwill.marketcoli.dto.OrderItem;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.dto.UserInfo;

public class OrdersDao {
	private DataSource dataSource;

	public OrdersDao() {
		dataSource = new DataSource();
	}

	public int insertOrders(Orders orders) throws Exception {

		/*
		private int o_no;			//주문번호
		private Date o_date;		//주문일시
		private int o_price;		//주문 총가격 total_price
		private UserInfo userInfo;
		
		private ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		*/
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(OrdersSQL.ORDERS_INSERT);
		/*
		public static final sString ORDERS_INSERT
				= "insert into orders(o_no, o_date, o_price, u_id) values (orders_o_no_SEQ.nextval,sysdate, ?, ?)";
		public static final String ORDERITEM_INSERT
			= "insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, ? ,orders_o_no_SEQ.currval, ?)";
				*/

		pstmt1.setInt(1, orders.getO_price());
		pstmt1.setString(2, orders.getUserInfo().getU_id());
		int rowCount1 = pstmt1.executeUpdate();

		int rowCount2 = 0;
		int rowCount2Sum = 0;
		PreparedStatement pstmt2 = con.prepareStatement(OrdersSQL.ORDERITEM_INSERT);

		for (OrderItem orderItem : orders.getOrderItemList()) {

			// pstmt2.setInt(1, orderItem.getO_no());
			pstmt2.setInt(1, orderItem.getOi_qty());
			pstmt2.setInt(2, orderItem.getProduct().getP_no());
			rowCount2 = pstmt2.executeUpdate();
			rowCount2Sum++;
		}

		pstmt1.close();
		pstmt2.close();
		con.close();

		return rowCount1 * rowCount2Sum; // 둘중에 하나라도 안되면 0이므로 곱한다.

	}
	
	//주문번호를 통해 주문내역 전체삭제
	public int deleteOrdersByOrderNo(int o_no) throws Exception { // pk를 통해 삭제

		//delete from orders where o_no=?

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrdersSQL.ORDERS_DELETE_BY_ORDER_NO);

		pstmt.setInt(1, o_no);

		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close(); 

		return rowCount;
	}
	
	
	//주문번호를 통해 주문내역 전체삭제
	public int deleteOrdersByUserId(String u_id) throws Exception { // pk를 통해 삭제

		//delete from orders where u_id=?

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrdersSQL.ORDERS_DELETE_BY_USER_ID);

		pstmt.setString(1, u_id);

		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return rowCount;
	}
	
	//주문내역 화면에서, 주문아이템 수량변경 ----- 작성중, 일단은 매개변수로
	public int updateOrderItemQty(int oi_qty, int oi_no) throws Exception {

		// update order_item set oi_qty = ? where oi_no= ?"

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrdersSQL.ORDERS_UPDATE_BY_ORDER_ITEM_NO);

		pstmt.setInt(1, oi_qty);
		pstmt.setInt(2, oi_no);

		int rowCount = pstmt.executeUpdate();
		// System.out.println(rowCount+" 행 update.. ");

		pstmt.close();
		con.close();

		return rowCount;
	}
	
	
	
	
	
	

	/****************************************************************/
	// 주문 전체 출력
	public ArrayList<Orders> selectAll() throws Exception {
		ArrayList<Orders> orderslist = new ArrayList<Orders>();
		String selectAll = "select * from orders o join userinfo u on o.u_id = u.u_id";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectAll);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			orderslist.add(new Orders(rs.getInt("O_no"),
										rs.getDate("O_date"),
										rs.getInt("O_PRICE"),
										new UserInfo(0, rs.getString("u_id"), null, null, null, null, null, 0, null, null),
										null));
										/*new UserInfo(), -> UserInfo..에서 get할 값이 없다면, 생성하지 않고null로 해도 될거같은데요?*/
					                               
		}
		rs.close();
		pstmt.close();
		con.close();
		return orderslist;
		
		
		
	}

	// 유저 id를 이용한 주문내역 전체검색
	public Orders findOrders(String u_id) throws Exception {
		Orders findOrders = null;
		String selectOrders = "select * from orders o join userinfo u on o.u_id = u.u_id where o.u_id =?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectOrders);
		pstmt.setString(1, u_id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			findOrders = new Orders(rs.getInt("o_no"),
									rs.getDate("O_date"),
									rs.getInt("O_PRICE"),
									new UserInfo(0, rs.getString("u_id"), null, null, null, null, null, 0, null, null),
									/*new UserInfo(), -> UserInfo..에서 get할 값이 없다면, 생성하지 않고null로 해도 될거같은데요?*/
									null);
		}
		rs.close();
		pstmt.close();
		con.close();
		return findOrders;
	}
	
	
	
	//주문번호를 이용한 주문 상품 수량 변경
	public int updateOrderItemByO_no(int OI_QTY, int P_NO, int O_no) throws Exception {
		String updateOrderitem =" update order_item set OI_QTY = ?  where  P_NO =? and O_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateOrderitem);
		pstmt.setInt(1, OI_QTY);
		pstmt.setInt(2, P_NO);
		pstmt.setInt(3, O_no);
		int rowCount = pstmt.executeUpdate();
		return rowCount;
	}
	
	
	
	public OrderItem findOrderItemByOi_No(int oi_no)throws Exception{
		OrderItem findOrders = null;
		String selectOrderItem =" select * from order_item oi join product p on oi.p_no = p.p_no where oi_no = ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectOrderItem);
		pstmt.setInt(1, oi_no);
		ResultSet rs =pstmt.executeQuery();
		if(rs.next()) {
			findOrders= new OrderItem(0, 0, rs.getInt("o_no"),
						new Product(0, rs.getString("p_name"), rs.getInt("p_price"), null, null, null));
		}
		return findOrders;
		
	}
	
	public Orders findOrdersByO_No(int o_no)throws Exception{
		Orders findOrders = null;
		String selectOrderItem =" select * from orders where o_no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectOrderItem);
		pstmt.setInt(1, o_no);
		ResultSet rs =pstmt.executeQuery();
		if(rs.next()) {
			findOrders= new Orders(rs.getInt("o_no"),
					rs.getDate("O_date"),
					rs.getInt("O_PRICE"),
					new UserInfo(0, rs.getString("u_id"), null, null, null, null, null, 0, null, null),
					null);
		}
		return findOrders;
		
	}
	
	
}
