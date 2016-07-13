package cn.edu.henu.rjxy.sumproject.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.henu.rjxy.sumproject.bean.User;
import cn.edu.henu.rjxy.sumproject.bean.UserNameRegistedException;
import cn.edu.henu.rjxy.sumproject.util.MysqlUtil;

import com.mysql.jdbc.Connection;


public class UserDao {
	Connection con = null;
	String sql = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 注册用户到数据库
	 * @param user
	 * @throws UserNameRegistedException 
	 */
	public void registUser(User user) throws UserNameRegistedException {
		checkUser(user);
		String userId = user.getUserId();
		String username = user.getUsername();
		String password = user.getPassword();
		sql = "insert into userInfo (userId,username,password) values (?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 查询用户是否已经存在
	 * @param user
	 * @throws UserNameRegistedException 
	 */
	public void checkUser(User user) throws UserNameRegistedException {
		
		try {
			con = MysqlUtil.getConnection();
			String username = user.getUsername();
			sql = "select ? from userInfo where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, username);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				throw new UserNameRegistedException("用户名已存在");
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}

