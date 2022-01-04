package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class CarOwnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int u =0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarOwnerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int x = 0;
		String Fname1 = request.getParameter("Fname");
		String Lname1 = request.getParameter("Lname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String pass1 = request.getParameter("pass");
		String user1 = request.getParameter("username");
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
			String query = "insert into carownerdata(Fname,Lname,City,State,UserId,Password) values ('"+Fname1+"','"+Lname1+"' , '"+city+"' ,'"+state+"' , '"+user1+"' , '"+pass1+"')";
			try {
				u = stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			if(u==0)
			{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.println("<html>" 
		                   +"<body style=background-color:Ivory>"
		                   +"<h2 style=color:Coral;text-align:center;font-size:500%>CARZOZ</h2>"
		                   +"<h3 style=color:DarkCyan;text-align:center;font-size:300%>You are registered</h3>"
		                   +"</body>"
		                   +"</html>");
				//response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\java\\project\\RegisterHomepage.java");
				//response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\CarOwnerLogin.jsp");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/CarOwnerLogin.jsp");
//				dispatcher.forward(request, response);
				response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\CarOwnerLogin.jsp");
			}
			
//			{
//				response.setContentType("text/html");
//				PrintWriter pw = response.getWriter();
//				pw.println("<html>" 
//		                   +"<body style=background-color:Ivory>"
//		                   +"<h2 style=color:Coral;text-align:center;font-size:500%>CARZOZ</h2>"
//		                   +"<h3 style=color:DarkCyan;text-align:center;font-size:300%>You are not registered</h3>"
//		                   +"</body>"
//		                   +"</html>");
//			}
//		
	}
}
