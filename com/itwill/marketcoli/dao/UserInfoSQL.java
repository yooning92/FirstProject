package com.itwill.marketcoli.dao;

public class UserInfoSQL {
	
	//SQL 문장을 채워서 사용하세요
	
	public static final String USERINFO_INSERT
	 = "insert into userinfo values(userinfo_u_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

	public static final String USERINFO_UPDATE 
	 = "update userinfo set u_pw = ?, u_name = ?, u_email = ?, u_phone = ?, u_address = ?, u_birth = ?, u_job = ? where u_no = ?";
	
	public static final String USERINFO_DELETE 
	 = "delete from userinfo where u_no = ?";
	
	public static final String USERINFO_FIND_BY_ID
	 = "select u_id from userinfo where u_email = ?";
	
	public static final String USERINFO_SELECT_BY_PW 
	 = "select * from userinfo where u_id = ? and u_email = ?";
	
	public static final String USERINFO_SELECT_ALL 
	 = "select * from userinfo";

	public static final String USERINFO_SELECT_BY_NO
	 = "select *from userinfo where u_no = ?";
	
	public static final String USERINFO_SELECT_BY_ID = "select * from userinfo where u_id = ?";
}
