/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;
import model.FollowContract;
import dal.FollowContractDAO;
import dal.ProgressDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Users;

/**
 *
 * @author 84376
 */
@WebServlet(name="FollowContract", urlPatterns={"/flcontract"})
public class FollowContractController extends HttpServlet {
   private FollowContractDAO fcd = new FollowContractDAO();
   private ProgressDAO pd = new ProgressDAO();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FollowContract</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FollowContract at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Users user = (Users) session.getAttribute("user");
        if (user.getRoleID() != 2) { // Chỉ cho phép nhân viên truy cập
            response.sendRedirect("unauthorized.jsp");
            return;
        }

        List<FollowContract> contracts = fcd.getPendingContracts();
        request.setAttribute("contracts", contracts);
        request.getRequestDispatcher("employeeContracts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Users user = (Users) session.getAttribute("user");
        if (user.getRoleID() != 2) {
            response.sendRedirect("unauthorized.jsp");
            return;
        }

        int contractID = Integer.parseInt(request.getParameter("contractID"));
        String status = request.getParameter("status");
        String notes = request.getParameter("notes");

        boolean success = pd.updateProgress(contractID, status, notes);
        if (success) {
            response.sendRedirect("updateSuccess.jsp");
        } else {
            response.sendRedirect("updateFailure.jsp");
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
