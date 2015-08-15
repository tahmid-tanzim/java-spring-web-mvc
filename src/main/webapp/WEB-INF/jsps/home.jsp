<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<h3>Java Spring Framework</h3>
<%--<sql:query var="rs" dataSource="jdbc/spring">--%>
<%--SELECT id, name, email, text FROM notices--%>
<%--</sql:query>--%>
<%--<c:forEach var="row" items="${rs.rows}">--%>
<%--ID: ${row.id}<br/>--%>
<%--Name: ${row.name}<br/>--%>
<%--Email: ${row.email}<br/>--%>
<%--</c:forEach>--%>

<p><a href="${pageContext.request.contextPath}/notices" type="button" class="btn btn-primary">Show Notices</a></p>

<p><a href="${pageContext.request.contextPath}/createnotice" type="button" class="btn btn-primary">Create Notices</a>
</p>


</body>
</html>