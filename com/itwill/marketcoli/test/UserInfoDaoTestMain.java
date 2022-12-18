package com.itwill.marketcoli.test;

import java.util.List;

import com.itwill.marketcoli.dao.UserInfoDao;
import com.itwill.marketcoli.dto.UserInfo;



public class UserInfoDaoTestMain {

	public static void main(String[] args) throws Exception {

		UserInfoDao userInfoDao= new UserInfoDao();
		//VALUES (userinfo_u_no_seq.nextval, 'itwill1', '1111', '김첨지', 'a@www.a.com', '11111111111', '사랑시고백구행복동','19500625',null,sysdate);
		//User insertDao = new User(0, 'today', '0630', '오늘이, 'today@nail.com', '', null, 0, null, null)
		//아직 진행중
		
		System.out.println("1.insertUserInfo");
		// (수정)생성자 변경하여 사용
		UserInfo insertUserInfo = new UserInfo(0, "insert14", "1111", "고길동", "1@insert.com", 
												"01011112222", "서울", 20110201, "둘리보호자", null);
		System.out.println(userInfoDao.insertUserInfo(insertUserInfo));

		/*
		 * = "insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)\r\n"
				+ "VALUES (userinfo_u_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ? , sysdate) ";
		 */
		System.out.println("2.deleteUserInfo");
		System.out.println(userInfoDao.deleteUserInfo(5));

		// (수정)생성자 변경하여 사용
		/*	
		private int u_no;			//회원번호 - pk
		private String u_id;		//아이디 - 변경불가
		private String u_pw;		//비밀번호
		private String u_name;		//이름
		private String u_email;		//이메일
		private int u_phone;		//휴대폰번호
		private String u_address;	//주소
		private int u_birth;		//생년월일
		private String u_job;		//직업
		private Date u_joindate;	//java.util.Date - 변경불가
*/
		System.out.println("3.updateUserInfo");
		UserInfo updateUserInfo = new UserInfo(1, "update1", "1234", "고고길동", "11@update.com", "01011111111", "서울 강북", 20220703, "둘리사육사", null);
		System.out.println(userInfoDao.updateUserInfo(updateUserInfo));
		
		System.out.println("4.selectByNo");
		System.out.println(userInfoDao.selectByNo(1));
		
		System.out.println("5.findById");
		System.out.println(userInfoDao.findByEmail("11@update.com"));
		
		System.out.println("6.findByPw");
		System.out.println(userInfoDao.findByPW("itwill1", "11@update.com"));
		
		System.out.println("7.selectAll");
		List<UserInfo> userInfoList = userInfoDao.selectAll();
		for(UserInfo userInfo : userInfoList) {
			System.out.println(userInfo);
		
		}
		
		System.out.println("8.selectById");
		System.out.println(userInfoDao.selectById("itwill1"));
		
		
		
	}
}

