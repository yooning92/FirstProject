package com.itwill.marketcoli.dto;

import java.util.Date;

/*//
이름         널?       유형            
---------- -------- ------------- 
U_NO       NOT NULL NUMBER(10)    
U_ID       NOT NULL VARCHAR2(10)  
U_PW       NOT NULL VARCHAR2(20)  
U_NAME     NOT NULL VARCHAR2(50)  
U_EMAIL    NOT NULL VARCHAR2(40)  
U_PHONE    NOT NULL NUMBER(11)    
U_ADDRESS  NOT NULL VARCHAR2(100) 
U_BIRTH    NOT NULL NUMBER(8)     
U_JOB               VARCHAR2(20)  
U_JOINDATE NOT NULL DATE    
 */

public class UserInfo {

	private int u_no;			//회원번호
	private String u_id;		//아이디
	private String u_pw;		//비밀번호
	private String u_name;		//이름
	private String u_email;		//이메일
	private String u_phone;		//휴대폰번호
	private String u_address;	//주소
	private int u_birth;		//생년월일
	private String u_job;		//직업
	private Date u_joindate;	//java.util.Date
	
	public UserInfo() {

	}

	public UserInfo(int u_no, String u_id, String u_pw, String u_name, String u_email, String u_phone, String u_address,
			int u_birth, String u_job, Date u_joindate) {
		super();
		this.u_no = u_no;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_address = u_address;
		this.u_birth = u_birth;
		this.u_job = u_job;
		this.u_joindate = u_joindate;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public int getU_birth() {
		return u_birth;
	}

	public void setU_birth(int u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_job() {
		return u_job;
	}

	public void setU_job(String u_job) {
		this.u_job = u_job;
	}

	public Date getU_joindate() {
		return u_joindate;
	}

	public void setU_joindate(Date u_joindate) {
		this.u_joindate = u_joindate;
	}

	@Override
	public String toString() {
		return "UserInfo [u_no=" + u_no + ", u_id=" + u_id + ", u_pw=" + u_pw + ", u_name=" + u_name + ", u_email="
				+ u_email + ", u_phone=" + u_phone + ", u_address=" + u_address + ", u_birth=" + u_birth + ", u_job="
				+ u_job + ", u_joindate=" + u_joindate + "]";
	}

	
	
}
