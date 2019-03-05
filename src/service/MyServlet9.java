package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description 文件压缩
 */
public class MyServlet9 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String ss = "aaaaaaaaaaaaaaaaaaaab第一行bbbbbbbbbbbbbbbbbbbbbbbbb"
				+ "cccccccccccccccccccccccc第二行ccccccccccccccddddddddddddd"
				+ "eeeeeeeeeeeeeeeeefffffff第三行ffffffffffffggggggggggggg"
				+ "hhhhhhhhhhhhhhhhhhhhhhhhhh最后一行hiiiiiiiiiiiiiiiiiijjjjj";
		System.out.println("压缩前长度" + ss.getBytes().length);

		// 创建GZIPOutputStream对象，给与它ByteArrayOutputStream对象
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		GZIPOutputStream zipOut = new GZIPOutputStream(byteArrayOutputStream);
		// gzip对数据压缩，gzip写入的数据是保存在byteArrayOutputStream里面的
		zipOut.write(ss.getBytes());
		// gzip有缓冲，把缓冲清了，并顺便关闭流
		zipOut.close();
		// 把压缩数据取出来，送给浏览器
		byte[] bytes = byteArrayOutputStream.toByteArray();

		System.out.println("压缩后长度" + bytes.length);

		resp.setHeader("content-encoding", "gzip");
		resp.getOutputStream().write(bytes);
		// 在内存生成一张图片，宽为80，高位20，类型是RGB
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		// 往图片设置颜色和字体
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 80, 20);
		graphics.setFont(new Font(null, Font.BOLD, 20));

		graphics.drawString("12345", 0, 20);
		resp.setHeader("ContentType", "jpeg");
		ImageIO.write(image, "jpg", resp.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
