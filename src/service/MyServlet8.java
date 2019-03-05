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
public class MyServlet8 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.sendRedirect("/WebServlet/index.jsp");
		// resp.setStatus(302);
		// 状态码常量 代表302
		// resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);

		// 最新的302 状态码值
		resp.setStatus(HttpServletResponse.SC_FOUND);
		resp.setHeader("location", "/WebServlet/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
