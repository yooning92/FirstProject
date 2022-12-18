package com.itwill.marketcoli.dao;

public class ReviewSQL {
	
	
	public static final String REVIEW_INSERT = "insert into review(R_NO, R_IMAGE, R_CONTENT, R_WDATE, R_RATING, P_NO, U_NO, U_NAME, O_NO,O_DATE )values (REVIEW_R_NO_SEQ.nextval,?,?,sysdate,?,?,?,?,?,?)";
	public static final String REVIEW_DELETE = "delete review where u_no = ?";
	
	//후기를 번호로 조회
	public static final String REVIEW_SELECT_R_NO = "select * from review where r_no=?";
	
	//후기를 회원아이디로 조회 -> 마이페이지에서 해당고객이 작성한 후기전체조회
	public static final String REVIEW_SELECT_ID_ALL = "select * from (select * from review r\r\n"
			+ "                join userinfo u\r\n"
			+ "                on r.u_no = u.u_no)\r\n"
			+ "where u_id=?";
	
	//후기를 상품번호로 조회 -> 상품페이지에서 해당상품별로 후기전체조회
	public static final String REVIEW_SELECT_BY_PRODUCT_NO=
			"select * from review where p_no=?";

	//후기번호로 후기 업데이트 -> (마이페이지,상품페이지의)후기리스트에서 후기선택 후 업데이트
	public static final String REVIEW_UPDATE_BY_REVIEW_NO=
			"update review set r_image = ?, r_content=?, r_rating=? where r_no = ?";

	
}
