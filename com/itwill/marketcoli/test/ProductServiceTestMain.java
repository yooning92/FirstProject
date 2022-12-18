package com.itwill.marketcoli.test;

import java.util.List;

import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.service.ProductService;


public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		ProductService productService = new ProductService();


		System.out.println("1.상품추가하기");
		Product insertProduct = new Product(0, "꿀사과", 10000, "사과를 한입먹으면", "채소/과일", "과일");
		System.out.println(">> insert count:" + productService.inserProduct(insertProduct));


		System.out.println("2.상품삭제하기"); 
		System.out.println(">> delect count:" + productService.deleteProdunt(56));

				
		System.out.println("3.상품수정하기"); 
		Product product = productService.productDetail(19);
		product.setP_name("사과");
		product.setP_price(3000);
		product.setP_exp("빨가면 사과~");
		System.out.println(">> update count:"+ productService.updateProduct(product));
		
		//상품1개보기-상세보기
		System.out.println("4.상품1개보기");
		System.out.println(productService.productDetail(10));
		
		
		//상품전체 보기 
		System.out.println("5.상품리스트 전체보기");
		System.out.println("1.상품넘버로 상세페이지 불러오기");
		System.out.println(productService.productDetail(18));
		
		System.out.println("2.상품리스트 전체보기");
		System.out.println("5.상품리스트 전체보기");
		System.out.println(productService.productList());
		
		
				
		/************************상품카테고리 Select ************************/
		
		//대분류-분류별 상품명, 가격 출력
		System.out.println("6-1.큰카테고리별 리스트 보기-부분");
		System.out.println(productService.categoryBMapList("정육/수산"));
		
		//대분류-분류별 전체 출력
		System.out.println("6-2.큰카테고리별 리스트 보기-전체");
		System.out.println(productService.categoryBList("정육/수산"));
		
		
		//소분류-분류별 상품명, 가격 출력
		System.out.println("7-1.소카테고리별 리스트 보기-부분");
		System.out.println(productService.categoryBList("과일"));
		
		//소분류-분류별 전체 출력
		System.out.println("7-1.소카테고리별 리스트 보기-전체");
		System.out.println(productService.categoryBList("과일"));
			

	}

}
