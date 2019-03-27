/**
 * 
 */
package session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import service.BookService;

/**
 * @author Administrator
 * @date 2019年3月11日 下午8:00:14
 * @description 书店购买记录
 */
@WebServlet(name = "SessionServlet3", urlPatterns = { "/SessionServlet3" })
public class SessionServlet3 extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html;charset=utf-8");
		String id = req.getParameter("id");
		Book book = BookService.getAll().get(id);
		List<Book> list = (List<Book>) session.getAttribute("list");
		if (null == list) {
			list = new ArrayList<Book>();
			session.setAttribute("list", list);
		}
		list.add(book);
		System.out.println("sessionservlet3里面的sessionid=" + session.getId());
		String url = "/WebServlet/SessionBoughtBook";
		// resp.sendRedirect(url);
		// 由于禁用cookie了，所以要重写URL地址，带上JSESSIONID的值
		String realURL = resp.encodeURL(url);
		System.out.println(realURL);
		resp.sendRedirect(realURL);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
