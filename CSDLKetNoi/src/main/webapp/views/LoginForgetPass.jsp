<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style type="text/css">
.input-box {
	display: block;
	width: 250px; /* full chiều rộng ô trắng */
	height: 40px; /* chiều cao cụ thể */
	margin: 20px auto; /* khoảng cách giữa các ô */
	padding: 0 10px; /* khoảng cách trong (trái/phải) */
	font-size: 16px; /* cỡ chữ */
	border: 1px solid #ccc; /* viền xám */
	border-radius: 6px; /* bo góc */
	box-sizing: border-box; /* tính cả padding vào width */
}

.input-box:focus {
	border-color: #007BFF; /* viền xanh khi focus */
	outline: none; /* bỏ viền xanh mặc định */
}

.btn {
	display: block;
	margin: 20px auto; /* căn giữa */
	padding: 10px 20px; /* khoảng cách trong */
	width: 250px;
	height: 50px;
	font-size: 24px;
	font-weight: bold;
	color: white;
	background-color: #007BFF; /* màu xanh */
	border: none; /* bỏ viền */
	border-radius: 8px; /* bo góc */
	cursor: pointer; /* đổi con trỏ chuột */
	transition: 0.3s; /* hiệu ứng hover */
}
</style>
</head>
<body>

	<form action="../forgetpass" method="post">
		<input type="text" name="email" placeholder="Nhập email"
			class="input-box">
		<button type="submit" class="btn">Get Pass</button>

	</form>
</body>
</html>