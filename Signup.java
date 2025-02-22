package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Signup extends HttpServlet{
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	String fullname = req.getParameter("fullname");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chirulogin","root","root");
		PreparedStatement pstmt = con.prepareStatement("insert into register values(?,?,?)");
		pstmt.setString(1, fullname);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		
		int count = pstmt.executeUpdate();
		
		if(count>0) {
		
			out.println(" <h3 style='color:green'>user registration successfull </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
		else {
			out.println(" <h3 style='color:red'>user registration not successfull </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
		
	}
	catch (Exception e) {
		
		e.printStackTrace();
		resp.setContentType("text/html");
		 out.print("<h3 style='color:red'>Exception Occured:"+e.getMessage()+"</h3>");
		RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		rd.include(req, resp); 
	
	
}
}
}
