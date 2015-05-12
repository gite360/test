<%@ page language="java" import="java.util.*,com.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'success.jsp' starting page</title>

  </head>
  
  <body>
    登录成功         <a href="login.jsp">退出</a>
    <br/><br>
    <h4>用户信息</h4>
    <table border="1" width="40%" height="40px">
    	<tr>
    		<td>username:</td>
    		<td>age:</td>
    		<td>job:</td>
    		<td>tel:</td>
    		<td>email:</td>
    	</tr>
    
    <% 
    String username = (String)session.getAttribute("username");
    String age = (String)session.getAttribute("age");
    String job = (String)session.getAttribute("job");
    String tel = (String)session.getAttribute("tel");
    String email = (String)session.getAttribute("email");
    	
    %>
   
    <tr>
    	<td>${username }</td>
    	<td>${age }</td>
    	<td>${job }</td>
    	<td>${tel }</td>
    	<td>${email }</td>
    
    </tr>
   
    </table>
    
    <form action="SecServlet" method="post" name="form1">
    <table>
    <h4>密码修改</h4>
    	
    	<tr>
    		<td>新密码：</td>
    		<td><input type="text" name="xp" size="13" /></td>
    	</tr>
    	<tr>
    		<td><input type="submit" value="提交"/></td>
    	</tr>
    	
    </table>
    
    </form>
    
    
    
    
  </body>
</html>
