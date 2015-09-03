<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-10 col-md-offset-1">
    <h3>Authorized users only!</h3>
    <table class="table table-striped">
        <tr>
            <th>Full Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Authority</th>
            <th>Enabled</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"></c:out></td>
                <td><c:out value="${user.username}"></c:out></td>
                <td><c:out value="${user.email}"></c:out></td>
                <td><c:out value="${user.authority}"></c:out></td>
                <td><c:out value="${user.enabled}"></c:out></td>
            </tr>
            <%--<p><c:out value="${notice}"></c:out></p>--%>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back</a>
</div>