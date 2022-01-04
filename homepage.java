package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crudOperation
 */
public class homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String o = request.getParameter("opt");
		response.setContentType("text/html");
		PrintWriter pw1 = response.getWriter();
		pw1.println("<html>"
				+"<body>"
				+"<h1>option: "+o+"</h1>"
				+"</body></html>");
		if(o.equals("one"))
		{
			//response.sendRedirect("D:\\3rd sem\\EWA\\ewamaven\\src\\main\\webapp\\Carownerregister.jsp");
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Carownerregister.jsp");
			//response.
		}
		
		else if(o.equals("two"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\CarOwnerLogin.jsp");
		}
		
		else if(o.equals("three"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Caruserregister.jsp");
		}
		
		else if(o.equals("four"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Caruserlogin.jsp");
		}

		else
		{
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html>"
					+"<body>"
					+"<h1>Wrong option entered</h1>"
					+"</body></html>");
		}
	}

}
