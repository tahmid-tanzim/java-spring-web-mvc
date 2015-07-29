<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
Hello World Tanzim! Bye

<p>
    Request using EL: ${name}
    Request using JSTL: <c:out value="${name}"></c:out>
</p>

<sql:query var="rs" dataSource="jdbc/spring">
    SELECT id, name, email, text FROM notices
</sql:query>
<c:forEach var="row" items="${rs.rows}">
    ID: ${row.id}<br/>
    Name: ${row.name}<br/>
    Email: ${row.email}<br/>
</c:forEach>
</body>
</html>