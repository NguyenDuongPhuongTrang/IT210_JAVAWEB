<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ha
  Date: 4/8/2026
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Detail Employee</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h2 class="text-center">DETAIL EMPLOYEE!</h2>
        <table class="table table-bordered table-striped">
            <tr>
                <td><b>Employee Id</b></td>
                <td>${employee.empId}</td>
            </tr>
            <tr>
                <td><b>Full Name</b></td>
                <td>${employee.fullName}</td>
            </tr>
            <tr>
                <td><b>Gender</b></td>
                <td>${employee.gender?"Nam":"Nữ"}</td>
            </tr>
            <tr>
                <td><b>Birthday</b></td>
                <td><fmt:formatDate value="${employee.birthday}"/></td>
            </tr>
            <tr>
                <td><b>Address</b></td>
                <td>${employee.address}</td>
            </tr>
            <tr>
                <td><b>Department</b></td>
                <td>${employee.department}</td>
            </tr>
            <tr>
                <td><b>Position</b></td>
                <td>${employee.position}</td>
            </tr>
            <tr>
                <td><b>Salary</b></td>
                <td><fmt:formatNumber value="${employee.salary}"/></td>
            </tr>
        </table>
        <a href="${pageContext.request.contextPath}/employees">Back</a>
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
