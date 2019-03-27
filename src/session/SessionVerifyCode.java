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
 * @date 2019年3月27日 下午7:49:04
 * @description
 */
public class SessionVerifyCode extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); // 否则读取的clientCode是中文乱码
		String serverCode = (String) req.getSession().getAttribute("verifiedCode");
		String clientCode = req.getParameter("checkcode");
		if (serverCode != null && clientCode != null && serverCode.equals(clientCode)) {
			System.out.println("验证成功" + serverCode + " " + clientCode);
		} else {
			System.out.println("验证失败" + serverCode + " " + clientCode);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
