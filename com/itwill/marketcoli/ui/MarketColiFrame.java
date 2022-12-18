package com.itwill.marketcoli.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Scrollbar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketColiFrame extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu cartMenu;
	private JMenu nothing1;
	private JMenu titleMenu;
	private JMenu noting2;
	private JMenu userMenu;
	private JTabbedPane tabbedPane;
	private JPanel productPanel;
	private JPanel cartPanel;
	private JPanel orderPanel;
	private JPanel joinPanel;
	private JPanel mypagePanel;
	private JPanel noticePanel;
	private JMenuItem joinMenuItem;
	private JMenuItem loginMenuItem;
	private JMenuItem mypageMenuItem;
	private JMenuItem logoutMenuItem;
	private JSeparator separator1;
	private JScrollPane joinScrollPane;
	private JPanel loginPanel;
	private JPanel idpwFindpanel;
	private JScrollPane loginScrollPane;
	private JScrollPane idpwFindScrollPane;
	private JScrollPane noitceScrollPane;
	private JScrollPane productScrollPane;
	private JScrollPane orderScrollPane;
	private Join join;
	private Login login;
	private FindIdPassword findIdPassword;
	private MyPage myPage;
	private ProductListPanel productListPanel;
	private OrdersPanel ordersPanel;
	private NoticeUI noticeUI;
	private JMenuItem exitMenuItem;
	private JSeparator separator2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketColiFrame frame = new MarketColiFrame();
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
	public MarketColiFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		cartMenu = new JMenu("               ");
		menuBar.add(cartMenu);
		
		nothing1 = new JMenu("                            ");
		menuBar.add(nothing1);
		
		titleMenu = new JMenu("Market Coli");
		titleMenu.setForeground(new Color(148, 0, 211));
		titleMenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		menuBar.add(titleMenu);
		
		noting2 = new JMenu("                                                  ");
		menuBar.add(noting2);
		
		userMenu = new JMenu("메뉴");
		menuBar.add(userMenu);
		
		joinMenuItem = new JMenuItem("회원가입");
		userMenu.add(joinMenuItem);
		
		separator1 = new JSeparator();
		userMenu.add(separator1);
		
		loginMenuItem = new JMenuItem("로그인");
		userMenu.add(loginMenuItem);
		
		mypageMenuItem = new JMenuItem("마이페이지");
		userMenu.add(mypageMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		userMenu.add(logoutMenuItem);
		
		separator2 = new JSeparator();
		userMenu.add(separator2);
		
		exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
			
		});
		userMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		joinPanel = new JPanel();
		joinPanel.setPreferredSize(new Dimension(10, 800));
		tabbedPane.addTab("회원가입", null, joinPanel, null);
		joinPanel.setLayout(new BorderLayout(0, 0));
		
		joinScrollPane = new JScrollPane();
		joinPanel.add(joinScrollPane, BorderLayout.CENTER);
		
		join = new Join();
		joinScrollPane.setViewportView(join);
		
		loginPanel = new JPanel();
		tabbedPane.addTab("로그인", null, loginPanel, null);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		loginScrollPane = new JScrollPane();
		loginPanel.add(loginScrollPane, BorderLayout.CENTER);
		
		login = new Login();
		loginScrollPane.setViewportView(login);
		
		idpwFindpanel = new JPanel();
		tabbedPane.addTab("아이디/비밀번호찾기", null, idpwFindpanel, null);
		idpwFindpanel.setLayout(new BorderLayout(0, 0));
		
		idpwFindScrollPane = new JScrollPane();
		idpwFindpanel.add(idpwFindScrollPane, BorderLayout.CENTER);
		
		findIdPassword = new FindIdPassword();
		idpwFindScrollPane.setViewportView(findIdPassword);
		
		mypagePanel = new JPanel();
		tabbedPane.addTab("마이페이지", null, mypagePanel, null);
		mypagePanel.setLayout(new BorderLayout(0, 0));
		
		myPage = new MyPage();
		mypagePanel.add(myPage, BorderLayout.CENTER);
		
		productPanel = new JPanel();
		tabbedPane.addTab("상품", null, productPanel, null);
		productPanel.setLayout(new BorderLayout(0, 0));
		
		productScrollPane = new JScrollPane();
		productPanel.add(productScrollPane, BorderLayout.CENTER);
		
		productListPanel = new ProductListPanel();
		productScrollPane.setViewportView(productListPanel);
		
		cartPanel = new JPanel();
		tabbedPane.addTab("카트", null, cartPanel, null);
		cartPanel.setLayout(new BorderLayout(0, 0));
		
		orderPanel = new JPanel();
		tabbedPane.addTab("주문", null, orderPanel, null);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		orderScrollPane = new JScrollPane();
		orderPanel.add(orderScrollPane, BorderLayout.CENTER);
		
		ordersPanel = new OrdersPanel();
		orderScrollPane.setViewportView(ordersPanel);
		
		noticePanel = new JPanel();
		tabbedPane.addTab("공지사항", null, noticePanel, null);
		noticePanel.setLayout(new BorderLayout(0, 0));
		
		noitceScrollPane = new JScrollPane();
		noticePanel.add(noitceScrollPane, BorderLayout.CENTER);
		
		noticeUI = new NoticeUI();
		noitceScrollPane.setViewportView(noticeUI);
	}
}
