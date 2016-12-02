package mx.edu.itsm.msc.controllers.carrito;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.edu.itsm.msc.cliente.Cliente;


@WebServlet(name = "agregarcarrito", urlPatterns = {"/agregarcarrito"})
public class ItemsPageServlet  extends HttpServlet{

    Cliente notificador;
	private static final long serialVersionUID = -4103143605765885530L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		System.out.println("Home/Get ==> Agrega al Carrito.");
		
		HttpSession session = request.getSession();
		String articulo = request.getParameter("articulo");
		
		System.out.println("===== Articulo ======");
		System.out.println(articulo);
		System.out.println("======================");
		
		if(articulo == null)
			articulo = "";
		
		String articulos = "";
		
		if(session.getAttribute("articulos")==null){
		            articulos = articulo + ",";
                }
		else{
                    articulos = session.getAttribute("articulos").toString();
                    if(!articulos.contains(articulo)){
                        articulos = articulos+ articulo + ",";
                    }
		}
		session.setAttribute("articulos", articulos);
		
		System.out.println("=======  Articulos ========");
                if(articulos.length()>1)articulos=articulos.substring(0, articulos.length()-1);
                        System.out.println(articulos);
                notificador.send(articulos);
                System.out.println("=========Recomendacion=========");
                System.out.println(notificador.get());
		//System.out.println(session.getAttribute("articulos"));
		System.out.println("===========================");
		request.getRequestDispatcher("items-page.jsp").forward(request, response);
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

    @Override
    public void init() throws ServletException {
        notificador=new Cliente("localhost",2551);        
    }
        
        
}
