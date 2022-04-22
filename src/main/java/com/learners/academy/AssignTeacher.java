package com.learners.academy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBConfig;

/**
 * Servlet implementation class AssignTeacher
 */
@WebServlet("/AssignTeacher")
public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		// TODO Auto-generated method stub
		if(conn != null) {
			try {
				ArrayList<String> subjects = new ArrayList<String>();
				Statement statement = conn.createStatement();
				String query = "Select * from subjects";
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					subjects.add(rs.getString(2));
				}
				request.setAttribute("subjects", subjects);
				RequestDispatcher rd=request.getRequestDispatcher("/AssignTeacher.jsp");  
				rd.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String age = request.getParameter("age");
			String subjectName = request.getParameter("selected-subject");
			int subjectId = 0;
			if(fname != "" || lname != "" || age != "" || subjectName != "") {
				String queryToGetIDForSubject = "Select ID from subjects where name='"+subjectName+"'";
				ResultSet subjectIds = conn.createStatement().executeQuery(queryToGetIDForSubject);
				while(subjectIds.next()) {
					subjectId = subjectIds.getInt(1);
				}
				if(subjectId > 0) {
					String queryToInsert = "Insert into teachers values("+null+",'"+fname+"','"+lname+"',"+age+","+subjectId+")";
					int rows = conn.createStatement().executeUpdate(queryToInsert);
					if(rows > 0) {
						System.out.println("Successfully Added");
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/DashBoard.jsp");  
		rd.forward(request, response);
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
