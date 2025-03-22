<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GSMoving - Dịch vụ chuyển nhà trọn gói</title>
    <link rel="stylesheet" href="CSS/home.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Header -->
    <header class="header">
        <div class="header-top"></div>
        <div class="container">
            <nav class="navbar">
                <div class="logo">
                    <div class="logo-circle">GS</div>
                    <div class="logo-text">GSMOVING</div>
                </div>
                
                <ul class="nav-links">
                    <li><a href="home.jsp">Trang chủ <span class="dropdown">▼</span></a></li>
                    <li><a href="about.jsp">Giới thiệu <span class="dropdown">▼</span></a></li>
                    <li><a href="giavanchuyen">Bảng giá dịch vụ <span class="dropdown">▼</span></a></li>
                    <li><a href="contact.jsp">Liên hệ <span class="dropdown">▼</span></a></li>
                </ul>
                
                <div class="auth-buttons">
                    <a href="login.jsp" class="login-btn">Đăng nhập</a>
                    <a href="register.jsp" class="signup-btn">Đăng ký</a>
                </div>
            </nav>
        </div>
    </header>

    <!-- Hero Section -->
    <section class="hero">
        <div class="container">
            <div class="hero-content">
                <div class="hero-text">
                    <h2 class="hero-subtitle">Dịch vụ chuyển nhà</h2>
                    <h1 class="hero-title">Trọn gói</h1>
                    <p class="hero-description">GSMoving là đơn vị cung cấp dịch vụ chuyển nhà trọn gói hàng đầu, giúp khách hàng dễ dàng di chuyển đến nơi ở mới mà không gặp bất kỳ khó khăn nào.</p>
                    <a href="giavanchuyen" class="cta-button">Tìm hiểu thêm</a>
                    
                    <div class="slider-dots">
                        <div class="dot"></div>
                        <div class="dot active"></div>
                        <div class="dot"></div>
                    </div>
                </div>
                
                <div class="hero-image">
                    <img src="images/housemove.jpg" alt="Dịch vụ chuyển nhà DMove">
                </div>
            </div>
        </div>
    </section>
    
    <!-- Services Section -->
    <section class="services">
        <div class="container">
            <h2 class="section-title">Dịch vụ của chúng tôi</h2>
            
            <div class="service-list">
                <div class="service-item">
                    <img src="images/home-moving.jpg" alt="Chuyển nhà">
                    <div class="service-content">
                        <h3 class="service-title">Chuyển nhà trọn gói</h3>
                        <p class="service-description">Chúng tôi giúp bạn vận chuyển mọi thứ đến ngôi nhà mới nhanh chóng, an toàn.</p>
                        <a href="requestForm.jsp" class="service-link">Liên hệ để khảo sát ngay <span>→</span></a>
                    </div>
                </div>
                
                <div class="service-item">
                    <img src="images/office-moving.jpg" alt="Chuyển văn phòng">
                    <div class="service-content">
                        <h3 class="service-title">Chuyển văn phòng</h3>
                        <p class="service-description">Di dời văn phòng, công ty với quy trình chuyên nghiệp, không làm gián đoạn công việc.</p>
                        <a href="requestForm.jsp" class="service-link">Liên hệ để khảo sát ngay <span>→</span></a>
                    </div>
                </div>
                
                <div class="service-item">
                    <img src="images/storage-service.jpg" alt="Chuyển kho">
                    <div class="service-content">
                        <h3 class="service-title">Dịch vụ lưu trữ</h3>
                        <p class="service-description">Cung cấp kho bãi an toàn để lưu trữ hàng hóa, nội thất trong thời gian dài.</p>
                        <a href="requestForm.jsp" class="service-link">Liên hệ để khảo sát ngay <span>→</span></a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Blue base at bottom -->
    <div class="blue-base"></div>
    
    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <div class="footer-bottom">
                <p>&copy; 2025 GSMoving - Dịch vụ chuyển nhà trọn gói. All rights reserved.</p>
            </div>
        </div>
    </footer>
</body>
</html>