<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report</title>
</head>
<body>
<%-- Tiêu đề báo cáo --%>
<h1>Danh sách sinh viên</h1>

<%-- Bảng hiển thị dữ liệu sinh viên --%>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Mã sinh viên</th>
        <th>Faculty</th>
        <th>GPA</th>
        <th>Trạng thái</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${students}" varStatus="status">
        <tr>
            <td><c:out value="${status.index + 1}" /></td>
            <td><c:out value="${s.fullName}" /></td>
            <td><c:out value="${s.studentCode}" /></td>
            <td><c:out value="${s.faculty}" /></td>
            <td><c:out value="${s.gpa}" /></td>
            <td>
                <c:choose>
                    <c:when test="${s.status == 'STUDYING'}">Đang học</c:when>
                    <c:when test="${s.status == 'GRADUATED'}">Đã tốt nghiệp</c:when>
                    <c:otherwise>Khác</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


