package service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description
 */
public class MyServlet7 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 设置禁止缓存 浏览器有三种消息头用来设置缓存，为兼容性，可以将三个消息头都设置了
		resp.setDateHeader("Expire", -1);
		resp.setHeader("cache-control", "no-cache");
		resp.setHeader("Pragma", "no-cache");

		// 查看效果
		resp.getWriter().write("你好呀！" + new Date().toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
