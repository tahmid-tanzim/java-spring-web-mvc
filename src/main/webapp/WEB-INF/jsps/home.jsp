<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-10 col-md-offset-1">
    <h3>Java Spring Framework</h3>
    <%--<sql:query var="rs" dataSource="jdbc/spring">--%>
    <%--SELECT id, name, email, text FROM notices--%>
    <%--</sql:query>--%>
    <%--<c:forEach var="row" items="${rs.rows}">--%>
    <%--ID: ${row.id}<br/>--%>
    <%--Name: ${row.name}<br/>--%>
    <%--Email: ${row.email}<br/>--%>
    <%--</c:forEach>--%>

    <p>
        <a href="${pageContext.request.contextPath}/notices" type="button" class="btn btn-primary">Show Notices</a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/createnotice" type="button" class="btn btn-primary">Create
            Notices</a>
    </p>
    <sec:authorize access="!isAuthenticated()">
        <p>
            <a href="<c:url value='/login' />" type="button" class="btn btn-primary">Log in</a>
        </p>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p>
            <a href="<c:url value='/j_spring_security_logout' />" type="button" class="btn btn-primary">Log out</a>
        </p>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p>
            <a href="<c:url value='/admin' />" type="button" class="btn btn-primary">Admin Page</a>
        </p>
    </sec:authorize>
</div>
</body>
</html>