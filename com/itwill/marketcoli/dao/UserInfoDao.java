package com.itwill.marketcoli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.marketcoli.common.DataSource;
import com.itwill.marketcoli.dto.UserInfo;


public class UserInfoDao {
	private DataSource dataSource;

	public UserInfoDao() {
		dataSource = new DataSource();
	}

	public int insertUserInfo(UserInfo insertUserInfo) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_INSERT);
		// prepared는 일반statement에 비해 준비된 pipe!
		/*
		 * private int u_no; //회원번호 - pk private String u_id; //아이디 - 변경불가 private
		 * String u_pw; //비밀번호 private String u_name; //이름 private String u_email; //이메일
		 * private int u_phone; //휴대폰번호 private String u_address; //주소 private int
		 * u_birth; //생년월일 private String u_job; //직업 private Date u_joindate;
		 * //java.util.Date - 변경불가
		 */
		pstmt.setString(1, insertUserInfo.getU_id());
		pstmt.setString(2, insertUserInfo.getU_pw());
		pstmt.setString(3, insertUserInfo.getU_name());
		pstmt.setString(4, insertUserInfo.getU_email());
		pstmt.setString(5, insertUserInfo.getU_phone());
		pstmt.setString(6, insertUserInfo.getU_address());
		pstmt.setInt(7, insertUserInfo.getU_birth());
		pstmt.setString(8, insertUserInfo.getU_job());
		// date 추가하기
		// (참고)
		// pstmt.setString(1, userInfo.getU_name());
		/*********** 내용 입력 필요합니다 *********************/

		int insertrowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();

		return insertrowCount;

	}

	// pk를 통해 삭제
	public int deleteUserInfo(int u_no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_DELETE);

		pstmt.setInt(1, u_no);

		int deleterowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();

		return deleterowCount;
	}

	public int updateUserInfo(UserInfo userInfo) throws Exception {
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_UPDATE);
		/*
		 * private int u_no; //회원번호 - pk private String u_id; //아이디 - 변경불가 private
		 * String u_pw; //비밀번호 private String u_name; //이름 private String u_email; //이메일
		 * private int u_phone; //휴대폰번호 private String u_address; //주소 private int
		 * u_birth; //생년월일 private String u_job; //직업 private Date u_joindate;
		 * //java.util.Date - 변경불가
		 */
		pstmt.setString(1, userInfo.getU_pw());
		pstmt.setString(2, userInfo.getU_name());
		pstmt.setString(3, userInfo.getU_email());
		pstmt.setString(4, userInfo.getU_phone());
		pstmt.setString(5, userInfo.getU_address());
		pstmt.setInt(6, userInfo.getU_birth());
		pstmt.setString(7, userInfo.getU_job());
		pstmt.setInt(8, userInfo.getU_no());

		int updaterowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updaterowCount;

	}

	public UserInfo selectByNo(int u_no) throws Exception {

		UserInfo findUserInfoId = null;

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_SELECT_BY_NO);
		pstmt.setInt(1, u_no);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			/* 
			 * private int u_no; //회원번호 - pk private String u_id; //아이디 - 변경불가 private
			 * String u_pw; //비밀번호 private String u_name; //이름 private String u_email; //이메일
			 * private int u_phone; //휴대폰번호 private String u_address; //주소 private int
			 * u_birth; //생년월일 private String u_job; //직업 private Date u_joindate;
			 * //java.util.Date - 변경불가
			 */
			
			findUserInfoId = new UserInfo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"),
					rs.getString("u_name"), rs.getString("u_email"), rs.getString("u_phone"), rs.getString("u_address"),
					rs.getInt("u_birth"), rs.getString("u_job"),
					rs.getDate("u_joindate"));/* sql.date는 상위(util.date)로 자동캐스팅 */
			
		}
		rs.close();
		pstmt.close(); // 이 pstmt는 이미 sql문을 가지고 있으므로, 또
		con.close();
		return findUserInfoId;

	}
	
	//아이디로 회원 한명 찾기
	public UserInfo selectById(String u_id) throws Exception{
		UserInfo selectUserInfoId = null;

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_SELECT_BY_ID);
		pstmt.setString(1, u_id);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			selectUserInfoId = new UserInfo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"),
					rs.getString("u_name"), rs.getString("u_email"), rs.getString("u_phone"), rs.getString("u_address"),
					rs.getInt("u_birth"), rs.getString("u_job"),
					rs.getDate("u_joindate"));
		}
		
		rs.close();
		pstmt.close(); 
		con.close();
		
		
		return selectUserInfoId;
	}
	
	
	
	
	
	//아이디 찾기
	public UserInfo findByEmail(String u_email) throws Exception {
		UserInfo findUserInfo = null;

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_FIND_BY_ID);
		pstmt.setString(1, u_email);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			/*
			 * private int u_no; //회원번호 - pk private String u_id; //아이디 - 변경불가 private
			 * String u_pw; //비밀번호 private String u_name; //이름 private String u_email; //이메일
			 * private int u_phone; //휴대폰번호 private String u_address; //주소 private int
			 * u_birth; //생년월일 private String u_job; //직업 private Date u_joindate;
			 * //java.util.Date - 변경불가
			 */
			findUserInfo = new UserInfo(0, rs.getString("u_id"), 
					null,
					null, 
					null, 
					null, 
					null,
					0, 
					null,
					null);
		}
			/*
			findUserInfo = new UserInfo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"),
					rs.getString("u_name"), rs.getString("u_email"), rs.getInt("u_phone"), rs.getString("u_address"),
					rs.getInt("u_birth"), rs.getString("u_job"),
					rs.getDate("u_joindate"));/* sql.date는 상위(util.date)로 자동캐스팅 
												
		}
		*/
		rs.close();
		pstmt.close(); // 이 pstmt는 이미 sql문을 가지고 있으므로, 또
		con.close();
		return findUserInfo;

	}

		//비밀번호 찾기
			public UserInfo findByPW(String u_id ,String u_email) throws Exception {
				UserInfo findUserInfo = null;
	
				Connection con = this.dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_SELECT_BY_PW);
				pstmt.setString(1, u_id);
				pstmt.setString(2, u_email);
	
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					findUserInfo = new UserInfo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"),
							rs.getString("u_name"), rs.getString("u_email"), rs.getString("u_phone"), rs.getString("u_address"),
							rs.getInt("u_birth"), rs.getString("u_job"),
							rs.getDate("u_joindate"));
				}
				rs.close();
				pstmt.close(); 
				con.close();
				return findUserInfo;
	
			}
	/*		//비밀번호 찾기
			public String findByPW(String u_id ,String u_email) throws Exception {
				//UserInfo findUserInfo = null;
				String findUserPw = null;
				Connection con = this.dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_SELECT_BY_PW);
				pstmt.setString(1, u_id);
				pstmt.setString(2, u_email);
				
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					findUserPw = 
							rs.getString("u_pw");		
				}
				rs.close();
				pstmt.close(); 
				con.close();
				return findUserPw;
				
			}*/
	
		
		
		
		
	// 관리자가 서비스에서 사용하게 될 부분
	public List<UserInfo> selectAll() throws Exception {

		// String selectAllSql = "select * from userInfo";
		List<UserInfo> userInfoList = new ArrayList<UserInfo>();

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserInfoSQL.USERINFO_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			/*
			 * private int u_no; //회원번호 - pk private String u_id; //아이디 - 변경불가 private
			 * String u_pw; //비밀번호 private String u_name; //이름 private String u_email; //이메일
			 * private int u_phone; //휴대폰번호 private String u_address; //주소 private int
			 * u_birth; //생년월일 private String u_job; //직업 private Date u_joindate;
			 * //java.util.Date - 변경불가
			 */

			userInfoList.add(new UserInfo(rs.getInt("u_no"), rs.getString("u_id"), rs.getString("u_pw"),
					rs.getString("u_name"), rs.getString("u_email"), rs.getString("u_phone"), rs.getString("u_address"),
					rs.getInt("u_birth"), rs.getString("u_job"),
					rs.getDate("u_joindate")/* sql.date는 상위(util.date)로 자동캐스팅 */
			));

		}
		rs.close();
		pstmt.close();
		con.close();

		return userInfoList;

	}

}