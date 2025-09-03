<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tìm danh mục để sửa</title>
<link rel="stylesheet" 
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow-lg">
                <div class="card-header bg-info text-white text-center">
                    <h4>Nhập ID danh mục muốn sửa</h4>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/admin/category/find" method="get">
                        <div class="mb-3">
                            <label class="form-label">ID danh mục:</label>
                            <input type="number" class="form-control" name="id" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Tìm</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
