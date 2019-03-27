package dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description
 */
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = -4778212903219146272L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		req.setAttribute("param1", "转发数据");
		//
		PrintWriter writer = resp.getWriter();
		writer.write("测试转发forward之前通过response向浏览器输出数据");
		// writer.close(); //注释掉，只是写入缓冲区，没有写入到浏览器，转发可以正常进行
		RequestDispatcher dispatcher = req.getRequestDispatcher("/DispatcherServlet2");
		dispatcher.forward(req, resp);
		java.util.UUID.randomUUID();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
