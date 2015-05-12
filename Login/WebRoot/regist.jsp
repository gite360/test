<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'regist.jsp' starting page</title>
    

    
  </head>
  
  <body>
	
	<form action="RegisteServlet" name="form1" method="post">
	<table>
	<h4>注册信息</h4>
		<tr>
			<td>username:</td>
			<td><input type="text" name="username" size="13" /></td>
		</tr>
	
		<tr>
			<td>password:</td>
			<td><input type="text" name="password" size="13" /></td>
		</tr>
		
		<tr>
			<td>age:</td>
			<td><input type="text" name="age" size="13" /></td>
		</tr>
		
		<tr>
			<td>job</td>
			<td><input type="text" name="job" size="13" /></td>
		</tr>
		
		<tr>
			<td>tel:</td>
			<td><input type="text" name="tel" size="13" /></td>
		</tr>
		
		<tr>
			<td>E-mail:</td>
			<td><input type="text" name="email" size="13" /></td>
		</tr>
	
		 <tr>
		 	<td></td>
    		<td><input type="submit" value="注册" /></td>
  		 </tr>
	
	</table>
	</form>   







  </body>
</html>
