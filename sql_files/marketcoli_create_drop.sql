DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE inquiry CASCADE CONSTRAINTS;

DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;

DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;

DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

CREATE TABLE userinfo(
		u_no                          		NUMBER(10)		 NOT NULL,
		u_id                          		VARCHAR2(10)		NOT NULL,
		u_pw                          		VARCHAR2(20)		 NOT NULL,
		u_name                        		VARCHAR2(50)		 NOT NULL,
		u_email                       		VARCHAR2(40)		 NOT NULL,
		u_phone                       		varchar2(11)		 NOT NULL,
		u_address                     		VARCHAR2(100)		 NOT NULL,
		u_birth                       		NUMBER(8)		 NOT NULL,
		u_job                         		VARCHAR2(20)		 DEFAULT Null		 NULL ,
		u_joindate                    		DATE		 DEFAULT sysdate		 NOT NULL
);

DROP SEQUENCE userinfo_u_no_SEQ;

CREATE SEQUENCE userinfo_u_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 DEFAULT Null		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_exp                         		VARCHAR2(1000)		 DEFAULT Null		 NULL ,
		p_category_b                  		VARCHAR2(50)		 NULL ,
		p_category_s                  		VARCHAR2(50)		 NULL
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE orders(
		o_no                          		NUMBER(10)		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_price                       		NUMBER(10)		 NULL ,
		u_id                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

--
--CREATE TABLE cart(
--		c_no                          		NUMBER(10)		 DEFAULT 0		 NULL ,
--		c_qty                         		NUMBER(10)		 NULL ,
--		p_no                          		NUMBER(10)		 NULL ,
--		p_name                        		VARCHAR2(50)		 NULL ,
--		p_price                       		NUMBER(10)		 NULL ,
--		u_no                          		NUMBER(10)		 NULL 
--);

CREATE TABLE cart(
		c_no                          		NUMBER(10)		 DEFAULT 0		 NULL ,
		c_qty                         		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		
		u_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE notice(
		n_no                          		NUMBER(10)		 NULL ,
		n_title                        		VARCHAR2(100)		 NULL ,
		n_date                        		DATE		 DEFAULT sysdate		 NULL ,
		n_content                     		VARCHAR2(3000)		 NULL 
);

DROP SEQUENCE notice_n_no_SEQ;

CREATE SEQUENCE notice_n_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE order_item(
		oi_no                         		NUMBER(10)		 NULL ,
		oi_qty                        		NUMBER(10)		 NULL ,
		o_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE order_item_oi_no_SEQ;

CREATE SEQUENCE order_item_oi_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

--u_no -> u_id변경
CREATE TABLE inquiry(
		i_no                          		NUMBER(20)		 NULL ,
		i_title                       		VARCHAR2(100)		 NOT NULL,
		i_date                        		DATE		 DEFAULT sysdate		 NOT NULL,
		i_content                     		VARCHAR2(2000)		 NULL ,
		u_id                          		VARCHAR2(10)		 NULL ,
		u_phone                       		NUMBER(20)		 NOT NULL,
		u_email                       		VARCHAR2(40)		 NOT NULL
);

DROP SEQUENCE inquiry_i_no_SEQ;

CREATE SEQUENCE inquiry_i_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE review(
		r_no                          		NUMBER(10)		 NULL ,
		r_image                       		VARCHAR2(10)		 NULL ,
		r_content                     		VARCHAR2(3000)		 NOT NULL,
		r_wdate                       		DATE		 DEFAULT sysdate		 NOT NULL,
		r_rating                      		NUMBER(10)		 NOT NULL,
		p_no                          		NUMBER(10)		 NOT NULL,
		u_no                          		NUMBER(10)		 NULL ,
		u_name                        		VARCHAR2(50)		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL 
);

DROP SEQUENCE review_r_no_SEQ;

CREATE SEQUENCE review_r_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (u_no);
ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_uq UNIQUE (u_id); --수정

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);


ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (u_id) REFERENCES userinfo (u_id) ON DELETE CASCADE;--pk삭제시, fk삭제됨

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no) ON DELETE CASCADE;--pk삭제시, fk삭제됨
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no)ON DELETE CASCADE;--pk삭제시, fk삭제됨

ALTER TABLE notice ADD CONSTRAINT IDX_notice_PK PRIMARY KEY (n_no);


ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_PK PRIMARY KEY (oi_no);
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK0 FOREIGN KEY (o_no) REFERENCES orders (o_no) ON DELETE CASCADE;--pk삭제시, fk삭제됨
ALTER TABLE order_item ADD CONSTRAINT IDX_order_item_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no) ON DELETE CASCADE;--pk삭제시, fk삭제됨

ALTER TABLE inquiry ADD CONSTRAINT IDX_inquiry_PK PRIMARY KEY (i_no);
ALTER TABLE inquiry ADD CONSTRAINT IDX_inquiry_FK0 FOREIGN KEY (u_id) REFERENCES userinfo (u_id);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (r_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

commit;
