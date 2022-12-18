package com.itwill.marketcoli.common;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Connection을 생성하고, 해지하는 역할을 하는 클래스
 */
public class DataSource {
	/********** team3 Connection생성 필요정보 ***************/
	
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	String user = "J2205JDEVELOPER#TEAM3";
	String password = "J2205JDEVELOPER#TEAM3";
	
	/*******************************************************/
	
	/*****************개인서버 정보*************************/
	/*
	String driverClass = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	String user = "jdeveloper02"; //공주꺼
	String password = "jdeveloper02"; //공주꺼
	*/
	/******************************************************/
	
	/*****************개인로컬 정보************************/
	 /*
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String password="java";
	  */
	/******************************************************/
		
	/*
	 * Connection 객체를 생성해서 반환하는 메소드
	 */
	public Connection getConnection() throws Exception{	//객체를 생성하는 역할
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		return con;
	}
	
	
	
	
}
