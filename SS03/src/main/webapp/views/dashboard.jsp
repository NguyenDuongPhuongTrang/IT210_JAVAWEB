<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Tổng quan</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4 text-center">CHI TIẾT SINH VIÊN</h1>
    <div class="mb-3">
        <p class="fw-bold"> Tổng số sinh viên:
            <span class="fw-normal"><c:out value="${totalStudent}"/></span>
        </p>
        <p class="fw-bold"> Phần trăm sinh viên bảo lưu:
            <span class="fw-normal"><c:out value="${reservedPercentage}%"/></span>
        </p>
        <p class="fw-bold"> Tổng số sinh viên đang học:
            <span class="fw-normal"><c:out value="${studyingPercentage}%"/></span>
        </p>
        <p class="fw-bold"> Tổng số sinh viên đã tốt nghiệp:
            <span class="fw-normal"><c:out value="${graduatedPercentage}%"/></span>
        </p>
        <p class="fw-bold"> GPA trung bình:
            <span class="fw-normal">
                <fmt:formatNumber value="${averageGpa}" pattern="0.00"/>
            </span>
        </p>
        <p class="fw-bold"> Sinh viên có GPA cao nhất:
            <span class="fw-normal"><c:out value="${studentWithHighestGpa.fullName}"/></span>
        </p>
    </div>
</div>
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