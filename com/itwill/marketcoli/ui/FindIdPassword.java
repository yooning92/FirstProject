package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.UserInfoService;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FindIdPassword extends JPanel {
	
	/*********** Frame변수 선언 *************/
	private JFrame marketColiFrame;

	/*********** UserInfo *************/
	private UserInfoService userInfoService;

	/************* 아이디/비번찾기 한회원 **********/
	private UserInfo findUserInfo = null; // MemberMainFrame.this.loginMember
	
	private JTextField findIdTF;
	private JTextField findPwIdTF;
	private JTextField findPwEmailTF;
	private JButton FindIdBtn;
	private JButton FindPwBtn;
	private JLabel findIdLB;
	private JLabel findByEmailLB;
	private JLabel findPwLB;
	private JLabel findPwIdLB;
	private JLabel findPwEmailLB;
	private JLabel printIdLB;
	private JLabel printPwLB;

	/**
	 * Create the panel.
	 */
	public FindIdPassword() {
		setPreferredSize(new Dimension(400, 800));
		setLayout(null);
		
		findIdTF = new JTextField();
		findIdTF.setBounds(136, 199, 179, 21);
		add(findIdTF);
		findIdTF.setColumns(10);
		
		findIdLB = new JLabel("아이디 찾기");
		findIdLB.setHorizontalAlignment(SwingConstants.LEFT);
		findIdLB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		findIdLB.setBounds(136, 150, 114, 15);
		add(findIdLB);
		
		findByEmailLB = new JLabel("이메일");
		findByEmailLB.setBounds(68, 202, 57, 15);
		add(findByEmailLB);
		
		FindIdBtn = new JButton("아이디 찾기");
		FindIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = findIdTF.getText();
				try {
					findUserInfo= userInfoService.selectByEamil(email);
					
					if(findUserInfo==null) {
						printIdLB.setText("일치하는 아이디가 없습니다.");
					}else {
						printIdLB.setText("고객님의 아이디는 [ "+ findUserInfo.getU_id() +" ] 입니다");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		FindIdBtn.setBounds(134, 249, 116, 23);
		add(FindIdBtn);
		
		findPwIdTF = new JTextField();
		findPwIdTF.setColumns(10);
		findPwIdTF.setBounds(136, 453, 179, 21);
		add(findPwIdTF);
		
		findPwEmailTF = new JTextField();
		findPwEmailTF.setColumns(10);
		findPwEmailTF.setBounds(136, 501, 179, 21);
		add(findPwEmailTF);
		
		findPwLB = new JLabel("비밀번호 찾기");
		findPwLB.setHorizontalAlignment(SwingConstants.LEFT);
		findPwLB.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		findPwLB.setBounds(134, 398, 116, 21);
		add(findPwLB);
		
		findPwIdLB = new JLabel("아이디");
		findPwIdLB.setBounds(68, 456, 57, 15);
		add(findPwIdLB);
		
		findPwEmailLB = new JLabel("이메일");
		findPwEmailLB.setBounds(68, 504, 57, 15);
		add(findPwEmailLB);
		
		FindPwBtn = new JButton("비밀번호 찾기");
		FindPwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//null값이 나오는 상태
				String id = findPwIdLB.getText();
				String email = findPwEmailLB.getText();
				//String pw = null;
				try {
					findUserInfo = userInfoService.selectByPw(id,email);
					System.out.println(findUserInfo);
					if(findUserInfo==null) {
						printPwLB.setText("일치하는 회원이 없습니다.");
					}else if(findUserInfo!=null){
						System.out.println(findUserInfo);
						printPwLB.setText("고객님의 비밀번호는 [ "+ findUserInfo.getU_pw() +" ] 입니다");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		FindPwBtn.setBounds(134, 563, 116, 23);
		add(FindPwBtn);
		
		printIdLB = new JLabel("");
		printIdLB.setForeground(new Color(148, 0, 211));
		printIdLB.setBounds(68, 299, 247, 15);
		add(printIdLB);
		
		printPwLB = new JLabel("");
		printPwLB.setForeground(new Color(148, 0, 211));
		printPwLB.setBounds(59, 605, 256, 15);
		add(printPwLB);

		/*********** 2.UserInfoService객체생성 *****************/
		userInfoService = new UserInfoService();

		/************* 처음프레임생성될때 UI 초기화 ***********/
		// resetProcess();
		
	}//생성자 끝
	
	
}//클래스 끝