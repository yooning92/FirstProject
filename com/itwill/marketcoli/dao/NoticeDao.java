package com.itwill.marketcoli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.marketcoli.common.DataSource;
import com.itwill.marketcoli.dto.Notice;



public class NoticeDao {
	private DataSource dataSource;

	public NoticeDao() {
		dataSource = new DataSource();
	}

	//공지사항 입력 - 관리자
	public int insertNotice(Notice notice) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(NoticeSQL.NOTICE_INSERT);

		/*
			private int n_no; //공지 번호 - sequence value
			private String n_title; //공지 제목
			private Date n_date; //공지 작성일자 - sysdate
			private String n_content; //공지 내용
			
			//'카테고리'는 추후에 추가해보자. 왜냐, 테이블 수정 필요
		*/
		pstmt.setString(1, notice.getN_title());
		pstmt.setString(2, notice.getN_content());

		int insertRowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		return insertRowCount;

	}
	
	//공지사항 수정 - 관리자
	public int updateNotice(Notice notice) throws Exception {

		// guest_date제외하고 update, 게시판의 date는 수정하지 않는다.
		//String updateSql = "update notice set guest_name=?, guest_email=? ,guest_homepage=? ,guest_title=? ,guest_content=? where guest_no=?";

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(NoticeSQL.NOTICE_UPDATE);
		/*
		"update notice set n_title = ?,"
		+ "                    n_date = sysdate,"
		+ "                    n_content = ?"
		+ "                    where n_no = ?";
		*/
		pstmt.setString(1, notice.getN_title());
		pstmt.setString(2, notice.getN_content());
		pstmt.setInt(3, notice.getN_no());

		int updaterowCount = pstmt.executeUpdate();

		pstmt.close();
		con.close();

		return updaterowCount;
	}
	
	//공지사항 삭제(PK) - 관리자
	public int deleteNotice(int n_no) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(NoticeSQL.NOTICE_DELETE);

		pstmt.setInt(1, n_no);

		int deleterowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();

		return deleterowCount;
	}
	
	//공지사항 선택 (PK, 목록에서 선택) - 관리자, 고객
	public Notice selectByNoticeNo(int n_no) throws Exception {

		Notice findNotice = null;
		
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(NoticeSQL.NOTICE_SELECT_BY_NO);

		pstmt.setInt(1, n_no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			findNotice = new Notice(rs.getInt("n_no"),
									rs.getString("n_title"),
									rs.getDate("n_date"),
									rs.getString("n_content"));
		}
		rs.close();
		pstmt.close();
		con.close();

		return findNotice;
	}
	
	//공지사항 전체선택 (목록 전체보여주기) - 관리자, 고객
	public List<Notice> selectAll() throws Exception{
		List<Notice> noticeList = new ArrayList<Notice>();
		
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(NoticeSQL.NOTICE_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			noticeList.add(new Notice(rs.getInt("n_no"),
										rs.getString("n_title"),
										rs.getDate("n_date"),
										rs.getString("n_content")));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return noticeList;
	}
	
}
