package com.itwill.marketcoli.test;

import com.itwill.marketcoli.dto.Notice;
import com.itwill.marketcoli.service.NoticeService;

public class NoticeServiceTestMain {

	public static void main(String[] args) throws Exception{
		NoticeService noticeService = new NoticeService();
		
		
		
		//공지사항 입력
		Notice newNotice = new Notice(4, "공지가 있습니다!!!", null, "지금 집에 가고싶어요!!!!");
		System.out.println("공지사항 입력 >>"+noticeService.insertNotice(newNotice));
		
		
		
		//공지사항 수정
		Notice updateNotice = new Notice(3, "공지가 달라졌어요!!!", null, "갑자기 배고파요!!");
		System.out.println("공지사항 수정 >>"+noticeService.updateNotice(updateNotice));
		
		
		//공지사항 삭제
		System.out.println("공지사항 삭제 >>"+noticeService.deleteNotice(5));
		
		//공지사항 선택 -관리자, 고객
		System.out.println(noticeService.selectByNoticeNo(8));
		
		//공지사항 전체선택 - 관리자, 고객
		System.out.println(noticeService.selectAll());
	
		
		
		
		
		
		
		
		
		

	}

}
