/**
 * 
 */
package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @date 2019年3月11日 下午8:00:14
 * @description Session通信
 */
@WebServlet(name = "SessionServlet2", urlPatterns = { "/SessionServlet2" })
public class SessionServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html;charset=utf-8");
		// session.setMaxInactiveInterval(60); // 单位秒
		System.out.println(session.getMaxInactiveInterval()); // 返回单位以秒计时
		String myname = (String) session.getAttribute("myname");
		if (null != myname) {
			resp.getWriter().write(myname);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
