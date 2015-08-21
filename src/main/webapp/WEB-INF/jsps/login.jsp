<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"
          type="text/css"/>
</head>
<body onload='document.f.j_username.focus();'>
<div class="col-md-6 col-md-offset-3">
    <form class="form-horizontal" name='f' action='${pageContext.request.contextPath}/j_spring_security_check'
          method='POST'>
        <fieldset>
            <legend>Login</legend>
            <c:if test="${param.error != null && param.error == 'true'}">
                <div class="alert alert-danger">Incorrect Username or Password provided.</div>
            </c:if>
            <div class="control-group">
                <label class="control-label" for="j_username">Username</label>

                <div class="controls">
                    <input id="j_username" name="j_username" type="text" placeholder="" class="input-xlarge">

                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="j_password">Password</label>

                <div class="controls">
                    <input id="j_password" name="j_password" type="password" placeholder="" class="input-xlarge">

                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="_spring_security_remember_me">Remember Me</label>
                <input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox"
                       checked="checked">
            </div>
            <div class="control-group">
                <label class="control-label" for="singlebutton"></label>

                <div class="controls">
                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Login</button>
                </div>
            </div>
        </fieldset>
    </form>
    <p>
        <a href="<c:url value='/newaccount' />" type="button" class="btn btn-success">Create new account</a>
        <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-default">Back to Home</a>
    </p>
</div>
</body>
</html>