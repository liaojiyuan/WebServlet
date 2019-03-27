/**
 * 
 */
package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2019年3月9日 上午11:06:17
 * @description 简单向浏览器发送一个Cookie
 */
public class CookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 统一设置浏览器，服务器编码格式
		resp.setContentType("text/html;charset=utf-8");
		// Cookie[] cookies = req.getCookies();
		// for (Cookie cookie : cookies) {
		// if ("username".equals(cookie.getName())) {
		// cookie.setMaxAge(0);
		// // 不要忘记把cookie重新写入到response里面，否则不会覆盖的
		// resp.addCookie(cookie);
		// break;
		// }
		// }
		// 创建Cookie对象
		Cookie cookie = new Cookie("username", "www.gcc.com");
		// 设置Cookie有效期，不设置默认为-1，表示只存在该会话期间，不保存在硬盘
		cookie.setMaxAge(1000);
		// 不能加点，否则报错（很奇怪360浏览器）cookie.setDomain(".gcc.com");
		// cookie.setDomain("gcc.com");
		cookie.setPath("/MyServlet2");
		resp.addCookie(cookie);
		resp.getWriter().write("使用www.gcc.com域名添加一个cookie");
		// resp.getWriter().write("使用www.gcc.com域名添加一个cookie,只要一级域名是.gcc.com都可以访问");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
	}

}
