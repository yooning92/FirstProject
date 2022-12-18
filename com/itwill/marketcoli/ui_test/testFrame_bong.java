package com.itwill.marketcoli.ui_test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.marketcoli.dto.Notice;
import com.itwill.marketcoli.service.NoticeService;
import com.itwill.marketcoli.service.UserInfoService;

import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Scrollbar;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class testFrame_bong extends JFrame {

	/*********** Service 선언 생성 *************/
	private NoticeService noticeService = new NoticeService();// 공지사항 서비스

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
	private JTabbedPane noticeTabbedPane;
	private JPanel notice1;
	private JTextField notice1Date;
	private JTextPane notice1Content;
	private JTextField notice1Title;
	private JPanel notice2;
	private JTextField notice2Date;
	private JTextPane notice2Content;
	private JTextField notice2Title;
	private JPanel notice3;
	private JTextField notice3Date;
	private JTextPane notice3Content;
	private JTextField notice3Title;
	private static JPanel notice1_1;

	/**
	 * Launch the application.
	 *
notice1_1 = new javax.swing.JPanel();/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFrame_bong frame = new testFrame_bong();
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
	public testFrame_bong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 680);

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

		orderPanel = new JPanel();
		tabbedPane.addTab("주문", null, orderPanel, null);

		/************* 공지사항 ******************/
		JPanel noticePanel = new JPanel();
		JPanel notice1 = new JPanel();
		noticePanel = new JPanel();
		tabbedPane.addTab("공지사항", null, noticePanel, null);
		noticePanel.setLayout(new BorderLayout(0, 0));

		try {
			Notice notice = noticeService.selectByNoticeNo(1);
			String title = notice.getN_title();
			// Date date = notice.getN_date();
			//Date noticeDate = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
			String noticeDateStr = sdf1.format(notice.getN_date());
			String content = notice.getN_content();

			noticeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			noticePanel.add(noticeTabbedPane, BorderLayout.CENTER);

			notice1 = new JPanel();
			notice1.setLayout(null);
			noticeTabbedPane.addTab("배송 안내", null, notice1, null);

			notice1Date = new JTextField();
			notice1Date.setHorizontalAlignment(SwingConstants.CENTER);
			notice1Date.setEditable(false);
			//notice1Date.setText("작성일자"); 타이핑 해서 입력
			notice1Date.setText(noticeDateStr); //DB값 불러오기
			notice1Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			notice1Date.setColumns(10);
			notice1Date.setBounds(237, 7, 116, 30);
			notice1.add(notice1Date);

			notice1Content = new JTextPane();
			//notice1Content.setText("안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 저희 마켓콜리 상품 구매 시 회원가입이 필요합니다. 회원가입 절차 진행 후 구매 부탁드립니다.");
			notice1Content.setText(content);
			notice1Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			notice1Content.setEditable(false);
			notice1Content.setBounds(0, 42, 354, 500);
			notice1.add(notice1Content);

			notice1Title = new JTextField();
			notice1Title.setEditable(false);
			//notice1Title.setText("안내문");
			notice1Title.setText(title);
			notice1Title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			notice1Title.setColumns(10);
			notice1Title.setBounds(2, 7, 233, 30);
			notice1.add(notice1Title);
			
			/*****************/
			notice = noticeService.selectByNoticeNo(2);
			title = notice.getN_title();
			//Date date = notice.getN_date();
			noticeDateStr = sdf1.format(notice.getN_date());
			content = notice.getN_content();
			/*****************/
			
			notice2 = new JPanel();
			noticeTabbedPane.addTab("배송 안내", null, notice2, null);
			notice2.setLayout(null);

			notice2Date = new JTextField();
			notice2Date.setHorizontalAlignment(SwingConstants.CENTER);
			notice2Date.setText(noticeDateStr); //DB값 불러오기
			notice2Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			notice2Date.setEditable(false);
			notice2Date.setColumns(10);
			notice2Date.setBounds(237, 7, 116, 30);
			notice2.add(notice2Date);

			notice2Content = new JTextPane();
			notice2Content.setEditable(false);
			//notice2Content.setText("안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 오전에 주문 시 당일 출고되어 배송됩니다.");
			notice2Content.setText(content);
			notice2Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			notice2Content.setBounds(0, 42, 354, 500);
			notice2.add(notice2Content);

			notice2Title = new JTextField();
			//notice2Title.setText("배송 안내");
			notice2Title.setText(title);
			notice2Title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			notice2Title.setEditable(false);
			notice2Title.setColumns(10);
			notice2Title.setBounds(2, 7, 233, 30);
			notice2.add(notice2Title);

			notice3 = new JPanel();
			notice3.setLayout(null);
			noticeTabbedPane.addTab("긴급 공지", null, notice3, null);
			
			/*****************/
			notice = noticeService.selectByNoticeNo(3);
			title = notice.getN_title();
			//Date date = notice.getN_date();
			noticeDateStr = sdf1.format(notice.getN_date());
			content = notice.getN_content();
			/*****************/
			
			notice3Date = new JTextField();
			notice3Date.setHorizontalAlignment(SwingConstants.CENTER);
			notice3Date.setEditable(false);
			notice3Date.setText(noticeDateStr);
			notice3Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			notice3Date.setColumns(10);
			notice3Date.setBounds(237, 7, 116, 30);
			notice3.add(notice3Date);

			notice3Content = new JTextPane();
			//notice3Content.setText("안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 저희 마켓콜리 상품 구매 시 회원가입이 필요합니다. 회원가입 절차 진행 후 구매 부탁드립니다.");
			notice3Content.setText(content);
			notice3Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
			notice3Content.setEditable(false);
			notice3Content.setBounds(0, 42, 354, 500);
			notice3.add(notice3Content);

			notice3Title = new JTextField();
			notice3Title.setEditable(false);
			//notice3Title.setText("긴급 공지");
			notice3Title.setText(title);
			notice3Title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			notice3Title.setColumns(10);
			notice3Title.setBounds(2, 7, 233, 30);
			notice3.add(notice3Title);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
