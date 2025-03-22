<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập - GSMoving</title>
    <link rel="stylesheet" href="CSS/loginandregister.css">
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h2>Đăng nhập</h2>
            
            <% 
                if (request.getParameter("error") != null) { 
                    String error = request.getParameter("error");
                    if (error.equals("invalid_credentials")) {
                        out.println("<p class='error-msg'>Sai tên đăng nhập hoặc mật khẩu!</p>");
                    } else if (error.equals("access_denied")) {
                        out.println("<p class='error-msg'>Bạn không được phép truy cập trang này!</p>");
                    } else if (error.equals("invalid_role")) {
                        out.println("<p class='error-msg'>Không có quyền truy cập vào trang này!</p>");
                    }
                } 
            %>
            
            <form action="login" method="post">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="username" name="username" required><br>

                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required><br>

                <input type="submit" value="Đăng nhập" class="login-btn">
                <p class="signup-link">Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a></p>
            </form>
        </div>
    </div>
</body>
</html>
