package com.imooc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc";
	private static final String USER="root";
	private static final String PASSWORD=null;
	
	public static void main(String[] args)
	{		
		try 
		{
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获得数据库的连接
			Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);	
			//3.通过数据库的连接操作数据库，实现增删改查
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select user_name,age from imooc_goddess");
			
			while(rs.next())
			{
				System.out.println(rs.getString("user_name") + "," + rs.getInt("age"));
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
