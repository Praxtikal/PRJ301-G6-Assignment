<%-- 
    Document   : manager
    Created on : Mar 8, 2025, 12:32:49 PM
    Author     : 84376
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<%
    Users manager = (Users) session.getAttribute("user");
    if (manager == null || manager.getRoleID() != 3) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<jsp:include page="menu.jsp" />
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Quản Lý - GSMoving</title>
    <link rel="stylesheet" href="CSS/dashboard.css">
</head>
<body>
    <div class="container">
        <div class="user-welcome">
            <h2>Chào mừng, <%= manager.getFullName() %></h2>
            <p>Bạn đang ở trong trang quản lý. Vui lòng chọn chức năng bên dưới.</p>
        </div>
        
        <div class="dashboard-section">
            <h3>Quản lý hợp đồng</h3>
            <ul>
                <li><a href="request">Quản lý hợp đồng và tạo hợp đồng mới</a></li>
                <li><a href="contractdetail">Phân công nhân viên</a></li>
                <li><a href="listContract">Xem danh sách hợp đồng đã tạo</a></li>
                <li><a href="logout" class="btn-logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
    
    <footer class="footer">
        <p>&copy; 2025 GSMoving - Dịch vụ chuyển nhà. All rights reserved.</p>
    </footer>
</body>
</html>