package com.learnersacademy.admin;

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
import com.models.StudentModel;

/**
 * Servlet implementation class StudentReport
 */
@WebServlet("/StudentReport")
public class StudentReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReport() {
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
		// TODO Auto-generated method stub
		try {
			if(conn != null) {
				ArrayList<StudentModel> students = new ArrayList<StudentModel>();
				String query = "Select students.fname, students.lname, students.age,classes.id ,classes.section from students, classes where classes.id = students.class";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					String name = rs.getString(1) +" "+ rs.getString(2);
					int age = rs.getInt(3);
					int classNumber = rs.getInt(4);
					char section = (char) (rs.getInt(5) + 'A' - 1);
					students.add(new StudentModel(name, age, classNumber, section));
				}
				if(students.size() == 0 || students == null) {
					RequestDispatcher rd=request.getRequestDispatcher("/Error.jsp");  
					rd.forward(request, response);
				}
				else {
					request.setAttribute("students", students);
					RequestDispatcher rd=request.getRequestDispatcher("/StudentList.jsp");  
					rd.forward(request, response);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
