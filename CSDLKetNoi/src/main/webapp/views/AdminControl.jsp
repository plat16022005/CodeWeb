<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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

.btn:hover {
	background-color: #0056b3; /* đổi màu khi hover */
}
</style>
</head>
<body>
	<form action="admin/list-category.jsp" method="get">
		<button type="submit" class="btn">Load</button>
	</form>
	<form action="admin/add-category.jsp" method="post">
		<button type="submit" class="btn">Add</button>
	</form>
	<form action="admin/edit-category.jsp" method="post">
		<button type="submit" class="btn">Edit</button>
	</form>
</body>
</html>