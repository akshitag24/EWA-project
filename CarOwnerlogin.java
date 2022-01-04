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
 * Servlet implementation class Login
 */
public class CarOwnerlogin extends HttpServlet {
	boolean y;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarOwnerlogin() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("username");
		String pwd = request.getParameter("pass");
		
		
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
			//String query = "insert into userdata(name,username, password) values ('user' , 'username', 'password')";
			String query = "select exists(SELECT * from carownerdata WHERE UserId='"+user+"' and Password='"+pwd+"');";
			try {
				 y =stmt.execute(query);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		if(y==1)
//		{
			//System.out.println(y);
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Operations.jsp");
			
//		}
//		else
//		{
//			response.setContentType("text/html");
//			PrintWriter pw1 = response.getWriter();
//			pw1.println("<html>"
//					+"<body>"
//					+"<h1 style=color:blue>Wrong username and password</h1>"				
//					+"</body></html>");
//		}
	}

}

