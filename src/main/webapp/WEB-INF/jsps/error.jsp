<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <div class="alert alert-danger" role="alert">
        <p>A Database Error occurred. Please check you database connection or try again later.</p>
    </div>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
</div>
</body>
</html>
