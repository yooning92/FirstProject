package com.itwill.marketcoli.service;

import java.util.List;
import java.util.Map;

import com.itwill.marketcoli.dao.ProductDao;
import com.itwill.marketcoli.dto.Product;

public class ProductService {
	
	private ProductDao productDao;

	public ProductService() {
		productDao = new ProductDao();
	}
	
	public int inserProduct(Product product) throws Exception {
		return productDao.insertProduct(product);	
	}
	
	public int deleteProdunt(int p_no) throws Exception {
		return productDao.deleteProduct(p_no);
	}
	
	public int updateProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}
	
	
	//상품 1개보기-상세보기
	public Product productDetail(int p_no) throws Exception {
		return productDao.selectByNo(p_no);
	}
	
	//전체상품보기
	public List<Product> productList() throws Exception {
		return productDao.selsectAll();
	}
	
	
	
	
	
	/************************상품카테고리 Select ************************/
	//대분류-분류별 상품명, 가격 출력
		public List<Map> categoryBMapList(String p_category_b) throws Exception {
		List<Map> productList=productDao.selectCategoryBMap(p_category_b);
		return productList;
	}	
	
	//대분류-분류별 전체 출력
	public List<Product> categoryBList(String p_category_b) throws Exception {
		return productDao.selectCategoryB(p_category_b);
	}
	
	
	//소분류-분류별 상품명, 가격 출력
	public List<Map> categorySMapList(String p_category_s) throws Exception {
	List<Map> productList=productDao.selectCategorySMap(p_category_s);
	return productList;
}	
			
	//소분류-분류별 전체 출력
	public List<Product> categorySList(String p_category_s) throws Exception {
		return productDao.selectCategoryS(p_category_s);
	}

}//
