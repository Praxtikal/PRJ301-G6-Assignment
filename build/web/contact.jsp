<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="menu.jsp" %> <!-- Include Header -->

<%@ page import="java.util.*" %>
<%
    request.setAttribute("page", "contact");
%>

<!-- Contact Section -->
<section class="contact">
    <div class="container">
        <h2 class="section-title">Liên hệ với chúng tôi</h2>
        <div class="contact-content">
            <p>Nếu bạn có bất kỳ câu hỏi nào hoặc cần hỗ trợ về dịch vụ chuyển nhà, vui lòng điền thông tin vào mẫu dưới đây. Chúng tôi sẽ phản hồi trong thời gian sớm nhất.</p>
            <form action="submitContact.jsp" method="POST">
                <div class="form-group">
                    <label for="name">Họ và tên:</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="message">Nội dung:</label>
                    <textarea id="message" name="message" required></textarea>
                </div>
                <button type="submit" class="cta-button">Gửi yêu cầu</button>
            </form>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %> <!-- Include Footer -->
