package mx.edu.itsm.msc.controllers.carrito;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "micarrito", urlPatterns = {"/micarrito"})
public class MiCarritoServlet  extends HttpServlet{

	private static final long serialVersionUID = -4103143605765885530L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		System.out.println("MiCarrito/Get ==> Agrega al Carrito.");
		
		HttpSession session = request.getSession();
		
		String articulos = "";
		
		if(session.getAttribute("articulos")!=null)
			articulos = session.getAttribute("articulos").toString();
		
		System.out.println("=======  Mi Carrito ========");
		System.out.println(articulos);
		System.out.println("===========================");
		
		articulos = articulos.substring(0, articulos.length()-1); 
		
		String[] articulosArray = articulos.split(",");
		
		String miTabla = "<table class='table'>" +
							"<thead>" +
								"<tr>" +
							        "<th>#</th>" +
							        "<th>Producto</th>" +
							        "<th>Precio</th>" +
							      "</tr>" +
							"</thead>" +
							"<tbody>";
		
		int total = 0;
		
		for (int i = 0; i < articulosArray.length; i++) { 
			System.out.println(articulosArray[i]);
			total += 100;
			miTabla += "<tr>";
			miTabla += "<td>" + (i + 1) + "</td>";
			miTabla += "<td>Coca Cola 2 L</td>";
			miTabla += "<td class='text-right'>$100.00</td>";
			miTabla += "</tr>";
		}
		miTabla += "</tbody></table>";
		System.out.println("===========================");
		
		request.setAttribute("total", total);
		request.setAttribute("miTabla", miTabla);		
		request.getRequestDispatcher("mi-carrito.jsp").forward(request, response);
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
