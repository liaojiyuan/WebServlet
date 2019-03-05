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
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletOutputStream out = resp.getOutputStream();

		// out.print("aaa");
		// OutputStream是输出二进制数据的，print方法要把字符串改成二进制数据
		// tomcat 使用ISO 8859-1编码对其转换，
		// “中国”是汉字gbk编码格式的，所以转换出错 报错500
		out.print("中国");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
