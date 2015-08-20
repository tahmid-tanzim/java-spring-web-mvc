<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Notice</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
    <h4>Create Notice</h4>
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="notice">
        <div class="form-group">
            <label for="inputName">Name: </label>
            <sf:input type="text" path="name" name="name" class="form-control" id="inputName" placeholder="Name"/>
            <sf:errors path="name" cssClass="alert-danger"></sf:errors>
        </div>
        <div class="form-group">
            <label for="inputEmail">Email: </label>
            <sf:input type="text" path="email" name="email" class="form-control" id="inputEmail" placeholder="Email"/>
            <sf:errors path="email" cssClass="alert-danger"></sf:errors>
        </div>
        <div class="form-group">
            <label for="inputNotice">Notice: </label>
            <sf:textarea name="text" path="text" rows="10" cols="20" class="form-control"
                         id="inputNotice"></sf:textarea>
            <sf:errors path="text" cssClass="alert-danger"></sf:errors>
        </div>
        <button type="submit" class="btn btn-success">Create Notice</button>
        <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
    </sf:form>
</div>
</body>
</html>
