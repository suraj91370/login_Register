package Com.java;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			java.sql.Statement st=conn.createStatement();
			String query= "select * from user where userid ='"+userId+"' and password='"+password+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				out.print("<h1>"+userId+": Welcome to Home Page</h1><br>");
				out.print("<h1>Login Succesfully!</h1><br>");
			}else {
				out.print("<h1>Please Enter correct userid or password</h1><br>");
				out.print("<h1>Login Failed</h1><br>");
			}
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			out.print("<h1>Login Failed! beacuse of server exception</h1><br>");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("<h1>Login Failed! beacuse of server exception</h1><br>");
			e.printStackTrace();
		}
		/*
		 * out.print("userId:" + userId); out.print("password:" + password);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String uname=request.getParameter("uname");
String password	=request.getParameter("password");
	String email=request.getParameter("email");
String phone =	request.getParameter("phone");
	
	}

}
