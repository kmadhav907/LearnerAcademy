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
import com.models.ClassModel;

/**
 * Servlet implementation class ClassList
 */
@WebServlet("/ClassList")
public class ClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
   
    public ClassList() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(conn != null) {
			try {
				String query = "select Classes.Time, Classes.Id, Teachers.fname ,Teachers.lname from Classes Inner Join Teachers where Classes.teacher = Teachers.id";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				ArrayList<ClassModel> classes = new ArrayList<ClassModel>();
				while(rs.next()) {
//					System.out.println("Class Number:" + rs.getInt(2)+ "Class Timinings:" + rs.getString(1) + "Class Teacher:" + rs.getString(3)+rs.getString(4));
					ClassModel temp = new ClassModel(rs.getString(1), rs.getString(3)+ rs.getString(4), rs.getInt(2));
					classes.add(temp);
				}
				if(classes.size() == 0) {
					RequestDispatcher rd=request.getRequestDispatcher("/Error.jsp");  
					rd.forward(request, response);
				}
				else {
					request.setAttribute("classes", classes);
					RequestDispatcher rd=request.getRequestDispatcher("/ClassResult.jsp");  
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
