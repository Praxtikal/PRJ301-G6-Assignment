<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký - GSMoving</title>
    <link rel="stylesheet" href="CSS/loginandregister.css">
</head>
<body>
    <div class="register-container">
        <div class="register-box">
            <div class="logo">
                <img src="images/logo.png" alt="GSMoving Logo">
            </div>
            <h2>Đăng ký tài khoản</h2>
            
            <% if (request.getParameter("error") != null) { %>
                <p class="error-msg">Lỗi! Tên đăng nhập hoặc email đã tồn tại.</p>
            <% } %>
            
            <form action="register" method="post" onsubmit="return validatePassword();">
                <div class="form-grid">
                    <div class="form-group">
                        <label for="fullName">Họ và Tên:</label>
                        <input type="text" id="fullName" name="fullName" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="username">Tên đăng nhập:</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="phoneNumber">Số điện thoại:</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" required>
                    </div>
                </div>
                
                <div class="form-group full-width">
                    <label for="address">Địa chỉ:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                
                <div class="form-group full-width">
                    <label for="password">Mật khẩu:</label>
                    <input type="password" id="password" name="password" required>
                </div>

                <div class="form-group full-width">
                    <label for="confirmPassword">Xác nhận mật khẩu:</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" required>
                </div>
                
                <div class="form-actions">
                    <input type="submit" value="Đăng ký">
                </div>
                
                <p class="login-link">Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
            </form>
        </div>
    </div>

    <script>
        // JavaScript validation to ensure password and confirm password match
        function validatePassword() {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                alert("Mật khẩu và xác nhận mật khẩu không khớp.");
                return false; // Prevent form submission
            }
            return true; // Allow form submission
        }
    </script>
</body>
</html>
