package cn.edu.henu.rjxy.sumproject.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class JdbConfig {
	/**
	 * 本类负责从jdbc_config中获得连接数据库中所需要的参数
	 */
	private static String driverClassName = "driverClass";
	private static String jdbcUrlName = "jdbcUrl";
	private static String userName = "user";
	private static String passwordName = "password";
	public static String driverClass;
	public static String jdbcUrl;
	public static String user;
	public static String password;
	
	static {
		
		try {
			Properties properties = new Properties();
			String fileName = "jdbc_config.properties";
			String fileUri = (Class.class.getResource("/").toString()+fileName).substring(6);
			FileInputStream fis = new FileInputStream(new File(fileUri));
			properties.load(fis);
			driverClass = properties.getProperty(driverClassName);
			jdbcUrl = properties.getProperty(jdbcUrlName);
			user = properties.getProperty(userName);
			password = properties.getProperty(passwordName);
			
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
	
}
