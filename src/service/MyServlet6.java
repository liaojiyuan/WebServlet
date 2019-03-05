package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description
 */
public class MyServlet6 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 每三秒网页自动刷新一次
		resp.setContentType("text/html;charset=utf-8");
		// resp.setHeader("refresh", "3");
		// resp.getWriter().write("当前时间是" + System.currentTimeMillis());
		resp.setHeader("Refresh", "3;url='/WebServlet/index.jsp'");
		resp.getWriter().write("当前时间是" + System.currentTimeMillis());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
