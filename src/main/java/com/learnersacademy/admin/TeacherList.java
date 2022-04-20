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
import com.models.TeacherModel;

/**
 * Servlet implementation class TeacherList
 */
@WebServlet("/TeacherList")
public class TeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherList() {
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
			ArrayList<TeacherModel> teachers = new ArrayList<TeacherModel>();
			if(conn != null) {
				String query = "select teachers.id ,teachers.fname, teachers.lname, teachers.age, Subjects.name from teachers, Subjects where teachers.subjectId = Subjects.id";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					TeacherModel temp = new TeacherModel(rs.getString(2) + " "+ rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(1));
					teachers.add(temp);
					}
			}
			if(teachers.size() == 0 || teachers == null) {
				RequestDispatcher rd=request.getRequestDispatcher("/Error.jsp");  
				rd.forward(request, response);
			}
			else {
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd=request.getRequestDispatcher("/TeachersList.jsp");  
				rd.forward(request, response);
			}
		}catch(SQLException e) {
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
