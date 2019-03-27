/**
 * 
 */
package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;

/**
 * @author Administrator
 * @date 2019年3月11日 下午8:00:14
 * @description Session通信
 */
@WebServlet(name = "SessionBoughtBook", urlPatterns = { "/SessionBoughtBook" })
public class SessionBoughtBook extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		// 将JSESSIONID保存在硬盘中，这样打开浏览器还有历史记录。
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(30 * 60);
		cookie.setPath("/WebServlet/");
		resp.addCookie(cookie);
		List<Book> list = (List<Book>) session.getAttribute("list");
		PrintWriter writer = resp.getWriter();
		System.out.println("sessionboughtBook里面的sessionid=" + session.getId());
		if (null == list || list.size() == 0) {
			writer.write("您的购物车还没有购买过商品");
		} else {
			for (Book book : list) {
				if (null != book) {
					writer.write(book.getName() + "<br>");
				}
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
