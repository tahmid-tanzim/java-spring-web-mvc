<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Denied</title>
    <link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <div class="alert alert-danger" role="alert">
        <p>Access denied!</p>
    </div>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
</div>
</body>
</html>
