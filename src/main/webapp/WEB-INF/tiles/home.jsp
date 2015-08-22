<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-md-10 col-md-offset-1">
    <h4>Notices Home</h4>

    <p>
        <a href="${pageContext.request.contextPath}/notices" type="button" class="btn btn-primary">Show Notices</a>
    </p>

    <p>
        <a href="${pageContext.request.contextPath}/createnotice" type="button" class="btn btn-primary">Create
            Notices</a>
    </p>
    <sec:authorize access="!isAuthenticated()">
        <p>
            <a href="<c:url value='/login' />" type="button" class="btn btn-primary">Log in</a>
        </p>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <p>
            <a href="<c:url value='/j_spring_security_logout' />" type="button" class="btn btn-primary">Log out</a>
        </p>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p>
            <a href="<c:url value='/admin' />" type="button" class="btn btn-primary">Admin Page</a>
        </p>
    </sec:authorize>
</div>