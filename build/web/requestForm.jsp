<%-- 
    Document   : requestForm
    Created on : Mar 9, 2025, 1:31:29 PM
    Author     : 84376
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Users" %>
<%@ page import="dal.ServicesDAO" %>
<%@ page import="dal.RequestDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Service" %>


<%-- Assuming the user is already logged in --%>
<%@ page session="true" %>
<%
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Get the available services from the database
    ServicesDAO servicesDAO = new ServicesDAO();
    List<Service> servicesList = servicesDAO.getAllServices();
%>

<html>
<head>
    <title>Request Service</title>
</head>
<body>
    <h2>Request a Service</h2>
    <form action="sendRequest" method="post">
        <label for="service">Choose a service:</label>
        <select name="service" id="service">
            <% for (Service service : servicesList) { %>
                <option value="<%= service.getServiceID() %>"><%= service.getServiceName() %></option>
            <% } %>
        </select>
        <br>

        <label for="description">Description:</label>
        <textarea name="description" id="description"></textarea>
        <br>

        <button type="submit">Request Service</button>
    </form>
</body>
</html>
