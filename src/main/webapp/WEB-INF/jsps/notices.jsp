<%--
  Created by IntelliJ IDEA.
  User: tanzim
  Date: 7/30/15
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-8 col-md-offset-2">
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Notice</th>
        </tr>
        <c:forEach var="notice" items="${notices}">
            <tr>
                <td><c:out value="${notice.id}"></c:out></td>
                <td><c:out value="${notice.name}"></c:out></td>
                <td><c:out value="${notice.email}"></c:out></td>
                <td><c:out value="${notice.text}"></c:out></td>
            </tr>
            <%--<p><c:out value="${notice}"></c:out></p>--%>
        </c:forEach>
    </table>
</div>
</body>
</html>
