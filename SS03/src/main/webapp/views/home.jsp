<%--
  Created by IntelliJ IDEA.
  User: dell fpt
  Date: 06/04/2026
  Time: 5:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>HOME</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="mt-2 mb-2 text-center">STUDENT LIST</h1>
<table class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>STT</th>
        <th>
            <a href="/home?sortBy=name"
               class="${currentSort == 'name' ? 'text-primary fw-bold' : ''}">
                HỌ VÀ TÊN
            </a>
        </th>
        <th>MÃ SINH VIÊN</th>
        <th>KHOA</th>
        <th>NĂM NHẬP HỌC</th>
        <th>
            <a href="/home?sortBy=gpa"
               class="${currentSort == 'gpa' ? 'text-primary fw-bold' : ''}">
                GPA
            </a>
        </th>
        <th>TRẠNG THÁI</th>
        <th>XEM CHI TIẾT</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="s" items="${students}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${s.fullName}</td>
            <td>${s.studentCode}</td>
            <td>${s.faculty}</td>
            <td>${s.enrollmentYear}</td>
            <td>${s.gpa}</td>
            <td>
                <c:choose>
                    <c:when test="${s.status == 'STUDYING'}">
                        <p class="text-success mb-0">Đang học</p>
                    </c:when>
                    <c:when test="${s.status == 'RESERVED'}">
                        <p class="text-warning mb-0">Bảo lưu</p>
                    </c:when>
                    <c:when test="${s.status == 'GRADUATED'}">
                        <p class="text-primary mb-0">Đã tốt nghiệp</p>
                    </c:when>
                    <c:otherwise>
                        <p>Khác</p>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="/home/detail?id=${s.id}" class="btn btn-info btn-sm">
                    Xem chi tiết
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
