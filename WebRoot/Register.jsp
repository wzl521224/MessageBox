<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Le Petit Prince Space</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<center>
    <font color="Blue" size="18">Welcome to Le Petit Prince Space!!!</font>
    <hr>
    <font color="Red" size="10"> 高端大气上档次的用户注册 </font>
    <form action="/MessageBoard/RegisterServlet" method="post">
    <table border='1px' bordercolor='blue' cellspacing='0px' >
    <tr><td>*用户名：　</td><td><input type="text" name="username" placeholder="例：张三丰"/></td></tr><br>
   	<tr><td>*密　码：　</td><td><input type="text" name="password"/></td></tr><br>
   	<tr><td>ＱＱ邮箱：</td><td><input type="text" name="QQEmail"/></td></tr>
   	<tr><td>QQ号：</td><td><input type="text" name="QQ"/></td></tr>
   	<tr><td>网名：</td><td><input type="text" name="InternetName"/></td></tr>
   	</table>
   	<input type ="submit" value="注册"/>
   	</form>
    </center>
  </body>
</html>
