/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Ave;
import es.albarregas.conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mario
 */
@WebServlet(name = "insertar", urlPatterns = {"/insertar"})
public class insertar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        String error = "";
        Conexion conexion = new Conexion();
        Ave ave = new Ave();
        ave.setAnilla(request.getParameter("anilla").toUpperCase());
        ave.setEspecie(request.getParameter("especie"));
        ave.setLugar(request.getParameter("lugar"));
        ave.setFecha(request.getParameter("dia")+"-"+request.getParameter("mes")+"-"+request.getParameter("anno"));
        
        error = conexion.insertar(ave);
        
        if(error.equals("-1")){
            url = "jsp/insercionCorrecta.jsp";
        }else{
            request.setAttribute("error", error);
            url = "jsp/error.jsp";
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
