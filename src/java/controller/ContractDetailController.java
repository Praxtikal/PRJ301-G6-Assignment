/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ContractDAO;
import dal.ContractDetailDAO;
import dal.EmployeeDAO;
import dal.VehicleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Contract;
import model.Employee;
import model.Users;
import model.Vehicle;

/**
 *
 * @author 84376
 */
@WebServlet(name = "ContractDetailController", urlPatterns = {"/contractdetail"})
public class ContractDetailController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContractDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContractDetailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách nhân viên từ EmployeeDAO
        EmployeeDAO e = new EmployeeDAO();
        List<Employee> employees = e.getAllEmployees();
       
        // Lấy danh sách xe từ VehicleDAO
        VehicleDAO v = new VehicleDAO();
        List<Vehicle> vehicles = v.getAllVehicles();
        ContractDAO c = new ContractDAO();
        // Lấy danh sách hợp đồng từ ContractDAO (Giả sử đã có phương thức getAllContracts trong DAO)
        List<Contract> contracts = c.getAllContracts();

        // Gửi các danh sách trên đến JSP
     request.setAttribute("employees", employees);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("contracts", contracts);

        // Forward đến JSP
        request.getRequestDispatcher("assignEmployeeToContract.jsp").forward(request, response);
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Lấy dữ liệu từ form    
    HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null || ((Users) session.getAttribute("user")).getRoleID() != 3) {
            response.sendRedirect("login.jsp?error=access_denied"); // Chuyển hướng về trang login nếu không phải quản lý
            return;
        }
    int contractID = Integer.parseInt(request.getParameter("contractID"));
    String[] employeeIDs = request.getParameterValues("employeeIDs"); // Lấy danh sách EmployeeID từ form
    int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));

    ContractDAO c = new ContractDAO();
    ContractDetailDAO contractDetailDAO = new ContractDetailDAO();
    // Gán nhân viên và phương tiện vào hợp đồng
    boolean success = true;
    for (String employeeIDStr : employeeIDs) {
        int employeeID = Integer.parseInt(employeeIDStr);
        boolean added = contractDetailDAO.addContractDetail(contractID, employeeID, vehicleID);
        if (!added) {
            success = false;
            break;
        }
    }

    // Sau khi thêm tất cả nhân viên, cập nhật trạng thái hợp đồng thành "Confirmed"
    if (success) {
        boolean updatedStatus = c.updateContractStatusToConfirmed(contractID);
        if (updatedStatus) {
            request.setAttribute("message", "Successfully added employees and vehicle to contract detail, and contract status is now Confirmed.");
        } else {
            request.setAttribute("error", "Failed to update contract status.");
        }
    } else {
        request.setAttribute("error", "Failed to add employees and vehicle to contract detail.");
    }

    response.sendRedirect("contractdetail?contractID=" + contractID); // Chuyển hướng về trang chi tiết hợp đồng
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
