package mx.edu.itsm.msc.controllers.carrito;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "micarritostatus", urlPatterns = {"/micarritostatus"})
public class MiCarritoStatusServlet  extends HttpServlet{

	private static final long serialVersionUID = -4103143605765885530L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		System.out.println("MiCarritoStatus/Get ==> Finaliza.");
		
		HttpSession session = request.getSession();
		
		String status = request.getParameter("status");
		
		if(status == null)
			status = "";
		
		String articulos = "";
				
		if(session.getAttribute("articulos")!=null)
			articulos = session.getAttribute("articulos").toString();
		
		System.out.println("=======  Mi Carrito ========");
		System.out.println(status);
		System.out.println(articulos);
		System.out.println("===========================");
		
		
		switch (status) {
		case "comprar":
			articulos = articulos.substring(0, articulos.length()-1); 
			String[] articulosArray = articulos.split(",");
			//ingresa articulos a la DB
			for (int i = 0; i < articulosArray.length; i++) { 
				//Este es el ID del Articulo
				System.out.println(articulosArray[i]);
			}
			session.setAttribute("infor", "infor");
			articulos = "";
			session.setAttribute("articulos", articulos);
			break;
		case "cancelar":
		default:
			articulos = "";
			session.setAttribute("articulos", articulos);
			break;
		}
		
		
		
		
		request.setAttribute("total", "");
		request.getRequestDispatcher("HomePage.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String userName = req.getParameter("username");
	    String password = req.getParameter("password");
		
        writer.println("username="+userName);
        writer.println("password="+password);
        
        req.setAttribute("result", "This is the result of the servlet call");
        req.getRequestDispatcher("agregar-carrito.jsp").forward(req, resp);
	}
}
