package com.itwill.marketcoli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itwill.marketcoli.common.DataSource;
import com.itwill.marketcoli.dto.Orders;
import com.itwill.marketcoli.dto.Product;
import com.itwill.marketcoli.dto.Review;
import com.itwill.marketcoli.dto.UserInfo;

public class ReviewDao {

	private DataSource dataSource;
	public ReviewDao() {
		dataSource = new DataSource();
	}
	public int insertReview (Review review) throws Exception{
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_INSERT);
		
		pstmt.setString(1, review.getR_image());
		pstmt.setString(2, review.getR_content());
		pstmt.setInt(3, review.getR_rating());

		pstmt.setInt(4,review.getProduct().getP_no());
		pstmt.setInt(5, review.getUserInfo().getU_no());
		pstmt.setString(6, review.getUserInfo().getU_name());
		
		pstmt.setInt(7, review.getOrders().getO_no());
		pstmt.setDate(8, new java.sql.Date(review.getOrders().getO_date().getTime()) );
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return rowCount;
		
	}
	


	public int updateByReviewNo(Review review) throws Exception {
		
		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_UPDATE_BY_REVIEW_NO);

		//"update review set r_image = ?, r_content=?, r_rating=? where r_no = ?";
		//"update review set r_image = 'up.jpg', r_content='씨이원한 맛!', r_rating='3' where r_no = 8";

		pstmt.setString(1, review.getR_image());
		pstmt.setString(2, review.getR_content());
		pstmt.setInt(3, review.getR_rating());
		pstmt.setInt(4, review.getR_no());
		
		int updateRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return updateRowCount;
	}
	
	
	public int deleteReview(int r_no) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_DELETE);
		pstmt.setInt(1, r_no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		
		return rowCount;
	}
	

	
	//select - 후기번호로 조회(전체상품조회 후 후기 상세조회)
	public Review selectNoReview(int r_no) throws Exception{
		Review findReviewId = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_R_NO);
		pstmt.setInt(1, r_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findReviewId = new Review(rs.getInt("r_no"), rs.getString("r_image"), 
					 rs.getString("r_content"), 
					 rs.getDate("r_wdate"), 
					 rs.getInt("r_rating"), 
					 new Product(rs.getInt("p_no"),null, 0, null, null, null),
					 new UserInfo(rs.getInt("u_no"), null, null, rs.getString("u_name"), null, null, null, 0, null, null),
					 new Orders(0, rs.getDate("o_date"), 0, null, null));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return findReviewId;
		
	}

	
	//리뷰테이블에 아이디도 추가해야하는거 아닌가
	public List<Review> selectIdReviewAll(String u_id) throws Exception{
		
		List<Review> reviewList = new ArrayList<Review>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_ID_ALL);
		pstmt.setString(1,u_id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			reviewList.add(new Review(rs.getInt("r_no"), rs.getString("r_image"), 
					 rs.getString("r_content"), 
					 rs.getDate("r_wdate"), 
					 rs.getInt("r_rating"), 
					 new Product(rs.getInt("p_no"),null, 0, null, null, null),
					 new UserInfo(rs.getInt("u_no"), null, null, rs.getString("u_name"), null, null, null, 0, null, null),
					 new Orders(0, rs.getDate("o_date"), 0, null, null)));
		}
		
		return reviewList;
	}

	//상품번호로 후기 조회 -> 상품페이지-후기에서 보여짐. ex> 상품-바나나 -> 바나나 구매고객들의 후기
	public List<Review> selectByProductNo(int p_no) throws Exception {
		// String selectAllSql = "select * from review";
		List<Review> reviewList = new ArrayList<Review>();

		Connection con = this.dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_BY_PRODUCT_NO);
		
		pstmt.setInt(1, p_no);
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			reviewList.add(new Review(rs.getInt("r_no"),
					rs.getString("r_image"),
					rs.getString("r_content"),
					rs.getDate("r_wdate"),
					rs.getInt("r_rating"),
					new Product(rs.getInt("p_no"), null, 0, null, null, null),
					new UserInfo(rs.getInt("u_no"), null, null, rs.getString("u_name"), null, null, null, 0, null, null),
					new Orders(0, rs.getDate("o_date"), 0, null, null)
				)
);
		}
		rs.close();
		pstmt.close();
		con.close();

		return reviewList;
	}
	
}
