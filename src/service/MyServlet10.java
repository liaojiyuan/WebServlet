package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description 生成随机图片
 */
public class MyServlet10 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 在内存生成一张图片，宽为80，高位20，类型是RGB
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		// 获取到这张图片
		Graphics graphics = image.getGraphics();
		// 设置背景色
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 80, 20);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(1, 1, 78, 18);
		// 设置字体大小，样式
		graphics.setFont(new Font("宋体", Font.BOLD, 20));
		// 图片上写文字
		graphics.setColor(Color.RED);
		graphics.drawString("中国", 0, 20);
		// 告诉浏览器数据类型是啥
		resp.setContentType("image/jpeg");
		// 不要缓存
		resp.setDateHeader("expries", -1);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		// java包装的图片流工具 ImageIO
		// 把图片穿进去，类型是jpg，写给浏览器
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
