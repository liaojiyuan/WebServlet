package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description 通过超链接将数据带给浏览器
 */
public class MyServlet12 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println(username);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("username" + username);
		// resp.sendRedirect("/WebServlet/index2.jsp"); // 重定向
		// req.getRequestDispatcher("").forward(req, resp); // 转发
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
