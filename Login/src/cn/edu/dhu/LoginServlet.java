package cn.edu.dhu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	try{
		boolean ret = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DbConn dbc = new DbConn();
		ret = dbc.loginCheck(username, password);
		if(ret == true){
			String[] info = new String[6];
			info = dbc.getInfo(username);
			HttpSession hs = request.getSession();
			hs.setAttribute("username", info[0]);
			hs.setAttribute("age", info[2]);
			hs.setAttribute("job", info[3]);
			hs.setAttribute("tel", info[4]);
			hs.setAttribute("email", info[5]);
			
			response.sendRedirect("success.jsp");
		} else 
		{
			response.sendRedirect("error.jsp");
		}
		
	} catch(Exception e) {
		e.printStackTrace();
	}

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
