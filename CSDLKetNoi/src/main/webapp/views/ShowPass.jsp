<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị mật khẩu</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        text-align: center;
    }
    h2 {
        color: #333;
    }
    p {
        font-size: 18px;
        color: #555;
    }
    .password {
        font-weight: bold;
        color: red;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: white;
        background: #007BFF;
        padding: 10px 20px;
        border-radius: 5px;
    }
    a:hover {
        background: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Mật khẩu của bạn</h2>
        <p>Mật khẩu trong hệ thống là: 
            <span class="password">${password}</span>
        </p>
        <a href="views/Login.jsp">Quay lại đăng nhập</a>
    </div>
</body>
</html>
