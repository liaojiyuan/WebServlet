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
public class Servlet2 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletOutputStream out = resp.getOutputStream();
		// out.write("aaa".getBytes()); //ok
		//
		// out.write("中国".getBytes()); //ok getByte()方法会默认使用字符串自身的编码格式转换成字节数组

		out.write("中国".getBytes("utf-8"));

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
