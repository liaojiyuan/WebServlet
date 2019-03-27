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
@WebServlet(name = "SessionServlet", urlPatterns = { "/SessionServlet" })
public class SessionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		resp.setContentType("text/html;charset=utf-8");
		session.setAttribute("myname", "我的名字gcc");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
