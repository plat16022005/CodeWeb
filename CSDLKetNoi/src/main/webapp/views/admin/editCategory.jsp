<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa danh mục</title>
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header bg-warning text-white text-center">
                    <h4>Sửa danh mục</h4>
                </div>
                <div class="card-body">

                    <c:url value="/admin/category/edit" var="editUrl" />
                    <form action="${editUrl}" method="post" enctype="multipart/form-data">

                        <!-- ID (ẩn) -->
                        <input type="hidden" name="id" value="${category.id}" />

                        <div class="mb-3">
                            <label class="form-label">Tên danh mục:</label>
                            <input type="text" class="form-control"
                                   name="name" value="${category.name}" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Ảnh hiện tại:</label><br>
                            <c:url value="/image?fname=${category.icon}" var="imgUrl" />
                            <img src="${imgUrl}" class="img-thumbnail mb-2" style="max-width:150px;">
                            <label class="form-label mt-2">Chọn ảnh mới:</label>
                            <input type="file" class="form-control" name="icon" accept="image/*">
                        </div>

                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-success">Cập nhật</button>
                            <button type="reset" class="btn btn-secondary">Làm lại</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
