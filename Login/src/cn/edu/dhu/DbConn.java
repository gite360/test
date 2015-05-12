package cn.edu.dhu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DbConn {
	
	private static Connection conn = null;
	
	//连接数据库
	public static Connection getConn()
	{
		try {
			String url = "jdbc:mysql://localhost:3306/info";
 			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			return conn;
			
		} catch (Exception e) {
			System.err.println("数据库连接异常:" + e.getMessage());
			return null;
		}
		
		
	}
	
	
	//关闭数据库
	public void CloseConn()
	{
		try {
			conn.close();
		} catch (Exception e) {
			System.err.println("数据库关闭异常:" + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
	}
	

	
	//登录查询
	public boolean loginCheck(String username, String password)
	{
		Connection conn;
		DbConn dc = new DbConn();
		conn = dc.getConn();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from userinfo where username = '"
				+username+"' and password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			dc.CloseConn();
		}
	}
	
	//读取用户信息
	public String[] getInfo(String username)
	{
		Connection conn;
		DbConn dc = new DbConn();
		conn = dc.getConn();
		//List<String[]> infoList = new ArrayList();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from userinfo where username = '"
				+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				
				String[] info = new String[6];
				info[0] = rs.getString("username");
				info[1] = rs.getString("password");
				info[2] = rs.getString("age");
				info[3] = rs.getString("job");
				info[4] = rs.getString("tel");
				info[5] = rs.getString("email");
				//infoList.add(info);
				return info;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dc.CloseConn();
		}
	}
	
	
	
	
	
	
	//注册
	public boolean registCheck(String username, String password, String age, String job, String tel, String email)
	{
		Connection conn;
		PreparedStatement pstate;
		DbConn dc = new DbConn();
		conn = dc.getConn();
		try {
			
			String sql = "insert into userinfo(username,password,age,job,tel,email) values(?,?,?,?,?,?)";
			
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, username);
			pstate.setString(2, password);
			pstate.setString(3, age);
			pstate.setString(4, job);
			pstate.setString(5, tel);
			pstate.setString(6, email);
			
			int n = 0;
			n = pstate.executeUpdate();
			
			if (n>0)
			{
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;       
		} finally {
			dc.CloseConn();
		}
	}
	
	
	//修改用户密码
	public boolean changeP(String xp)
	{
		Connection conn;
		PreparedStatement pstate;
		DbConn dc = new DbConn();
		conn = dc.getConn();
		try {
			
			String sql = "update userinfo set password = ?";
			pstate = conn.prepareStatement(sql);
			pstate.setString(1, xp);
			
			int n = 0;
			n = pstate.executeUpdate();
			
			if (n>0)
			{
				return true;
			} else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;       
		} finally {
			dc.CloseConn();
		}
	}
}
