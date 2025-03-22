<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="dal.ViewContractDetailsDAO, model.Users, model.ViewContractDetails, java.util.List" %>
<%
    // Kiểm tra nếu người dùng đã đăng nhập
    Users customer = (Users) session.getAttribute("user");
    if (customer == null || customer.getRoleID() != 1) {
        response.sendRedirect("login.jsp"); // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
        return;
    }
    
    // Lấy danh sách hợp đồng của người dùng từ DAO
   
%>
<jsp:include page="menu.jsp" />
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Khách Hàng - GSMoving</title>
    <link rel="stylesheet" href="CSS/dashboard.css">
</head>
<body>
    <div class="container">
        <div class="user-welcome">
            <h2>Chào mừng, <%= customer.getFullName() %></h2>
            <p>Bạn đang ở trong trang khách hàng. Vui lòng chọn dịch vụ bên dưới.</p>
        </div>
        
        <div class="dashboard-section">
            <h3>Quản lý dịch vụ</h3>
            <ul>
                <li><a href="giavanchuyen">Xem bảng giá dịch vụ</a></li>
                <li><a href="profile.jsp">Xem thông tin cá nhân</a></li>
                <li><a href="requestForm.jsp">Yêu cầu dịch vụ</a></li>
                <li><a href="viewContractDetails">Xem chi tiết hợp đồng</a></li>
                <li><a href="logout" class="btn-logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
    
    <footer class="footer">
        <p>&copy; 2025 GSMoving - Dịch vụ chuyển nhà. All rights reserved.</p>
    </footer>
</body>
</html>