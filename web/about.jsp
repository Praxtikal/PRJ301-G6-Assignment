<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="menu.jsp" %> <!-- Include Header -->

<%@ page import="java.util.*" %>
<%
    request.setAttribute("page", "about");
%>

<!-- About Section -->
<section class="about">
    <div class="container">
        <h2 class="section-title">Về DMove</h2>
        <div class="about-content">
            <p>DMove là một công ty cung cấp dịch vụ chuyển nhà trọn gói, giúp khách hàng dễ dàng chuyển đến nhà mới mà không gặp phải khó khăn nào. Chúng tôi cam kết chất lượng dịch vụ cao cấp và sự an toàn cho mọi tài sản của bạn trong suốt quá trình di chuyển.</p>
            <h3>Vì sao chọn DMove?</h3>
            <ul>
                <li><strong>Chuyên nghiệp:</strong> Đội ngũ nhân viên được đào tạo bài bản và nhiều kinh nghiệm.</li>
                <li><strong>Nhanh chóng:</strong> Chúng tôi giúp bạn tiết kiệm thời gian và công sức khi chuyển nhà.</li>
                <li><strong>Uy tín:</strong> Chúng tôi cam kết mang lại sự hài lòng tuyệt đối cho khách hàng.</li>
            </ul>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %> <!-- Include Footer -->
