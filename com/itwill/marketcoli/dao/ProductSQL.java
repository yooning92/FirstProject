package com.itwill.marketcoli.dao;

public class ProductSQL {

	//SQL 문장을 채워서 사용하세요

	public static final String PRODUCT_INSERT 
	= "insert into product values (product_p_no_seq.nextval,?,?,?,?,?)";

public static final String PRODUCT_UPDATE 
	= "update product set p_name=?,p_price=?,p_exp=?,p_category_b=?,p_category_s=? where p_no=?";

public static final String PRODUCT_DELETE 
	= "delete from product where p_no=?";

public static final String PRODUCT_SELECT_BY_NO 
	= "select * from product where p_no=? ";

public static final String PRODUCT_SELECT_ALL 
	= "select * from product";




/************************상품카테고리 Select ************************/
//대분류
public static final String PRODUCT_SELECT_BY_CATEGORY_B
							= "select * from product where p_category_b=? ";

//소분류
public static final String PRODUCT_SELECT_BY_CATEGORY_S
							= "select * from product where p_category_s=? ";
}