/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itsm.msc.controllers.apriori;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.itsm.msc.cliente.Cliente;

/**
 *
 * @author BIGZENER
 */
@WebServlet(name = "apriori", urlPatterns = {"/apriori"})
public class AprioriServlet extends HttpServlet {
    private static final long serialVersionUID = -4103143605765885530L;
	
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            double soporte = Double.valueOf(req.getParameter("soporte"))/100;
	    double confianza = Double.valueOf(req.getParameter("confianza"))/100;
            
            cliente.send(soporte+","+confianza);
            System.out.println("======= A priori ==========");
            System.out.println("soporte: " + soporte);
            System.out.println("confianza: " + confianza);
            System.out.println("===========================");
            req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
Cliente cliente;
    @Override
    public void init() throws ServletException {
        cliente=new Cliente("localhost",2550);
    }
// </editor-fold>

    
}
