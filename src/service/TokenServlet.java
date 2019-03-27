package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2019年3月27日 下午6:25:30
 * @description 创建Token随机数，并跳转到jsp页面
 */
@WebServlet(name = "TokenServlet", urlPatterns = { "/TokenServlet" })
public class TokenServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = TokenUtil.makeToken();
		req.getSession().setAttribute("token", token);
		req.getRequestDispatcher("/login2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
