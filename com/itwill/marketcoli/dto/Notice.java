package com.itwill.marketcoli.dto;

import java.util.Date;

/*
이름        널?       유형             
--------- -------- -------------- 
N_NO      NOT NULL NUMBER(10)     
N_TITLE            VARCHAR2(100)  
N_DATE             DATE           
N_CONTENT          VARCHAR2(3000)
 */
public class Notice {

	private int n_no; //공지 번호 - sequence value
	private String n_title; //공지 제목
	private Date n_date; //공지 작성일자 - sysdate
	private String n_content; //공지 내용

	//'카테고리'는 추후에 추가해보자. 왜냐, 테이블 수정 필요
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(int n_no, String n_title, Date n_date, String n_content) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_date = n_date;
		this.n_content = n_content;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	@Override
	public String toString() {
		return "Notice [n_no=" + n_no + ", n_title=" + n_title + ", n_date=" + n_date + ", n_content=" + n_content
				+ "]";
	}

}
