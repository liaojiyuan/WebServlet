package service;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author gcc
 * @date 2019年2月28日
 * @description 
 */
@WebServlet(name="MyServlet4",urlPatterns="/MyServlet4")
public class MyServlet4 extends HttpServlet {

	private static final long serialVersionUID = -5227389492384342812L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletContext实现Servlet之间通信
		ServletContext context=this.getServletContext();
		String username=(String)context.getAttribute("username");
		System.out.println("获取到Servlet3传递过来的用户信息名称"+username);
		//ServletContext 获取全局参数信息
		String globalName =(String) context.getInitParameter("GLOBAL_NAME");
		System.out.println("global name"+globalName);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
}

