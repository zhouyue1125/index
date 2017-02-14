package com.JDBC;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;





public class Jdbc {
	Connection conn = null;
	Statement stmt = null;
	Properties pro = new Properties();
	public Connection getConnection(){
		try {
			pro.load(Jdbc.class.getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String driver = pro.getProperty("jdbc.driver");
		String url = pro.getProperty("jdbc.url");
		String usr = pro.getProperty("jdbc.user");
		String pwd = pro.getProperty("jdbc.pwd");

			try {
				Class.forName(driver);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		try {
				conn = DriverManager.getConnection(url,usr,pwd);
				stmt = conn.createStatement();
				stmt.execute("insert into test1 set id = '2',name ='zyzyzyzy', password = 'yueyueyue'");

				ResultSet rs = stmt.executeQuery("select * from test1");
				while(rs.next()){
					System.out.println(rs.getString("id")+"|"+rs.getString("name")+"|"+rs.getString("password"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
		
	}
	
}




