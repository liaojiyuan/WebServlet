<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
    <form action="/WebServlet/SessionUserLogin2" method="post" >
    	用户名：<input type="text" name="username"><br>
    	    <%--使用EL表达式取出session中的Token--%>
    	<input type="hidden"  name="token" value="${token}"><br>
    	<input type="submit" value="提交" id="button">
    </form>
  </body>
</html>
