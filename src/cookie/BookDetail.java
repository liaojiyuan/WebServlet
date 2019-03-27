/**
 * 
 */
package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import service.BookService;

/**
 * @author Administrator
 * @date 2019年3月9日 上午11:06:17
 * @description 简单向浏览器发送一个Cookie
 */
@WebServlet(name = "BookDetail", urlPatterns = { "/BookDetail" })
public class BookDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String bookId = req.getParameter("id");
		if (null != bookId) {
			Book book = BookService.getAll().get(bookId);
			writer.write("书籍序号" + book.getId() + "<br>");
			writer.write("书籍名称" + book.getName() + "<br>");
			writer.write("书籍作者" + book.getAuthor() + "<br>");
		}
		Cookie[] cookies = req.getCookies();
		boolean found = false;
		for (Cookie cookie : cookies) {
			if ("book".equals(cookie.getName())) {
				found = true;
				String newValue = getTopThree(cookie, bookId);
				cookie.setValue(newValue);
				resp.addCookie(cookie);
				break;
			}
		}
		// 没有cookie ，创建cookie
		if (!found) {
			Cookie cookie = new Cookie("book", bookId);
			cookie.setMaxAge(7 * 24 * 3600);// 一周时间
			resp.addCookie(cookie);
		}
	}

	/**
	 * 更新浏览书籍的历史记录，只保留最新三条
	 * 
	 * @description TODO
	 * @param @param
	 *            cookie 保存历史浏览bookId序列串
	 * @param @param
	 *            bookId 新浏览的bookId
	 * @return String
	 */
	private String getTopThree(Cookie cookie, String bookId) {
		String cookieValue = cookie.getValue();
		StringBuilder builder = new StringBuilder();
		String[] bookids = cookieValue.split("_");
		List<String> list = Arrays.asList(bookids);
		LinkedList<String> bookList = new LinkedList<>(list);
		// 如果浏览过的书籍id又浏览一次，应该先删除
		if (bookList.contains(bookId)) {
			bookList.remove(bookId);
			bookList.addFirst(bookId);
		} else {
			// 如果浏览历史记录有三条，删除最后一条
			if (bookList.size() >= 3) {
				bookList.removeLast();
				bookList.addFirst(bookId);
			} else {
				bookList.addFirst(bookId);
			}
		}
		bookList.forEach(str -> {
			builder.append(str).append("_");
		});
		return builder.deleteCharAt(builder.lastIndexOf("_")).toString();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
