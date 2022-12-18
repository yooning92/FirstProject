package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.itwill.marketcoli.dao.UserInfoDao;
import com.itwill.marketcoli.dto.OrderItem;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.OrderService;
import com.itwill.marketcoli.service.UserInfoService;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MyPage extends JPanel {
	
	/***********Frame변수 선언*************/
	private JFrame marketColiFrame;
	
	/********** 1.Service객체선언 *******/
	private OrderService orderService;
	private UserInfoService userInfoService;
	
	private UserInfo updateUserInfo;

	private JTextField idField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JTextField birthField;
	private JTextField jobField;
	private JPanel orderDataPanel;
	private JTextField userNoField;
	private JPasswordField nowPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField newPasswordReField;
	private JTextField addressField;
	private JLabel lblNewLabel;
	private JLabel idLabel;
	private JLabel nowPwLabel;
	private JLabel newPwLabel;
	private JLabel newPwReLabel;
	private JLabel nameLabel;
	private JLabel emailLabel;
	private JLabel phoneLabel;
	private JLabel birthLabel;
	private JLabel jobLabel;
	private JButton dataChangeButton;
	private JButton dataDeleteButton;
	private JLabel userNoLabel;
	private JLabel addressLabel;

	public MyPage() {
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(5, 800));
		add(tabbedPane, BorderLayout.CENTER);

		changeUserDataPanel = new JPanel();
		changeUserDataPanel.setPreferredSize(new Dimension(10, 800));
		tabbedPane.addTab("\uAC1C\uC778\uC815\uBCF4\uC218\uC815", null, changeUserDataPanel, null);
		changeUserDataPanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(400, 800));
		changeUserDataPanel.add(scrollPane, BorderLayout.CENTER);

		changeUserDataPanel2 = new JPanel();
		changeUserDataPanel2.setPreferredSize(new Dimension(10, 800));
		scrollPane.setViewportView(changeUserDataPanel2);
		changeUserDataPanel2.setLayout(null);

		lblNewLabel = new JLabel("\uAC1C\uC778\uC815\uBCF4\uC218\uC815");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(129, 37, 164, 46);
		changeUserDataPanel2.add(lblNewLabel);

		idField = new JTextField();
		idField.setBounds(58, 169, 315, 21);
		changeUserDataPanel2.add(idField);
		idField.setColumns(10);

		idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBounds(58, 146, 57, 15);
		changeUserDataPanel2.add(idLabel);

		nowPwLabel = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638");
		nowPwLabel.setBounds(58, 211, 121, 15);
		changeUserDataPanel2.add(nowPwLabel);

		newPwLabel = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638");
		newPwLabel.setBounds(58, 275, 121, 15);
		changeUserDataPanel2.add(newPwLabel);

		newPwReLabel = new JLabel("\uC0C8 \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		newPwReLabel.setBounds(58, 340, 108, 15);
		changeUserDataPanel2.add(newPwReLabel);

		nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(58, 406, 57, 15);
		changeUserDataPanel2.add(nameLabel);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(58, 429, 315, 21);
		changeUserDataPanel2.add(nameField);

		emailLabel = new JLabel("\uC774\uBA54\uC77C");
		emailLabel.setBounds(58, 471, 57, 15);
		changeUserDataPanel2.add(emailLabel);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(58, 494, 315, 21);
		changeUserDataPanel2.add(emailField);

		phoneLabel = new JLabel("\uD578\uB4DC\uD3F0 \uBC88\uD638");
		phoneLabel.setBounds(58, 535, 108, 15);
		changeUserDataPanel2.add(phoneLabel);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(58, 558, 315, 21);
		changeUserDataPanel2.add(phoneField);

		birthLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		birthLabel.setBounds(58, 600, 57, 15);
		changeUserDataPanel2.add(birthLabel);

		birthField = new JTextField();
		birthField.setColumns(10);
		birthField.setBounds(58, 623, 315, 21);
		changeUserDataPanel2.add(birthField);

		jobLabel = new JLabel("\uC9C1\uC5C5");
		jobLabel.setBounds(58, 727, 57, 15);
		changeUserDataPanel2.add(jobLabel);

		jobField = new JTextField();
		jobField.setColumns(10);
		jobField.setBounds(58, 750, 315, 21);
		changeUserDataPanel2.add(jobField);

		dataChangeButton = new JButton("\uC218\uC815\uD558\uAE30");

		// 수정하기
		dataChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UserInfo updateUserInfo = new UserInfo(Integer.parseInt(userNoField.getText()), idField.getText(),
							newPasswordField.getText(), nameField.getText(), emailField.getText(), phoneField.getText(),
							addressField.getText(), Integer.parseInt(birthField.getText()), jobField.getText(), null);
					userInfoService.updateUserInfo(updateUserInfo);

				} catch (Exception e1) {

				}
			}

		});

		dataChangeButton.setBounds(58, 797, 137, 38);
		changeUserDataPanel2.add(dataChangeButton);

		// 탈퇴하기
		dataDeleteButton = new JButton("탈퇴하기");
		dataDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String u_no = userNoField.getText();
					userInfoService.deleteUserInfo(Integer.parseInt(u_no));

					// 비밀번호 입력 정보 초기화
					idField.setVisible(true);
					userNoField.setVisible(true);

					nowPasswordField.setText("");
					newPasswordField.setText("");
					newPasswordReField.setText("");

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		dataDeleteButton.setBounds(236, 797, 137, 38);
		changeUserDataPanel2.add(dataDeleteButton);

		userNoLabel = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		userNoLabel.setBounds(58, 92, 57, 15);
		changeUserDataPanel2.add(userNoLabel);

		userNoField = new JTextField();
		userNoField.setColumns(10);
		userNoField.setBounds(58, 115, 315, 21);
		changeUserDataPanel2.add(userNoField);
		UserInfo userInfo = new UserInfo();

		// userInfo = userInfoService.selectById("itwill1");
		// userNoField.setText(userInfo.getU_id());

		nowPasswordField = new JPasswordField();
		nowPasswordField.setBounds(58, 236, 315, 21);
		changeUserDataPanel2.add(nowPasswordField);

		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(58, 297, 315, 21);
		changeUserDataPanel2.add(newPasswordField);

		newPasswordReField = new JPasswordField();
		newPasswordReField.setBounds(58, 365, 315, 21);
		changeUserDataPanel2.add(newPasswordReField);

		addressLabel = new JLabel("\uC8FC\uC18C");
		addressLabel.setBounds(58, 666, 57, 15);
		changeUserDataPanel2.add(addressLabel);

		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(58, 689, 315, 21);
		changeUserDataPanel2.add(addressField);
		
		searchUserinfoBtn = new JButton("조회");
		searchUserinfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = idField.getText();
				try {
					updateUserInfo = userInfoService.selectById(id);
					
					userNoField.setText(updateUserInfo.getU_no()+"");
					nowPasswordField.setText(updateUserInfo.getU_pw());
					
					nameField.setText(updateUserInfo.getU_name());
					emailField.setText(updateUserInfo.getU_email());
					phoneField.setText(updateUserInfo.getU_phone());
					addressField.setText(updateUserInfo.getU_address());
					birthField.setText(updateUserInfo.getU_birth()+"");
					String job = updateUserInfo.getU_job();
					if(job == null) {
						jobField.setText("");
					}else {
						jobField.setText(job);
					}
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		searchUserinfoBtn.setBounds(302, 49, 71, 23);
		changeUserDataPanel2.add(searchUserinfoBtn);

		orderUserData = new JPanel();
		tabbedPane.addTab("\uC8FC\uBB38\uB0B4\uC5ED", null, orderUserData, null);
		orderUserData.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		orderUserData.add(scrollPane_1, BorderLayout.CENTER);

		orderDataPanel = new JPanel();
		orderDataPanel.setPreferredSize(new Dimension(10, 800));
		scrollPane_1.setViewportView(orderDataPanel);
		// orderDataPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

//		

		orderTitleLabel = new JLabel("\uC8FC\uBB38\uB0B4\uC5ED");
		orderDataPanel.add(orderTitleLabel);
		orderTitleLabel.setFont(new Font("굴림", Font.PLAIN, 25));

		/*******************************************************************/
		// 주문내역
		orderProductPanel_1 = new JPanel();
		orderProductPanel_1.setPreferredSize(new Dimension(400, 150));
		orderProductPanel_1.setBackground(new Color(221, 160, 221));
		orderDataPanel.add(orderProductPanel_1);
		orderProductPanel_1.setLayout(null);

		orderProductImg_1 = new JLabel("\uC8FC\uBB38\uC0C1\uD488\uC0AC\uC9C4");
		orderProductImg_1.setBackground(Color.WHITE);
		orderProductImg_1.setBounds(12, 10, 105, 114);
		orderProductPanel_1.add(orderProductImg_1);

		orderNoLabel_1 = new JLabel("\uC8FC\uBB38\uBC88\uD638");
		orderNoLabel_1.setBounds(129, 10, 146, 15);
		orderProductPanel_1.add(orderNoLabel_1);

		orderProductNameLabel_1 = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uC774\uB984");
		orderProductNameLabel_1.setBounds(129, 59, 146, 15);
		orderProductPanel_1.add(orderProductNameLabel_1);

		orderProductPriceLabel_1 = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uAC00\uACA9");
		orderProductPriceLabel_1.setBounds(129, 84, 146, 15);
		orderProductPanel_1.add(orderProductPriceLabel_1);

		orderProductCountLabel_1 = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uC218\uB7C9");
		orderProductCountLabel_1.setBounds(129, 109, 146, 15);
		orderProductPanel_1.add(orderProductCountLabel_1);

		orderDateLabel_1 = new JLabel("\uC8FC\uBB38\uB0A0\uC9DC");
		orderDateLabel_1.setBounds(129, 34, 146, 15);
		orderProductPanel_1.add(orderDateLabel_1);
		/*******************************************************************/
		/******** 2.Service객체생성 **********/
		try {
			orderService = new OrderService();
			userInfoService = new UserInfoService();
			orderProductList(u_id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/****** 처음프레임생성될때UI초기화 ****************/

	}// 생성자끝
	
	
	String u_id = "itwill2";
	private JButton searchUserinfoBtn;
	private JTabbedPane tabbedPane;
	private JPanel changeUserDataPanel;
	private JScrollPane scrollPane;
	private JPanel orderUserData;
	private JScrollPane scrollPane_1;
	private JLabel orderTitleLabel;
	private JPanel orderProductPanel_1;
	private JLabel orderProductImg_1;
	private JLabel orderNoLabel_1;
	private JLabel orderProductNameLabel_1;
	private JLabel orderProductPriceLabel_1;
	private JLabel orderProductCountLabel_1;
	private JLabel orderDateLabel_1;
	private JPanel changeUserDataPanel2;
	

	public void orderProductList(String u_id) throws Exception {
		orderDataPanel.removeAll();
		List<Orders> orderList = orderService.selectOrderListbyUserId(u_id);
		
		System.out.println(orderList.size());
		
		for (int i = 0; i < orderList.size(); i++) {
			Orders orders = orderList.get(i);

			System.out.println(orders.getOrderItemList());
			
			for (int j = 0; j < orders.getOrderItemList().size(); j++) {
				
				OrderItem orderItem = orders.getOrderItemList().get(j);

				System.out.println(orderItem);
				
				JPanel orderProductPanel = new JPanel();
				orderProductPanel.setPreferredSize(new Dimension(400, 150));
				orderProductPanel.setBackground(new Color(221, 160, 221));
				orderDataPanel.add(orderProductPanel);
				orderProductPanel.setLayout(null);

				JLabel orderProductImg = new JLabel("\uC8FC\uBB38\uC0C1\uD488\uC0AC\uC9C4");
				orderProductImg.setBackground(Color.WHITE);
				orderProductImg.setBounds(12, 10, 105, 114);
				orderProductPanel.add(orderProductImg);

				JLabel orderNoLabel = new JLabel("\uC8FC\uBB38\uBC88\uD638" + orderItem.getO_no());
				orderNoLabel.setBounds(129, 10, 146, 15);
				orderProductPanel.add(orderNoLabel);

				JLabel orderProductNameLabel = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uC774\uB984" + orderItem.getProduct().getP_name());
				orderProductNameLabel.setBounds(129, 59, 146, 15);
				orderProductPanel.add(orderProductNameLabel);

				JLabel orderProductPriceLabel = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uAC00\uACA9" + orderItem.getProduct().getP_price());
				orderProductPriceLabel.setBounds(129, 84, 146, 15);
				orderProductPanel.add(orderProductPriceLabel);

				JLabel orderProductCountLabel = new JLabel("\uC8FC\uBB38 \uC0C1\uD488 \uC218\uB7C9" + orderItem.getOi_qty());
				orderProductCountLabel.setBounds(129, 109, 146, 15);
				orderProductPanel.add(orderProductCountLabel);

				//orders.getO_date()
				JLabel orderDateLabel = new JLabel("\uC8FC\uBB38\uB0A0\uC9DC" + j);
				orderDateLabel.setBounds(129, 34, 146, 15);
				orderProductPanel.add(orderDateLabel);

			}
		}

	}
}// 클래스끝
