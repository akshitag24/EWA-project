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
public class operations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public operations() {
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
		String o = request.getParameter("opt");
		response.setContentType("text/html");
		PrintWriter pw1 = response.getWriter();
		pw1.println("<html>"
				+"<body>"
				+"<h1>option: "+o+"</h1>"
				+"</body></html>");
		if(o.equals("one"))
		{
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Insert.jsp");
//			dispatcher.forward(request, response);
			//response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Insert.jsp");
			//response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Insert.jsp");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Mavenproject/src/main/webapp/Insert.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Update.jsp");
		}
		
		else if(o.equals("two"))
		{
			//response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Delete.jsp");
			response.sendRedirect("/Mavenproject/Delete.jsp");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/Delete.jsp");
//			dispatcher.forward(request, response);
			//response.sendRedirect("/Mavenproject/src/main/webapp/Delete.jsp");
//			response.sendRedirect("Delete.jsp");
			
		}
		
		else if(o.equals("three"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\Update.jsp");
		}
		
		else if(o.equals("four"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\View.jsp");
		}
		
		else if(o.equals("five"))
		{
			response.sendRedirect("D:\\3rd sem\\EWA\\Mavenproject\\src\\main\\webapp\\index.jsp");
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