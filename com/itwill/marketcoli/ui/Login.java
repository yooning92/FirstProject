package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.UserInfoService;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	
	/***********Frame변수 선언*************/
	private JFrame marketColiFrame;
	
	/***********UserInfo*************/
	private UserInfoService userInfoService;
	
	/************* 로그인한회원 **********/
	private UserInfo loginUser = null; // MemberMainFrame.this.loginMember
	
	private JTextField loginidTF;
	private JTextField loginpwTF;
	private JLabel loginTitle;
	private JLabel loginidLB;
	private JLabel loginpwLB;
	private JButton loginBtn;
	private JButton joinBtn;
	private JButton cancleBtn;
	private JLabel loginMessageLB;
	private JButton findidpwBtn;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		loginTitle = new JLabel("로그인");
		loginTitle.setFont(new Font("굴림", Font.PLAIN, 30));
		loginTitle.setBounds(124, 64, 120, 65);
		add(loginTitle);
		
		loginidLB = new JLabel("아이디");
		loginidLB.setBounds(55, 167, 57, 15);
		add(loginidLB);
		
		loginidTF = new JTextField();
		loginidTF.setBounds(124, 164, 217, 21);
		add(loginidTF);
		loginidTF.setColumns(10);
		
		loginpwLB = new JLabel("비밀번호");
		loginpwLB.setBounds(55, 241, 57, 15);
		add(loginpwLB);
		
		loginpwTF = new JTextField();
		loginpwTF.setBounds(124, 238, 217, 21);
		add(loginpwTF);
		loginpwTF.setColumns(10);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*************** 회원로그인 ****************/
				try {
					String id = loginidTF.getText();
					String password = loginpwTF.getText();
					int result = userInfoService.UserInfoLogin(id, password);
					/*
					 * 0:성공
					 * 1:아이디없다 -> 실제로는 
					 * 2:패쓰워드불일치
					 */
					if (result == 0) { // 로그인성공시, 할일이 많음 -> 메소드를빼서 메소드프로세스를 실행시키는게 편함
						/* 생성자 밖 메소드로 보냄
						// 로그인 성공한 객체멤버변수에 저장
						Member loginSuccessMember = memberService.findById(id);
						// 로그인,회원가입패널 불활성화
						loginMember = loginSuccessMember;
						
						//프레임타이틀 설정
						setTitle(loginMember.getM_name());
						// 성공 -> 회원리스트 패널보여줌
						memberTabbedPane.setSelectedIndex(2);
						memberTabbedPane.setEnabledAt(0, false);
						memberTabbedPane.setEnabledAt(1, false);
						*/

						loginMessageLB.setText("로그인 성공");
						loginProcess(id);

					} else if (result == 1) {
						// 실패 (아이디 존재안함)
						loginMessageLB.setText("아이디 존재안함");
						loginidTF.requestFocus();

					} else if (result == 2) {
						// 실패 (패쓰워드 불일치)
						loginMessageLB.setText("패쓰워드 불일치");
						loginpwTF.requestFocus();
						loginpwTF.setSelectionStart(0);
						loginpwTF.setSelectionEnd(id.length());

					}

					// (참고)로그아웃 버튼은 메뉴에 작업한다.

				} catch (Exception e1) {
					// TODO: handle exception

				}

				/********************************/
			}
			
		});
		
		loginBtn.setBackground(new Color(128, 0, 128));
		loginBtn.setBounds(44, 335, 120, 39);
		add(loginBtn);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBackground(new Color(128, 0, 128));
		joinBtn.setBounds(44, 384, 297, 39);
		add(joinBtn);
		
		cancleBtn = new JButton("취소");
		cancleBtn.setBackground(new Color(128, 0, 128));
		cancleBtn.setBounds(221, 335, 120, 39);
		add(cancleBtn);
		
		loginMessageLB = new JLabel("");
		loginMessageLB.setForeground(Color.RED);
		loginMessageLB.setBounds(55, 278, 175, 15);
		add(loginMessageLB);
		
		findidpwBtn = new JButton("아이디/비밀번호 찾기");
		findidpwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********아이디 찾기*****************/
				
				System.out.println("아이디/비밀번호 찾기로 화면이동");
				/******************프레임 전환  ***********************/
				/*		
					loginMenuItem.setEnabled(true);
					joinMenuItem.setEnabled(true);
					logoutMenuItem.setEnabled(false);
					
					memberTabbedPane.setEnabledAt(0,true);	//가입
					memberTabbedPane.setEnabledAt(1,true);	//로그인
					memberTabbedPane.setEnabledAt(2,false);	//회원정보
					
					memberTabbedPane.setSelectedIndex(1);	//로그인 보여지게
				*/
				/****************************************************/
			}
		});
		findidpwBtn.setBounds(44, 446, 297, 23);
		add(findidpwBtn);
		
		/*********** 2.UserInfoService객체생성 *****************/
		userInfoService = new UserInfoService();
		
		/*************처음프레임생성될때 UI 초기화 ***********/
		logoutProcess();
		
	}//생성자끝
	
	/****************   로그인성공시호출할메소드	 **********************/
	public void loginProcess(String id) throws Exception {
		/*
		 * 1.로그인멤버객체 저장
		 * 2.MemberMainFrame타이틀변경
		 * 3.로그인,회원가입 tab 불활성화
		 * 4.로그아웃메뉴아이템 활성화
		 * 5.회원리스트탭 활성화
		 */
		// 로그인 성공한 객체멤버변수에 저장
		UserInfo loginSuccessMember = userInfoService.selectById(id);
		// 로그인,회원가입패널 불활성화
		loginUser = loginSuccessMember;

		if(loginUser==null) {
			System.out.println("로그인 실패");
		}else {
			System.out.println("로그인 성공");
			
		}
			
		
		/******************프레임 전환  ***********************/
		// 프레임타이틀 설정
		//setTitle(loginMember.getM_name());
		
		/*	loginMenuItem.setEnabled(false);
			joinMenuItem.setEnabled(false);
			logoutMenuItem.setEnabled(true);*/
		
		/*		memberTabbedPane.setEnabledAt(0, false);
				memberTabbedPane.setEnabledAt(1, false);
				memberTabbedPane.setEnabledAt(2, true);*/
		// 성공 -> 회원리스트 패널보여줌
		//memberTabbedPane.setSelectedIndex(2);	//회원리스트 보여지게
		/****************************************************/
	}
	
	/**************** 로그아웃시호출할메소드 **********************/
	//초기화면에서도 사용하는 프로세스
	public void logoutProcess() {
		/*
		 	주석 넣기
		 */		
		this.loginUser=null;
		//setTitle("");
		/******************프레임 전환  ***********************/
		/*		
			loginMenuItem.setEnabled(true);
			joinMenuItem.setEnabled(true);
			logoutMenuItem.setEnabled(false);
			
			memberTabbedPane.setEnabledAt(0,true);	//가입
			memberTabbedPane.setEnabledAt(1,true);	//로그인
			memberTabbedPane.setEnabledAt(2,false);	//회원정보
			
			memberTabbedPane.setSelectedIndex(1);	//로그인 보여지게
		*/
		/****************************************************/
		
	}//메소드 끝
	
	
}//클래스끝