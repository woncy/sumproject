package cn.edu.henu.rjxy.sumproject.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import cn.edu.henu.rjxy.sumproject.util.VerrifyCode;

public class TestVerifyCode {

	@Test
	public void testVerifyCode() {
		/**
		 * 测试验证码工具类
		 * 此测试生成的验证码在D:/img.jpg文件中可查看
		 */
		VerrifyCode code = new VerrifyCode(75, 30);
		try {
			code.outPutImage("jpg", new FileOutputStream(new File("D:/img.jpg")));
			System.out.println(code.getText());
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
