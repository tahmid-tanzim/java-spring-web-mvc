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
</head>
<body>
<c:forEach var="notice" items="${notices}">
    <p><c:out value="${notice}"></c:out></p>
</c:forEach>
</body>
</html>
