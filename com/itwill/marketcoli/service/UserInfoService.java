package com.itwill.marketcoli.service;

import java.util.List;

import com.itwill.marketcoli.dao.UserInfoDao;
import com.itwill.marketcoli.dto.UserInfo;

public class UserInfoService {
	private UserInfoDao userInfoDao;

	public UserInfoService() {
		userInfoDao = new UserInfoDao();
	}

	/*
	 * 회원가입 아이디 중복 시 메세지 출력
	 */
	public boolean addUserInfo(UserInfo newUserInfo) throws Exception {

		boolean isSuccess = false;
		/*
		 * 아이디존재여부체크 - 존재하면 메세지 - 존재안하면 가입
		 */
		UserInfo findUserInfo = userInfoDao.findByEmail(newUserInfo.getU_id());
		if (findUserInfo == null) {
			int rowCount = userInfoDao.insertUserInfo(newUserInfo);
			isSuccess = true;
		} else {
			isSuccess = false;
		}
		return isSuccess;

	}

	// 회원 로그인
	public int UserInfoLogin(String id, String password) throws Exception {
		/*
		 * 0 : 성공 1 : 존재하지 않는 아이디 2 : 패스워드 불일치
		 */
		int loginResult = -999;
		UserInfo findUserInfo = userInfoDao.selectById(id);
		if (findUserInfo == null) {
			// 존재하지 않는 아이디
			loginResult = 1;
		} else {
			// 존재하는 아이디
			if (findUserInfo.getU_pw().equals(password) && (findUserInfo.getU_id().equals(id))) {
				loginResult = 0;
			} else {
				// 패스워드 불일치
				loginResult = 2;
			}
		}
		return loginResult;
	}
	//회원 이메일로 아이디 찾기
	public UserInfo selectByEamil(String u_email) throws Exception {
		return userInfoDao.findByEmail(u_email);
	}

	//회원 비밀번호 찾기
	public UserInfo selectByPw(String u_id, String u_email) throws Exception {
		return userInfoDao.findByPW(u_id, u_email);
	}
	/*	public String selectByPw(String u_id, String u_email) throws Exception {
			return userInfoDao.findByPW(u_id, u_email);
		}
		*/
	
	//회원 아이디로 회원정보 출력
	public UserInfo selectById(String u_id) throws Exception {
		return userInfoDao.selectById(u_id);
	}
	//회원번호로 회원정보 출력
	public UserInfo selectByNo(int u_no) throws Exception {
		return userInfoDao.selectByNo(u_no);
	}
	//모든 회원정보 출력(관리자)
	 public List<UserInfo> selectAll() throws Exception{
		 return userInfoDao.selectAll();
	 }
	//회원정보 수정
	 public int updateUserInfo(UserInfo updateUserInfo) throws Exception {
		 return userInfoDao.updateUserInfo(updateUserInfo);
	 }
	//회원 탈퇴
	 public int deleteUserInfo(int u_no) throws Exception {
		 return userInfoDao.deleteUserInfo(u_no);
	 }
	
	
	
	
	
}
