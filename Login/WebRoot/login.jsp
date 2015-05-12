<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>My JSP 'login.jsp' starting page</title>

  </head>
  
  <body>
   <form action="LoginServlet" method="post" name="form1">
   <table>
   <h5>登录系统</h5>
   
   	<tr>
   		<td>username：</td>
   		<td><input type="text" name="username" size="13" /></td>
   	</tr>
   
    <tr>
    	<td>password:</td>
    	<td><input type="text" name="password" size="13" /></td>
    </tr>
    
    <tr>
    	<td><input type="submit" value="Login" /></td>
    	<td><a href="regist.jsp" >注册</a></td>
    </tr>
   
   </table>
</form>




  </body>
</html>
