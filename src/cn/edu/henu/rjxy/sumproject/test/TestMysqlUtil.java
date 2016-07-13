package cn.edu.henu.rjxy.sumproject.test;

import org.junit.Test;

import cn.edu.henu.rjxy.sumproject.util.MysqlUtil;

import com.mysql.jdbc.Connection;

public class TestMysqlUtil {

	@Test
	public void testGetConnection() {
		Connection con = MysqlUtil.getConnection();
		System.out.println(con);
	}
}
