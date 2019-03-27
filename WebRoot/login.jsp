<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
    	function doSubmit(){
    		var button=document.getElementById("button");
    		button.disabled=true;
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <form action="/WebServlet/SessionUserLogin" method="post" onsubmit="return doSubmit()">
    	用户名：<input type="text" name="username"><br>
    	密码：<input type="password" name="pwd"><br>
    	<input type="submit" value="提交" id="button">
    </form>
  </body>
</html>
