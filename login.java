package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
	String email = req.getParameter("email");
	String password=req.getParameter("password");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chirulogin","root","root");
		PreparedStatement pstmt = con.prepareStatement("select * from register where email=? and password=?");
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		 ResultSet rs = pstmt.executeQuery();
		 
		 if(rs.next()) {
		
			 HttpSession session = req.getSession();
			 session.setAttribute("fullname",rs.getString("fullname"));
			 RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			 rd.include(req, resp);
		 }
		 else {
			 out.print("<h3 style:'color:red'>Email id and password didn't match please try again</h3>");
			 RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			 rd.include(req, resp);
		 }
	} catch (Exception e) {
		e.printStackTrace();
		 out.print("<h3 style:'color:red'> Exception: "+e.getMessage()+"</h3>");
		 RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		 rd.include(req, resp);
		
	}
		
		
		
	}

}
