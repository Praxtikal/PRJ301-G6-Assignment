<%-- 
    Document   : employee
    Created on : Mar 8, 2025, 12:33:03 PM
    Author     : 84376
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<%
    Users employee = (Users) session.getAttribute("user");
    if (employee == null || employee.getRoleID() != 2) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Nhân Viên - GSMoving</title>
    <link rel="stylesheet" href="CSS/dashboard.css">
</head>
<body>
    <div class="container">
        <div class="user-welcome">
            <h2>Chào mừng, <%= employee.getFullName() %></h2>
            <p>Bạn đang ở trong trang nhân viên. Vui lòng chọn chức năng bên dưới.</p>
        </div>
        
        <div class="dashboard-section">
            <h3>Quản lý công việc</h3>
            <ul>
                <li><a href="flcontract">Xem hợp đồng được giao</a></li>
                <li><a href="update_progress.jsp">Cập nhật tiến độ công việc</a></li>
                <li><a href="logout" class="btn-logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
    
    <footer class="footer">
        <p>&copy; 2025 GSMoving - Dịch vụ chuyển nhà. All rights reserved.</p>
    </footer>
</body>
</html>