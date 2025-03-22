<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.FollowContract, model.Users" %>

<%
    Users user = (Users) session.getAttribute("user");
    if (user == null || user.getRoleID() != 2) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<FollowContract> contracts = (List<FollowContract>) request.getAttribute("contracts");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách hợp đồng cần thực hiện</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
    <h2>Danh sách hợp đồng cần thực hiện</h2>

    <table border="1">
        <tr>
            <th>Mã Hợp Đồng</th>
            <th>Khách Hàng</th>
            <th>Điện Thoại</th>
            <th>Điểm Bắt Đầu</th>
            <th>Điểm Đến</th>
            <th>Ngày Bắt Đầu</th>
            <th>Ngày Kết Thúc</th>
           
            
        </tr>

        <% if (contracts != null && !contracts.isEmpty()) { 
            for (FollowContract contract : contracts) { %>
                <tr>
                    <td><%= contract.getContractID() %></td>
                    <td><%= contract.getFullName() %></td>
                    <td><%= contract.getPhoneNumber() %></td>
                    <td><%= contract.getStartLocation() %></td>
                    <td><%= contract.getEndLocation() %></td>
                    <td><%= contract.getStartDate() %></td>
                    <td><%= contract.getEndDate() %></td>
                    
                    <td>
                        <form action="flcontract" method="post">
                            <input type="hidden" name="contractID" value="<%= contract.getContractID() %>">
                            <label for="status">Cập nhật trạng thái:</label>
                            <select name="status">
                                <option value="In Progress">Đang thực hiện</option>
                                <option value="Completed">Hoàn thành</option>
                            </select>
                            <br>
                            <label for="notes">Ghi chú:</label>
                            <input type="text" name="notes">
                            <br>
                            <button type="submit">Cập nhật</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        <% } else { %>
            <tr><td colspan="9">Không có hợp đồng nào cần thực hiện.</td></tr>
        <% } %>
    </table>

    <a href="logout">Đăng xuất</a>
</body>
</html>
