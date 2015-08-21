<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notice created successfully</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <div class="alert alert-info" role="alert">
        <p>Notice Created.</p>
    </div>
    <a href="${pageContext.request.contextPath}/notices" type="button" class="btn btn-primary">All Current Notices</a>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back</a>
</div>
</body>
</html>
