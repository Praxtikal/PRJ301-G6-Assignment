<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách hợp đồng</title>
</head>
<body>

<h2>Danh sách hợp đồng</h2>

<c:if test="${param.success == '1'}">
    <p style="color: green;">Hợp đồng đã được tạo thành công!</p>
</c:if>
<c:if test="${param.error != null}">
    <p style="color: red;">Có lỗi xảy ra, vui lòng thử lại.</p>
</c:if>

<table border="1">
    <tr>
        <th>Mã hợp đồng</th>
        <th>Người dùng</th>
        <th>Yêu cầu</th>
        <th>Địa điểm đi</th>
        <th>Địa điểm đến</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Tổng chi phí</th>
        <th>Trạng thái</th>
        <th>Tiền cọc</th>
    </tr>
    <c:forEach var="contracts" items="${listContract}">
        <tr>
            <td>${contracts.contractID}</td>
            <td>${contracts.userID}</td>
            <td>${contracts.requestID}</td>
            <td>${contracts.startLocation}</td>
            <td>${contracts.endLocation}</td>
            <td>${contracts.startDate}</td>
            <td>${contracts.endDate}</td>
            <td>${contracts.totalCost}</td>
            <td>${contracts.status}</td>
            <td>${contracts.depositAmount}</td>
        </tr>
    </c:forEach>
</table>
    <a href="createContract"> Quay lại trang tạo hợp đồng </a>

</body>
</html>
