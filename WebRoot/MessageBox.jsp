<%@ page language="java" import="java.util.*,com.gc.model.SaveData" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String username=(String) request.getSession().getAttribute("username");
if (username==null){
username="访客";
}
/*String username=(String) request.getAttribute("username");*/
ArrayList<SaveData> al = (ArrayList<SaveData>) request.getAttribute("al");

System.out.println(al.get(1).getMessage());
System.out.println(al.get(2).getMessage());


String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" name="viewport"
content="width=device-width,minimum-scale=1.0, maximum-scale=2.0"  />
<title>MyZone</title>
<style type="text/css">


.RightText {
	text-align: right;
	color:#30F;
	
}
.LeftText {
	text-align: left;
}
</style>
</head>

<body class="RightText">
<strong><%=username%>  <a href="/MessageBoard/Login">注销</a></strong>
<hr color="#FF0000"/>
<center>
<img align="absmiddle" src="images/titlelogin.gif" />
<form action="/MessageBoard/OperatorServlet" method="post">
<hr color="#0000FF"/>
<input type="text" name="username" style="visibility:hidden" value=<%=username%>><%=username%>:<input type ="text" name="message"/>
<input type ="submit" value="留言"/>
<br />
<hr color="#00FFFF"/>

<table width=50% border="1px" cellspacing="0px"  bordercolor="#CC00CC">
<% for (int i=0;i<al.size();i++){
%>
<tr><td><br />
<span class="LeftText"><%=al.get(i).getMessage()%></span><br />
<span class="RightText"><%=al.get(i).getDateTime()%></span><br />
</td></tr>

<%} %>

</table>
</form>
<br />
<a href="#">上一页</a>
<a href="#">[1]</a>
<a href="#">[2]</a>
<a href="#">[3]</a>
<a href="#">下一页</a>
</center>
</body>
</html>


