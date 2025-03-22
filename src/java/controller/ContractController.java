    package controller;

    import dal.ContractDAO;
    import dal.RequestDAO;
    import dal.UsersDAO;
    import model.Contract;
    import model.Request;

    import java.io.IOException;
    import java.sql.Date;
    import java.util.List;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
    import model.Users;

    @WebServlet(name = "ContractController", urlPatterns = {"/createContract"})
    public class ContractController extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null || ((Users) session.getAttribute("user")).getRoleID() != 3) {
            response.sendRedirect("login.jsp?error=access_denied"); // Chuyển hướng về trang login nếu không phải quản lý
            return;
        }
            UsersDAO usersDAO = new UsersDAO();

            List<Users> users = usersDAO.getAllCustomers();
            request.setAttribute("users", users);
            RequestDAO requestDAO = new RequestDAO();
            // 🟢 Lấy danh sách Requests đang chờ xử lý
            List<Request> requests = requestDAO.getPendingRequests();

            // ✅ Truyền danh sách Requests vào request để hiển thị trên JSP
            request.setAttribute("requests", requests);
            
            // Chuyển hướng đến trang tạo hợp đồng
            request.getRequestDispatcher("createContract.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            try {
                // 🔹 Nhận dữ liệu từ form
                int requestID = Integer.parseInt(request.getParameter("requestID"));
                String startLocation = request.getParameter("startLocation");
                String endLocation = request.getParameter("endLocation");
                Date startDate = Date.valueOf(request.getParameter("startDate"));
                Date endDate = Date.valueOf(request.getParameter("endDate"));
                double totalCost = Double.parseDouble(request.getParameter("totalCost"));
                double depositAmount = Double.parseDouble(request.getParameter("depositAmount"));

                // 🔹 Lấy UserID từ RequestID
                RequestDAO requestDAO = new RequestDAO();
                int userID = requestDAO.getUserIDByRequestID(requestID);

                // 🔹 Thêm hợp đồng vào DB
                ContractDAO contractDAO = new ContractDAO();
                int contractID = contractDAO.createContract(userID, requestID, startLocation, endLocation, startDate, endDate, totalCost, depositAmount);

                if (contractID > 0) {
                    requestDAO.updateRequestStatus(requestID, "resolved");
                    request.setAttribute("success ","Hợp đồng tạo thành công ");
                    request.getRequestDispatcher("createContract.jsp").forward(request, response);
                } else {
                    System.err.println("❌ Lỗi: Không thể tạo hợp đồng!");
                    request.setAttribute("error", "Không thể tạo hợp đồng.");
                    request.getRequestDispatcher("createContract.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "⚠ Lỗi hệ thống, vui lòng thử lại!");
                request.getRequestDispatcher("createContract.jsp").forward(request, response);
            }
        }
    }
