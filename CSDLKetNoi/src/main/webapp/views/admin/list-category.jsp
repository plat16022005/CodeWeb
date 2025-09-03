<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<style>
    table {
        border-collapse: collapse;
        width: 80%;
        margin: 20px auto;
    }
    table, th, td {
        border: 1px solid black;
    }
    th, td {
        padding: 10px;
        text-align: center;
    }
    img {
        max-width: 200px;
        height: auto;
    }
</style>
</head>
<body>

<h2 style="text-align:center;">Danh sách Category</h2>

<table>
    <tr>
        <th>STT</th>
        <th>Hình ảnh</th>
        <th>Tên Category</th>
        <th>Thao tác</th>
    </tr>

    <c:forEach items="${cateList}" var="cate" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <c:url value="/image?fname=${cate.icon}" var="imgUrl" />
            <td><img src="${imgUrl}" alt="${cate.name}" /></td>
            <td>${cate.name}</td>
            <td>
                <a href="<c:url value='/admin/category/edit?id=${cate.id}'/>">Sửa</a>
                |
                <a href="<c:url value='/admin/category/delete?id=${cate.id}'/>">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
