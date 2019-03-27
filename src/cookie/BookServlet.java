/**
 * 
 */
package cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

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
 * @date 2019年3月11日 上午11:34:53
 * @description
 */
@WebServlet(name = "BookServlet", urlPatterns = { "/BookServlet" })
public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 输出所有书籍，书籍名称是超链接，点击跳转查看书籍详细信息
		LinkedHashMap<String, Book> bookList = BookService.getAll();
		PrintWriter writer = resp.getWriter();
		writer.write("网上书店的书籍列表<br>");
		Set<Entry<String, Book>> entrySet = bookList.entrySet();
		for (Entry<String, Book> entry : entrySet) {
			Book book = entry.getValue();
			writer.write("<a href='/WebServlet/BookDetail?id=" + book.getId() + "'>" + book.getName() + "</a><br>");
		}
		// 从cookie中获取浏览记录输出
		writer.write("你曾经浏览过的书籍<br>");
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if ("book".equals(cookie.getName())) {
					String[] bookIds = cookie.getValue().split("_");
					for (String id : bookIds) {
						Book book = bookList.get(id);
						writer.write("<strong>" + book.getName() + "</strong><br>");
					}
				}
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
