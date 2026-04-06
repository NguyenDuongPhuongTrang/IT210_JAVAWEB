<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <title>Kết quả tìm kiếm</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">

<h3>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" />
</h3>

<p>
    Tìm thấy <strong>${totalFound}</strong> sự kiện
</p>
<c:if test="${empty events}">
    <div class="alert alert-warning">
        Không tìm thấy sự kiện nào phù hợp.
    </div>
</c:if>
<c:if test="${not empty events}">
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>
                    <c:out value="${event.name}" />
                </td>
                <td>${event.eventDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge badge-success">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true"/> VND
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="text-danger font-weight-bold">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="text-warning">
                                Sắp hết (còn ${event.remainingTickets} vé)
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span class="text-success">
                                    ${event.remainingTickets}
                            </span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book"/>

                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <a href="#" class="btn btn-secondary btn-sm disabled">
                                Hết vé
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="${bookUrl}" class="btn btn-primary btn-sm">
                                Đặt vé
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>

<hr>

<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên:
        <strong>${fn:toUpperCase(events[0].name)}</strong>
    </p>
</c:if>

<p>
    Độ dài từ khóa:
    <strong>${fn:length(keyword)}</strong> ký tự
</p>

</body>
</html>