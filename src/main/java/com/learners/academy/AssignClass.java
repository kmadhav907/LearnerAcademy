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
 * Servlet implementation class AssignClass
 */
@WebServlet("/AssignClass")
public class AssignClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignClass() {
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
				String query = "Select fname, lname from teachers";
				Statement statement;
				ArrayList<String> teachers = new ArrayList<String>();
				try {
					statement = conn.createStatement();
					ResultSet rs = statement.executeQuery(query);
					while(rs.next()) {
						String teacher = rs.getString(1)+" "+rs.getString(2);
						teachers.add(teacher);
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(teachers.size());
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd = request.getRequestDispatcher("/AssignClass.jsp");  
				rd.forward(request, response);
			}
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacher = request.getParameter("selected-teacher");
		String timings = request.getParameter("timings");
		String section = request.getParameter("section");
	
		try {
			String queryToGetSubject = "Select SubjectID, ID from teachers where fname='"+teacher+"'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(queryToGetSubject);
			int subjectID = 0;
			int id = 0 ;
			while(rs.next()) {
				subjectID = rs.getInt(1);	
				id = rs.getInt(2);
			}
			if(teacher != "" || timings != "" || subjectID != 0 || id != 0 || section != "") {
				System.out.println("Everything is fine");
				@SuppressWarnings("unchecked")
				ArrayList<String> teachers=(ArrayList<String>)request.getAttribute("teachers");
				System.out.println(teachers);
				int sectionInInt = Integer.parseInt(section);
				String queryToAddClass = "Insert into classes values("+null+","+sectionInInt+","+id+","+subjectID+","+"'"+timings+"'";
				int rows = statement.executeUpdate(queryToAddClass);
				if(rows >0) {
					System.out.println("Successfully added");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/DashBoard.jsp");  
		rd.forward(request, response);
	}

}
