/**
 * 
 */
package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2019年3月27日 下午4:21:14
 * @description
 */
public class SessionUserLogin2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String serverToken = (String) req.getSession().getAttribute("token");
		String clientToken = req.getParameter("token");
		if (serverToken != null && clientToken != null && serverToken.equals(clientToken)) {
			System.out.println("登陆成功" + serverToken + " " + clientToken);
			// 清除Session域对象数据
			req.getSession().removeAttribute("token");
		} else {
			System.out.println("不可重复提交" + serverToken + " " + clientToken);
		}
	}
}
