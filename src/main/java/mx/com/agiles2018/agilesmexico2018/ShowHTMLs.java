/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.agiles2018.agilesmexico2018;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author orugiho
 */
@WebServlet(name = "ShowHTMLs", urlPatterns = {"/ShowHTMLs"})
public class ShowHTMLs extends HttpServlet {

    private static final Logger LOG
            = Logger.getLogger("mx.com.agiles2018.controller.ShowHTMLs");

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
        File jsp = new File(request.getRealPath("html/index.jsp"));
        File directory = jsp.getParentFile();
        File[] list = directory.listFiles();
        Map<String, String> archivos = new HashMap<String, String>();
        for (File file : list) {
            if (file.isFile() && !file.getName().contains("jsp")) {
                try (Scanner scan = new Scanner(file)) {

                    StringBuilder builder = new StringBuilder();
                    while (scan.hasNext()) {
                        builder.append(scan.next());
                    }
                    archivos.put(file.getName(), builder.toString());
                } catch (Exception e) {
                    LOG.throwing("ShowHTMLs", "processRequest", e);
                }
            }
        }
        request.setAttribute("archivos", archivos);
        request.getRequestDispatcher("html/index.jsp").forward(request, response);
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

}
