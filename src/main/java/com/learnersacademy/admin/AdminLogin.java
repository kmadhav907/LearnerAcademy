package com.learnersacademy.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBConfig;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Connection conn;
	private String adminUserName;
	private String adminPassword;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	try {
			conn = DBConfig.getConnection();
			System.out.println("Connection is created");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			String command = request.getParameter("command");
//			if(command == null) {
//				command = "CLASSLIST";
//			}
			if(getCookie(request, response)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DashBoard.jsp");
				dispatcher.forward(request, response);
			}
			else {
				response.sendRedirect("/LearnerAcademy/AdminLogin.jsp");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private boolean getCookie(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean check = false;
		Cookie[] cookies = request.getCookies();
		// Find the cookie of interest in arrays of cookies
		for (Cookie cookie : cookies) {
			 
			if (cookie.getName().equals(adminUserName) && cookie.getValue().equals(adminPassword)) {
				check = true;
				break;
			} 

		}
		
		
		return check;
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Post method");
		adminUserName = request.getServletContext().getInitParameter("adminUserName");
		adminPassword = request.getServletContext().getInitParameter("adminPassword");
		String userName = request.getParameter("email");
		String password = request.getParameter("password");
		if(adminUserName.equals(userName) && adminPassword.equals(password)) {
			System.out.println("Authorization is completed");
			Cookie cookie = new Cookie(userName, password);
			cookie.setMaxAge(86400); 
			response.addCookie(cookie);
			doGet(request, response);
		}
		else {
		
			response.sendRedirect("/LearnerAcademy/LoginError.jsp");
		}
		
	}
	public void destroy() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
