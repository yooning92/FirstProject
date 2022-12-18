package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

import com.itwill.marketcoli.dto.Notice;
import com.itwill.marketcoli.service.NoticeService;
import com.itwill.marketcoli.service.UserInfoService;

import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Cart extends JPanel {
	/***********Frame변수 선언*************/
	private JFrame marketColiFrame;
	
	/***********Service 객체 선언*************/
	private NoticeService noticeService = new NoticeService();
	private JPanel tabbedPane;
	private JPanel notice1;

	/**
	 * Create the panel.
	 */
	public Cart() {
		setPreferredSize(new Dimension(400, 800));
		setLayout(null);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBounds(0, 0, 400, 764);
		add(cartPanel);
		cartPanel.setLayout(new BorderLayout(0, 0));
		JPanel notice1 = new JPanel();
		
		try {
			Notice notice = noticeService.selectByNoticeNo(1);
			String title = notice.getN_title();
			// Date date = notice.getN_date();
			//Date noticeDate = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
			String noticeDateStr = sdf1.format(notice.getN_date());
			String content = notice.getN_content();
		
		/*****************/
		notice = noticeService.selectByNoticeNo(2);
		title = notice.getN_title();
		//Date date = notice.getN_date();
		noticeDateStr = sdf1.format(notice.getN_date());
		content = notice.getN_content();
		
		/*****************/
		notice = noticeService.selectByNoticeNo(3);
		title = notice.getN_title();
		//Date date = notice.getN_date();
		noticeDateStr = sdf1.format(notice.getN_date());
		content = notice.getN_content();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
