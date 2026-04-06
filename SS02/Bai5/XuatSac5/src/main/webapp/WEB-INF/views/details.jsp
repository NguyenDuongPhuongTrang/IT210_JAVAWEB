<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2026
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Mã nhân viên: <strong><c:out value="${employee.id}"/></strong></p>
<p>Họ và tên: <strong><c:out value="${employee.fullName}"/></strong></p>
<p>Phòng ban: <strong><c:out value="${employee.department}"/></strong></p>
<p>Lương: <strong><fmt:formatNumber type="currency" currencyCode="VND" value="${employee.salary}"/></strong></p>
<p>Ngày vào: <strong><fmt:formatDate value="${employee.date}" pattern="dd/MM/yyyy"/></strong></p>
<p>Tình trạng: <strong><span
        style="background-color: ${employee.status == 'Đang làm' ? 'blue' : employee.status == 'Nghỉ phép' ? 'green' : 'yellow'}; color: white; padding: 5px;"><c:out
        value="${employee.status}"/></span></strong></p>
<c:url value="/employees" var="employeesUrl"/>
<a href="${employeesUrl}">Quay lại</a>
</body>
</html>