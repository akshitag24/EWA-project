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
public class RegisterHomepage extends HttpServlet {
	int y=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterHomepage() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.println("<html>" 
                   +"<body style=background-color:Ivory>"
                   +"<h2 style=color:Coral;text-align:center;font-size:500%>Welcome to CARZOZ</h2>"
                   +"<h3 style=color:DarkCyan;text-align:center;font-size:300%>You are certified car provider</h3>"
                   +"</body>"
                   +"</html>");
		response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\CarOwnerLogin.jsp");
	
		
		
	}

}
