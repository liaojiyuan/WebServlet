package encode;

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
public class Servlet4 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 调用getWriter()方法向浏览器输出数据
		// resp.setCharacterEncoding("UTF-8");
		// PrintWriter writer = resp.getWriter();
		// writer.write("aaa");
		// writer.write("中国");

		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("中国good!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
