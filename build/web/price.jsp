<%@ page import="java.util.List, model.HouseMovingPrice, model.AdditionalService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bảng giá dịch vụ</title>
    <link rel="stylesheet" href="CSS/customer.css">
</head>
<body>
    <jsp:include page="menu.jsp" />
    
    <div class="container">
        <div class="price-list-section">
            <h2 class="title">Bảng giá dịch vụ chuyển nhà</h2>
            <div class="table-container">
                <table class="price-table">
                    <tr>
                        <th>Loại xe</th>
                        <th>Khoảng cách</th>
                        <th>Số tầng</th>
                        <th>Nhân công</th>
                        <th>Dịch vụ đóng gói</th>
                        <th>Giá cơ bản (VNĐ)</th>
                        <th>Phụ phí (VNĐ)</th>
                    </tr>
                    <%
                        List<HouseMovingPrice> housePrices = (List<HouseMovingPrice>) request.getAttribute("housePrices");
                        if (housePrices != null && !housePrices.isEmpty()) {
                            for (HouseMovingPrice p : housePrices) {
                    %>
                        <tr>
                            <td><%= p.getVehicleType() %></td>
                            <td><%= p.getDistanceRange() %></td>
                            <td><%= p.getFloor() %></td>
                            <td><%= p.getWorkers() %></td>
                            <td><%= p.isPackingService() ? "Có" : "Không" %></td>
                            <td><%= p.getBasePrice() %> VNĐ</td>
                            <td><%= p.getAdditionalCost() %> VNĐ</td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr><td colspan="7">Không có dữ liệu.</td></tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        
        <div class="price-list-section">
            <h2 class="title">Bảng giá dịch vụ bổ sung</h2>
            <div class="table-container">
                <table class="price-table">
                    <tr>
                        <th>Tên dịch vụ</th>
                        <th>Mô tả</th>
                        <th>Giá (VNĐ)</th>
                        <th>Đơn vị</th>
                    </tr>
                    <%
                        List<AdditionalService> additionalServices = (List<AdditionalService>) request.getAttribute("additionalServices");
                        if (additionalServices != null && !additionalServices.isEmpty()) {
                            for (AdditionalService s : additionalServices) {
                    %>
                        <tr>
                            <td><%= s.getServiceName() %></td>
                            <td><%= s.getDescription() %></td>
                            <td><%= s.getPrice() %> VNĐ</td>
                            <td><%= s.getUnit() %></td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr><td colspan="4">Không có dữ liệu.</td></tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        
        <div class="buttons-container">
            <a href="home.jsp" class="btn-back">Quay lại Trang Chủ</a>
            <a href="sendRequest" class="signup-btn">Liên hệ báo giá</a>
        </div>
    </div>
    
    <div class="footer">
        <p>&copy; 2025 DMove - Dịch vụ chuyển nhà. All rights reserved.</p>
    </div>
</body>
</html>