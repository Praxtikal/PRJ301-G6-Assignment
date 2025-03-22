<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="model.Users" %>
<%
    Users customer = (Users) session.getAttribute("user");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="CSS/customer.css">
</head>
<body>

<div class="container">
    <h2>Thông tin cá nhân</h2>

    <div class="customer-info">
        <p><strong>Họ và Tên:</strong> <%= customer.getFullName() %></p>
        <p><strong>Email:</strong> <%= customer.getEmail() %></p>
        <p><strong>Số điện thoại:</strong> <%= customer.getPhoneNumber() %></p>
        <p><strong>Địa chỉ:</strong> <%= customer.getAddress() %></p>
    </div>

    <a href="customer.jsp" class="btn-back">Quay lại</a>
</div>

</body>
</html>
