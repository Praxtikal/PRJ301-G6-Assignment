<%@ page import="model.Users" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Kiểm tra nếu Admin chưa đăng nhập
    Users admin = (Users) session.getAttribute("user");
    if (admin == null || admin.getRoleID() != 4) {
        response.sendRedirect("login.jsp");
        return;
    }
%>  
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - GSMoving</title>
    <link rel="stylesheet" href="CSS/dashboard.css">
</head>
<body>
    <div class="container">
        <div class="user-welcome">
            <h2>Xin chào, <%= admin.getFullName() %> (Admin)</h2>
            <p>Chào mừng bạn đến với trang quản lý hệ thống.</p>
        </div>
        
        <div class="dashboard-section">
            <div class="dashboard-header">
                <h3>Quản lý hệ thống</h3>
            </div>
            <ul>
                <li><a href="admin_add_user.jsp">Thêm tài khoản Nhân viên / Quản lý</a></li>
                <li><a href="AdminManageUsersServlet">Quản lý danh sách tài khoản</a></li>
                <li><a href="logout" class="btn-logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
    
    <footer class="footer">
        <p>&copy; 2025 GSMoving - Dịch vụ chuyển nhà. All rights reserved.</p>
    </footer>
</body>
</html>