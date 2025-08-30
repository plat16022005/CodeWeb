<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Tạo tài khoản mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }
        .container {
            width: 380px;
            margin: 50px auto;
            background: #fff;
            border-radius: 6px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.2);
            padding: 20px;
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        .form-group {
            position: relative;
            margin-bottom: 15px;
        }
        .form-group input {
            width: 100%;
            padding: 10px 10px 10px 35px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-group i {
            position: absolute;
            top: 50%;
            left: 10px;
            transform: translateY(-50%);
            color: #777;
        }
        .btn {
            width: 100%;
            padding: 10px;
            background: #007BFF;
            border: none;
            color: #fff;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background: #0056b3;
        }
        .login-link {
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }
        .login-link a {
            color: #007BFF;
            text-decoration: none;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <div class="container">
        <h2>Tạo tài khoản mới</h2>
        <form action="register" method="post">
            <div class="form-group">
                <i class="fa fa-user"></i>
                <input type="text" name="username" placeholder="Tên đăng nhập" required>
            </div>
            <div class="form-group">
                <i class="fa fa-id-card"></i>
                <input type="text" name="fullname" placeholder="Họ tên" required>
            </div>
            <div class="form-group">
                <i class="fa fa-envelope"></i>
                <input type="email" name="email" placeholder="Email" required>
            </div>
            <div class="form-group">
                <i class="fa fa-phone"></i>
                <input type="text" name="phone" placeholder="Số điện thoại" required>
            </div>
            <div class="form-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="password" placeholder="Mật khẩu" required>
            </div>
            <div class="form-group">
                <i class="fa fa-lock"></i>
                <input type="password" name="confirmPassword" placeholder="Nhập lại mật khẩu" required>
            </div>
            <div class="form-group">
                <i class="fa fa-image"></i>
                <input type="text" name="avatar" placeholder="Ảnh đại diện (link hoặc tên file)">
            </div>
            <div class="form-group">
                <i class="fa fa-user-shield"></i>
                <input type="number" name="roleid" placeholder="Role ID (ví dụ: 1=admin, 2=user)" required>
            </div>
            <div class="form-group">
                <i class="fa fa-calendar"></i>
                <input type="date" name="createddate" required>
            </div>
            <button type="submit" class="btn">Tạo tài khoản</button>
        </form>
        <div class="login-link">
            Nếu bạn đã có tài khoản? <a href="login.jsp">Đăng nhập</a>
        </div>
    </div>
</body>
</html>
