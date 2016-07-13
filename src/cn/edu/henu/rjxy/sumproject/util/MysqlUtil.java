package cn.edu.henu.rjxy.sumproject.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;

public class MysqlUtil {
	/*
	 * 本类负责得到数据库的连接connection
	 * 其中driverClass，url，username，password等参数从JdbConfig类中获得
	 */
	private static Connection connection = null;
	static {
		try {
			Class.forName(JdbConfig.driverClass).newInstance();
			connection = (Connection) DriverManager.getConnection(JdbConfig.jdbcUrl
					,JdbConfig.user,JdbConfig.password);
			
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
		
	}

}
