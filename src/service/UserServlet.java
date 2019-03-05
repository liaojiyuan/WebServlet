package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description 用户验证
 */
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 通过html 的name属性，获取到值
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");

		// 复选框和下拉框有多个值，获取到多个值
		String[] hobbies = req.getParameterValues("hobbies");
		String[] address = req.getParameterValues("address");
		// 获取到隐藏域的值
		String hideValue = req.getParameter("aaa");
		String email = req.getParameter("email");
		System.out.println(username);
		System.out.println(password);
		System.out.println(gender);
		for (int i = 0; i < hobbies.length; i++)
			System.out.print(hobbies[i]);
		System.out.println();
		for (int i = 0; i < address.length; i++)
			System.out.print(address[i]);
		System.out.println();

		// System.out.println(hobbies.toString());
		// System.out.println(address.toString());
		System.out.println(email);
		System.out.println(hideValue);
	}

}
