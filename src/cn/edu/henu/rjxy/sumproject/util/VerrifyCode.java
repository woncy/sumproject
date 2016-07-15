package cn.edu.henu.rjxy.sumproject.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerrifyCode {
	
	private BufferedImage bufferedImage = null;
	private int width;
	private int height;
	private Random random;
	private String strings;
	private StringBuffer text;
	private int fontSize;
	private int textLength;
	public VerrifyCode(int width,int height) {
		this.width = width;
		this.height = height;
		this.textLength = 4;
		this.fontSize = 18;
		init();
	}

	
	private void init() {
		random = new Random();
		strings = "abcdefghijklmnopqrstuvwxyz0123456789";
		bufferedImage = new BufferedImage(width, height, Image.SCALE_FAST);
		Graphics g = bufferedImage.getGraphics();
		imageInit(g);
	}
	
	private void imageInit(Graphics g) {
		Color c = g.getColor();
		//设置背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//设置字体及字体颜色
		text = getRandomText();
		Font font =new Font(getRandomFont().getName(),Font.BOLD+Font.ITALIC,fontSize );
		g.setFont(font);
		g.setColor(getRandmColor());
		for(int i=0;i<text.length();i++) {
			g.setColor(getRandmColor());
			g.drawString(text.charAt(i)+"", i*font.getSize(), font.getSize());
		}
		drawRandomLine(g);
		g.setColor(c);
	}
	
	//生成随机干扰线
	private void drawRandomLine(Graphics g) {
		for(int i=0; i<4; i++) {
			g.setColor(getRandmColor());
			int startX = random.nextInt(width/2)+1;
			int startY = random.nextInt(height);
			int endX = random.nextInt(width/2)+width/2;
			int endY = random.nextInt(height);
			g.drawLine(startX, startY, endX, endY);
		}
	}
	
	//获得随机生成的字符串
	private StringBuffer getRandomText() {
		StringBuffer randomText = new StringBuffer();
		for (int i = 0; i < textLength; i++) {
			Character c = getRandomChar();
			int lowerCase = random.nextInt(2);
			if(c>='a' && c<='z') {
				if(lowerCase==0){
					c = Character.toUpperCase(c);
				}else
					c = Character.toLowerCase(c);
			}
		
			randomText.append(c.toString());
			
		}
		
		return randomText;
	}
	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}


	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}


	//从strings获得随机字符
	private Character getRandomChar() {
		Character c = null;
		int randomNum = random.nextInt(strings.length());
		c = strings.charAt(randomNum);
		return c;
		
	}
	
	//获得本地字体库
	private Font[] getLocalFonts() {
		//获得本地字体库方法
		Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		return fonts;
		
	}
	
	//从本地字体库中随机获得字体
	private Font getRandomFont() {
		Font font = null;
		Font[] fonts = getLocalFonts();
		int randomNum = random.nextInt(fonts.length);
		font = fonts[randomNum];
		return font;
		
	}
	
	//获得随机颜色 
	private Color getRandmColor() {
		Color c = null;
		int color_r = random.nextInt(200);
		int color_g = random.nextInt(200);
		int color_b = random.nextInt(200);
		c = new Color(color_r, color_g, color_b);
		return c;
	}
	
	public void outPutImage(String format,OutputStream output) throws IOException {
		ImageIO.write(bufferedImage, format, output);
	}
	
	public String getText() {
		return text.toString();
	}
	

}
