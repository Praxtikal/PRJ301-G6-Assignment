<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request List</title>
    </head>
    <script>
        function confirmDelete() {
            let checkboxes = document.querySelectorAll('input[name="requestIDs"]:checked');
            if (checkboxes.length === 0) {
                alert("Vui lòng chọn ít nhất một đơn hàng để xóa!");
                return false;
            }
            return confirm("Bạn có chắc muốn xóa những đơn hàng này không?");
        }
    </script>
    <body>
        <form action="deleteR" method="post" onsubmit="return confirmDelete();">
            <table border="1">
                <thead>
                    <tr>
                        <th>RequestID</th>               
                        <th>FullName</th>
                        <th>PhoneNumber</th>
                        <th>Address</th>               
                        <th>RequestDate</th>
                        <th>Status</th>
                        <th>Description</th>
                        <th>BasePrice</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach items="${requestScope.listRequest}" var="r">
                        <tr>
                            <td>${r.requestID}</td>
                            <td>${r.fullName}</td>
                            <td>${r.phoneNumber}</td>
                            <td>${r.address}</td>
                            <td>${r.requestDate}</td>
                            <td>${r.status}</td>
                            <td>${r.description}</td>
                            <td>${r.basePrice}</td>
                            <td>
                                <input type="checkbox" name="requestIDs" value="${r.requestID}">

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Delete Selected Orders"><!-- comment -->
            <a href="createContract">Tạo hợp đồng cho từng khách hàng</a>
            <a href="manager.jsp">Quay trở lại bảng công việc</a>
        </form>
    </body>

</html>
