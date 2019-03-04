package service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author gcc
 * @date 2019年2月28日
 * @description 
 */
public class MyServlet3 extends HttpServlet {

	private static final long serialVersionUID = -4778212903219146272L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletConfig获取单个Servlet参数信息
		String username = this.getServletConfig().getInitParameter("name");
		System.out.println(username);
		//ServletContext实现Servlet之间通信
		ServletContext context=this.getServletContext();
		context.setAttribute("username", username);
		//ServletContext 获取全局参数信息
		String globalName =(String) context.getInitParameter("GLOBAL_NAME");
		System.out.println("global name"+globalName);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
}

