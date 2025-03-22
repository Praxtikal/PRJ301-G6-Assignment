<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gán Nhân Viên và Phương Tiện vào Hợp Đồng</title>
</head>
<body>
    <h2>Gán Nhân Viên và Phương Tiện vào Hợp Đồng Chi Tiết</h2>

    <!-- Form để người dùng gán nhân viên và phương tiện vào hợp đồng -->
    <form action="contractdetail" method="post">
        <!-- Dropdown cho chọn hợp đồng -->
        <label for="contractID">Chọn Hợp Đồng:</label>
        <select name="contractID" required>
            <c:forEach items="${contracts}" var="contract">
                <option value="${contract.contractID}">Hợp Đồng #${contract.contractID}</option>
            </c:forEach>
        </select>
        <br>

      <label for="employeeIDs">Chọn Nhân Viên:</label>
<select name="employeeIDs" multiple required>
    <c:forEach items="${employees}" var="employee">
        <option value="${employee.employeeID}">
            ${employee.fullName} - ${employee.position}
        </option>
    </c:forEach>
</select>
<br>
        
        

        

        <!-- Dropdown cho chọn phương tiện -->
        <label for="vehicleID">Chọn Phương Tiện:</label>
        <select name="vehicleID" required>
            <c:forEach items="${vehicles}" var="vehicle">
                <option value="${vehicle.vehicleID}">
                    ${vehicle.licensePlate} - ${vehicle.status}
                </option>
            </c:forEach>
        </select>
        <br>

        <!-- Submit Button -->
        <input type="submit" value="Gán Nhân Viên và Phương Tiện vào Hợp Đồng">
    </form>

    <br>
    <!-- Link quay lại trang hợp đồng chi tiết -->
    <a href="viewContractDetails?contractID=${param.contractID}">Quay lại chi tiết hợp đồng</a>
</body>
</html>
