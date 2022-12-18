desc userinfo;
desc product;
desc cart;
desc orders;
desc order_item;
desc notice;
desc review;

/*************USERINFO(회원)**************/
--userinfo insert(회원가입)
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill1', '1111', '김첨지', 'a@www.a.com', '11111', '사랑시고백구행복동','19500625',null,sysdate);
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill2', '2222', '박혁거세', 'b@www.b.com', '22222', 'egg','19001225','조류관찰자',sysdate);
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill3', '3333', '최배달', 'c@www.c.com', '33333', '부여성','19100102','배민라이더',sysdate);
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill4', '4444', '미륵', 'd@www.d.com', '44444', '감비아','15410131','목사',sysdate);
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill5', '5555', '도요토미', 'e@www.japan.com', '55555', '몽골','20020202','독립운동가',sysdate);
insert into userinfo(u_no, u_id, u_pw, u_name, u_email, u_phone, u_address, u_birth, u_job, u_joindate)
VALUES (userinfo_u_no_seq.nextval, 'itwill6', '6666', '히데요시', 'f@www.love.com', '66666', '그랜드캐년','19990808','해군장교',sysdate);

commit;

/*************PRODUCT(상품)**************/
--상품테이블 -> 구성항목(상품번호/상품명/상품가격/상품설명/상위카테고리/하위카테고리)

--채소/과일
--과일
insert into Product values(product_p_no_seq.nextval,'사과',2500,'빨가면 사과,사과는 맛있어!','채소/과일','과일');
insert into Product values(product_p_no_seq.nextval,'수박',9000,'줄그으면 수박이지!','채소/과일','과일');
insert into Product values(product_p_no_seq.nextval,'복숭아',5500,'나는 신비복숭아','채소/과일','과일');
insert into Product values(product_p_no_seq.nextval,'석류',3000,'미인은 석류를 좋아해~','채소/과일','과일');
insert into Product values(product_p_no_seq.nextval,'체리',8000,'동글동글 체리','채소/과일','과일');
--채소
insert into Product values(product_p_no_seq.nextval,'상추',2000,'세븐 친구 아닙니다','채소/과일','채소');
insert into Product values(product_p_no_seq.nextval,'깻잎',1000,'캣잎 아닙니다','채소/과일','채소');
insert into Product values(product_p_no_seq.nextval,'시금치',5000,'시금치','채소/과일','채소');
insert into Product values(product_p_no_seq.nextval,'양파',5000,'사랑 그게 뭔데','채소/과일','채소');
--정육/수산
--정육
insert into Product values(product_p_no_seq.nextval,'소고기',30000,'한우 냠, 맛있겠다','정육/수산','정육');
insert into Product values(product_p_no_seq.nextval,'돼지고기',20000,'꿀꿀','정육/수산','정육');
insert into Product values(product_p_no_seq.nextval,'닭고기',15000,'꼬기오 꼬꼬','정육/수산','정육');
insert into Product values(product_p_no_seq.nextval,'오리고기',15000,'꽉꽉?','정육/수산','정육');
--수산
insert into Product values(product_p_no_seq.nextval,'고등어',15000,'퍼덕퍼덕','정육/수산','수산');
insert into Product values(product_p_no_seq.nextval,'갈치',15000,'퍼더덕','정육/수산','수산');
insert into Product values(product_p_no_seq.nextval,'연어',15000,'퍼덕 퍼더덕?','정육/수산','수산');

commit;

/*************CART(장바구니)**************/
--장바구니 등록
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 4, 1, 1); 
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 7, 2, 1);
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 7, 3, 2);
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 8, 4, 2);
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 9, 5, 3);
insert into cart(c_no, c_qty, p_no, u_no) values(cart_c_no_seq.nextval, 10, 6, 3);

commit;

/***********ORDERS(주문) ORDER_ITEM(주문상세)**********/
--유저아이디'itwill1' << 제품 1번 3개 제품2번 2개>>
insert into orders(o_no,o_date,o_price,U_id) values(ORDERS_O_NO_SEQ.nextval,sysdate-1,42000,'itwill1');
    --제품번호 1번 3개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,3,orders_o_no_SEQ.currval,1);
    --제품번호 2번 2개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,2);
    
--유저아이디'itwill2' << 제품 3번 2개 제품4번 5개>>
insert into orders(o_no,o_date,o_price,U_id) values(ORDERS_O_NO_SEQ.nextval,sysdate+3,72000,'itwill2');
    --제품번호 1번 3개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,3);
    --제품번호 2번 2개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,5,orders_o_no_SEQ.currval,4);
        
--유저아이디'itwill3' << 제품 5번 2개 제품6번 2개>>
insert into orders(o_no,o_date,o_price,U_id) values(ORDERS_O_NO_SEQ.nextval,sysdate,52000,'itwill3');
    --제품번호 1번 3개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,5);
    --제품번호 2번 2개
insert into order_item(oi_no,oi_qty,o_no,p_no)
    values(order_item_oi_no_SEQ.nextval,2,orders_o_no_SEQ.currval,6);

    commit;
    
/***********NOTICE(공지)**********/
-- insert
insert into notice(n_no, n_title, n_date, n_content) 
VALUES(notice_n_no_seq.nextval, 
                        '안내문', 
                         sysdate, 
                        '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 저희 마켓콜리 상품 구매 시 회원가입이 필요합니다. 회원가입 절차 진행 후 구매 부탁드립니다.');
insert into notice(n_no, n_title, n_date, n_content) 
VALUES(notice_n_no_seq.nextval, 
                        '배송 안내', 
                         sysdate, 
                         '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 오전에 주문 시 당일 출고되어 배송됩니다.');
insert into notice(n_no, n_title, n_date, n_content) 
VALUES(notice_n_no_seq.nextval, 
                        '긴급공지', 
                         sysdate, 
                        '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 현재 코로나 사태로 인한 배송량이 급증하여 당일출고가 어려운점 안내드립니다. 회원님들의 양해 부탁드립니다. 항상 최선을 다하는 마켓콜리가 되겠습니다. ');
                        
commit;

/***********REVIEW(리뷰)**********/
--Review insert
insert into review(R_NO, R_IMAGE, R_CONTENT, R_WDATE,
                        R_RATING, P_NO, U_NO, U_NAME, O_DATE )
                        values (REVIEW_R_NO_SEQ.nextval,'r1.png','정말 맛있어요!!',sysdate,5,'1','1','김두유',sysdate-7);

insert into review(R_NO, R_IMAGE, R_CONTENT, R_WDATE,
                        R_RATING, P_NO, U_NO, U_NAME, O_DATE )
                        values (REVIEW_R_NO_SEQ.nextval,'r2.png','정말 맛있어요!!',sysdate,4,'2','2','둘째임',sysdate-7);

insert into review(R_NO, R_IMAGE, R_CONTENT, R_WDATE,
                        R_RATING, P_NO, U_NO, U_NAME, O_DATE )
                        values (REVIEW_R_NO_SEQ.nextval,'d4.png','정말 맛있어요!!',sysdate,3,'4','4','셋째임',sysdate-7);



commit;





























