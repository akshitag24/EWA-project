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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBook
 */
public class Viewcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewcar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	       //Class.forName(com.mysql.cj.jdbc.Driver);
	       String url = "jdbc:mysql://localhost:3306/elibrary";
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
			
			String query = "select * from cardata";
    		//ResultSet rs;
    		ResultSet rs = null;
			try {
				rs = stmt.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
				//response.sendRedirect(query);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Operations.jsp");
				dispatcher.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
