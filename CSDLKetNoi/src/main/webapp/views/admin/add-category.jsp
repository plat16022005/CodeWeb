<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm danh mục</title>
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white text-center">
                    <h4>Thêm danh mục mới</h4>
                </div>
                <div class="card-body">

                    <form action="${pageContext.request.contextPath}/admin/category/add" 
                          method="post" enctype="multipart/form-data">

                        <!-- Tên danh mục -->
                        <div class="mb-3">
                            <label class="form-label">Tên danh mục:</label>
                            <input type="text" class="form-control" 
                                   placeholder="Nhập tên danh mục" name="name" required>
                        </div>

                        <!-- Ảnh đại diện -->
                        <div class="mb-3">
                            <label class="form-label">Ảnh đại diện:</label>
                            <input type="file" class="form-control" name="icon" accept="image/*" required>
                        </div>

                        <!-- Nút bấm -->
                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-success">Thêm</button>
                            <button type="reset" class="btn btn-secondary">Hủy</button>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
