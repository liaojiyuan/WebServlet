package download;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

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
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取资源路径
		String path = this.getServletContext().getRealPath("/download/中国10.jpg");
		System.out.println(path);
		// 读取资源
		FileInputStream in = new FileInputStream(path);

		// 获取到文件名
		String fileName = path.substring(path.lastIndexOf("\\") + 1);
		System.out.println(fileName);

		// 告诉浏览器，我要下载这个文件
		resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));

		// 将读取到的内容回送给浏览器
		int len = 0;
		byte[] bytes = new byte[1024];
		ServletOutputStream out = resp.getOutputStream();
		while ((len = in.read(bytes)) > 0) {
			out.write(bytes, 0, len);
		}
		// 关闭资源
		out.close();
		in.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
