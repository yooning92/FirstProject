package com.itwill.marketcoli.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.UserInfoService;
import com.itwill.marketcoli.ui.JFrame;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Dimension;

public class Join extends JPanel {

	/*********** Frame변수 선언 *************/
	private JFrame marketColiFrame;

	/*********** UserInfo *************/
	private UserInfoService userInfoService = new UserInfoService();

	/************* 로그인한회원 **********/
	private UserInfo newUserInfo = null; // MemberMainFrame.this.loginMember

	private JTextField joinidtext;
	private JTextField joinNameText;
	private JTextField joinhbdText;
	private JTextField joinAddressText;
	private JTextField joinPhoneText;
	private JTextField joinEmailText;
	private JTextField joinjobText;
	private JLabel lblNewLabel;
	private JLabel joinidLB;
	private JLabel joinPwLB;
	private JLabel joinPwReLB;
	private JLabel joinNameLB;
	private JLabel joinemailLB;
	private JLabel joinphoneLB;
	private JLabel joinaddressLB;
	private JLabel joinhbdLB;
	private JLabel joinjobLB;
	private JButton joinBtn;
	private JButton cancelBtn;
	private JLabel pwCheckMessageLB;
	private JPasswordField joinpwField;
	private JPasswordField joinpwcheckField;
	private JLabel idDuplicateCheckLB;

	/**
	 * Create the panel.
	 */
	public Join() {
		setPreferredSize(new Dimension(400, 800));

		setLayout(null);

		lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel.setBounds(124, 51, 131, 72);
		add(lblNewLabel);

		joinidLB = new JLabel("아이디");
		joinidLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinidLB.setBounds(43, 146, 57, 15);
		add(joinidLB);

		joinPwLB = new JLabel("비밀번호");
		joinPwLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinPwLB.setBounds(43, 243, 57, 15);
		add(joinPwLB);

		joinPwReLB = new JLabel("비밀번호확인");
		joinPwReLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinPwReLB.setBounds(43, 291, 74, 15);
		add(joinPwReLB);

		joinNameLB = new JLabel("이름");
		joinNameLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinNameLB.setBounds(43, 360, 57, 15);
		add(joinNameLB);

		joinemailLB = new JLabel("이메일");
		joinemailLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinemailLB.setBounds(43, 388, 57, 15);
		add(joinemailLB);

		joinphoneLB = new JLabel("핸드폰");
		joinphoneLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinphoneLB.setBounds(43, 437, 57, 15);
		add(joinphoneLB);

		joinaddressLB = new JLabel("주소");
		joinaddressLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinaddressLB.setBounds(43, 479, 57, 15);
		add(joinaddressLB);

		joinhbdLB = new JLabel("생년월일");
		joinhbdLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinhbdLB.setBounds(43, 520, 57, 15);
		add(joinhbdLB);

		joinjobLB = new JLabel("직업");
		joinjobLB.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinjobLB.setBounds(43, 564, 57, 15);
		add(joinjobLB);

		joinidtext = new JTextField();
		joinidtext.setBounds(139, 143, 116, 21);
		add(joinidtext);
		joinidtext.setColumns(10);

		joinNameText = new JTextField();
		joinNameText.setColumns(10);
		joinNameText.setBounds(139, 357, 116, 21);
		add(joinNameText);

		joinhbdText = new JTextField();
		joinhbdText.setColumns(10);
		joinhbdText.setBounds(139, 517, 116, 21);
		add(joinhbdText);

		joinAddressText = new JTextField();
		joinAddressText.setColumns(10);
		joinAddressText.setBounds(139, 476, 116, 21);
		add(joinAddressText);

		joinPhoneText = new JTextField();
		joinPhoneText.setColumns(10);
		joinPhoneText.setBounds(139, 434, 116, 21);
		add(joinPhoneText);

		joinEmailText = new JTextField();
		joinEmailText.setColumns(10);
		joinEmailText.setBounds(139, 388, 116, 21);
		add(joinEmailText);

		joinjobText = new JTextField();
		joinjobText.setColumns(10);
		joinjobText.setBounds(139, 561, 116, 21);
		add(joinjobText);

		pwCheckMessageLB = new JLabel("");
		pwCheckMessageLB.setForeground(Color.RED);
		pwCheckMessageLB.setBounds(139, 332, 175, 15);
		add(pwCheckMessageLB);

		joinBtn = new JButton("가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********** 회원가입 **********/
				// 유효성 체크(skip,생략) -> Dto에 입력

				try {

					System.out.println("회원가입 시작");
					String password = joinpwField.getText();
					String passwordCheck = joinpwcheckField.getText();
					if (password.equals(passwordCheck)) {
						pwCheckMessageLB.setText("비밀번호 일치");
					} else {
						pwCheckMessageLB.setText("");
					}

					// TextField로부터 데이타얻기
					String id = joinidtext.getText();
					
					String name = joinNameText.getText();
					String email = joinEmailText.getText();
					String phone = joinPhoneText.getText();
					String address = joinAddressText.getText();
					int birth = Integer.parseInt(joinhbdText.getText());
					String job = joinjobText.getText();
					//messageLB.setText("*test test");

					if (id.equals("") || password.equals("") || passwordCheck.equals("")/* || name.equals("")
						|| email.equals("") || phone.equals("") || address.equals("") || birth == 0 */) {
						pwCheckMessageLB.setText("*내용을 입력하세요");
						return;
					}

					newUserInfo = new UserInfo(0, id, password, name, email, phone, address, birth, job, null);
					boolean isSuccess = userInfoService.addUserInfo(newUserInfo);

					// <<화면전환>>
					if (isSuccess) {
						// 성공(로그인패널을 보여준다.)
						// memberTabbedPane.setSelectedIndex(1); // 1번패널=로그인

					} else {
						// 실패(다이알로그를 띄운다.)
						//pwCheckMessageLB.setText("아이디가 중복되었습니다.");
						//JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다.");
						// 아이디쪽(idTF)으로 focus가 간다
						joinidtext.requestFocus();
						joinidtext.setSelectionStart(0); // id를 0번(처음) 부터 선택한다
						joinidtext.setSelectionEnd(id.length()); // id는 String이다
					}

				} catch (Exception e1) {
					e1.printStackTrace();

				}
				/****************************/

			}
		});

		joinBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		joinBtn.setBounds(43, 638, 124, 42);
		add(joinBtn);

		cancelBtn = new JButton("취소");
		cancelBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cancelBtn.setBounds(236, 638, 124, 42);
		add(cancelBtn);

		joinpwField = new JPasswordField();
		joinpwField.setBounds(139, 242, 116, 21);
		add(joinpwField);

		joinpwcheckField = new JPasswordField();
		joinpwcheckField.setBounds(139, 290, 116, 21);
		add(joinpwcheckField);
		
		JButton idDuplicateCheckBtn = new JButton("아이디 중복체크");
		idDuplicateCheckBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************* 아이디 중복 체크 ***********/
				String id = joinidtext.getText();
				try {
					
					System.out.println(userInfoService.selectById(id));
					if(userInfoService.selectById(id)==null) {
						idDuplicateCheckLB.setText("아이디 사용가능");
					}else {
						idDuplicateCheckLB.setText("아이디 중복");
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		idDuplicateCheckBtn.setBounds(139, 174, 131, 23);
		add(idDuplicateCheckBtn);
		
		idDuplicateCheckLB = new JLabel("");
		idDuplicateCheckLB.setBounds(139, 207, 175, 15);
		add(idDuplicateCheckLB);


		/************* 처음프레임생성될때 UI 초기화 ***********/
		// resetProcess();

	}// 생성자끝
}// 클래스 끝