package com.itwill.marketcoli.ui_test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.marketcoli.dto.Cart;
import com.itwill.marketcoli.dto.Notice;
import com.itwill.marketcoli.service.CartService;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Scrollbar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JTable;

public class testFrame_harim extends JFrame {
	
	private static final Cart CartService = null;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JTabbedPane tabbedPane;
	private JPanel productPanel;
	private JPanel cartPanel;
	private JPanel orderPanel;
	private JPanel userPanel;
	private JPanel mypagePanel;
	private JPanel noticePanel;
	private JPanel cartpanel;
	private JTextField addressWrite;
	private JTextField product1;
	private JTextField product2;
	private JTextField price1;
	private JTextField price2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFrame_harim frame = new testFrame_harim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testFrame_harim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
		
		mnNewMenu_4 = new JMenu("New menu");
		menuBar.add(mnNewMenu_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		userPanel = new JPanel();
		tabbedPane.addTab("회원가입", null, userPanel, null);
		
		mypagePanel = new JPanel();
		tabbedPane.addTab("마이페이지", null, mypagePanel, null);
		
		productPanel = new JPanel();
		tabbedPane.addTab("상품", null, productPanel, null);
		
		cartPanel = new JPanel();
		tabbedPane.addTab("카트", null, cartPanel, null);
		cartPanel.setLayout(new BorderLayout(0, 0));
		
		cartpanel = new JPanel();
		cartPanel.add(cartpanel, BorderLayout.CENTER);
		
		JCheckBox savingAddress = new JCheckBox("기존주소지");
		savingAddress.setSelected(true);
		
		addressWrite = new JTextField();
		addressWrite.setColumns(10);
		
		JButton orderBtn = new JButton("주문하기");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("장바구니전체선택");
		chckbxNewCheckBox.setSelected(true);
		
		JRadioButton productBtn1 = new JRadioButton("");
		productBtn1.setSelected(true);
		
		JRadioButton productBtn2 = new JRadioButton("");
		productBtn2.setSelected(true);
		
		product1 = new JTextField();
		product1.setColumns(10);
		
		product2 = new JTextField();
		product2.setColumns(10);
		
		price1 = new JTextField();
		price1.setColumns(10);
		
		price2 = new JTextField();
		price2.setColumns(10);
		GroupLayout gl_cartpanel = new GroupLayout(cartpanel);
		gl_cartpanel.setHorizontalGroup(
			gl_cartpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cartpanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_cartpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartpanel.createSequentialGroup()
							.addComponent(productBtn2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(product2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cartpanel.createSequentialGroup()
							.addComponent(productBtn1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(product1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addGroup(gl_cartpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(price2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(price1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(chckbxNewCheckBox)
						.addGroup(gl_cartpanel.createSequentialGroup()
							.addComponent(savingAddress)
							.addGap(18)
							.addComponent(addressWrite, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_cartpanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(orderBtn, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_cartpanel.setVerticalGroup(
			gl_cartpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cartpanel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_cartpanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(savingAddress)
						.addComponent(addressWrite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(chckbxNewCheckBox)
					.addGap(65)
					.addGroup(gl_cartpanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cartpanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(product1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(price1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(productBtn1))
					.addGap(54)
					.addGroup(gl_cartpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cartpanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(product2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(price2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(productBtn2))
					.addGap(113)
					.addComponent(orderBtn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
		);
		cartpanel.setLayout(gl_cartpanel);
		
		orderPanel = new JPanel();
		tabbedPane.addTab("주문", null, orderPanel, null);
		
		noticePanel = new JPanel();
		tabbedPane.addTab("공지사항", null, noticePanel, null);
	}
}
