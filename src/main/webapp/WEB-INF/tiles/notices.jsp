<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-10 col-md-offset-1">
    <table class="table table-striped">
        <tr>
            <th width="5%">ID</th>
            <th width="15%">Name</th>
            <th width="30%">Email</th>
            <th width="50%">Notice</th>
        </tr>
        <c:forEach var="notice" items="${notices}">
            <tr>
                <td><c:out value="${notice.id}"></c:out></td>
                <td><c:out value="${notice.name}"></c:out></td>
                <td><c:out value="${notice.email}"></c:out></td>
                <td><c:out value="${notice.text}"></c:out></td>
            </tr>
            <%--<p><c:out value="${notice}"></c:out></p>--%>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back</a>
</div>