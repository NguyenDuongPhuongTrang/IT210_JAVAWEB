<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>

    <!-- Bootstrap 4 CDN -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container">
    <div class="row justify-content-center align-items-center" style="height: 100vh;">
        <div class="col-md-4">

            <div class="card shadow">
                <div class="card-body">
                    <h4 class="text-center mb-4">Đăng nhập</h4>

                    <!-- Thông báo lỗi -->
                    <c:if test="${not empty loginError}">
                        <div class="alert alert-danger">
                                ${loginError}
                        </div>
                    </c:if>

                    <form method="post" action="/login">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="username"
                                   class="form-control"
                                   placeholder="Nhập username" required>
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password"
                                   class="form-control"
                                   placeholder="Nhập password" required>
                        </div>

                        <button type="submit"
                                class="btn btn-primary btn-block">
                            Đăng nhập
                        </button>
                    </form>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>