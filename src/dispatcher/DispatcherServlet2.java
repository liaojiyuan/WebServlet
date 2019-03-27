package dispatcher;

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
public class DispatcherServlet2 extends HttpServlet {

	private static final long serialVersionUID = -4778212903219146272L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.setContentType("text/html;charset=utf-8");
		String param1 = (String) req.getAttribute("param1");
		resp.getWriter().write("从DispatcherServlet获取到的值=" + param1);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
