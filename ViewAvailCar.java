package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterLogin
 */
//@WebServlet("Register")
public class ViewAvailCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int u =0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAvailCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int x = 0;
		String location = request.getParameter("location");
		//String s = request.getParameter("login");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	       //Class.forName(com.mysql.cj.jdbc.Driver);
	       String url = "jdbc:mysql://localhost:3306/carzoz";
	       String username = "root";
	       String password = "Akshita@123";
	       
	       Connection con = null;
	       //step - 3
			try {
				 con = DriverManager.getConnection(url,username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(con!=null)
			{
				System.out.println("connection established");
				//System.out.println("Login is:"+s);
			}
			Statement stmt = null;
			try {
				 stmt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//String query = "insert into userinfo values("name+" , "+pass")";
			//String query = "insert into caruserdata values ('"+Fname1+"','"+Lname1+"' , '"+city+"' ,'"+state+"' , '"+user1+"' , '"+pass1+"')";
			String query = "Select * from cardata where location='"+location+"'";
			
			ResultSet rs = null;
			try {
				rs = stmt.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			PrintWriter out=response.getWriter();
    		out.print("<table border='1' width='100%' style='background-color:gray'");  
	        out.print("<tr><th>Owner</th>"
	        			+ "<th>Car</th>"
	        			+ "<th>Unique car id</th>"
	        			+ "<th>Year</th>"
	        			+ "<th>registration number</th>"
	        		+ "</tr>");
    		try {
				while(rs.next()) {
					 out.print("<tr>"
					 				+"<td>"+rs.getString(1)+"</td>"
					 				+"<td>"+rs.getString(2)+"</td>"
					 				+"<td>"+rs.getString(3)+"</td>"
					 				+"<td>"+rs.getString(4)+"</td>"
					 				+"<td>"+rs.getString(5)+"</td>"
					 			+"</tr>");      	        
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		
	}
}

