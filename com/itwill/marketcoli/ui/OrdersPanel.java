package com.itwill.marketcoli.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.itwill.marketcoli.dto.OrderItem;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.OrderService;
import com.itwill.marketcoli.service.UserInfoService;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrdersPanel extends JPanel {

	/*********** Frame변수 선언 *************/
	private JFrame marketColiFrame;

	/*********** service 객체 선언 생성 *************/
	private UserInfoService userInfoService = new UserInfoService();
	private OrderService orderService = null;

	private UserInfo orderUserInfo = null;
	private Orders orders = null;
	private OrderItem orderItem = null;

	//private String userId = "itwill3";

	private JTextField orderUserinfoTF;
	private JTextField orderAddressTF;
	private JTextField detailInfoTF;
	private JTextField productListTF;
	private JButton orderBtn;
	private JLabel orderPriceLB;
	private JLabel p_PriceLB;
	private JLabel d_FeeLB;
	private JLabel orderTotalPriceLB;
	private JLabel discount_FeeLB;
	private JTextField userinfoPhoneTF;
	private JLabel orderProductLB;
	private JLabel orderUserinfoLB;
	private JLabel orderAddressLB;
	private JLabel detailInfoLB;
	private JLabel totalPriceLB;
	private JLabel text7;
	private JLabel text9;
	private JLabel text8;
	private JLabel discountPriceLB;
	private JLabel deliveryPriceLB;
	private JLabel orderFinalPriceLB;
	private JLabel paymethodLB;
	private JLabel won5LB;
	private JLabel won4LB;
	private JLabel won3LB;
	private JLabel won2LB;
	private JLabel won1LB;
	private JLabel won6LB;
	private JRadioButton creditcardRdBtn;
	private JRadioButton easypayRdBtn;
	private JRadioButton withrawRdBtn;
	private JRadioButton phonepayRdBtn;
	private JLabel userinfoPhoneLB;
	private JLabel orderNoLB;
	private JTextField orderNoTF;
	private JButton orderNoFindBtn;

	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
		setLayout(null);

		orderProductLB = new JLabel("주 문 상 품");
		orderProductLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		orderProductLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderProductLB.setBounds(38, 44, 88, 15);
		add(orderProductLB);

		orderUserinfoLB = new JLabel("주문자 성함");
		orderUserinfoLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		orderUserinfoLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderUserinfoLB.setBounds(38, 72, 88, 15);
		add(orderUserinfoLB);

		orderAddressLB = new JLabel("배 송 지");
		orderAddressLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		orderAddressLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderAddressLB.setBounds(38, 134, 88, 15);
		add(orderAddressLB);

		orderUserinfoTF = new JTextField();
		orderUserinfoTF.setBounds(138, 69, 171, 21);
		add(orderUserinfoTF);
		orderUserinfoTF.setColumns(10);

		orderAddressTF = new JTextField();
		orderAddressTF.setBounds(138, 131, 171, 21);
		add(orderAddressTF);
		orderAddressTF.setColumns(10);

		detailInfoTF = new JTextField();
		detailInfoTF.setBounds(138, 162, 171, 21);
		add(detailInfoTF);
		detailInfoTF.setColumns(10);

		detailInfoLB = new JLabel("상세 정보 입력");
		detailInfoLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		detailInfoLB.setHorizontalAlignment(SwingConstants.CENTER);
		detailInfoLB.setBounds(38, 165, 88, 15);
		add(detailInfoLB);

		productListTF = new JTextField();
		productListTF.setForeground(new Color(0, 0, 0));
		productListTF.setBounds(138, 41, 171, 21);
		add(productListTF);
		productListTF.setColumns(10);

		orderBtn = new JButton("주  문  하  기");
		orderBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		orderBtn.setBackground(new Color(147, 112, 219));
		orderBtn.setBounds(38, 509, 310, 31);
		add(orderBtn);

		totalPriceLB = new JLabel("최종 결제 금액");
		totalPriceLB.setFont(new Font("Dialog", Font.BOLD, 15));
		totalPriceLB.setBounds(58, 459, 111, 23);
		add(totalPriceLB);

		text7 = new JLabel("결 제 금 액");
		text7.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		text7.setHorizontalAlignment(SwingConstants.CENTER);
		text7.setBounds(38, 319, 88, 15);
		add(text7);

		text9 = new JLabel("┖ 상품금액");
		text9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		text9.setBounds(58, 368, 79, 15);
		add(text9);

		text8 = new JLabel("주 문 금 액");
		text8.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		text8.setHorizontalAlignment(SwingConstants.CENTER);
		text8.setBounds(38, 343, 88, 15);
		add(text8);

		discountPriceLB = new JLabel("┖ 할인금액");
		discountPriceLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		discountPriceLB.setBounds(58, 393, 79, 15);
		add(discountPriceLB);

		deliveryPriceLB = new JLabel("배  송  비");
		deliveryPriceLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		deliveryPriceLB.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryPriceLB.setBounds(38, 418, 88, 15);
		add(deliveryPriceLB);

		orderFinalPriceLB = new JLabel();
		orderFinalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderFinalPriceLB.setBounds(222, 320, 57, 15);
		add(orderFinalPriceLB);

		orderPriceLB = new JLabel();
		orderPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderPriceLB.setBounds(222, 345, 57, 15);
		add(orderPriceLB);

		p_PriceLB = new JLabel();
		p_PriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		p_PriceLB.setBounds(222, 370, 57, 15);
		add(p_PriceLB);

		discount_FeeLB = new JLabel();
		discount_FeeLB.setHorizontalAlignment(SwingConstants.RIGHT);
		discount_FeeLB.setBounds(222, 395, 57, 15);
		add(discount_FeeLB);

		d_FeeLB = new JLabel();
		d_FeeLB.setHorizontalAlignment(SwingConstants.RIGHT);
		d_FeeLB.setBounds(222, 420, 57, 15);
		add(d_FeeLB);

		paymethodLB = new JLabel("결 제 수 단");
		paymethodLB.setHorizontalAlignment(SwingConstants.CENTER);
		paymethodLB.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		paymethodLB.setBounds(38, 204, 88, 15);
		add(paymethodLB);

		won5LB = new JLabel("원");
		won5LB.setBounds(291, 420, 57, 15);
		add(won5LB);

		won4LB = new JLabel("원");
		won4LB.setBounds(291, 395, 57, 15);
		add(won4LB);

		won3LB = new JLabel("원");
		won3LB.setBounds(291, 370, 57, 15);
		add(won3LB);

		won2LB = new JLabel("원");
		won2LB.setBounds(291, 345, 57, 15);
		add(won2LB);

		won1LB = new JLabel("원");
		won1LB.setBounds(291, 320, 57, 15);
		add(won1LB);

		won6LB = new JLabel("원");
		won6LB.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		won6LB.setHorizontalAlignment(SwingConstants.LEFT);
		won6LB.setBounds(291, 458, 57, 24);
		add(won6LB);

		orderTotalPriceLB = new JLabel();
		orderTotalPriceLB.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		orderTotalPriceLB.setHorizontalAlignment(SwingConstants.RIGHT);
		orderTotalPriceLB.setBounds(222, 460, 57, 21);
		add(orderTotalPriceLB);

		creditcardRdBtn = new JRadioButton("신용 카드");
		creditcardRdBtn.setBounds(56, 241, 93, 23);
		add(creditcardRdBtn);

		easypayRdBtn = new JRadioButton("간편 결제");
		easypayRdBtn.setBounds(56, 266, 93, 23);
		add(easypayRdBtn);

		withrawRdBtn = new JRadioButton("계좌 이체");
		withrawRdBtn.setBounds(216, 241, 93, 23);
		add(withrawRdBtn);

		phonepayRdBtn = new JRadioButton("휴대폰 결제");
		phonepayRdBtn.setBounds(216, 266, 93, 23);
		add(phonepayRdBtn);

		userinfoPhoneTF = new JTextField();
		userinfoPhoneTF.setBounds(138, 100, 171, 21);
		add(userinfoPhoneTF);
		userinfoPhoneTF.setColumns(10);

		userinfoPhoneLB = new JLabel("휴대폰 번호");
		userinfoPhoneLB.setHorizontalAlignment(SwingConstants.CENTER);
		userinfoPhoneLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		userinfoPhoneLB.setBounds(38, 101, 88, 15);
		add(userinfoPhoneLB);

		orderNoLB = new JLabel("주 문 번 호");
		orderNoLB.setHorizontalAlignment(SwingConstants.CENTER);
		orderNoLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		orderNoLB.setBounds(38, 11, 88, 15);
		add(orderNoLB);

		orderNoTF = new JTextField();
		orderNoTF.setBounds(138, 10, 88, 21);
		add(orderNoTF);
		orderNoTF.setColumns(10);

		orderNoFindBtn = new JButton("조회");
		orderNoFindBtn.setBounds(243, 9, 66, 23);
		add(orderNoFindBtn);

		/*
		int orderItemNo = 5;
				try {
					orderService = new OrderService();
		
					//orderItemNo = Integer.parseInt(orderNoTF.getText());
		
					orderItem = orderService.selectOrderItemByOiNo(orderItemNo);
		
					orders = orderService.findOrdersByO_No(orderItem.getOi_no());
		
					String id = orders.getUserInfo().getU_id();
		
					orderUserInfo = userInfoService.selectById(id);
					String name = orderUserInfo.getU_name();
					String phone = orderUserInfo.getU_phone();
					String address = orderUserInfo.getU_address();
		
					orderUserinfoTF.setText(name);
					orderAddressTF.setText(address);
					userinfoPhoneTF.setText(phone);
		
					//ArrayList<Orders> ordersList = orderService.selectOrderListbyUserId(id);
		
					productListTF.setText(orderItem.getProduct().getP_name() + " " + orderItem.getOi_qty() + " 개");
					orderFinalPriceLB.setText(orders.getO_price() + 3000 + "");
					orderPriceLB.setText(orders.getO_price() + "");
					p_PriceLB.setText(orders.getO_price() + "");
					discount_FeeLB.setText("0");
					d_FeeLB.setText("3000");
					orderTotalPriceLB.setText(orders.getO_price() + 3000 + "");
		
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				orderNoFindBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						*//********* 주문번호로 조회 ***********//*
															int orderNo = Integer.parseInt(orderNoTF.getText());
															System.out.println(orderNo);
															}
															});
															*/
		
		
	}//생성자 끝
}//클래스 끝