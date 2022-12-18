desc userinfo;
desc product;
desc cart;
desc orders;
desc order_item;
desc notice;
desc review;

/*************USERINFO(회원)**************/
desc userinfo;

--총회원 정보<<관리자용>>select All
select * from userinfo;
--select
--이메일을 이용하여 아이디 찾기 
select u_id from userinfo where u_email = 'e@www.japan.com';
--유저 아이디와 이메일을 이용하여 비밀번호 찾기 
select u_pw from userinfo where u_id = 'itwill5' and u_email = 'e@www.japan.com';
--아이디로 회원 한명 조회 selectByID
select * from userinfo where u_id = 'itwill1';

--update 
--회원정보 수정 
update userinfo set u_id = 'itwill5', 
u_pw = '5555', 
u_name = '도요토미', 
u_email = 'e@www.japan.com', 
u_phone = '5555555555', 
u_address = '몽골', 
u_birth = '20020202',
u_job = '독립운동가'
where u_no = '5';

--delite
--회원탈퇴
delete userinfo where u_id = 'itwill8';



/*************PRODUCT(상품)**************/
--select All
--상품 전체 조회
select *from product;
--select
--상품 이름을 이용해 검색
select * from product where p_name = '꿀사과';
--작은카테고릴 이용해 검색
select * from product where p_category_s = '과일';


--update
--상품 가격 변경
update product set p_price = 6000 where P_name ='사과' and p_no =17;


--delete
--상품 삭제
delete product where  p_name ='꿀사과';
rollback;


/*************CART(장바구니)**************/


--select
-- 카트 + 상품 cart 전체 조회
select c.c_no, c.c_qty, c.p_no, p.p_name, p.p_price, c.u_no from cart c join product p on p.p_no = c.p_no; 
--유저 번호로 카트 리스트 조회
select * from cart where u_no=3;


--update
-- 유저 번호로 상품 수량 변경
update cart set c_qty = 15 where u_no = 5; 
-- 유저 번호로 상품 변경
update cart set p_no = 10 where u_no = 3; 
--유저 번호와 상품번호로 상품 수량 1개 증가
update cart set c_qty = c_qty+1 where u_no = 4 and p_no = 8;

--delete
--1번 카트 삭제
delete from cart where c_no = 1; 
--유저 번호로 카트 삭제
delete from cart where u_no = 1; 

/***********ORDERS(주문)**********/

--select <<주문 조회>>
--유저아이디를 이용하여 주문 전체조회
 select *from orders where U_id = 'itwill5';
--주문번호와 유저아이디를 이용하여 주문 찾기 +상품출력
select * from orders o join order_item oi on o.o_no=oi.o_no where o.U_id = 'itwill5' and o.o_no =62 ;
 


--delete
--주문번호를 이용한 주문한개 취소 + 주문상세 여러개(ordersdetail)같이삭제
delete orders where o_no=63;
--유저 아이디itwill1 의 주문번호 전체 삭제
delete from order_item where o_no in(select o_no from orders where userid='itwill1');

/***********Order_Item**********/

--select
--주문번호를 이용한 주문상세 찾기
select * from order_item where o_no = 60;

--update
--주문번호를 이용해서 상품수량 변경
 update order_item set OI_QTY = 8  where  P_NO =13 and O_no=70;

--delete
--주문상세에 품목 한개 삭제 
delete from order_item where od_no=1;


/***********NOTICE**********/
--select All
select * from notice;

--select
--공지 한개 찾기
select * from notice where n_no=5;

--update
update notice set n_title = '배송지연 안내',  
                    n_date = sysdate,
                    n_content = '안녕하세요! 마켓콜리 입니다. 마켓콜리를 사랑해주시고 아껴주신 고객님께 진심으로 감사드립니다. 현재 코로나 때문에 배송 많이 밀림 기다리셈.'
                    where n_no = 5;
                    
--delete
--공지사항 한개 삭제
delete notice where n_no = 2;



/***********REVIEW**********/

--select ALL
--전체 후기 조회
select * from review;

--select
--후기목록에서 회원번호로 조회
select * from review where u_no=1;
--후기목록에서 회원아이디로 조회
select * from (select * from review r
                join userinfo u
                on r.u_no = u.u_no)
where u_id='itwill4';
--상품별 후기 조회
select * from review where p_no=1;

--update
update review set r_image = 'ff.jpg', r_content='너무 맛있어요 최고!', r_rating='4' where u_no = 4;

--delete
--후기목록에서 유저번호로 나오는 리뷰 전체삭제
delete review where u_no = 1;


































