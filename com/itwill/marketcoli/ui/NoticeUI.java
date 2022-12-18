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

public class NoticeUI extends JPanel {
	/***********Frame변수 선언*************/
	private JFrame marketColiFrame;
	
	/***********Service 객체 선언*************/
	private NoticeService noticeService = new NoticeService();
	
	private JTextField notice1Date;
	private JTextField notice1Title;
	private JTextField notice2Date;
	private JTextField notice2Title;
	private JTextField notice3Date;
	private JTextField notice3Title;
	private JPanel tabbedPane;
	private JTabbedPane noticeTabbedPane;
	private JPanel notice1;
	private JTextPane notice1Content;
	private JPanel notice2;
	private JTextPane notice2Content;
	private JPanel notice3;
	private JTextPane notice3Content;

	/**
	 * Create the panel.
	 */
	public NoticeUI() {
		setPreferredSize(new Dimension(400, 800));
		setLayout(null);
		/************* 공지사항 ******************/
		JPanel tabbedPane = new JPanel();
		tabbedPane.setPreferredSize(new Dimension(400, 600));
		JPanel notice1 = new JPanel();
		tabbedPane.setBounds(0, 0, 389, 680);
		add(tabbedPane);
		
		try {
			Notice notice = noticeService.selectByNoticeNo(1);
			String title = notice.getN_title();
			// Date date = notice.getN_date();
			//Date noticeDate = new Date();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
			String noticeDateStr = sdf1.format(notice.getN_date());
			String content = notice.getN_content();
		tabbedPane.setLayout(new GridLayout(0, 1, 0, 0));
			
		noticeTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.add(noticeTabbedPane);
		
		notice1 = new JPanel();
		notice1.setLayout(null);
		noticeTabbedPane.addTab("안내문", null, notice1, null);
		
		notice1Date = new JTextField();
		notice1Date.setText(noticeDateStr); 
		notice1Date.setHorizontalAlignment(SwingConstants.CENTER);
		notice1Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		notice1Date.setEditable(false);
		notice1Date.setColumns(10);
		notice1Date.setBounds(237, 7, 116, 30);
		notice1.add(notice1Date);
		
		notice1Content = new JTextPane();
		notice1Content.setText(content);
		notice1Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		notice1Content.setEditable(false);
		notice1Content.setBounds(0, 42, 354, 500);
		notice1.add(notice1Content);
		
		notice1Title = new JTextField();
		notice1Title.setText(title);
		notice1Title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		notice1Title.setEditable(false);
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
		notice2.setLayout(null);
		noticeTabbedPane.addTab("배송 안내", null, notice2, null);
		
		notice2Date = new JTextField();
		notice2Date.setText(noticeDateStr);
		notice2Date.setHorizontalAlignment(SwingConstants.CENTER);
		notice2Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		notice2Date.setEditable(false);
		notice2Date.setColumns(10);
		notice2Date.setBounds(237, 7, 116, 30);
		notice2.add(notice2Date);
		
		notice2Content = new JTextPane();
		notice2Content.setText(content);
		notice2Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		notice2Content.setEditable(false);
		notice2Content.setBounds(0, 42, 354, 500);
		notice2.add(notice2Content);
		
		notice2Title = new JTextField();
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
		notice3Date.setText(noticeDateStr);
		notice3Date.setHorizontalAlignment(SwingConstants.CENTER);
		notice3Date.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		notice3Date.setEditable(false);
		notice3Date.setColumns(10);
		notice3Date.setBounds(237, 7, 116, 30);
		notice3.add(notice3Date);
		
		notice3Content = new JTextPane();
		notice3Content.setText(content);
		notice3Content.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		notice3Content.setEditable(false);
		notice3Content.setBounds(0, 42, 354, 500);
		notice3.add(notice3Content);
		
		notice3Title = new JTextField();
		notice3Title.setText(title);
		notice3Title.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		notice3Title.setEditable(false);
		notice3Title.setColumns(10);
		notice3Title.setBounds(2, 7, 233, 30);
		notice3.add(notice3Title);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
