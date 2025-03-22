<%-- 
    Document   : requestSuccess
    Created on : Mar 17, 2025, 2:12:18 PM
    Author     : 84376
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : requestForm
    Created on : Mar 9, 2025, 1:31:29 PM
    Author     : 84376
--%>

<%@ page import="model.Users" %>
<%@ page session="true" %>
<%
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head>
    <title>Yêu cầu thành công</title>
</head>
<body>
    <h2>Yêu cầu của bạn đã được gửi thành công!</h2>
    <p>Chúng tôi sẽ liên hệ với bạn sớm nhất có thể để báo giá.</p>
    <a href="customer.jsp"> Quay về trang chủ </a>

