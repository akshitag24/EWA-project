package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updatebook
 */
public class Updatecar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int u =0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatecar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String owner = request.getParameter("owner");
		String car = request.getParameter("car");
		String id = request.getParameter("id");
		String year = request.getParameter("year");
		String number = request.getParameter("number");
		
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
			
			//String query = "insert into userinfo values("name+" , "+pass")";
			String query = "update cardata set owner = '"+owner+"' , car='"+car+"' , year='"+year+"' , number='"+number+"' where id='"+id+"'";
			try {
				u = stmt.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(u==1)
			{
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				//pw.println("<html>"
						//+"<body>"
						//+"<h1>Welcome to E-Library</h1>"				
						//+"<h2>Succesfully Registered</h2>"
						//+"</body></html>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Operations.jsp");
				dispatcher.forward(request, response);
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