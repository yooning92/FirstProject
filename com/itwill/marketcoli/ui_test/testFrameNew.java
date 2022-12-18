package com.itwill.marketcoli.ui_test;

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

public class testFrameNew extends JFrame {

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
	private JPanel userPanel;
	private JPanel mypagePanel;
	private JPanel noticePanel;
	private JMenuItem joinMenuItem;
	private JMenuItem loginMenuItem;
	private JMenuItem mypageMenuItem;
	private JMenuItem logoutMenuItem;
	private JSeparator separator1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFrameNew frame = new testFrameNew();
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
	public testFrameNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		cartMenu = new JMenu("");
		menuBar.add(cartMenu);
		
		nothing1 = new JMenu("");
		menuBar.add(nothing1);
		
		titleMenu = new JMenu("Market Coli");
		titleMenu.setForeground(new Color(148, 0, 211));
		titleMenu.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		menuBar.add(titleMenu);
		
		noting2 = new JMenu("");
		menuBar.add(noting2);
		
		userMenu = new JMenu("");
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
		
		orderPanel = new JPanel();
		tabbedPane.addTab("주문", null, orderPanel, null);
		
		noticePanel = new JPanel();
		tabbedPane.addTab("공지사항", null, noticePanel, null);
	}

}
