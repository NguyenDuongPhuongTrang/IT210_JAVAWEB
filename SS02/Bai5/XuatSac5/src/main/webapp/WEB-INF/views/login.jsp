<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2026
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error.length() >0}">
    <p style="color: red">${error}</p>
</c:if>
</body>
</html>