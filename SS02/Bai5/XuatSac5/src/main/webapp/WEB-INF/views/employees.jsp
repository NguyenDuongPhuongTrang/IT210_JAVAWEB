<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2026
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã NV</th>
            <th>Họ và tên</th>
            <th>Phòng ban</th>
            <th>Lương</th>
            <th>Ngày vào</th>
            <th>Tình trạng</th>
            <td>Chi tiết</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="employee" items="${list}">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${employee.id}</td>
                <td>${employee.fullName}</td>
                <td>${employee.department}</td>
                <td>
                    <fmt:formatNumber type="currency" currencyCode="VND" value="${employee.salary}"/>
                </td>
                <td>
                    <fmt:formatDate value="${employee.date}" pattern="dd/MM/yyyy"/>
                </td>
                <td>
                    <span style="
                        ${employee.status == 'Đang làm' ? 'background-color: blue' :
                                employee.status == 'Nghỉ phép' ? 'background-color: green' :
                                        'background-color: yellow'}
                            ; color: white; padding: 5px;">
                            ${employee.status}
                    </span>
                </td>
                <td>
                    <c:url var="url" value="detail/${employee.id}"/>
                    <a href="${url}">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>