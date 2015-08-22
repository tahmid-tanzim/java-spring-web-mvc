<%--
  Created by IntelliJ IDEA.
  User: tanzim
  Date: 8/18/15
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
    <link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <div class="alert alert-info" role="alert">
        <p>You have logged out!</p>
    </div>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
</div>
</body>
</html>
