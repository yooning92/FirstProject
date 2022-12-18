package com.itwill.marketcoli.dao;

public class NoticeSQL {	
	//공지사항 입력 - 관리자
	public static final String NOTICE_INSERT=
			"insert into notice(n_no, n_title, n_date, n_content)"
			+ "VALUES(notice_n_no_seq.nextval,"
			+ "                         ?,"
			+ "                         sysdate,"
			+ "                         ?)";
	/*	"insert into notice(n_no, n_title, n_date, n_content)"
		+ "VALUES(notice_n_no_seq.nextval,"
		+ "                        '배송지연 안내',"
		+ "                         sysdate,"
		+ "                        '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 현재 코로나 때문에 배송 많이 밀림 기다리셈.')";
	*/
	//공지사항 수정 - 관리자
	public static final String NOTICE_UPDATE=
			"update notice set n_title = ?,"
					+ "                    n_date = sysdate,"
					+ "                    n_content = ?"
					+ "                    where n_no = ?";
	/*	"update notice set n_title = '배송지연 안내',"
		+ "                    n_date = sysdate,"
		+ "                    n_content = '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 현재 코로나 때문에 배송 많이 밀림 기다리셈.'"
		+ "                    where n_no = 5;";
	 */
	
	//공지사항 삭제 - 관리자
	public static final String NOTICE_DELETE=
			"delete notice where n_no = ?";
	
	//공지사항 선택 (목록에서 선택) - 관리자, 고객
	public static final String NOTICE_SELECT_BY_NO=
			"select * from notice where n_no=?";
	
	//공지사항 전체선택 (목록 전체보여주기) - 관리자, 고객
	public static final String NOTICE_SELECT_ALL=
			"select * from notice";
	

}
