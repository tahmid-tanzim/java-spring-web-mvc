<%--
  Created by IntelliJ IDEA.
  User: tanzim
  Date: 7/30/15
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Notice</title>
    <%--<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />--%>
</head>
<body>
<div class="container">
    <%--<form method="get" action="${pageContext.request.contextPath}/docreate">--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<td>Name:</td>--%>
                <%--<td><input name="name" type="text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Email:</td>--%>
                <%--<td><input name="email" type="text"/></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td>Notice:</td>--%>
                <%--<td><textarea name="text" rows="10" cols="10"></textarea></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td></td>--%>
                <%--<td><input name="Create Notice" type="submit"/></td>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</form>--%>

    <form method="post" action="${pageContext.request.contextPath}/docreate">
        <div class="form-group">
            <label for="inputName">Name: </label>
            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
        </div>
        <div class="form-group">
            <label for="inputEmail">Email: </label>
            <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="inputNotice">Notice: </label>
            <textarea name="text" rows="10" cols="20" class="form-control" id="inputNotice"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Create Notice</button>
    </form>
</div>
</body>
</html>
