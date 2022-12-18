package com.itwill.marketcoli.test;

import java.util.List;
import java.util.Map;

import com.itwill.marketcoli.dao.ProductDao;
import com.itwill.marketcoli.dto.Product;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDao productDao = new ProductDao();
		
		System.out.println("1.insertProduct");
		Product insertProduct=new Product(0, "딸기",9000, "새콤달콤....", "채소/과일", "과일");		
		int rowCount = productDao.insertProduct(insertProduct);	

		
		System.out.println("2.deleteProduct");
		rowCount = productDao.deleteProduct(16);

		System.out.println("3.updateProduct");	
		Product updateProduct = new Product(17,"사과",3000,"빨가면 사과","채소/과일","과일");
		rowCount = productDao.updateProduct(updateProduct);
		 			
		
		System.out.println("4.selectByNo");
		Product findProduct = productDao.selectByNo(15);
		System.out.println(findProduct);


		System.out.println("5.selsectAll");
		List<Product> productList = productDao.selsectAll();
		for (Product product : productList) {
			System.out.println(product);
		}
		
		
		
		/************************상품카테고리 Select ************************/
		//대분류-분류별 상품명, 가격 출력
		List<Map> categoryBMapList = productDao.selectCategoryBMap("채소/과일");
		System.out.println(categoryBMapList);
		
		//대분류-분류별 전체 출력
		List<Product> categorySBList = productDao.selectCategoryB("채소/과일");
		System.out.println(categorySBList);

		
		//소분류-분류별 상품명, 가격 출력
		List<Map> categorySMapList = productDao.selectCategorySMap("정육");
		System.out.println(categorySMapList);
		
		
		//소분류-분류별 전체 출력
		List<Product> categorySList = productDao.selectCategoryS("정육");
		System.out.println(categorySList);
		

	}

}
