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
import mx.edu.itsm.msc.daos.ArticulosDao;


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
		System.out.println("Actual:" + articulo);
		System.out.println("========== Guardado en Session ============");
		System.out.println(session.getAttribute("articulos"));
		System.out.println(session.getAttribute("articulosLista"));
		System.out.println("===========================================");
		
		String articuloActual = ArticulosDao.descripcionYPrecio(Integer.valueOf(articulo));
		String[] articuloActualArray = articuloActual.split(",");
		
		session.setAttribute("producto_id", articuloActualArray[0]);
		session.setAttribute("producto", articuloActualArray[1]);
		session.setAttribute("precio", articuloActualArray[2]);
		
		if(articulo == null)
			articulo = "";
		
		String articulos = "";
		String articulosLista = "";
		
		if(session.getAttribute("articulos")==null){
			articulos = articulo + ",";
		}
		else{
            articulos = session.getAttribute("articulos").toString();
            if(!articulos.contains(articulo)){
                articulos = articulos+ articulo + ",";
            }
		}
		
		if(session.getAttribute("articulosLista")==null){
			articulosLista = articulo + ",";
		}
		else{
			articulosLista = session.getAttribute("articulosLista").toString();
			articulosLista = articulosLista + articulo + ",";
		}
		
		session.setAttribute("articulos", articulos);
		session.setAttribute("articulosLista", articulosLista);
		/*TODO: De aqui
		System.out.println("=======  Articulos ========");
        if(articulos.length()>1)articulos=articulos.substring(0, articulos.length()-1);
                System.out.println(articulos);
        notificador.send(articulos);
        System.out.println("=========Recomendacion=========");
        System.out.println(notificador.get());

        if(notificador.get().toString()!=null){        
	        String articulosRecomendados = notificador.get().toString();
	        */ 
			//TODO: hasta aqui
			//String articulosRecomendados = "90082,210017,180753,";
                        notificador.send(articulos);
			String articulosRecomendados = notificador.get().toString();
	                
	        articulosRecomendados = articulosRecomendados.substring(0, articulosRecomendados.length()-1); 
			String[] articulosArray = articulosRecomendados.split(",");
			for (int i = 0; i < articulosArray.length; i++) { 
				//Este es el ID del Articulo
				System.out.println(articulosArray[i]);
				String recomendado = ArticulosDao.descripcionYPrecio(Integer.valueOf(articulosArray[i]));
				System.out.println(recomendado);
				String[] articuloRecomendadoArray = recomendado.split(",");
				
				session.setAttribute("producto" + (i+1) + "_id", articuloRecomendadoArray[0]);
				session.setAttribute("producto" + (i+1), articuloRecomendadoArray[1]);
			}
        //} //TODO:Este se quita cuando funcione el recomendador.    
		//System.out.println(session.getAttribute("articulos"));
		System.out.println("===========================");
		request.getRequestDispatcher("agregar-carrito.jsp").forward(request, response);
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
