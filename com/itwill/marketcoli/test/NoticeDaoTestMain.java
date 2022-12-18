package com.itwill.marketcoli.test;

import java.text.SimpleDateFormat;
import java.util.List;

import com.itwill.marketcoli.dao.NoticeDao;
import com.itwill.marketcoli.dto.Notice;

public class NoticeDaoTestMain {

	public static void main(String[] args) throws Exception {

		NoticeDao noticeDao = new NoticeDao();
		
		//공지사항 입력 - 관리자
		System.out.println("1.insertNotice");
		Notice insertNotice = new Notice(0, "공지 공지 공지합니다", null, "우리조 최고체고");
		System.out.println(noticeDao.insertNotice(insertNotice));

		//공지사항 수정 - 관리자
		System.out.println("2.updateNotice");
		Notice updateNotice = new Notice(4, "사이트 업데이트", null, "짜잔! 홈페이지 업데이트!");
		System.out.println(noticeDao.updateNotice(updateNotice));
		
		//공지사항 삭제(PK) - 관리자
		System.out.println("3.deleteNotice");
		System.out.println(noticeDao.deleteNotice(7));
		
		//공지사항 선택 (PK, 목록에서 선택) - 관리자, 고객
		System.out.println("4.selectByNoticeNo");
		Notice findNotice = noticeDao.selectByNoticeNo(4);
		System.out.println(findNotice);
		
		//공지사항 전체선택 (목록 전체보여주기) - 관리자, 고객
		System.out.println("5.selectAll");
		List<Notice> noticeList = noticeDao.selectAll();
		for (Notice notice : noticeList) {
			System.out.println(notice);
		}
		
	}
}
