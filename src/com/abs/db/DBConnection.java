package com.abs.db;

import java.sql.Connection;
import java.sql.DriverManager;

import com.abs.input.InitDatabase;

public class DBConnection {
	
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL_PREFIX = "jdbc:mysql://localhost:3306/";							//	url 前缀
	private static final String URL_SUFFIX = "?useUnicode=true&characterEncoding=utf-8&useSSL=false";	//	url	后缀 取消警告
	private static final String USER = "xiayangchn";
//	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	
	private Connection[] conn = new Connection[DBName.values().length];	//	private Database Connection 的引用
	
	static{	// 在静态块中，用反射加载数据库驱动
		try {
			Class.forName(Driver);		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			InitDatabase.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DBConnection(){}
	
	public Connection getConnection(DBName dbName) throws Exception {	// 获取指定数据库的连接
		int index = dbName.ordinal();
		if(conn[index] == null){
			try{
				this.conn[index] = DriverManager.getConnection(URL_PREFIX + dbName.toString() + URL_SUFFIX, USER, PASSWORD);
			}catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		}
		return conn[index];
	}
	
	public Connection[] getAllConnection() throws Exception {		// 获取所有数据库的连接
		for(DBName d : DBName.values()){
			this.getConnection(d);
		}
		return this.conn;
	}
	
	public void close(DBName dbName) throws Exception {	// 关闭指定数据库连接
		int index = dbName.ordinal();
		if(this.conn[index] != null){
			try {
				this.conn[index].close();
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		}
	}
	
	public void closeAll() throws Exception {		// 关闭所有数据库连接
		for(DBName d : DBName.values()){
			try {
				this.close(d);
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		DBConnection connection = new DBConnection();
		connection.getAllConnection();
		connection.getConnection(DBName.AIRLINE_1);
		connection.closeAll();
		System.out.println(DBName.values().length);
	}
}
