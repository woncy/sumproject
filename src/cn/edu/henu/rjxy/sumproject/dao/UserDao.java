package cn.edu.henu.rjxy.sumproject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.henu.rjxy.sumproject.bean.User;

import com.mysql.jdbc.Connection;


public class UserDao {
	Connection con = null;
	String sql = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 注册用户到数据库
	 * @param user
	 */
	public void registUser(User user) {
		
	}
	
	/**
	 * 查询用户是否已经存在
	 * @param user
	 */
	public void checkUser(User user) {
		
		try {
			String username = user.getUsername();
			sql = "select ? from userInfo";
			pstmt = con.prepareStatement(username);
			rs = pstmt.executeQuery();
			if(rs!=null) {
				
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

