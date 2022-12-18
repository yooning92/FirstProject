package com.itwill.marketcoli.dto;

/*

		내용 확인 필요

*/

/*
이름      널?       유형           
------- -------- ------------ 
C_NO    NOT NULL NUMBER(10)   
C_QTY            NUMBER(10)   
P_NO             NUMBER(10)   
U_NO             NUMBER(10)   
 */
public class Cart {
	
	private int c_no;		//장바구니번호(pk)
	private int c_qty;		//상품수량
	private int p_no;		//상품번호(fk)
	private int u_no;		//회원번호(fk)
	
	public Cart() {

	}

	public Cart(int c_no, int c_qty, int p_no, int u_no) {
		this.c_no = c_no;
		this.c_qty = c_qty;
		this.p_no = p_no;
		this.u_no = u_no;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getC_qty() {
		return c_qty;
	}

	public void setC_qty(int c_qty) {
		this.c_qty = c_qty;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}

	@Override
	public String toString() {
		return "Cart [c_no=" + c_no + ", c_qty=" + c_qty + ", p_no=" + p_no + ", u_no=" + u_no + "]";
	}
	
}