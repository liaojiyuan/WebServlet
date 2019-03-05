package encode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gcc
 * @date 2019年2月28日
 * @description
 */
public class Servlet3 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置头信息，告诉浏览器我回送数据的编码时UTF-8格式的
		/*
		 * //第一种方式，设置响应头回送数据的类型 resp.setHeader("content-type",
		 * "text/html;charset=UTF-8"); ServletOutputStream out
		 * =resp.getOutputStream(); out.write("中国".getBytes());
		 */
		ServletOutputStream out = resp.getOutputStream();
		// 使用meta标签模拟http消息头，告诉浏览器被回送数据的编码格式
		out.write("<meta http-equiv='content-type' content='text/html;charset=utf-8'>".getBytes());
		out.write("中国".getBytes("utf-8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
