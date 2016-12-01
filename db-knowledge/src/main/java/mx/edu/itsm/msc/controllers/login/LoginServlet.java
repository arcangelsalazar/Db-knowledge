package mx.edu.itsm.msc.controllers.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet{

	private static final long serialVersionUID = -4103143605765885530L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		request.setAttribute("message", "Productos Ness");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String userName = req.getParameter("username");
	    String password = req.getParameter("password");
		
        writer.println("username="+userName);
        writer.println("password="+password);
        
        req.setAttribute("result", "This is the result of the servlet call");
        req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
