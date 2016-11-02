/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.conexion.Conexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario
 */
@WebServlet(name = "menuInicial", urlPatterns = {"/menuInicial"})
public class menuInicial extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url;
        if(request.getParameter("destino").equals("create")){
            url = "jsp/formularioInsertar.jsp";            
        }else{
            Conexion conexion = new Conexion();
            request.setAttribute("aves", conexion.todaTabla());
            url = "jsp/mostrarTabla.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
        
    }/*processRequest*/

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
