DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE inquiry CASCADE CONSTRAINTS;
DROP TABLE orderdetail CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE cart CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE product CASCADE CONSTRAINTS;
DROP TABLE userinfo CASCADE CONSTRAINTS;

CREATE TABLE userinfo(
		u_no                          		NUMBER(10)		 NOT NULL,
		u_id                          		VARCHAR2(10)		 NOT NULL,
		u_pw                          		VARCHAR2(20)		 NOT NULL,
		u_name                        		VARCHAR2(15)		 NOT NULL,
		u_email                       		VARCHAR2(40)		 NOT NULL,
		u_phone                       		VARCHAR2(20)		 NOT NULL,
		u_address                     		VARCHAR2(100)		 NOT NULL,
		u_birth                       		VARCHAR2(20)		 NOT NULL,
		u_job                         		VARCHAR2(20)		 DEFAULT Null		 NULL ,
		u_joindate                    		DATE		 DEFAULT sysdate		 NOT NULL
);

DROP SEQUENCE userinfo_u_no_SEQ;

CREATE SEQUENCE userinfo_u_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER userinfo_u_no_TRG
BEFORE INSERT ON userinfo
FOR EACH ROW
BEGIN
IF :NEW.u_no IS NOT NULL THEN
  SELECT userinfo_u_no_SEQ.NEXTVAL INTO :NEW.u_no FROM DUAL;
END IF;
END;


CREATE TABLE product(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 DEFAULT Null		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_exp                         		VARCHAR2(1000)		 DEFAULT Null		 NULL ,
		p_category_b                  		VARCHAR2(50)		 NULL ,
		p_category_s                  		NUMBER(10)		 NULL 
);

DROP SEQUENCE product_p_no_SEQ;

CREATE SEQUENCE product_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER product_p_no_TRG
BEFORE INSERT ON product
FOR EACH ROW
BEGIN
IF :NEW.p_no IS NOT NULL THEN
  SELECT product_p_no_SEQ.NEXTVAL INTO :NEW.p_no FROM DUAL;
END IF;
END;


CREATE TABLE orders(
		o_no                          		NUMBER(10)		 DEFAULT 0		 NULL ,
		o_date                        		DATE		 DEFAULT sysdate		 NULL ,
		o_state                       		VARCHAR2(30)		 NOT NULL,
		u_name                        		VARCHAR2(15)		 NOT NULL,
		u_phone                       		NUMBER(20)		 NOT NULL,
		u_address                     		VARCHAR2(100)		 NOT NULL,
		u_no                          		NUMBER(10)		 DEFAULT Null		 NOT NULL,
		p_no                          		NUMBER(10)		 NULL ,
		d_fee                         		NUMBER(10)		 DEFAULT 3000		 NULL ,
		d_memo                        		VARCHAR2(3000)		 NULL ,
		p_piece                       		NUMBER(10)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE orders_o_no_SEQ;

CREATE SEQUENCE orders_o_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER orders_o_no_TRG
BEFORE INSERT ON orders
FOR EACH ROW
BEGIN
IF :NEW.o_no IS NOT NULL THEN
  SELECT orders_o_no_SEQ.NEXTVAL INTO :NEW.o_no FROM DUAL;
END IF;
END;


CREATE TABLE cart(
		c_no                          		NUMBER(10)		 DEFAULT 0		 NULL ,
		c_qty                         		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NULL ,
		p_price                       		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE cart_c_no_SEQ;

CREATE SEQUENCE cart_c_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER cart_c_no_TRG
BEFORE INSERT ON cart
FOR EACH ROW
BEGIN
IF :NEW.c_no IS NOT NULL THEN
  SELECT cart_c_no_SEQ.NEXTVAL INTO :NEW.c_no FROM DUAL;
END IF;
END;


CREATE TABLE notice(
		n_no                          		NUMBER(10)		 NULL ,
		n_tite                        		VARCHAR2(100)		 NULL ,
		n_date                        		DATE		 DEFAULT sysdate		 NULL ,
		n_content                     		VARCHAR2(3000)		 NULL 
);

DROP SEQUENCE notice_n_no_SEQ;

CREATE SEQUENCE notice_n_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER notice_n_no_TRG
BEFORE INSERT ON notice
FOR EACH ROW
BEGIN
IF :NEW.n_no IS NOT NULL THEN
  SELECT notice_n_no_SEQ.NEXTVAL INTO :NEW.n_no FROM DUAL;
END IF;
END;


CREATE TABLE orderdetail(
		od_no                         		NUMBER(10)		 NULL ,
		p_piece                       		NUMBER(10)		 NULL ,
		u_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE orderdetail_od_no_SEQ;

CREATE SEQUENCE orderdetail_od_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER orderdetail_od_no_TRG
BEFORE INSERT ON orderdetail
FOR EACH ROW
BEGIN
IF :NEW.od_no IS NOT NULL THEN
  SELECT orderdetail_od_no_SEQ.NEXTVAL INTO :NEW.od_no FROM DUAL;
END IF;
END;


CREATE TABLE inquiry(
		i_no                          		NUMBER(20)		 NULL ,
		i_title                       		VARCHAR2(100)		 NOT NULL,
		i_date                        		DATE		 DEFAULT sysdate		 NOT NULL,
		i_content                     		VARCHAR2(2000)		 NULL ,
		u_no                          		VARCHAR2(10)		 NULL ,
		u_phone                       		NUMBER(20)		 NOT NULL,
		u_email                       		VARCHAR2(40)		 NOT NULL
);

DROP SEQUENCE inquiry_i_no_SEQ;

CREATE SEQUENCE inquiry_i_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER inquiry_i_no_TRG
BEFORE INSERT ON inquiry
FOR EACH ROW
BEGIN
IF :NEW.i_no IS NOT NULL THEN
  SELECT inquiry_i_no_SEQ.NEXTVAL INTO :NEW.i_no FROM DUAL;
END IF;
END;


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

CREATE TRIGGER review_r_no_TRG
BEFORE INSERT ON review
FOR EACH ROW
BEGIN
IF :NEW.r_no IS NOT NULL THEN
  SELECT review_r_no_SEQ.NEXTVAL INTO :NEW.r_no FROM DUAL;
END IF;
END;



ALTER TABLE userinfo ADD CONSTRAINT IDX_userinfo_PK PRIMARY KEY (u_no);

ALTER TABLE product ADD CONSTRAINT IDX_product_PK PRIMARY KEY (p_no);

ALTER TABLE orders ADD CONSTRAINT IDX_orders_PK PRIMARY KEY (o_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE orders ADD CONSTRAINT IDX_orders_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE cart ADD CONSTRAINT IDX_cart_PK PRIMARY KEY (c_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE cart ADD CONSTRAINT IDX_cart_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE notice ADD CONSTRAINT IDX_notice_PK PRIMARY KEY (n_no);

ALTER TABLE orderdetail ADD CONSTRAINT IDX_orderdetail_PK PRIMARY KEY (od_no);
ALTER TABLE orderdetail ADD CONSTRAINT IDX_orderdetail_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE orderdetail ADD CONSTRAINT IDX_orderdetail_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

ALTER TABLE inquiry ADD CONSTRAINT IDX_inquiry_PK PRIMARY KEY (i_no);
ALTER TABLE inquiry ADD CONSTRAINT IDX_inquiry_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE inquiry ADD CONSTRAINT IDX_Inquiry_Table_1 UNIQUE (u_id);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (r_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (u_no) REFERENCES userinfo (u_no);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK1 FOREIGN KEY (p_no) REFERENCES product (p_no);

commit;