<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tạo Hợp Đồng Mới</title>
</head>
<body>
    <h2>Tạo Hợp Đồng</h2>

    <!-- Hiển thị thông báo thành công -->
    <c:if test="${not empty success}">
        <p style="color: green;">${success}</p>
    </c:if>

    <!-- Hiển thị lỗi nếu có -->
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <form action="createContract" method="post">
        <label for="requestID">Chọn Yêu Cầu:</label>
        <select name="requestID" required>
            <c:forEach items="${requests}" var="r">
                <option value="${r.requestId}">Yêu Cầu #${r.requestId} -(${r.status})</option>
            </c:forEach>
        </select>
        <br>

        <label for="startLocation">Địa điểm đi:</label>
        <input type="text" name="startLocation" required><br>

        <label for="endLocation">Địa điểm đến:</label>
        <input type="text" name="endLocation" required><br>

        <label for="startDate">Ngày bắt đầu:</label>
        <input type="date" name="startDate" required><br>

        <label for="endDate">Ngày kết thúc:</label>
        <input type="date" name="endDate" required><br>

        <label for="totalCost">Tổng chi phí:</label>
        <input type="number" name="totalCost" step="0.01" required><br>

        <label for="depositAmount">Tiền đặt cọc:</label>
        <input type="number" name="depositAmount" step="0.01" required><br>

        <input type="submit" value="Tạo Hợp Đồng">
    </form>

    <br>
    <a href="request">Quay lại danh sách hợp đồng</a>
</body>
</html>
