package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
public class MyServlet5 extends HttpServlet {

	private static final long serialVersionUID = 61713865921365229L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		FileInputStream	in=new FileInputStream("2.png");
		//绝对路径
//		FileInputStream	in=new FileInputStream(
//				"F:\\MyEclipse_workspace\\WebServlet\\WebRoot\\WEB-INF\\classes\\service\\2.png");
//	    ServletContext context=this.getServletContext();
        //调用ServletContext方法获取到读取文件的流
//	    InputStream in = context.getResourceAsStream("/WEB-INF/classes/service/2.png");
//		System.out.println(in);
	    //图片直接放在WEB-INF同目录，直接读取
//	    InputStream in = context.getResourceAsStream("2.png");
//		System.out.println(in);
		
		//通过类加载器获取
		ClassLoader loader=MyServlet5.class.getClassLoader();
//		InputStream in = loader.getResourceAsStream("3.png");
//		System.out.println(in);
		
		InputStream in = loader.getResourceAsStream("/service/4.png");
		System.out.println(in);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	
	
	
}

