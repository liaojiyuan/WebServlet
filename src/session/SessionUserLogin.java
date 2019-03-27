/**
 * 
 */
package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.DBUser;

/**
 * @author Administrator
 * @date 2019年3月27日 下午4:21:14
 * @description
 */
public class SessionUserLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		System.out.println(username + " " + pwd);
		User user = DBUser.find(username, pwd);
		if (null == user) {
			resp.getWriter().write("登录失败");
			return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		resp.sendRedirect("/WebServlet/index.jsp");
	}

}
