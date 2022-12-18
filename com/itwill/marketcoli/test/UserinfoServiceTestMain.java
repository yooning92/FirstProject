package com.itwill.marketcoli.test;

import java.util.List;

import com.itwill.marketcoli.dto.UserInfo;
import com.itwill.marketcoli.service.UserInfoService;

public class UserinfoServiceTestMain {

	public static void main(String[] args) throws Exception{
		UserInfoService userInfoService = new UserInfoService();
		
/*		
		//회원가입
		UserInfo newUserInfo =
				new UserInfo(0, "insert100", "1234", "서비스맨", "1@service.test", "01099999999", "아이티윌", 20220702, null, null);
		System.out.println(userInfoService.addUserInfo(newUserInfo));
*/		
		
		
		System.out.println(">>로그인 테스트");
		int userInfoLogin = userInfoService.UserInfoLogin("insert100", "updatePw");
		if(userInfoLogin==0) {
			System.out.println("로그인 성공");
		}else if (userInfoLogin==1) {
			System.out.println("회원 정보가 없습니다 회원가입 바로가기>>");
		}else {
			System.out.println("패스워드 불일치 합니다 다시 입력해주세요");
		}
		
		
		
				
		//회원 아이디 찾기
		System.out.println(">>아이디찾기");
		System.out.println(userInfoService.selectById("a@www.a.com"));
		
		//회원 비밀번호 찾기
		System.out.println(">>비밀번호찾기");
		System.out.println(userInfoService.selectByPw("user2", "user1@user.com"));
		
		//회원번호로 회원정보 출력
		System.out.println("회원번호로 회원정보 출력");
		System.out.println(userInfoService.selectByNo(1));
		
		//회원정보 전체 출력
		System.out.println(">>회원정보 전체 출력");
		List<UserInfo> userInfoList =
				userInfoService.selectAll();
		for (UserInfo userInfo : userInfoList) {
			System.out.println(userInfo);
		}
		
		//회원정보 수정
		System.out.println(">>회원정보 수정");
		UserInfo updateUserInfo =
				new UserInfo(1, "update11", "updatePw", "업데이트", "1@update.test", "01011111111", "업데이트시", 19900101, "업데이트맨", null);
			System.out.println(userInfoService.updateUserInfo(updateUserInfo));
			
			
		//회원 탈퇴
		System.out.println(">>회원 탈퇴");
		System.out.println(userInfoService.deleteUserInfo(15));
	}

}
