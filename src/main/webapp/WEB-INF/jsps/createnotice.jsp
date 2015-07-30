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
    <title></title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/docreate">
    <table>
        <tr>
            <td>Name:</td>
            <td><input name="name" type="text"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input name="email" type="text"/></td>
        </tr>
        <tr>
            <td>Notice:</td>
            <td><textarea name="text" rows="10" cols="10"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input name="Create Notice" type="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
