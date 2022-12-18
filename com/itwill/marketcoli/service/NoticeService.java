package com.itwill.marketcoli.service;

import java.util.List;

import com.itwill.marketcoli.dao.NoticeDao;
import com.itwill.marketcoli.dto.Notice;

public class NoticeService {
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new NoticeDao();
	}
	
	//공지사항 입력 - 관리자
	public int insertNotice(Notice notice) throws Exception {
		
		return noticeDao.insertNotice(notice);
	}
	
	
	//공지사항 수정 - 관리자
	public int updateNotice(Notice notice) throws Exception {
		
		return noticeDao.updateNotice(notice);
	}
	
	//공지사항 삭제(pk) - 관리자
	public int deleteNotice(int n_no) throws Exception {
		
		return noticeDao.deleteNotice(n_no);
	}
	
	//공지사항 선택(pk, 목록에서 선택) - 관리자, 고객
	public Notice selectByNoticeNo(int n_no) throws Exception {
		
		return noticeDao.selectByNoticeNo(n_no);
	}
	
	//공지사항 전체선택 - 관리자, 고객
	public List<Notice> selectAll() throws Exception{
		
		return noticeDao.selectAll();
	}
	
	
	
	
	
	
	
	
	
}
