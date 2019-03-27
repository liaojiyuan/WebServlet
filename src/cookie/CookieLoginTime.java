/**
 * 
 */
package cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2019年3月9日 上午11:06:17
 * @description 简单向浏览器发送一个Cookie
 */
@WebServlet(name = "CookieLoginTime", urlPatterns = { "/CookieLoginTime" })
public class CookieLoginTime extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd#hh:mm:ss");// 中间不能有空格（空格在ASCII是32非法字符）,使用#代替
		String currentDateTime = sdf.format(new Date());
		Cookie[] cookies = req.getCookies();
		Cookie lastLoginTime = null;
		for (Cookie cookie : cookies) {
			if ("time".equals(cookie.getName())) {
				lastLoginTime = cookie;
				cookie.setValue(currentDateTime);
				resp.addCookie(cookie);
				break;

			}
		}
		if (null != lastLoginTime) {
			resp.getWriter().write("您上次登录时间" + lastLoginTime.getValue());
		} else {
			lastLoginTime = new Cookie("time", currentDateTime);
			lastLoginTime.setMaxAge(3600);
			resp.addCookie(lastLoginTime);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
	}

}
