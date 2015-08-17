<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create New Account</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <h4>Create User</h4>
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="notice">
        <div class="form-group">
            <label for="inputusername">Username: </label>
            <sf:input type="text" path="username" name="username" class="form-control" id="inputusername" placeholder="username"/>
            <sf:errors path="username" cssClass="alert-danger"></sf:errors>
        </div>
        <div class="form-group">
            <label for="inputEmail">Email: </label>
            <sf:input type="text" path="email" name="email" class="form-control" id="inputEmail" placeholder="Email"/>
            <sf:errors path="email" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputPassword">Email: </label>
            <sf:input type="password" path="password" name="password" class="form-control" id="inputPassword" />
            <sf:errors path="passowrd" cssClass="alert-danger"></sf:errors>
        </div>

        <button type="submit" class="btn btn-success">Create Notice</button>
    </sf:form>
</div>
</body>
</html>
