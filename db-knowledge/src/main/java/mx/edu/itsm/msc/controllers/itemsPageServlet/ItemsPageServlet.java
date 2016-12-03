package mx.edu.itsm.msc.controllers.itemsPageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.itsm.msc.daos.ArticulosDao;

@WebServlet(name = "itemspage", urlPatterns = {"/itemspage"})
public class ItemsPageServlet  extends HttpServlet{

	private static final long serialVersionUID = -4103143605765885530L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
		System.out.println("Home/Get ==> Inicializa el Carrusel.");
		String cat = request.getParameter("cat");
		String marca = request.getParameter("marca");
		System.out.println("===== Categoria ======");
		System.out.println(cat);
		System.out.println(marca);
		System.out.println("======================");
		
		if(cat == null)
			cat = "";
		
		if(marca == null)
			marca = "";
		
		switch (cat) {
		case "botanas":
			request.setAttribute("cat", "botanas");
			request.setAttribute("marca1", "Alegro");
			switch (marca) {
			case "Alegro":
				request.setAttribute("producto1_id", "150014");
				request.setAttribute("producto1", "SABRISURTIDO 1/30PZ ALEGRO");
				break;
			default:
				request.setAttribute("producto1_id", "150014");
				request.setAttribute("producto1", "SABRISURTIDO 1/30PZ ALEGRO");
				break;
			}
			break;
		case "confiteria":
			request.setAttribute("cat", "confiteria");
			request.setAttribute("marca1", "Barcel");
			request.setAttribute("marca2", "DLR");
			switch (marca) {
			case "Barcel":
				System.out.println("Entró a Barcel.");
				request.setAttribute("producto1_id", "10245");
				request.setAttribute("producto1", "BOCADIN CHOC BLS 12/50 BARCEL");
				break;
			case "DLR":
				System.out.println("Entró a DLR.");
				request.setAttribute("producto1_id", "90011");
				request.setAttribute("producto1", "BOMBON CHOC.20/50PZ DLR");
				request.setAttribute("producto2_id", "90082");
				request.setAttribute("producto2", "BOMBON GIGANTE 15/400GR DLR");
				break;
			default:
				request.setAttribute("producto1_id", "90011");
				request.setAttribute("producto1", "BOMBON CHOC.20/50PZ DLR");
				request.setAttribute("producto2_id", "90082");
				request.setAttribute("producto2", "BOMBON GIGANTE 15/400GR DLR");
				request.setAttribute("producto3_id", "10245");
				request.setAttribute("producto3", "BOCADIN CHOC BLS 12/50 BARCEL");
				break;
			}
			break;
		case "varios":
			request.setAttribute("cat", "varios");
			request.setAttribute("marca1", "Covermex");
			request.setAttribute("marca2", "Reyma");
			request.setAttribute("marca3", "Dart");
			switch (marca) {
			case "Covermex":
				request.setAttribute("producto1_id", "210016");
				request.setAttribute("producto1", "VASO # 108 40/25PZ CONVERMEX");
				request.setAttribute("producto2_id", "210017");
				request.setAttribute("producto2", "VASO # 110 40/25PZ CONVERMEX");
				request.setAttribute("producto3_id", "210146");
				request.setAttribute("producto3", "VASO # 732 20/15PZ CONVERMEX");
				break;
			case "Reyma":
				request.setAttribute("producto1_id", "180721");
				request.setAttribute("producto1", "CHAROLA 007 10/50 REYMA");
				request.setAttribute("producto2_id", "180722");
				request.setAttribute("producto2", "CHAROLA MARIEL 66 10/50 REYMA");
				request.setAttribute("producto3_id", "180719");
				request.setAttribute("producto3", "CHAROLA MARIEL 855 10/50 REYMA");
				request.setAttribute("producto4_id", "180514");
				request.setAttribute("producto4", "CONTENEDOR 8X8 DIV 8/25 REYMA");
				request.setAttribute("producto5_id", "180753");
				request.setAttribute("producto5", "CONTENEDOR 8X8 LISO 8/25 REYMA");
				request.setAttribute("producto6_id", "210079");
				request.setAttribute("producto6", "VASO # 8 20/50PZ REYMA");
				request.setAttribute("producto7_id", "210172");
				request.setAttribute("producto7", "VASO # 12 20/50PZ REYMA");
				break;
			case "Dart":
				request.setAttribute("producto1_id", "210363");
				request.setAttribute("producto1", "ENVASE 32J32 946ML 20/15 DART");
				break;
			default:
				request.setAttribute("producto1_id", "210016");
				request.setAttribute("producto1", "VASO # 108 40/25PZ CONVERMEX");
				request.setAttribute("producto2_id", "210017");
				request.setAttribute("producto2", "VASO # 110 40/25PZ CONVERMEX");
				request.setAttribute("producto3_id", "210146");
				request.setAttribute("producto3", "VASO # 732 20/15PZ CONVERMEX");
				request.setAttribute("producto4_id", "180721");
				request.setAttribute("producto4", "CHAROLA 007 10/50 REYMA");
				request.setAttribute("producto5_id", "180722");
				request.setAttribute("producto5", "CHAROLA MARIEL 66 10/50 REYMA");
				request.setAttribute("producto6_id", "180719");
				request.setAttribute("producto6", "CHAROLA MARIEL 855 10/50 REYMA");
				request.setAttribute("producto7_id", "180514");
				request.setAttribute("producto7", "CONTENEDOR 8X8 DIV 8/25 REYMA");
				request.setAttribute("producto8_id", "210363");
				request.setAttribute("producto8", "ENVASE 32J32 946ML 20/15 DART");
				break;
			}
			break;
		case "populares":
		default:
			request.setAttribute("cat", "populares");
			List<String> masvendidos = ArticulosDao.obtenerMasVendidos();
			System.out.println("=== Mas vendidos ===");
			int contador = 1;
			for (String vendido : masvendidos) {
				System.out.println(vendido);
				
				String articuloListado = ArticulosDao.descripcionYPrecio(Integer.valueOf(vendido));
				String[] articuloRecomendadoArray = articuloListado.split(",");
						
				request.setAttribute("producto" + contador + "_id", articuloRecomendadoArray[0]);
				request.setAttribute("producto" + contador, articuloRecomendadoArray[1]);
				contador++;
			}
			System.out.println("====================");
			break;
		}
		
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
        req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
