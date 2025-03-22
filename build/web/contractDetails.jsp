<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.ViewContractDetails" %>

<jsp:include page="menu.jsp" />

<%
    List<ViewContractDetails> contracts = (List<ViewContractDetails>) request.getAttribute("contracts");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Hợp Đồng</title>
    <link rel="stylesheet" type="text/css" href="CSS/customer.css">
    <link rel="stylesheet" type="text/css" href="CSS/contractDetails.css">
</head>
<body>

<div class="container">
    <h2 class="title">Chi Tiết Hợp Đồng</h2>

    <div class="table-container">
        <table class="contract-table">
            <thead>
                <tr>
                    <th>Mã Hợp Đồng</th>
                    <th>Họ Tên</th>
                    <th>Email</th>
                    <th>Điện Thoại</th>
                    <th>Địa Chỉ</th>
                    <th>Điểm Xuất Phát</th>
                    <th>Điểm Đến</th>
                    <th>Ngày Bắt Đầu</th>
                    <th>Ngày Kết Thúc</th>
                    <th>Tổng Chi Phí</th>
                    <th>Trạng Thái</th>
                    <th>Số Tiền Cọc</th>
                    <th>Vị Trí Nhân Viên</th>
                    <th>Biển Số Xe</th>
                    <th>Sức Chứa</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (ViewContractDetails contract : contracts) {
                %>
                <tr>
                    <td><%= contract.getContractID() %></td>
                    <td><%= contract.getFullName() %></td>
                    <td><%= contract.getEmail() %></td>
                    <td><%= contract.getPhoneNumber() %></td>
                    <td><%= contract.getAddress() %></td>
                    <td><%= contract.getStartLocation() %></td>
                    <td><%= contract.getEndLocation() %></td>
                    <td><%= contract.getStartDate() %></td>
                    <td><%= contract.getEndDate() %></td>
                    <td><%= contract.getTotalCost() %></td>
                    <td><%= contract.getContractStatus() %></td>
                    <td><%= contract.getDepositAmount() %></td>
                    <td><%= contract.getEmployeePosition() %></td>
                    <td><%= contract.getLicensePlate() %></td>
                    <td><%= contract.getCapacity() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>

<footer class="footer">
    <p>&copy; 2025 DMove - Dịch vụ chuyển nhà. All rights reserved.</p>
</footer>

</body>
</html>
